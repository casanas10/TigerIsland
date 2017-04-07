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
    private Player player = new Player("White", 0);

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
    private Boolean maxMinTurn = true;
    private Boolean isFirstTilePlaced = false;
    private Boolean nukingFlag = false;
    private int level = 0;
    private Boolean wasTigerPlaced = false;
    private int[] level3HexIDs  = new int[2];
    private Boolean readyToPlaceTiger = false;


    //CONSTANTS FOR FIRST TILE
    private static final int hex1  = 3014;
    private static final int hex2  = 2814;
    private static final int hex3  = 2815;
    private static final int hex4  = 3214;
    private static final int hex5  = 3215;


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

    public AI(Game game){
        this.game = game;
        this.islandMap = new IslandMap();
        this.settMap = islandMap.getSettlementObj();

        int[] tileHexIDsArray = {coordinateSystem.getHexID(99,99), coordinateSystem.getHexID(99,98),coordinateSystem.getHexID(100,98),
                coordinateSystem.getHexID(99,100), coordinateSystem.getHexID(100, 100)};

        activeHexIDs.add(hex1);
        volcanosOnMap.add(hex1);
        activeHexIDs.add(hex2);
        activeHexIDs.add(hex3);
        activeHexIDs.add(hex4);
        activeHexIDs.add(hex5);

    }

    public MoveData sendTilePlacementToServer(int[] toServer){
        moveData.setTilePlacementX(toServer[0]);
        moveData.setTilePlacementY(toServer[1]);
        moveData.setTilePlacementZ(toServer[2]);
        moveData.setOrientation(toServer[3]);
        return moveData;
    }

    public MoveData sendBuildToServer(int[] toServer){
        moveData.setBuildOption(toServer[0]);
        moveData.setBuildOptionX(toServer[1]);
        moveData.setBuildOptionY(toServer[2]);
        moveData.setBuildOptionZ(toServer[3]);
        return moveData;
    }

    public void receiveTilePlacementFromServer(){
        int serverX = moveData.getTilePlacementX();
        int serverY = moveData.getTilePlacementY();
        int serverZ = moveData.getTilePlacementZ();
        int serverOrientation = moveData.getOrientation();
        int[] ourX = coordinateConverter.serverToOurs(serverX, serverY, serverZ);
        int ourOrientation = rotationConverter.serverToOurs(serverOrientation);
    }

    public void receiveBuildFromServer(){
        int buildOption = moveData.getBuildOption();
        int serverBuildOptionX = moveData.getBuildOptionX();
        int serverBuildOptionY = moveData.getBuildOptionY();
        int serverBuildOptionZ = moveData.getBuildOptionZ();
        int[] hexCoordinates = coordinateConverter.serverToOurs(serverBuildOptionX, serverBuildOptionY, serverBuildOptionZ);
    }

    public void playingAI(IslandMap islandMap){
        //First move
        //Place first Tile

        if(!isFirstTilePlaced) {
            makeFirstMove(islandMap);
        }
        else {
            //place Tile
            if (canYouNuke(islandMap)) {
                if (!canYouPlaceMeepleAnywhere(islandMap, player)) {
                    findLocationToPlaceTile(islandMap);
                }
                else {
                    nuke(islandMap);
                    level = islandMap.getHex(activeHexIDs.get(activeHexIDs.size() - 1)).getLevel();
                    if (islandMap.getHex(activeHexIDs.get(activeHexIDs.size() - 1)).getLevel() >= 3) {
                        Boolean isThereASettlement = false;
                        isThereASettlement = lookAroundAHexForASettlment(islandMap, activeHexIDs.get(activeHexIDs.size() - 1), player);
                        if (isThereASettlement) {
                            if(builder.build(player, islandMap, 4, activeHexIDs.get(activeHexIDs.size() - 1))) {
                                wasTigerPlaced = true;
                                return;
                            }
                        }
                        isThereASettlement = lookAroundAHexForASettlment(islandMap, activeHexIDs.get(activeHexIDs.size() - 2), player);
                        if (isThereASettlement) {
                            if(builder.build(player, islandMap, 4, activeHexIDs.get(activeHexIDs.size() - 2))) {
                                wasTigerPlaced = true;
                                return;
                            }
                        }
                        level3HexIDs[0] = activeHexIDs.get(activeHexIDs.size() - 1);
                        level3HexIDs[1] = activeHexIDs.get(activeHexIDs.size() - 2);
                    }
                }
            } else {
                findLocationToPlaceTile(islandMap);
            }

            //build
            if(readyToPlaceTiger){
                Boolean isThereASettlement = false;
                isThereASettlement = lookAroundAHexForASettlment(islandMap, level3HexIDs[0], player);
                if (isThereASettlement) {
                    builder.build(player, islandMap, 4, level3HexIDs[0]);
                    wasTigerPlaced = true;
                    return;
                }
                isThereASettlement = lookAroundAHexForASettlment(islandMap, level3HexIDs[1], player);
                if (isThereASettlement) {
                    builder.build(player, islandMap, 4, level3HexIDs[1]);
                    wasTigerPlaced = true;
                    return;
                }
                readyToPlaceTiger = false;
            }

            if ((wasTigerPlaced == false) && (level == 3)) {
                if(lookAroundAHexForASettlment(islandMap, level3HexIDs[0], player)){
                    placeMeeple(islandMap, player, level3HexIDs[0]);
                }
                else if(lookAroundAHexForASettlment(islandMap, level3HexIDs[1], player)){
                    placeMeeple(islandMap, player, level3HexIDs[1]);
                }
                readyToPlaceTiger = true;
            }

            else {
                if (!canATotoroBePlaced(islandMap, player)) {
                    if (!findTheLargestSettlementLessThanFive(islandMap, player)) {
                        if (player.getPieces().getNumberOfMeeples() != 0)
                            System.out.println(placeMeepleAnywhere(islandMap, player));

                        else {
                            System.out.println("Out of Meeple!");
                            return;
                        }
                    }
                    //Look for tile in talest level
                    //If level >= 3 place tiger
                    //else look if a totoro can be placed
                    //else place a meeple in your largest settlement <5
                }
            }
        }

        return;
    }

    public Boolean placeMeepleAnywhere(IslandMap islandMap, Player player){
        for(int i = activeHexIDs.size()-1; i>0; i--){
            if(islandMap.getHex(activeHexIDs.get(i)).getLevel() == 1){
                if(islandMap.getHex(activeHexIDs.get(i)).getPlayerColorOnHex() == "") {
                    if (islandMap.getHex(activeHexIDs.get(i)).getTerrain() != "Volcano") {
                        placeMeeple(islandMap, player, activeHexIDs.get(i));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean canYouPlaceMeepleAnywhere(IslandMap islandMap, Player player){
        for(int i = activeHexIDs.size()-1; i>0; i--){
            if(islandMap.getHex(activeHexIDs.get(i)).getLevel() == 1){
                if(islandMap.getHex(activeHexIDs.get(i)).getPlayerColorOnHex() == "") {
                    if (islandMap.getHex(activeHexIDs.get(i)).getTerrain() != "Volcano") {
                        //placeMeeple(islandMap, player, activeHexIDs.get(i));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void build(){
        int lastHexPlaced = activeHexIDs.get(activeHexIDs.size()-1);
        int lastPlacedHexLevel = islandMap.getHex(lastHexPlaced).getLevel();
        if(lastPlacedHexLevel >= 3){
            //place tiger
        }
        else{
            //int largestSettlementSizeLessThanFive = findTheLargestSettlementLessThanFive(settMap, islandMap, player)
            //if(canATotoroBePlaced(islandMap, ))
        }
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
                        if(!((islandMap.getHex(Tile[1]).getTerrain() == "Volcano") || (islandMap.getHex(Tile[2]).getTerrain() == "Volcano"))){
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

    public Boolean findTheLargestSettlementLessThanFive(IslandMap islandMap, Player player){
        Settlement settlements = islandMap.getSettlementObj();
        ArrayList<Integer> settlementHexIDs = new ArrayList<>();
        ActiveSettlements = settlements.getListOfActiveSettlementIDs();
        ArrayList<Integer> settlementHexIDsTemp = new ArrayList<>();
        int maxSize = 0;
        int settlementID = 0;

        for(int i = 0; i<ActiveSettlements.size(); i++){

            if((settlements.getSettlementSize(ActiveSettlements.get(i)) > maxSize) && (settlements.getSettlementSize(ActiveSettlements.get(i)) < 5)){

                settlementHexIDsTemp = settlements.getSettlementHexIDs(ActiveSettlements.get(i));

                if(islandMap.getHex(settlementHexIDsTemp.get(0)).getPlayerColorOnHex() == player.getPlayerColor()){
                    settlementHexIDs = settlements.getSettlementHexIDs(ActiveSettlements.get(i));
                    maxSize = (settlements.getSettlementSize(ActiveSettlements.get(i)));
                }
            }
        }
        int[] terrainFrequency = {0, 0, 0, 0}; //Jungle, Lake, Grassland, Rocky
        int[] terrainOccurranceIndex = {0, 0, 0, 0}; //Jungle, Lake, Grassland, Rocky
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
                            terrainOccurranceIndex[0] = i;
                            break;
                        case "Lake":
                            terrainFrequency[1] = terrainFrequency[1] + 1;
                            terrainOccurranceIndex[1] = i;
                            break;
                        case "Grassland":
                            terrainFrequency[2] = terrainFrequency[2] + 1;
                            terrainOccurranceIndex[2] = i;
                            break;
                        case "Rocky":
                            terrainFrequency[3] = terrainFrequency[3] + 1;
                            terrainOccurranceIndex[3] = i;
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
            return builder.extendForAI(settlementHexIDs.get(terrainOccurranceIndex[minFreqIndex]), islandMap, player, terrain);
        }
        return false;
    }

    public Boolean canATotoroBePlaced(IslandMap islandMap, Player player ){

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
            if(!availableHexIDs.isEmpty()){
                //place Totoro
                builder.build(player, islandMap, 3, availableHexIDs.get(0));
                return true;
            }
        }

        return false;
    }

    public Boolean lookAroundAHexForASettlment(IslandMap islandMap, int HexID, Player player){
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
                if(hexColor == player.getPlayerColor()) {
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
                if(hexColor == "") {
                    if (hexTerrain != "Volcano") {
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

//    public int[] makeFirstMove(IslandMap islandMap){
//        int[] toServer = new int[4];
//        RotateTile rotateTile = new RotateTile(0,0);
//
//        //Check right side
//        if(islandMap.addTileToMap(19900,60)){
//            //return x, y, z and orientation
//            toServer = toSendToServer(19900, 60);
//            volcanosOnMap.add(19900);
//            rotateTile = new RotateTile(19900, 60);
//            placeMeeple(islandMap, player, 19901);
//        }
//        //Check left side
//        else if(islandMap.addTileToMap(19898,240)){
//            //return x, y, z and orientation
//            toSendToServer(19898, 240);
//            volcanosOnMap.add(19898);
//            rotateTile = new RotateTile(19898, 240);
//            placeMeeple(islandMap, player, 19897);
//        }
//        isFirstTilePlaced = true;
//        int[] Tile = rotateTile.checkPair();
//        for(int i = 0; i<3; i++) {
//            activeHexIDs.add(Tile[i]);
//        }
//
//        updateMaxAndMin();
//        return toServer;
//    }

    public int[] makeFirstMove(IslandMap islandMap){
        int[] toServer = new int[4];
        RotateTile rotateTile = new RotateTile(0,0);

        //Check right side
        if(islandMap.addTileToMap(3015,60)){
            //return x, y, z and orientation
            toServer = toSendToServer(3015, 60);
            volcanosOnMap.add(3015);
            rotateTile = new RotateTile(3015, 60);
            placeMeeple(islandMap, player, 3016);
        }
        //Check left side
        else if(islandMap.addTileToMap(3013,240)){
            //return x, y, z and orientation
            toSendToServer(3013, 240);
            volcanosOnMap.add(3013);
            rotateTile = new RotateTile(3013, 240);
            placeMeeple(islandMap, player, 3012);
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
        islandMap.addTileToMap(volcanoHexID, orientation);
        RotateTile rotateTile = new RotateTile(volcanoHexID, orientation);
        int[] Tile = rotateTile.checkPair();
        for(int i = 0; i<3; i++) {
            activeHexIDs.add(Tile[i]);
        }

        updateMaxAndMin();

        volcanosOnMap.add(volcanoHexID);

        return toSendToServer(volcanoHexID, orientation);
    }

    public int[] toSendToServer(int volcanoHexID, int orientation){
        int[] toServer = new int[4];
        int ourX = coordinateSystem.getXCoordinate(volcanoHexID);
        int ourY = coordinateSystem.getYCoordinate(volcanoHexID);
        int[] serverCoordinates = coordinateConverter.oursToServer(ourX, ourY);
        int serverOrientation = rotationConverter.oursToServer(orientation);

        for(int i=0; i<3; i++)
            toServer[i] = serverCoordinates[i];

        toServer[3] = serverOrientation;

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

    public Boolean placeMeeple(IslandMap islandMap, Player player, int hexID){
        return builder.build(player, islandMap, 1, hexID);
    }
    /*
    public void expandSettlement(HexGrid hexGrid, Player player){
        updateActiveSettlements(hexGrid);
        ArrayList<Integer> settlementSmallerThanFive = SettlementSmallerThanFive(hexGrid, player);
    }
    */

    public HashMap<Integer, int[]> getAllPossibleTilePlacementPosition(int[] tileArr) {

        int[] orientation = {0, 60, 120, 180, 240, 300};

        for (int i = 0; i < tileArr.length; i++){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(tileArr[i]));

            for (int j = 0; j < adjacentHexes.size(); j++){

                System.out.println(adjacentHexes.get(j));

                for (int k = 0; k < orientation.length; k++){

                    tile = new RotateTile(adjacentHexes.get(j), orientation[k]);

                    allPossibleTiles.put(k, tile.checkPair());

                }

//                if(validity.SearchAdjacentTiles(islandMap.getHexGrid(),tileArr) && validity.checkIfHexesCanBePlaced(islandMap.getHexGrid(), tileArr)){
//
////                    System.out.println(adjacentHexes.get(j));
//                }
            }
        }

        return allPossibleTiles;
    }

    public void printAllPossibleTiles(){
        Iterator<Map.Entry<Integer, int[]>> iterator = allPossibleTiles.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, int[]> entry = iterator.next();
            System.out.print("Tile " + entry.getKey() + ": ");
            for(int i=0;i<3;i++){
                System.out.print(entry.getValue()[i] + " ");
            }
            System.out.println();
        }
    }


}