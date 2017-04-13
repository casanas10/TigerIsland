import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by alecasanas on 3/27/17.
 */
public class AI {

    private HashMap<Integer, int[]> allPossibleTiles = new HashMap<>();
    private PlacementValidity validity = new PlacementValidity();

    private Game game = new Game();
    private IslandMap islandMap;
    private Player player = new Player("white", 0);
    private Player otherAI = new Player("black", 0);

    private CoordinateSystem coordinateSystem = new CoordinateSystem();
    private RotateTile tile;

    private CoordinateConverter coordinateConverter = new CoordinateConverter();
    private RotationConverter rotationConverter = new RotationConverter();

    private Nuking nuker = new Nuking();

    private Builder builder = new Builder();

    private Settlement settMap;
    private ArrayList<Integer> ActiveSettlements = new ArrayList<>();
    private ArrayList<Integer> activeHexIDs = new ArrayList<>();
    private SettlementSizeChecker settlementSizeChecker;

    private int[] possibleOrientation = {0, 60, 120, 180, 240, 300};
    private MoveData moveData = new MoveData();
    private int maxHexID = 20100;
    private int minHexID = 19699;
    private ArrayList<Integer> volcanosOnMap = new ArrayList<>();
    private boolean maxMinTurn = true;
    private boolean isFirstTilePlaced = false;
    private boolean nukingFlag = false;
    private int level = 0;
    private boolean wasTigerPlaced = false;
    private int[] level3HexIDs  = new int[2];
    private boolean readyToPlaceTiger = false;
    private int[] toSendServer = new int[6]; //int ourTileX, int ourTileY, int ourOrientation, int ourBuildOption, int ourBuildOptionX, int ourBuildOptionY
    private String[] globalTerrains = new String[3];

    private boolean tileWasPlaced;
    private boolean buildOptionWasChosen;


    /*
    * Strategy for building:
     *
    * 1st - Check if there is a settlement size 5 without a totoro
    *       If yes, place a totoro -- done: need to place a Totoro
    *       Else place a meeple in the largest settlement without a totoro --settlements of size smaller than 5 cannot have totoros -findTheLargestSettlementLessThanFive: need to place meeple
    *       Else place a meeple in the tile just placed
    *
    *
    *  Strategy for placing tiles:
    *  Check if nuking is possible by where the volcanos are
                If possible, nuke (number of volcanos >= 2)
                Else
    *               placeFirstTile (place volcano next to volcano of main tile)
       Check if nuking is possible by where the volcanos are
                If possible, nuke (number of volcanos >= 2)
                Else Remember where the other player placed their tile and check where we can place it -
                place volcanos close to each other (place volcano next to volcano of main tile)
                Else remember were self placed the first tile and place place tile there. (place volcano next to volcano of main tile)
                For Tomorrow:
                Look at:
                    placing meeple before nuking, if not possible: place tile in level 1
                Look at timing
                Look at how to fill the message for the server
    * */

    public AI(){
        this.game = new Game();
        this.islandMap = game.getIslandMap();
        this.player = game.getWhitePlayer();
        this.otherAI = game.getBlackPlayer();

        int[] tileHexIDsArray = {coordinateSystem.getHexID(99,99), coordinateSystem.getHexID(99,98),coordinateSystem.getHexID(100,98),
                coordinateSystem.getHexID(99,100), coordinateSystem.getHexID(100, 100)};
        activeHexIDs.add(coordinateSystem.getHexID(99, 99));
        volcanosOnMap.add(coordinateSystem.getHexID(99, 99));
        activeHexIDs.add(coordinateSystem.getHexID(99, 98));
        activeHexIDs.add(coordinateSystem.getHexID(100, 98));
        activeHexIDs.add(coordinateSystem.getHexID(99, 100));
        activeHexIDs.add(coordinateSystem.getHexID(100, 100));
        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grasslands"};
        islandMap.placeFirstTile(tileHexIDsArray, tileTerrainsArray);


    }

    public Player getPlayer(){
        return player;
    }

