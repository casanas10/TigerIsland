import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ale on 4/18/17.
 */
public class NEW_AI {

    private Game game = new Game();

    private IslandMap islandMap;
    private Builder builder;
    private Player aiPlayer;
    private Player serverPlayer;

    private RotateTile tile;
    private RotationConverter rotationConverter = new RotationConverter();
    private CoordinateConverter coordinateConverter = new CoordinateConverter();
    private CoordinateSystem coordinateSystem = new CoordinateSystem();

    private PlacementValidity validity = new PlacementValidity();

    private String[] terrainsArray;


    public NEW_AI(){
        this.builder = this.game.builder;
        this.islandMap = this.game.getIslandMap();
        this.aiPlayer = this.game.getWhitePlayer();
        this.serverPlayer = this.game.getBlackPlayer();

        // First tile will actually be placed in the center, this is for testing purposes
        //tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
        int[] tileHexIDsArray = {coordinateSystem.getHexID(99,99), coordinateSystem.getHexID(99,98),coordinateSystem.getHexID(100,98),
                coordinateSystem.getHexID(99,100), coordinateSystem.getHexID(100, 100)};
        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grassland"};
        islandMap.placeFirstTile(tileHexIDsArray, tileTerrainsArray);
    }


    public MoveData play(){

        if(aiPlayer.getRemainingMeeples() <= 0){

            return UnableToBuild();
        }

        NukeResult nukeResult = placeTile();

        BuildResult buildResult = makeMove();

        return BuildAction(nukeResult, buildResult);

    }

    private BuildResult makeMove() {

        BuildResult buildResult;

        if (aiPlayer.getRemainingTigers() == 0){

            buildResult = findTheBestExpansion();

            if (buildResult.buildSuccessfull){

                return buildResult;
            }
        }

        buildResult = BuildATigerPlayground();

        if (buildResult.buildSuccessfull){

            return buildResult;
        }


        buildResult = buildNextToHigherLevelHex();

        if(buildResult.buildSuccessfull){

            return buildResult;
        }


        buildResult = foundNewSettlementSomewhere();

        if (buildResult.buildSuccessfull){

            return buildResult;
        }

        return buildResult;
    }

    public BuildResult findTheBestExpansion() {

        ArrayList<Integer> hexesThatCanBeExpanded = ableToExpand().listHexes;

        int tempMaxSize = 0;
        int[] hexIDPlusTerrain = new int[2];

        int meepleNeededToCompleteExpansion = 0;

        for (int i = 0; i < hexesThatCanBeExpanded.size(); i++){

            int hexID = hexesThatCanBeExpanded.get(i);

            ExtendSettlement extend = new ExtendSettlement(hexID,islandMap,aiPlayer);

            ArrayList<Integer> jungles = extend.getTerrainList("Jungle");
            ArrayList<Integer> lakes = extend.getTerrainList("Lake");
            ArrayList<Integer> rockys = extend.getTerrainList("Rocky");
            ArrayList<Integer> grass = extend.getTerrainList("Grassland");

            int jungleSize = jungles.size();
            int lakeSize = lakes.size();
            int rockySize = rockys.size();
            int grassSize = grass.size();

            int[] arraylistSizes = {jungleSize, lakeSize, rockySize, grassSize};

            int max = arraylistSizes[0];

            int bestTerrain = 0;

            for (int j = 0; j < arraylistSizes.length; j++){

                if (arraylistSizes[j] > max) {
                    max = arraylistSizes[j];
                    bestTerrain = j;
                }
            }

            if (max > tempMaxSize){
                hexIDPlusTerrain[0] = hexID; //hexid
                hexIDPlusTerrain[1] = bestTerrain;  //terrain max expansion

                tempMaxSize = max;
                meepleNeededToCompleteExpansion = max;
            }
        }

        String terrainToExpand = "";

        if (hexIDPlusTerrain[1] == 0){
            terrainToExpand = "Jungle";
        } else if (hexIDPlusTerrain[1] == 1){
            terrainToExpand = "Lake";
        } else if (hexIDPlusTerrain[1] == 2){
            terrainToExpand = "Rocky";
        } else if (hexIDPlusTerrain[1] == 3){
            terrainToExpand = "Grassland";
        }

        int buildOption = 2;
        
        if (terrainToExpand != ""){

            if (aiPlayer.getRemainingMeeples() - meepleNeededToCompleteExpansion >= 0){

                if (builder.extend(hexIDPlusTerrain[0], islandMap, aiPlayer,terrainToExpand)) {

                    return (new BuildResult(true, buildOption, hexIDPlusTerrain[0], terrainToExpand));
                }
            }

        }

        return (new BuildResult(false));
    }

