/**
 * Created by alecasanas on 4/2/17.
 */

import java.util.*;

public class ALE_AI {

    private Game game = new Game();
    private IslandMap islandMap;
    private Builder builder = new Builder();
    private Player aiPlayer = new Player("White", 0);
    private Player serverPlayer = new Player("Black" , 0);

    private RotateTile tile;
    private RotationConverter rotationConverter = new RotationConverter();
    private CoordinateConverter coordinateConverter = new CoordinateConverter();
    private CoordinateSystem coordinateSystem = new CoordinateSystem();

    private String[] terrainsArray;

    private SettlementSizeChecker settlementSizeChecker;

    private PlacementValidity validity = new PlacementValidity();

    public ALE_AI(){
        this.islandMap = game.getIslandMap();
        this.aiPlayer = game.getWhitePlayer();
        this.serverPlayer = game.getBlackPlayer();


        // First tile will actually be placed in the center, this is for testing purposes
        //tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
        int[] tileHexIDsArray = {coordinateSystem.getHexID(99,99), coordinateSystem.getHexID(99,98),coordinateSystem.getHexID(100,98),
                coordinateSystem.getHexID(99,100), coordinateSystem.getHexID(100, 100)};
        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grassland"};
        islandMap.placeFirstTile(tileHexIDsArray, tileTerrainsArray);

        islandMap.printTilesOnMap();

    }

    public void setTerrainsArray(String[] terrainsArray){

        this.terrainsArray = terrainsArray;
    }

    public void updateOpponentMove(MoveData moveData){
        int ourOrientation = rotationConverter.serverToOurs(moveData.getOrientation());

        System.out.println("Orientation " + ourOrientation);

        int[] ourCoordinatesTile = coordinateConverter.serverToOurs(moveData.getTilePlacementX(), moveData.getTilePlacementY(), moveData.getTilePlacementZ());

        System.out.println("x " + moveData.getTilePlacementX());
        System.out.println("y " + moveData.getTilePlacementY());
        System.out.println("z " + moveData.getTilePlacementZ());

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

        System.out.println("Hex ID : " + hexID);

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

    public int findBestStrategy() {

        if (findAISettlements5orGreater(aiPlayer) != -1) return 1;  //build a totoro
        else if (youCanExpand()) return 2; //expand

        return 5;
    }

    private boolean youCanExpand() {

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        for (int i = 0; i < settlements.size(); i++){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getSettlementsMap().get(settlements.get(i)).get(0));

            if (settlements.get(i) != -1){

                return true;
            }
        }

        return false;
    }

    public int[] findTheBestExpansion(Player aiPlayer) {

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        int[] hexIDPlusTerrain = new int[2];  //hexID   terrain number

        int tempMaxSize = 0;

        for (int i = 1; i < settlements.size(); i++){

            ArrayList<Integer> hexIDs = islandMap.getSettlementsMap().get(settlements.get(i));

            int hexID = hexIDs.get(0);

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

            int bestTerrain = arraylistSizes[0];

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
            }
        }