    public void updateOpponentMove(MoveData moveData){
        int ourOrientation = rotationConverter.serverToOurs(moveData.getOrientation());
        int[] ourCoordinatesTile = coordinateConverter.serverToOurs(moveData.getTilePlacementX(), moveData.getTilePlacementY(), moveData.getTilePlacementZ());

        String[] Terrains = moveData.getTerrainsArray();

        int hexID = coordinateSystem.getHexID(ourCoordinatesTile[0], ourCoordinatesTile[1]);

        islandMap.addTileToMap(hexID, ourOrientation, Terrains, otherAI);

        int buildOption = moveData.getBuildOption(); //1. found settlement, 2. expand, 3. totoro, 4. tiger
        String ExtendTerrain = "";
        int[] ourCoordinatesBuild = coordinateConverter.serverToOurs(moveData.getBuildOptionX(), moveData.getBuildOptionY(), moveData.getBuildOptionZ());
        switch (buildOption){
            case 1:
                builder.build(otherAI, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
            case 3:
                builder.build(otherAI, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
            case 4:
                builder.build(otherAI, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
        }

        if(buildOption == 2){
            ExtendTerrain = moveData.getExtendTerrain();
            builder.extendForAI(coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]), islandMap, otherAI, ExtendTerrain);
        }
        tile = new RotateTile(hexID, ourOrientation);
        int[] Tile = tile.checkPair();
        activeHexIDs.add(hexID);
        activeHexIDs.add(Tile[1]);
        activeHexIDs.add(Tile[2]);
        volcanosOnMap.add(hexID);
        updateMaxAndMin();
    }

    public void makeMove(String[] Terrains){
        tileWasPlaced = false;
        buildOptionWasChosen = false;

        System.out.println("MAKE MOVE");
        for(int i = 0; i<3; i++){
            globalTerrains[i] = Terrains[i];
        }

        playingAI();

        if(!tileWasPlaced){
            findLocationToPlaceTile(islandMap);
        }
        if(!buildOptionWasChosen){
            placeMeepleAnywhere(islandMap, player);
        }
    }

    public void sendMoveToServer(int ourTileX, int ourTileY, int ourOrientation, int ourBuildOption, int ourBuildOptionX, int ourBuildOptionY){
        int serverOrientation = rotationConverter.oursToServer(ourOrientation);
        int[] serverCoordinatesTile = coordinateConverter.oursToServer(ourTileX, ourTileY);
        moveData.setOrientation(serverOrientation);
        moveData.setTilePlacementX(serverCoordinatesTile[0]);
        moveData.setTilePlacementY(serverCoordinatesTile[1]);
        moveData.setTilePlacementZ(serverCoordinatesTile[2]);

        int[] serverCoordinatesBuild = coordinateConverter.oursToServer(ourBuildOptionX, ourBuildOptionY);

        moveData.setBuildOption(ourBuildOption);
        moveData.setBuildOptionX(serverCoordinatesBuild[0]);
        moveData.setBuildOptionY(serverCoordinatesBuild[1]);
        moveData.setBuildOptionZ(serverCoordinatesBuild[2]);
    }

    public void sendExtendToServer(int ourTileX, int ourTileY, int ourOrientation, int ourBuildOption, int ourBuildOptionX, int ourBuildOptionY, String extendTerrain){
        int serverOrientation = rotationConverter.oursToServer(ourOrientation);
        int[] serverCoordinatesTile = coordinateConverter.oursToServer(ourTileX, ourTileY);
        moveData.setOrientation(serverOrientation);
        moveData.setTilePlacementX(serverCoordinatesTile[0]);
        moveData.setTilePlacementY(serverCoordinatesTile[1]);
        moveData.setTilePlacementZ(serverCoordinatesTile[2]);

        int[] serverCoordinatesBuild = coordinateConverter.oursToServer(ourBuildOptionX, ourBuildOptionY);

        moveData.setBuildOption(ourBuildOption);
        moveData.setBuildOptionX(serverCoordinatesBuild[0]);
        moveData.setBuildOptionY(serverCoordinatesBuild[1]);
        moveData.setBuildOptionZ(serverCoordinatesBuild[2]);
        moveData.setExtendTerrain(extendTerrain);
    }

    public MoveData getMoveData(){
        System.out.println("Tile Placement Coordinates: " + moveData.getTilePlacementX() + " " +
                moveData.getTilePlacementY() + " " + moveData.getTilePlacementZ() + " " +
                moveData.getOrientation());
        System.out.println("Build Coordinates: " + moveData.getBuildOptionX() + " " +
                moveData.getBuildOptionY() + " " + moveData.getBuildOptionZ());
        return moveData;
    }

    public void playingAI(){
        //First move
        //Place first Tile

        if(!isFirstTilePlaced) {
            int[] toServer = makeFirstMove(islandMap);
            for(int i = 0; i<3; i++){
                toSendServer[i] = toServer[i];
            }
            sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
        }
        else {
            //place Tile

            if(player.getRemainingMeeples() == 0){
                System.out.println("WARNING!!!!!!!");
                System.out.println("Remaining Meeples: " + player.getRemainingMeeples());
                System.out.println("Remaining Totoros: " + player.getRemainingTotoros());
                System.out.println("Remaining Tiger: " + player.getRemainingTigers());
                if(canYouNuke(islandMap)) {
                    System.out.println("CONNOR SAYS");
                    nuke(islandMap);
                }
                else {
                    System.out.println("ERIC WAS HERE");
                    findLocationToPlaceTile(islandMap);
                }
                if(!canATotoroBePlaced(islandMap, player)){
                    if(!checkToPlaceTiger()){
                        System.out.println("PARTY!");
                        toSendServer[3] = 5;
                        sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
                        return;
                    }
                }
            }


            System.out.println("Remaining Meeples: " + player.getRemainingMeeples());
            System.out.println("Remaining Totoros: " + player.getRemainingTotoros());
            System.out.println("Remaining Tiger: " + player.getRemainingTigers());
            if (canYouNuke(islandMap)) {
                System.out.println("BOJANGLES");
                if (!canYouPlaceMeepleAnywhere(islandMap, player)) {
                    System.out.println("DERP");
                    findLocationToPlaceTile(islandMap);
                }
                else {
                    System.out.println("NUKE THEM!!!!!!");
                    nuke(islandMap);
                    System.out.println("WE NUKED");
                    if(checkToPlaceTiger()){
                        System.out.println("WOOWOWOWOWOWOW");
                        return;
                    }
                }
            }
            else {
                System.out.println("LOLOLOLOL");
                findLocationToPlaceTile(islandMap);
            }

            //build

            if (readyToPlaceTiger) {
                System.out.println("YODELEEEEHOOOO");
                boolean isThereASettlement = false;
                isThereASettlement = lookAroundAHexForASettlment(islandMap, level3HexIDs[0], player);
                if (isThereASettlement) {
                    System.out.println("TICKLE ME");
                    if (builder.build(player, islandMap, 4, level3HexIDs[0])) {
                        buildOptionWasChosen = true;
                        System.out.println("LAWDY LAWDY");
                        toSendServer[3] = 4;
                        toSendServer[4] = coordinateSystem.getXCoordinate(level3HexIDs[0]);
                        toSendServer[5] = coordinateSystem.getYCoordinate(level3HexIDs[0]);
                        sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
                        //wasTigerPlaced = true;
                        return;
                    }
                }
                isThereASettlement = lookAroundAHexForASettlment(islandMap, level3HexIDs[1], player);
                if (isThereASettlement) {
                    System.out.println("AHHHHHHHHHH");
                    if (builder.build(player, islandMap, 4, level3HexIDs[1])) {
                        buildOptionWasChosen = true;
                        System.out.println("RTWERWER");
                        toSendServer[3] = 4;
                        toSendServer[4] = coordinateSystem.getXCoordinate(level3HexIDs[1]);
                        toSendServer[5] = coordinateSystem.getYCoordinate(level3HexIDs[1]);
                        sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
                        //wasTigerPlaced = true;
                        return;
                    }
                }
                readyToPlaceTiger = false;
            }

            if ((wasTigerPlaced == false) && (level == 3)) {
                System.out.println("GLOBS");
                if (lookAroundAHexForASettlment(islandMap, level3HexIDs[0], player)) {
                    System.out.println("COCKADOODLEDOO");
                    placeMeeple(islandMap, player, level3HexIDs[0]);
                }
                else if (lookAroundAHexForASettlment(islandMap, level3HexIDs[1], player)) {
                    System.out.println("SSSSSSS");
                    placeMeeple(islandMap, player, level3HexIDs[1]);
                }
                else {
                    placeMeepleAnywhere(islandMap, player); //Added by Connor 4/12/17
                }

                readyToPlaceTiger = true;
            }
            else {
                System.out.println("YOU'RE A WIZARD");
                if (!canATotoroBePlaced(islandMap, player)) {
                    System.out.println("YUCK");
                    if (!findTheLargestSettlementLessThanFive(islandMap, player)) {
                        System.out.println("PUMPKIN");
                        if (player.getPieces().getNumberOfMeeples() != 0) {
                            System.out.println("PIE IS GOOd");
                            if (placeMeepleAnywhere(islandMap, player)) {
                                System.out.println("BLABLABLA");
                                return;
                            } else {
                                System.out.println("HOWDY GANG");
                                //System out of moves
                                toSendServer[3] = 5;
                                sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
                                return;
                            }
                        }
                    }
                    //Look for tile in tallest level
                    //If level >= 3 place tiger
                    //else look if a totoro can be placed
                    //else place a meeple in your largest settlement <5
                }
            }

        }
    }

    public boolean checkToPlaceTiger(){
        System.out.println("TIGERERRSSS");
        level = islandMap.getHex(activeHexIDs.get(activeHexIDs.size() - 1)).getLevel();
        if (level >= 3) {
            System.out.println("BLUB");
            boolean isThereASettlement = false;
            isThereASettlement = lookAroundAHexForASettlment(islandMap, activeHexIDs.get(activeHexIDs.size() - 1), player);
            if (isThereASettlement) {
                System.out.println("BLOB");
                if(builder.build(player, islandMap, 4, activeHexIDs.get(activeHexIDs.size() - 1))) {
                    buildOptionWasChosen = true;
                    System.out.println("BLEEB");
                    toSendServer[3] = 4;
                    toSendServer[4] = coordinateSystem.getXCoordinate(activeHexIDs.get(activeHexIDs.size() - 1));
                    toSendServer[5] = coordinateSystem.getYCoordinate(activeHexIDs.get(activeHexIDs.size() - 1));
                    sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
                    wasTigerPlaced = true;
                    return true;
                }
            }
            isThereASettlement = lookAroundAHexForASettlment(islandMap, activeHexIDs.get(activeHexIDs.size() - 2), player);
            if (isThereASettlement) {
                System.out.println("BLOOB");
                if(builder.build(player, islandMap, 4, activeHexIDs.get(activeHexIDs.size() - 2))) {
                    buildOptionWasChosen = true;
                    System.out.println("BLERB");
                    toSendServer[3] = 4;
                    toSendServer[4] = coordinateSystem.getXCoordinate(activeHexIDs.get(activeHexIDs.size() - 2));
                    toSendServer[5] = coordinateSystem.getYCoordinate(activeHexIDs.get(activeHexIDs.size() - 2));
                    sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
                    wasTigerPlaced = true;
                    return true;
                }
            }
            level3HexIDs[0] = activeHexIDs.get(activeHexIDs.size() - 1);
            level3HexIDs[1] = activeHexIDs.get(activeHexIDs.size() - 2);
        }
        return false;
    }

    public boolean placeMeepleAnywhere(IslandMap islandMap, Player player){
        for(int i=0; i < activeHexIDs.size(); i++){
            if(islandMap.getHex(activeHexIDs.get(i)).getLevel() == 1){
                if(islandMap.getHex(activeHexIDs.get(i)).getSettlementID() == -1) {
                    if (!islandMap.getHex(activeHexIDs.get(i)).getTerrain().equals("Volcano")) {
                        placeMeeple(islandMap, player, activeHexIDs.get(i));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canYouPlaceMeepleAnywhere(IslandMap islandMap, Player player){
        for(int i=0; i < activeHexIDs.size(); i++){
            if(islandMap.getHex(activeHexIDs.get(i)).getLevel() == 1){
                if(islandMap.getHex(activeHexIDs.get(i)).getSettlementID() == -1) {
                    if (!islandMap.getHex(activeHexIDs.get(i)).getTerrain().equals("Volcano")) {
                        //placeMeeple(islandMap, player, activeHexIDs.get(i));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canYouNuke(IslandMap islandMap) {
        int[] Tile = new int[3];
        int[] tileTemp = new int[3];
        String[] tileTerrains = new String[3];
        RotateTile rotateTile;
        HexGrid hexGrid = islandMap.getHexGrid();
        int volcanoTemp = 0;
        int volcano = 0;
        int orientationTemp = 0;
        int orientation = 0;
        int level = 0;

        for (int k = 0; k < volcanosOnMap.size(); k++) {
            if (volcanosOnMap.size() >= 2) {
                for (int i = 0; i < 6; i++) {
                    rotateTile = new RotateTile(volcanosOnMap.get(k), possibleOrientation[i]);
                    Tile = rotateTile.checkPair();
                    for (int j = 0; j < 3; j++) {
                        tileTerrains[j] = islandMap.getHex(Tile[j]).getTerrain();
                    }
                    if (nuker.canYouNukeSettlement(islandMap, Tile, volcanosOnMap.get(k))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean nuke(IslandMap islandMap){
        int[] Tile = new int[3];
        int[] tileTemp = new int[3];
        String[] tileTerrains = new String[3];
        RotateTile rotateTile;
        HexGrid hexGrid = islandMap.getHexGrid();
        int volcanoTemp = 0;
        int volcano = 0;
        int orientationTemp = 0;
        int orientation = 0;
        int level = 0;

        for(int k = 0; k<volcanosOnMap.size(); k++){
            if(volcanosOnMap.size() >= 2){
                for (int i = 0; i < 6; i++) {
                    rotateTile = new RotateTile(volcanosOnMap.get(k), possibleOrientation[i]);
                    Tile = rotateTile.checkPair();
                    for(int j = 0; j < 3; j++){
                        tileTerrains[j] = islandMap.getHex(Tile[j]).getTerrain();
                    }
                    if (nuker.canYouNukeSettlement(islandMap, Tile, volcanosOnMap.get(k))) {
                        if(!((islandMap.getHex(Tile[1]).getTerrain().equals("Volcano")) || (islandMap.getHex(Tile[2]).getTerrain().equals("Volcano")))){
                            volcanoTemp = Tile[0];
                            orientationTemp = possibleOrientation[i];
                        }
                    }
                    if(islandMap.getHex(volcanoTemp).getLevel() > level){
                        volcano = volcanoTemp;
                        orientation = orientationTemp;
                        level = islandMap.getHex(volcanoTemp).getLevel();
                        tileTemp = Tile;
                    }
                }
            }
        }
        if(volcano != 0){
            for(int l = 0; l<3; l++) {
                volcanosOnMap.remove(new Integer(tileTemp[l]));
            }
            placeTile(islandMap, volcano, orientation);
            return true;
        }
        return false;
    }

    public boolean findTheLargestSettlementLessThanFive(IslandMap islandMap, Player player){

        Settlement settlements = islandMap.getSettlementObj();
        ArrayList<Integer> settlementHexIDs = new ArrayList<>();
        ActiveSettlements = settlements.getListOfActiveSettlementIDs();
        ArrayList<Integer> settlementHexIDsTemp = new ArrayList<>();
        int maxSize = 0;
        int settlementID = 0;

        for(int i = 0; i<ActiveSettlements.size(); i++){

            if((settlements.getSettlementSize(ActiveSettlements.get(i)) > maxSize) && (settlements.getSettlementSize(ActiveSettlements.get(i)) < 5)){

                settlementHexIDsTemp = settlements.getSettlementHexIDs(ActiveSettlements.get(i));

                if(islandMap.getHex(settlementHexIDsTemp.get(0)).getPlayerColorOnHex().equals(player.getPlayerColor())){
                    settlementHexIDs = settlements.getSettlementHexIDs(ActiveSettlements.get(i));
                    maxSize = (settlements.getSettlementSize(ActiveSettlements.get(i)));
                }
            }
        }
        int[] terrainFrequency = {0, 0, 0, 0}; //Jungle, Lake, Grassland, Rocky
        int[] terrainNextTo = new int[4];
        ArrayList<Integer> availableHexIDs = new ArrayList<>();
        for(int i = 0; i < settlementHexIDs.size(); i++){
            availableHexIDs = lookAroundAHexForAnEmptySettlement(islandMap, settlementHexIDs.get(i));
            if(!availableHexIDs.isEmpty()){
                //place Meeple (extend)
                //return builder.extendForAI(settlementHexIDs.get(i), islandMap, player, islandMap.getHex(availableHexIDs.get(0)).getTerrain());
                //return true;
                for(int j = 0; j<availableHexIDs.size(); j++){
                    switch (islandMap.getHex(availableHexIDs.get(j)).getTerrain()){
                        case "Jungle":
                            terrainFrequency[0] = terrainFrequency[0] + 1;
                            terrainNextTo[0] = settlementHexIDs.get(i);
                            break;
                        case "Lake":
                            terrainFrequency[1] = terrainFrequency[1] + 1;
                            terrainNextTo[1] = settlementHexIDs.get(i);
                            break;
                        case "Grassland":
                            terrainFrequency[2] = terrainFrequency[2] + 1;
                            terrainNextTo[2] = settlementHexIDs.get(i);
                            break;
                        case "Rocky":
                            terrainFrequency[3] = terrainFrequency[3] + 1;
                            terrainNextTo[3] = settlementHexIDs.get(i);
                            break;
                    }
                }
            }
        }
        int minFreq = 20;
        int minFreqIndex = 0;
        String terrain = "";

        if((terrainFrequency[0] != 0) || (terrainFrequency[1] != 0) || (terrainFrequency[2] != 0) || (terrainFrequency[3] != 0)){
            for(int i = 0; i < 4; i++){
                if((terrainFrequency[i] < minFreq) && (terrainFrequency[i] > 0)){
                    minFreq = terrainFrequency[i];
                    minFreqIndex = i;
                }
            }
            switch (minFreqIndex){
                case 0:
                    terrain = "Jungle";
                    break;
                case 1:
                    terrain = "Lake";
                    break;
                case 2:
                    terrain = "Grassland";
                    break;
                case 3:
                    terrain = "Rocky";
                    break;
            }
            if(builder.extendForAI(terrainNextTo[minFreqIndex], islandMap, player, terrain)){
                toSendServer[3] = 2;
                toSendServer[4] = coordinateSystem.getXCoordinate(terrainNextTo[minFreqIndex]);
                toSendServer[5] = coordinateSystem.getYCoordinate(terrainNextTo[minFreqIndex]);
                sendExtendToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5], terrain);
                return true;
            }
        }
        return false;

/*
        Settlement settlements = islandMap.getSettlementObj();
        ArrayList<Integer> settlementHexIDs = new ArrayList<>();
        ArrayList<Integer> grasslands = new ArrayList<>();
        ArrayList<Integer> jungles = new ArrayList<>();
        ArrayList<Integer> lakes = new ArrayList<>();
        ArrayList<Integer> rockys = new ArrayList<>();
        String minExtendString;
        ArrayList<Integer> minExtend = new ArrayList<>();
        int minTerrainCount = 0;
        int minSettlementID = 0;
        ActiveSettlements = settlements.getListOfActiveSettlementIDs();
        int firstHexID = 0;

        for(int i=0; i<ActiveSettlements.size(); i++){
            settlementHexIDs = settlements.getSettlementHexIDs(ActiveSettlements.get(i));
            firstHexID = settlementHexIDs.get(0);

            Hex hex = islandMap.getHex(firstHexID);
            if(hex.getPlayerColorOnHex().equals(player.getPlayerColor())) {
                ExtendSettlement extend = new ExtendSettlement(firstHexID, islandMap, player);
                grasslands = extend.getGrasslandsToExtendOn();
                jungles = extend.getJunglesToExtendOn();
                lakes = extend.getLakesToExtendOn();
                rockys = extend.getRockysToExtendOn();

                minExtendString = findMinExtendString(grasslands, jungles, lakes, rockys);
                minExtend = findMinExtend(grasslands, jungles, lakes, rockys, minExtendString, minExtend);

                if ((i == 0) || (minTerrainCount == 0)) {
                    minTerrainCount = minExtend.size();
                    minSettlementID = i;
                }
                else if (((minExtend.size() <= minTerrainCount) && (minExtend.size() != 0) && (i > 0))
                        || (minTerrainCount == 0)) {
                    minTerrainCount = minExtend.size();
                    minSettlementID = i;
                }
            }
        }

        if(minTerrainCount == 0){
            return false;
        }
        else{
            ArrayList<Integer> hexIDs = settlements.getSettlementHexIDs(ActiveSettlements.get(minSettlementID));
            int hexID = hexIDs.get(0);
            ExtendSettlement extend = new ExtendSettlement(firstHexID, islandMap, player);
            grasslands = extend.getGrasslandsToExtendOn();
            jungles = extend.getJunglesToExtendOn();
            lakes = extend.getLakesToExtendOn();
            rockys = extend.getRockysToExtendOn();

            minExtendString = findMinExtendString(grasslands,jungles,lakes,rockys);
            boolean isExtensionSuccessful = extend.extendOnTerrain(minExtendString);
            if(isExtensionSuccessful){
                toSendServer[3] = 2;
                toSendServer[4] = coordinateSystem.getXCoordinate(hexID);
                toSendServer[5] = coordinateSystem.getYCoordinate(hexID);
                sendExtendToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5], minExtendString);
                return true;
            }
            else {
                return false;
            }
        }
**/
    }

    private ArrayList<Integer> findMinExtend(ArrayList<Integer> grasslands, ArrayList<Integer> jungles, ArrayList<Integer> lakes, ArrayList<Integer> rockys, String minExtendString, ArrayList<Integer> minExtend) {
        if (minExtendString.equals("Grassland")) {
            minExtend = grasslands;
        }
        if(minExtendString.equals("Jungle")){
            minExtend = jungles;
        }
        if(minExtendString.equals("Lake")){
            minExtend = lakes;
        }
        if(minExtendString.equals("Rocky")){
            minExtend = rockys;
        }
        return minExtend;
    }

    private String findMinExtendString(ArrayList<Integer> grasslands, ArrayList<Integer> jungles, ArrayList<Integer> lakes, ArrayList<Integer> rockys) {
        int sizes[] = new int[4];

        sizes[0] = grasslands.size();
        sizes[1] = jungles.size();
        sizes[2] = lakes.size();
        sizes[3] = rockys.size();

        //bubble sort
        int temp = 0;
        for(int i=0; i<sizes.length; i++) {
            for (int j = 1; j < (sizes.length - i); j++) {
                if (sizes[j - 1] > sizes[j]) {
                    //swap elements
                    temp = sizes[j - 1];
                    sizes[j - 1] = sizes[j];
                    sizes[j] = temp;
                }
            }
        }

        //get min that isn't zero
        int minsize = 0;
        int i=0;
        while(i<sizes.length){
            if(sizes[i] != 0){
                minsize = sizes[i];
                break;
            }
            i++;
        }

        if(minsize == 0){
            return "Rocky";
        }
        else{
            if(minsize == grasslands.size()){
                return "Grassland";
            }
            if(minsize == jungles.size()){
                return "Jungle";
            }
            if(minsize == lakes.size()){
                return "Lake";
            }
            if(minsize == rockys.size()){
                return "Rocky";
            }
        }
        return "Rocky";
    }

    public boolean canATotoroBePlaced(IslandMap islandMap, Player player ){

        Settlement settlements = islandMap.getSettlementObj();
        ArrayList<Integer> settlementHexIDs = new ArrayList<>();
        ArrayList<Integer> ActiveSettlementIDs = settlements.getListOfActiveSettlementIDs();

        for(int settlementID : ActiveSettlementIDs) {
            if (settlements.getSettlementSize(settlementID) >= 5) {
                if (settlements.doesNotHaveATotoro(settlementID, player)) {
                    settlementHexIDs = settlements.getSettlementHexIDs(settlementID);
                }
            }
        }

        ArrayList<Integer> availableHexIDs = new ArrayList<>();
        for(int i = 0; i < settlementHexIDs.size(); i++){
            availableHexIDs = lookAroundAHexForAnEmptySettlement(islandMap, settlementHexIDs.get(i));
            if(islandMap.getHex(settlementHexIDs.get(i)).getPlayerColorOnHex().equals(player.getPlayerColor()) &&
                    (!islandMap.getHex(settlementHexIDs.get(i)).getTerrain().equals("Volcano"))) {
                if (!availableHexIDs.isEmpty()) {
                    //place Totoro
                    if (builder.build(player, islandMap, 3, availableHexIDs.get(0))) {
                        buildOptionWasChosen = true;
                        System.out.println("Totoro places");
                        toSendServer[3] = 3;
                        toSendServer[4] = coordinateSystem.getXCoordinate(availableHexIDs.get(0));
                        toSendServer[5] = coordinateSystem.getYCoordinate(availableHexIDs.get(0));
                        sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
                        return true;

                    }
                }
            }
        }

        return false;
    }

    public boolean lookAroundAHexForASettlment(IslandMap islandMap, int HexID, Player player){
        int hexLevel;
        int hexIDTest;
        String hexColor = "";
        String hexTerrain = "";
        int[] Hex1Offset = new int[6];

        // Determine if the origin is on an odd or even row
        if((HexID/200) % 2 != 0) {
            Hex1Offset[0] = 200;
            Hex1Offset[1] = 201;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -199;
            Hex1Offset[4] = -200;
            Hex1Offset[5] = -1;
        }

        else{
            Hex1Offset[0] = 199;
            Hex1Offset[1] = 200;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -200;
            Hex1Offset[4] = -201;
            Hex1Offset[5] = -1;
        }

        for(int i = 0; i < 6; i++) {
            hexIDTest = HexID + Hex1Offset[i];
            hexLevel = islandMap.getHex(hexIDTest).getLevel();
            hexColor = islandMap.getHex(hexIDTest).getPlayerColorOnHex();
            hexTerrain = islandMap.getHex(hexIDTest).getTerrain();
            if(hexLevel != 0){
                if(hexColor.equals(player.getPlayerColor())) {
                    return true;
                }
            }
        }

        return false;
    }

    public ArrayList<Integer> lookAroundAHexForAnEmptySettlement(IslandMap islandMap, int HexID){
        ArrayList<Integer> availableHexIDs = new ArrayList<>();
        int hexLevel;
        int hexIDTest;
        String hexColor = "";
        String hexTerrain = "";
        int[] Hex1Offset = new int[6];

        // Determine if the origin is on an odd or even row
        if((HexID/200) % 2 != 0) {
            Hex1Offset[0] = 200;
            Hex1Offset[1] = 201;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -199;
            Hex1Offset[4] = -200;
            Hex1Offset[5] = -1;
        }

        else{
            Hex1Offset[0] = 199;
            Hex1Offset[1] = 200;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -200;
            Hex1Offset[4] = -201;
            Hex1Offset[5] = -1;
        }

        for(int i = 0; i < 6; i++) {
            hexIDTest = HexID + Hex1Offset[i];
            hexLevel = islandMap.getHex(hexIDTest).getLevel();
            hexColor = islandMap.getHex(hexIDTest).getPlayerColorOnHex();
            hexTerrain = islandMap.getHex(hexIDTest).getTerrain();
            if(hexLevel != 0){
                if(hexColor.equals("")) {
                    if (!hexTerrain.equals("Volcano")) {
                        availableHexIDs.add(hexIDTest);
                    }
                }
            }
        }

        return availableHexIDs;
    }

    public void updateMaxAndMin(){
        for(int i = activeHexIDs.size()-1; i>activeHexIDs.size()-4; i--){
            if(activeHexIDs.get(i) >= maxHexID){
                maxHexID = activeHexIDs.get(i);
            }
            if(activeHexIDs.get(i) <= minHexID){
                minHexID = activeHexIDs.get(i);
            }
        }
    }

    public int[] makeFirstMove(IslandMap islandMap){
        int[] toServer = new int[3];
        RotateTile rotateTile = new RotateTile(0,0);

        //Check right side
        if(islandMap.addTileToMap(19900,60, globalTerrains, player)){
            tileWasPlaced = true;
            //return x, y, z and orientation
            toServer = toSendToServer(19900, 60);
            volcanosOnMap.add(19900);
            rotateTile = new RotateTile(19900, 60);
            placeMeeple(islandMap, player, 19901);
            toSendServer[3] = 1;
            toSendServer[4] = coordinateSystem.getXCoordinate(19901);
            toSendServer[5] = coordinateSystem.getYCoordinate(19901);
        }
        //Check left side
        else if(islandMap.addTileToMap(19898,240, globalTerrains, player)){
            tileWasPlaced = true;
            //return x, y, z and orientation
            toServer = toSendToServer(19898, 240);
            volcanosOnMap.add(19898);
            rotateTile = new RotateTile(19898, 240);
            placeMeeple(islandMap, player, 19897);
            toSendServer[3] = 1;
            toSendServer[4] = coordinateSystem.getXCoordinate(19897);
            toSendServer[5] = coordinateSystem.getYCoordinate(19897);
        }
        isFirstTilePlaced = true;
        int[] Tile = rotateTile.checkPair();
        for(int i = 0; i<3; i++) {
            activeHexIDs.add(Tile[i]);
        }

        updateMaxAndMin();
        return toServer;
    }


    public int[] placeTile(IslandMap islandMap, int volcanoHexID, int orientation){
        if(islandMap.addTileToMap(volcanoHexID, orientation, globalTerrains, player)) {
            tileWasPlaced = true;
            RotateTile rotateTile = new RotateTile(volcanoHexID, orientation);
            int[] Tile = rotateTile.checkPair();
            for (int i = 0; i < 3; i++) {
                activeHexIDs.add(Tile[i]);
            }

            updateMaxAndMin();

            volcanosOnMap.add(volcanoHexID);
        }
        else{
            findLocationToPlaceTile(islandMap);
        }
        return toSendToServer(volcanoHexID, orientation);
    }

    public int[] toSendToServer(int volcanoHexID, int orientation){
        int[] toServer = new int[4];
        int ourX = coordinateSystem.getXCoordinate(volcanoHexID);
        int ourY = coordinateSystem.getYCoordinate(volcanoHexID);

        toServer[0] = ourX;
        toServer[1] = ourY;
        toServer[2] = orientation;

        toSendServer[0] = ourX;
        toSendServer[1] = ourY;
        toSendServer[2] = orientation;
        return toServer;
    }

    public int[] findLocationToPlaceTile(IslandMap islandMap){

        //worst case scenario
        if(maxMinTurn) {
            maxMinTurn = !maxMinTurn;
            return placeTile(islandMap, maxHexID + 1, 0);
        }

        else{
            maxMinTurn = !maxMinTurn;
            return placeTile(islandMap, minHexID - 1, 180);
        }
    }

    public boolean placeMeeple(IslandMap islandMap, Player player, int hexID){
        if(builder.build(player, islandMap, 1, hexID)){
            buildOptionWasChosen = true;
            toSendServer[3] = 1;
            toSendServer[4] = coordinateSystem.getXCoordinate(hexID);
            toSendServer[5] = coordinateSystem.getYCoordinate(hexID);
            sendMoveToServer(toSendServer[0], toSendServer[1], toSendServer[2], toSendServer[3], toSendServer[4], toSendServer[5]);
            return true;
        }
        else{
            return false;
        }
    }
}