    public BuildResult buildNextToHigherLevelHex() {

        BuildResult buildResult = findHexAtLevel3();

        int buildOption = 1;

        if (buildResult.buildSuccessfull){

            for(int i = 0; i < buildResult.listHexes.size(); i++){

                ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(buildResult.listHexes.get(i)));

                for (int j = 0; j < adjacentHexes.size(); j++){

                    if (builder.build(aiPlayer, islandMap, buildOption, adjacentHexes.get(j))){

                        return (new BuildResult(true, buildOption, adjacentHexes.get(j)));
                    }
                }

            }
        }

        buildResult = findHexAtLevel2();

        if (buildResult.buildSuccessfull){

            for(int i = 0; i < buildResult.listHexes.size(); i++){

                ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(buildResult.listHexes.get(i)));

                for (int j = 0; j < adjacentHexes.size(); j++){

                    if (builder.build(aiPlayer, islandMap, buildOption, adjacentHexes.get(j))){

                        return (new BuildResult(true, buildOption, adjacentHexes.get(j)));
                    }
                }

            }
        }

        return (new BuildResult(false));
    }



    private NukeResult placeTile() {

        NukeResult nukeResult;

        nukeResult = nukeSomeHex();

        if (nukeResult.nukingSuccessfull){

            return nukeResult;
        }

        nukeResult = placeTileSomewhere();

        if (nukeResult.nukingSuccessfull){

            return nukeResult;
        }

        return nukeResult;
    }

    public NukeResult nukeSomeHex() {

        ArrayList<Integer> activeHexesOnMap = islandMap.getAllHexesOnMap();

        int[] orientation = {0,60,120,180,240,300};

        for (int i = 0; i < activeHexesOnMap.size(); i++){

            if (islandMap.getHex(activeHexesOnMap.get(i)).getTerrain().equals("Volcano")){

                for ( int j = 0; j < orientation.length; j++) {

                    tile = new RotateTile(activeHexesOnMap.get(i), orientation[j]);

                    int[] pairs = tile.checkPair();

                    Nuking nuker = new Nuking();

                    if (nuker.canYouNukeSettlement(islandMap, pairs, activeHexesOnMap.get(i)) && ableToBuild()) {

                        if (islandMap.addTileToMap(activeHexesOnMap.get(i), orientation[j], terrainsArray, aiPlayer)){

                            System.out.println("NUKED SUCCESSFULLY");

                            System.out.print(activeHexesOnMap.get(i) + " " + orientation[j]);

                            return (new NukeResult(true, activeHexesOnMap.get(i), orientation[j]));
                        }
                    }
                }
            }
        }

        return (new NukeResult(false));
    }

    public BuildResult findHexAtLevel3() {

        boolean foundLevel3Hex = false;

        ArrayList<Integer> level3Hexes = new ArrayList<>();

        ArrayList<Integer> listHexesOnMap = islandMap.getAllHexesOnMap();

        for (int i = 0; i < listHexesOnMap.size(); i++){

            if(islandMap.getHex(listHexesOnMap.get(i)).getLevel() >= 3 && !(islandMap.getHex(listHexesOnMap.get(i)).getTerrain().equals("Volcano"))){

                level3Hexes.add(listHexesOnMap.get(i));

                foundLevel3Hex = true;
            }
        }

        if (foundLevel3Hex){
            return (new BuildResult(true,level3Hexes));
        }

        return (new BuildResult(false));
    }

    private BuildResult findHexAtLevel2() {

        boolean foundLevel3Hex = false;

        ArrayList<Integer> level3Hexes = new ArrayList<>();

        ArrayList<Integer> listHexesOnMap = islandMap.getAllHexesOnMap();

        for (int i = 0; i < listHexesOnMap.size(); i++){

            if(islandMap.getHex(listHexesOnMap.get(i)).getLevel() >= 2 && !(islandMap.getHex(listHexesOnMap.get(i)).getTerrain().equals("Volcano"))){

                level3Hexes.add(listHexesOnMap.get(i));

                foundLevel3Hex = true;
            }
        }

        if (foundLevel3Hex){
            return (new BuildResult(true,level3Hexes));
        }

        return (new BuildResult(false));

    }

    public MoveData BuildAction(NukeResult nukeResult, BuildResult buildResult) {

        if (buildResult.hexID == -1 || buildResult.hexID == 0){

            int buildOption = 1;

            MoveData info = new MoveData();

            HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

            for (int i = 0; i < allPossibleTiles.size(); i++){

                tile = new RotateTile(nukeResult.hexID, nukeResult.orientation);

                int[] pairs = tile.checkPair();

                if (builder.build(aiPlayer, islandMap, buildOption, pairs[1])){

                    int tileX = islandMap.getHex(nukeResult.hexID).getX();
                    int tileY = islandMap.getHex(nukeResult.hexID).getY();
                    int orientation = nukeResult.orientation;

                    int buildOptX = islandMap.getHex(pairs[1]).getX();
                    int buildOptY = islandMap.getHex(pairs[1]).getY();

                    int serverOrientation = rotationConverter.oursToServer(orientation);
                    int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);

                    info.setOrientation(serverOrientation);
                    info.setTilePlacementX(serverCoordinatesTile[0]);
                    info.setTilePlacementY(serverCoordinatesTile[1]);
                    info.setTilePlacementZ(serverCoordinatesTile[2]);

                    int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);

                    info.setBuildOption(buildOption);
                    info.setBuildOptionX(serverCoordinatesBuild[0]);
                    info.setBuildOptionY(serverCoordinatesBuild[1]);
                    info.setBuildOptionZ(serverCoordinatesBuild[2]);

                    return info;
                }
            }
        }

        MoveData info = new MoveData();

        int tileX = islandMap.getHex(nukeResult.hexID).getX();
        int tileY = islandMap.getHex(nukeResult.hexID).getY();
        int orientation = nukeResult.orientation;

        int buildOptX = islandMap.getHex(buildResult.hexID).getX();
        int buildOptY = islandMap.getHex(buildResult.hexID).getY();

        int serverOrientation = rotationConverter.oursToServer(orientation);
        int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);

        info.setOrientation(serverOrientation);
        info.setTilePlacementX(serverCoordinatesTile[0]);
        info.setTilePlacementY(serverCoordinatesTile[1]);
        info.setTilePlacementZ(serverCoordinatesTile[2]);

        int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);

        info.setBuildOption(buildResult.buildOption);
        info.setBuildOptionX(serverCoordinatesBuild[0]);
        info.setBuildOptionY(serverCoordinatesBuild[1]);
        info.setBuildOptionZ(serverCoordinatesBuild[2]);

        if (buildResult.buildOption == 2){
            info.setExtendTerrain(buildResult.terrainExtend);
        }

        return info;
    }

    public BuildResult foundNewSettlementSomewhere() {

        ArrayList<Integer> activeHexesOnMap = islandMap.getAllHexesOnMap();

        int buildOption = 1;

        for (int i = 0; i < activeHexesOnMap.size(); i++){

            Hex currentHex = islandMap.getHex(activeHexesOnMap.get(i));

            if(builder.verifyValidHexForSettlement(currentHex)){

                if (builder.build(aiPlayer, islandMap, buildOption,activeHexesOnMap.get(i))){

                    return (new BuildResult(true, buildOption, activeHexesOnMap.get(i)));
                }
            }

        }

        return (new BuildResult(false));
    }


    public BuildResult ableToExpand() {

        ArrayList<Integer> hexesThatCanBeExpanded = new ArrayList<>();

        boolean ableToExpandFromASettlement = false;

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        for (int i = 0; i < settlements.size(); i++){

            if (settlements.get(i) != -1) {

                ArrayList<Integer> hexes  = islandMap.getSettlementObj().getSettlementHexIDs(settlements.get(i));

                ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(hexes.get(0)));

                for (int j = 0; j < adjacentHexes.size(); j++){

                    if (!(islandMap.getHex(adjacentHexes.get(j)).getTerrain().equals("Volcano")) && islandMap.getHex(adjacentHexes.get(j)).getTileID() != -1 && islandMap.getHex(adjacentHexes.get(j)).checkIfHexIsNotSettled()){

                        hexesThatCanBeExpanded.add(hexes.get(0));

                        ableToExpandFromASettlement = true;
                    }
                }
            }
        }

        if (ableToExpandFromASettlement){

            return (new BuildResult(true, hexesThatCanBeExpanded));
        }

        return (new BuildResult(false));
    }

    public boolean ableToBuild() {

        ArrayList<Integer> activeHexesOnMap = islandMap.getAllHexesOnMap();

        int buildOption = 1;

        for (int i = 0; i < activeHexesOnMap.size(); i++){

            Hex currentHex = islandMap.getHex(activeHexesOnMap.get(i));

            if(builder.verifyValidHexForSettlement(currentHex)){

                return true;
            }

        }

        return false;
    }

    public NukeResult placeTileSomewhere() {

        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

        for (int i = 0; i < allPossibleTiles.size(); i++) {

            int[] tileInfo = allPossibleTiles.get(i);

            System.out.println(tileInfo[0] + " " + tileInfo[1]);

            if (islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer)) {

                return (new NukeResult(true, tileInfo[0], tileInfo[1]));
            }
        }

        return (new NukeResult(false));
    }

    public MoveData UnableToBuild() {

        System.out.println("NO MORE MEEEEPLLLEEEESSSS");

        int buildOption = 5; //UNABLE TO BUILD : because you ran out of meeples

        MoveData info = new MoveData();

        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

        int[] tileInfo = allPossibleTiles.get(0);

        islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer);

        tile = new RotateTile(tileInfo[0], tileInfo[1]);

        int[] pairs = tile.checkPair();

        builder.build(aiPlayer, islandMap, buildOption, pairs[1]);

        int tileX = islandMap.getHex(tileInfo[0]).getX();
        int tileY = islandMap.getHex(tileInfo[0]).getY();
        int orientation = tileInfo[1];
        int buildOptX = islandMap.getHex(pairs[1]).getX();
        int buildOptY = islandMap.getHex(pairs[1]).getY();

        int serverOrientation = rotationConverter.oursToServer(orientation);
        int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);

        info.setOrientation(serverOrientation);
        info.setTilePlacementX(serverCoordinatesTile[0]);
        info.setTilePlacementY(serverCoordinatesTile[1]);
        info.setTilePlacementZ(serverCoordinatesTile[2]);

        int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);

        info.setBuildOption(buildOption);
        info.setBuildOptionX(serverCoordinatesBuild[0]);
        info.setBuildOptionY(serverCoordinatesBuild[1]);
        info.setBuildOptionZ(serverCoordinatesBuild[2]);
        info.setBuildOption(buildOption);

        return info;
    }

    //given a tile it gets all the possible tile placement positions
    public HashMap<Integer, int[]> getAllPossibleTilePlacementPosition(ArrayList<Integer> tileArr) {

        HashMap<Integer, int[]> allPossibleTiles = new HashMap<>();

        int[] orientation = {0,60,120,180,240,300};

        int index = 0;

        for (int i = 0; i < tileArr.size(); i++){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(tileArr.get(i)));

            for (int j = 0; j < adjacentHexes.size(); j++){

                ArrayList<Integer> adjacentHexesAgain = validity.searchTheSixAdjacentHexes(islandMap.getHex(adjacentHexes.get(j)));

                for (int k =0; k < adjacentHexesAgain.size(); k++){

                    for (int l = 0; l < orientation.length; l++){

                        tile = new RotateTile(adjacentHexesAgain.get(k), orientation[l]);

                        if(validity.checkIfHexesCanBePlaced(islandMap.getHexGrid(), tile.checkPair()) && islandMap.isValidTilePlacement(tile)){

                            int[] tileInfo = {tile.HexID, orientation[l]};

                            allPossibleTiles.put(index, tileInfo);
                            index++;
                        }
                    }

                }
            }
        }

        return allPossibleTiles;
    }

    public void setTerrainsArray(String[] terrainsArray) {
        this.terrainsArray = terrainsArray;
    }

    public IslandMap getIslandMap() {
        return islandMap;
    }

    public Player getAiPlayer(){
        return aiPlayer;
    }

    public Player getServerPlayer(){
        return serverPlayer;
    }

    public void updateOpponentMove(MoveData moveData) {

        int ourOrientation = rotationConverter.serverToOurs(moveData.getOrientation());

//        System.out.println("Orientation " + ourOrientation);

        int[] ourCoordinatesTile = coordinateConverter.serverToOurs(moveData.getTilePlacementX(), moveData.getTilePlacementY(), moveData.getTilePlacementZ());

//        System.out.println("x " + moveData.getTilePlacementX());
//        System.out.println("y " + moveData.getTilePlacementY());
//        System.out.println("z " + moveData.getTilePlacementZ());

        String[] Terrains = moveData.getTerrainsArray();

        for (int i = 0; i < Terrains.length; i++){
            if (Terrains[i].equals("JUNGLE")){
                Terrains[i] = "Jungle";
            } else if (Terrains[i].equals("LAKE")){
                Terrains[i] = "Lake";
            } else if (Terrains[i].equals("ROCK")) {
                Terrains[i] = "Rocky";
            } else if (Terrains[i].equals("GRASS")) {
                Terrains[i] = "Grassland";
            }
        }

        int hexID = coordinateSystem.getHexID(ourCoordinatesTile[0], ourCoordinatesTile[1]);

//        System.out.println("Hex ID : " + hexID);

        islandMap.addTileToMap(hexID, ourOrientation, Terrains, serverPlayer);

        int buildOption = moveData.getBuildOption(); //1. found settlement, 2. expand, 3. totoro, 4. tiger

        String ExtendTerrain = "";

        int[] ourCoordinatesBuild = coordinateConverter.serverToOurs(moveData.getBuildOptionX(), moveData.getBuildOptionY(), moveData.getBuildOptionZ());

        switch (buildOption){
            case 1:
                builder.build(serverPlayer, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;

            case 2:
                ExtendTerrain = moveData.getExtendTerrain();
                builder.build(serverPlayer, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]), ExtendTerrain);
                break;
            case 3:
                builder.build(serverPlayer, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
            case 4:
                builder.build(serverPlayer, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
        }
    }

    public boolean hasAIPlayerPlacedAllTwoPieces(){
        return haveAllTwoPiecesBeenPlaced(aiPlayer);
    }

    public boolean hasServerPlayerPlacedAllTwoPieces(){
        return haveAllTwoPiecesBeenPlaced(serverPlayer);
    }

    private boolean haveAllTwoPiecesBeenPlaced(Player player){
        if(player.getRemainingMeeples() == 0){
            if(player.getRemainingTotoros() == 0){
                return true;
            }

            if(player.getRemainingTigers() == 0)
                return true;
        }
        else if(player.getRemainingTotoros() == 0){
            if(player.getRemainingTigers() == 0)
                return true;
        }

        return false;
    }

    public BuildResult BuildATigerPlayground() {

        BuildResult buildResult = findHexAtLevel3();

        if (buildResult.buildSuccessfull && aiPlayer.getRemainingTigers() != 0){

            for(int i = 0; i < buildResult.listHexes.size(); i++){

                Settlement settlement = islandMap.getSettlementObj();

                Hex currentHex = islandMap.getHex(buildResult.listHexes.get(i));

                if (builder.verifyValidHexForTiger(currentHex) && settlement.isTigerNextToSettlement(currentHex.getHexID(), aiPlayer)) {

                    int buildOption = 4;

                    if (builder.build(aiPlayer, islandMap, buildOption, buildResult.listHexes.get(i))){
                        return (new BuildResult(true, buildOption, buildResult.listHexes.get(i)));
                    }
                }
            }
        }

        return (new BuildResult(false));
    }
}