        return hexIDPlusTerrain;
    }

    public MoveData play() {

        int strategy = findBestStrategy();

        switch (strategy) {

            case 1: return buildATotoroSantuary();

            case 2: return expandSettlement();

            case 5: return addMeepleSomewhere();

            default: return addMeepleSomewhere();
        }

    }

    public MoveData expandSettlement() {

        int[] theBestExpansion = findTheBestExpansion(aiPlayer);

        MoveData info = new MoveData();

        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

        int[] tileInfo = allPossibleTiles.get(0);

        islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer);

        tile = new RotateTile(tileInfo[0], tileInfo[1]);

        int buildOption = 2;

        String terrainToExpand = "";

        if (theBestExpansion[1] == 0){
            terrainToExpand = "Jungle";
        } else if (theBestExpansion[1] == 1){
            terrainToExpand = "Lake";
        } else if (theBestExpansion[1] == 2){
            terrainToExpand = "Rocky";
        } else if (theBestExpansion[1] == 3){
            terrainToExpand = "Grassland";
        }

        builder.build(aiPlayer, islandMap, buildOption, theBestExpansion[0], terrainToExpand);

        int tileX = islandMap.getHex(tileInfo[0]).getX();
        int tileY = islandMap.getHex(tileInfo[0]).getY();
        int orientation = tileInfo[1];
        int buildOptX = islandMap.getHex(theBestExpansion[0]).getX();
        int buildOptY = islandMap.getHex(theBestExpansion[0]).getY();

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
        info.setExtendTerrain(terrainToExpand);

        return info;
    }

    public MoveData addMeepleSomewhere() {

        MoveData info = new MoveData();

        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

        int[] tileInfo = allPossibleTiles.get(0);

        islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer);

        tile = new RotateTile(tileInfo[0], tileInfo[1]);

        int[] pairs = tile.checkPair();

        int buildOption = 1;

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

        return info;
    }


    public MoveData buildATotoroSantuary() {

        MoveData info = new MoveData();

        //get all hexes in the settlement
        ArrayList<Integer> hexesOnSettlement = islandMap.getSettlementsMap().get(findAISettlements5orGreater(aiPlayer));

        //see where you can place a totoro
        for(int i = 0; i < hexesOnSettlement.size(); i++){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(hexesOnSettlement.get(i)));

            for (int j = 0; j < adjacentHexes.size(); j++){

                if(builder.verifyValidHexForSettlement(islandMap.getHex(adjacentHexes.get(j)))){

                    HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

                    int[] tileInfo = allPossibleTiles.get(0);

                    islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer);

                    int buildOption = 3;

                    builder.build(aiPlayer, islandMap, buildOption, adjacentHexes.get(j));

                    int tileX = islandMap.getHex(tileInfo[0]).getX();
                    int tileY = islandMap.getHex(tileInfo[0]).getY();
                    int orientation = tileInfo[1];
                    int buildOptX = islandMap.getHex(adjacentHexes.get(j)).getX();
                    int buildOptY = islandMap.getHex(adjacentHexes.get(j)).getY();

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

        System.out.println("Could Not Find A Place to build a Totoro Santuary, so we build a new settlement");
        return addMeepleSomewhere();
    }

    public int findLargestSettlement(Player aiPlayer) {

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        int largestSettlement = 0;

        for (int i = 1; i < settlements.size(); i++){

            if (islandMap.getSettlementsMap().get(settlements.get(i)).size() > largestSettlement){
                largestSettlement = settlements.get(i);
            }
        }

        return largestSettlement;
    }


//    public MoveData expandSettlement() {
//
//        MoveData info = new MoveData();
//
//        int largestSettlement = findLargestSettlement(aiPlayer);
//
//        ArrayList<Integer> listHexes = islandMap.getSettlementsMap().get(largestSettlement);
//
//        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());
//
//        int[] tileInfo = allPossibleTiles.get(0);
//
//        islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer);
//
//        int buildOption = 2;
//
//        builder.build(aiPlayer, islandMap, buildOption, listHexes.get(0)); //expand on largest settlement
//
//        int tileX = islandMap.getHex(tileInfo[0]).getX();
//        int tileY = islandMap.getHex(tileInfo[0]).getY();
//        int orientation = tileInfo[1];
//        int buildOptX = islandMap.getHex(listHexes.get(0)).getX();
//        int buildOptY = islandMap.getHex(listHexes.get(0)).getY();
//
//        int serverOrientation = rotationConverter.oursToServer(orientation);
//        int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);
//
//        info.setOrientation(serverOrientation);
//        info.setTilePlacementX(serverCoordinatesTile[0]);
//        info.setTilePlacementY(serverCoordinatesTile[1]);
//        info.setTilePlacementZ(serverCoordinatesTile[2]);
//
//        int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);
//
//        info.setBuildOption(buildOption);
//        info.setBuildOptionX(serverCoordinatesBuild[0]);
//        info.setBuildOptionY(serverCoordinatesBuild[1]);
//        info.setBuildOptionZ(serverCoordinatesBuild[2]);
//
//        return info;
//
//
//        //System.out.println("Could Not Expand, so we build a new settlement");
//        return addMeepleSomewhere();
//    }

    public int findAISettlements5orGreater(Player aiPlayer) {

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        int foundSettlementID = -1;

        for (int i = 1; i < settlements.size(); i++){
            if (islandMap.getSettlementsMap().get(settlements.get(i)).size() >= 5 && islandMap.getSettlementObj().doesNotHaveATotoro(settlements.get(i),aiPlayer)){
                foundSettlementID = settlements.get(i);
            }
        }

        return foundSettlementID;
    }




    public MoveData getNewMove() {

        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

        MoveData info = new MoveData();

        int[] tileInfo = allPossibleTiles.get(0);

        String[] newTile = islandMap.getNewTile();

        islandMap.addTileToMap(tileInfo[0], tileInfo[1], newTile, aiPlayer);

        tile = new RotateTile(tileInfo[0], tileInfo[1]);

        int[] pairs = tile.checkPair();

        int buildOption = 1;

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

    public IslandMap getIslandMap() {
        return islandMap;
    }

    public Player getAiPlayer(){
        return aiPlayer;
    }

    public Player getServerPlayer(){
        return serverPlayer;
    }


}