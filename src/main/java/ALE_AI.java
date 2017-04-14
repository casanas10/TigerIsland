/**
 * Created by alecasanas on 4/2/17.
 */

import java.util.*;

public class ALE_AI {

    private Game game = new Game();

    private IslandMap islandMap;
    private Builder builder = new Builder();
    private Player aiPlayer;
    private Player serverPlayer;

    private RotateTile tile;
    private RotationConverter rotationConverter = new RotationConverter();
    private CoordinateConverter coordinateConverter = new CoordinateConverter();
    private CoordinateSystem coordinateSystem = new CoordinateSystem();

    private String[] terrainsArray;

    private SettlementSizeChecker settlementSizeChecker;

    private PlacementValidity validity = new PlacementValidity();

    private ArrayList<Integer> hexesThatCanBeExpanded = new ArrayList<>();

    private int touchingHex = -1;

    private boolean hexesLevel3 = false;

    public ALE_AI(){

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

    public void updateOpponentMove(MoveData moveData){
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

//    public int findBestStrategyForPlacingTotoros() {
//
//        //clear hexes that can be expanded
//        hexesThatCanBeExpanded.clear();
//
//       // if (findAISettlements5orGreater(aiPlayer) != -1) return 1;  //build a totoro
//
//         if (isThereSettlementThatHasTotoroAlready(aiPlayer) != -1) {
//
//            int settlementID = isThereSettlementThatHasTotoroAlready(aiPlayer);
//
//            if (itOnlyTouchingOneHexInTheSettlement(settlementID)){
//
//                return 2; //Try to nuke whats next to totoro
//            }
//        } else if (ableToExpand()) {
//            return 3; //expand
//        }
//
//        return 5;
//    }


    public MoveData play(){

       NukeResult result = nukingStrategy();

       if (!result.nukingSuccessfull){

           return addTileAndMeepleSomewhereInTheMap();
       }

       MoveData info = performNuking(result);

       return buildStrategy(info);
    }

    public MoveData buildStrategy(MoveData moveData) {

        BuildResult buildResult = ableToBuildATigerPlayground();

        if (buildResult.buildSuccessfull){

            return buildATigerPlayground(moveData, buildResult.hexID);
        }

        buildResult = ableToBuildATotoroSantuary();

        if (buildResult.buildSuccessfull){

            return buildATotoroSantuary(moveData, buildResult.foundSettlementToPlaceTotoro);
        }

//        buildResult = ableToFindLevel1HexToFoundNewSettlement();
//
//        if(buildResult.buildSuccessfull){
//
//            return foundNewSettlementNextToLevel3Hex(buildResult.hexID);
//        }


        //clear hexes that can be expanded
        hexesThatCanBeExpanded.clear();

        buildResult = ableToExpand();
        if (buildResult.buildSuccessfull){
            return expandSettlement(moveData);
        }

                //TODO change this to add just meeples
        return addTileAndMeepleSomewhereInTheMap();
    }

    public BuildResult ableToBuildATotoroSantuary() {

        BuildResult buildResult = findAISettlements5orGreater(aiPlayer);

        if (buildResult.buildSuccessfull){

            boolean ableTobuild = true;
            int buildOption = 3;

            return (new BuildResult(ableTobuild, buildOption, buildResult.foundSettlementToPlaceTotoro));
        }

        return (new BuildResult(false));
    }

    public BuildResult ableToBuildATigerPlayground() {

        ArrayList<Integer> level3Hexes = findHexLevel3();

        for (int i = 0; i < level3Hexes.size(); i++){

            if (checkIfLevel3HexHasSettlementAdjacentToIt(level3Hexes.get(i))){

                boolean successfull = true;
                int level3hex = level3Hexes.get(i);
                int buildOption = 4;

                return (new BuildResult(successfull, buildOption, level3hex));
            }
        }

        return (new BuildResult(false));
    }

    public MoveData performNuking(NukeResult result) {

        MoveData info = new MoveData();

        int tileX = islandMap.getHex(result.hexID).getX();
        int tileY = islandMap.getHex(result.hexID).getY();

        int serverOrientation = rotationConverter.oursToServer(result.orientation);
        int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);

        info.setOrientation(serverOrientation);
        info.setTilePlacementX(serverCoordinatesTile[0]);
        info.setTilePlacementY(serverCoordinatesTile[1]);
        info.setTilePlacementZ(serverCoordinatesTile[2]);

        return info;
    }

    public NukeResult nukingStrategy() {

        NukeResult result = nukeOpponentWith3HexesOrMore();

        if (result.nukingSuccessfull) {
            return result;
        }

        result = nukeHexAdjacentToTotoro();

        if (result.nukingSuccessfull){

            return result;
        }

        result = nukeOpponentSettlement();

        if(result.nukingSuccessfull){

            return result;
        }

        return (new NukeResult(false));
    }

    public NukeResult nukeOpponentSettlement() {

        //find the opponent's settlement
        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(serverPlayer);

        int[] orientation = {0,60,120,180,240,300};

        for (int i = 1; i < settlements.size(); i++){

            boolean settlementDoesNotHaveTotoro = islandMap.getSettlementObj().doesNotHaveATotoro(settlements.get(i),serverPlayer);

            //if settlement size is > 3 and it does not have a totoro
            if (settlementDoesNotHaveTotoro){

                ArrayList<Integer> listHexesInSettlement = islandMap.getSettlementObj().getSettlementHexIDs(settlements.get(i));

                for (int j = 0; j < listHexesInSettlement.size(); j++){

                    ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(listHexesInSettlement.get(j)));

                    for (int k = 0; k < adjacentHexes.size(); k++){

                        if (islandMap.getHex(adjacentHexes.get(k)).getTerrain().equals("Volcano")){

                            Nuking nuker = new Nuking();

                            for ( int l = 0; l < orientation.length; l++){

                                tile = new RotateTile(adjacentHexes.get(k), orientation[l]);

                                int[] pairs = tile.checkPair();

                                if(nuker.canYouNukeSettlement(islandMap, pairs , adjacentHexes.get(k))){

                                    System.out.println(adjacentHexes.get(k)+ " " + orientation[l]);

                                    if (listHexesInSettlement.contains(pairs[1]) && listHexesInSettlement.contains(pairs[2])){

                                        if (islandMap.addTileToMap(adjacentHexes.get(k), orientation[l], terrainsArray, aiPlayer)){
                                            System.out.println("Nuked Both Meeples");

                                            boolean successfull = true;

                                            return (new NukeResult(successfull, adjacentHexes.get(k), orientation[l]));
                                        }

                                    } else {

                                        if (islandMap.addTileToMap(adjacentHexes.get(k), orientation[l], terrainsArray, aiPlayer)){
                                            System.out.println("Nuked One Meeple");

                                            boolean successfull = true;
                                            return (new NukeResult(successfull, adjacentHexes.get(k), orientation[l]));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return (new NukeResult(false));
    }


    public MoveData buildATigerPlayground(MoveData moveData, Integer level3Hex) {

        int buildOption = 4;

        if (builder.build(aiPlayer, islandMap, buildOption, level3Hex)){
            System.out.println("Placed a tiger");

            int buildOptX = islandMap.getHex(level3Hex).getX();
            int buildOptY = islandMap.getHex(level3Hex).getY();

            int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);

            moveData.setBuildOption(buildOption);
            moveData.setBuildOptionX(serverCoordinatesBuild[0]);
            moveData.setBuildOptionY(serverCoordinatesBuild[1]);
            moveData.setBuildOptionZ(serverCoordinatesBuild[2]);

            return moveData;
        }

        return addMeepleToAnExistingSettlement();
    }

//    public MoveData play() {
//
////        int strategy = findBestStrategyForPlacingTigers();
////
////        switch (strategy) {
////
////           // case 1: sendBuildTigerToServer(MoveData moveData);
////
////            case 5: return addTileAndMeepleSomewhereInTheMap();
////
////            default: return addTileAndMeepleSomewhereInTheMap();
////        }
//
//
//        if (aiPlayer.getRemainingMeeples() == 0){
//
//            int buildOption = 5; //UNABLE TO BUILD : because you ran out of meeples
//
//            MoveData info = new MoveData();
//
//            HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());
//
//            int[] tileInfo = allPossibleTiles.get(0);
//
//            islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer);
//
//            tile = new RotateTile(tileInfo[0], tileInfo[1]);
//
//            int[] pairs = tile.checkPair();
//
//            builder.build(aiPlayer, islandMap, buildOption, pairs[1]);
//
//            int tileX = islandMap.getHex(tileInfo[0]).getX();
//            int tileY = islandMap.getHex(tileInfo[0]).getY();
//            int orientation = tileInfo[1];
//            int buildOptX = islandMap.getHex(pairs[1]).getX();
//            int buildOptY = islandMap.getHex(pairs[1]).getY();
//
//            int serverOrientation = rotationConverter.oursToServer(orientation);
//            int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);
//
//            info.setOrientation(serverOrientation);
//            info.setTilePlacementX(serverCoordinatesTile[0]);
//            info.setTilePlacementY(serverCoordinatesTile[1]);
//            info.setTilePlacementZ(serverCoordinatesTile[2]);
//
//            int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);
//
//            info.setBuildOption(buildOption);
//            info.setBuildOptionX(serverCoordinatesBuild[0]);
//            info.setBuildOptionY(serverCoordinatesBuild[1]);
//            info.setBuildOptionZ(serverCoordinatesBuild[2]);
//            info.setBuildOption(buildOption);
//
//            return info;
//        }
//
//        int strategy = findBestStrategyForPlacingTotoros();
//
//        switch (strategy) {
//
//            case 1: return buildATotoroSantuary();
//
//            case 2: return nukeHexNextToTheTotoro();
//
//            case 3: return expandSettlement();
//
//            case 5: return addTileAndMeepleSomewhereInTheMap();
//
//            default: return addTileAndMeepleSomewhereInTheMap();
//        }
//
//    }

//    public MoveData nukeHexNextToTheTotoro() {
//
//        MoveData info = new MoveData();
//
//        if (touchingHex != -1){
//
//            //find all the adjacent hexes next to the hex that is touching totoro
//            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(touchingHex));
//
//            int[] orientation = {0,60,120,180,240,300};
//
//            for (int i = 0; i < adjacentHexes.size(); i++){
//
//                if (islandMap.getHex(adjacentHexes.get(i)).getTerrain().equals("Volcano")){
//
//                    Nuking nuker = new Nuking();
//
//                    for (int j = 0; j < orientation.length; j++){
//
//                        tile = new RotateTile(adjacentHexes.get(i), orientation[j]);
//
//                        int[] pairs = tile.checkPair();
//
//                        if (nuker.canYouNukeSettlement(islandMap, pairs , adjacentHexes.get(i))){
//
//                            if (pairs[1] == touchingHex || pairs[2] == touchingHex){
//
//                                if (islandMap.addTileToMap(adjacentHexes.get(i), orientation[j], terrainsArray, aiPlayer)){
//                                    System.out.println(adjacentHexes.get(i));
//
//                                    //if able to expand and build
//                                    if (ableToExpand()){
//
//                                        int[] theBestExpansion = findTheBestExpansion(aiPlayer);
//
//                                        int buildOption = 2;
//
//                                        String terrainToExpand = "";
//
//                                        if (theBestExpansion[1] == 0){
//                                            terrainToExpand = "Jungle";
//                                        } else if (theBestExpansion[1] == 1){
//                                            terrainToExpand = "Lake";
//                                        } else if (theBestExpansion[1] == 2){
//                                            terrainToExpand = "Rocky";
//                                        } else if (theBestExpansion[1] == 3){
//                                            terrainToExpand = "Grassland";
//                                        }
//
//
//                                        if (builder.build(aiPlayer, islandMap, buildOption, theBestExpansion[0], terrainToExpand)){
//
//                                            int tileX = islandMap.getHex(adjacentHexes.get(i)).getX();
//                                            int tileY = islandMap.getHex(adjacentHexes.get(i)).getY();
//
//                                            int buildOptX = islandMap.getHex(theBestExpansion[0]).getX();
//                                            int buildOptY = islandMap.getHex(theBestExpansion[0]).getY();
//
//                                            int serverOrientation = rotationConverter.oursToServer(orientation[j]);
//                                            int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);
//                                            info.setOrientation(serverOrientation);
//                                            info.setTilePlacementX(serverCoordinatesTile[0]);
//                                            info.setTilePlacementY(serverCoordinatesTile[1]);
//                                            info.setTilePlacementZ(serverCoordinatesTile[2]);
//
//                                            int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);
//
//                                            info.setBuildOption(buildOption);
//                                            info.setBuildOptionX(serverCoordinatesBuild[0]);
//                                            info.setBuildOptionY(serverCoordinatesBuild[1]);
//                                            info.setBuildOptionZ(serverCoordinatesBuild[2]);
//                                            info.setExtendTerrain(terrainToExpand);
//
//                                            return info;
//                                        } else {
//                                            System.out.println("*****UNABLE TO BUILD*****");
//                                            buildOption = 5; //UNABLE TO BUILD : because you ran out of meeples
//
//                                            int tileX = islandMap.getHex(adjacentHexes.get(i)).getX();
//                                            int tileY = islandMap.getHex(adjacentHexes.get(i)).getY();
//
//                                            int buildOptX = islandMap.getHex(theBestExpansion[0]).getX();
//                                            int buildOptY = islandMap.getHex(theBestExpansion[0]).getY();
//
//                                            int serverOrientation = rotationConverter.oursToServer(orientation[j]);
//                                            int[] serverCoordinatesTile = coordinateConverter.oursToServer(tileX, tileY);
//                                            info.setOrientation(serverOrientation);
//                                            info.setTilePlacementX(serverCoordinatesTile[0]);
//                                            info.setTilePlacementY(serverCoordinatesTile[1]);
//                                            info.setTilePlacementZ(serverCoordinatesTile[2]);
//
//                                            int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);
//
//                                            info.setBuildOption(buildOption);
//                                            info.setBuildOptionX(serverCoordinatesBuild[0]);
//                                            info.setBuildOptionY(serverCoordinatesBuild[1]);
//                                            info.setBuildOptionZ(serverCoordinatesBuild[2]);
//                                            info.setExtendTerrain(terrainToExpand);
//
//                                            return info;
//                                        }
//
//                                    } else {
//
//                                        return addMeepleToAnExistingSettlement();
//
//                                    }
//
//                                }
//
//                            }
//
//                        }
//                    }
//
//                }
//
//            }
//
//        }
//
//        return addTileAndMeepleSomewhereInTheMap();
//    }

    public BuildResult ableToExpand() {

        boolean ableToExpandFromASettlement = false;

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        for (int i = 0; i < settlements.size(); i++){

            if (settlements.get(i) != -1) {

                ArrayList<Integer> hexes  = islandMap.getSettlementObj().getSettlementHexIDs(settlements.get(i));

                ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(hexes.get(0)));

                for (int j = 0; j < adjacentHexes.size(); j++){

                    if (!(islandMap.getHex(adjacentHexes.get(j)).getTerrain().equals("Volcano")) && islandMap.getHex(adjacentHexes.get(j)).getTileID() != -1 && islandMap.getHex(adjacentHexes.get(j)).checkIfHexIsNotSettled()){

                        hexesThatCanBeExpanded.add(hexes.get(0));
//                        System.out.println(adjacentHexes.get(j));
                        return (new BuildResult(ableToExpandFromASettlement));
                    }
                }

            }
        }

        return (new BuildResult(false));
    }

    public int[] findTheBestExpansion(Player aiPlayer) {

        int tempMaxSize = 0;
        int[] hexIDPlusTerrain = new int[2];

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
            }
        }

        return hexIDPlusTerrain;
    }

    //TODO build the totoro so that it only touches one hex on in the edge of the settlement so that you can nuke and make another settlement of size 5
    public MoveData buildATotoroSantuary(MoveData moveData, int foundSettlementToPlaceATotoro) {

        //get all hexes in the settlement
        ArrayList<Integer> hexesOnSettlement = islandMap.getSettlementsMap().get(foundSettlementToPlaceATotoro);

        //see where you can place a totoro
        for(int i = 0; i < hexesOnSettlement.size(); i++){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(hexesOnSettlement.get(i)));

            for (int j = 0; j < adjacentHexes.size(); j++){

                if(builder.verifyValidHexForSettlement(islandMap.getHex(adjacentHexes.get(j)))) {

                    int buildOption = 3;

                    if (builder.build(aiPlayer, islandMap, buildOption, adjacentHexes.get(j))) {

                        int buildOptX = islandMap.getHex(adjacentHexes.get(j)).getX();
                        int buildOptY = islandMap.getHex(adjacentHexes.get(j)).getY();

                        int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);

                        moveData.setBuildOption(buildOption);
                        moveData.setBuildOptionX(serverCoordinatesBuild[0]);
                        moveData.setBuildOptionY(serverCoordinatesBuild[1]);
                        moveData.setBuildOptionZ(serverCoordinatesBuild[2]);

                        return moveData;
                    }
                }
            }
        }

        System.out.println("Could Not Find A Place to build a Totoro Santuary, so we build a new settlement");
        return addMeepleToAnExistingSettlement();
    }

    public MoveData expandSettlement(MoveData moveData) {

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

       if (builder.build(aiPlayer, islandMap, buildOption, theBestExpansion[0], terrainToExpand)){

           System.out.println("EXPANDED SUCCESSFULLY");

           info.setOrientation(moveData.getOrientation());
           info.setTilePlacementX(moveData.getTilePlacementX());
           info.setTilePlacementY(moveData.getTilePlacementY());
           info.setTilePlacementZ(moveData.getTilePlacementZ());

           int buildOptX = islandMap.getHex(theBestExpansion[0]).getX();
           int buildOptY = islandMap.getHex(theBestExpansion[0]).getY();

           int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);

           info.setBuildOption(buildOption);
           info.setBuildOptionX(serverCoordinatesBuild[0]);
           info.setBuildOptionY(serverCoordinatesBuild[1]);
           info.setBuildOptionZ(serverCoordinatesBuild[2]);
           info.setExtendTerrain(terrainToExpand);

           return info;

       }

       return addMeepleToAnExistingSettlement();
    }

    public MoveData addTileAndMeepleSomewhereInTheMap() {

        MoveData info = new MoveData();

        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(islandMap.getAllHexesOnMap());

        for (int i = 0; i < allPossibleTiles.size(); i++){

            int[] tileInfo = allPossibleTiles.get(i);

            if (islandMap.addTileToMap(tileInfo[0], tileInfo[1], terrainsArray, aiPlayer)){

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

        }

        return info;
    }

    public MoveData addMeepleToAnExistingSettlement() {

        MoveData info = new MoveData();

        int buildOption = 1;

        int largestSettlement = findLargestSettlement(aiPlayer);

        if (largestSettlement != -1){

            ArrayList<Integer> hexesInSettlement = islandMap.getSettlementObj().getSettlementHexIDs(largestSettlement);

            for (int i = 0 ; i < hexesInSettlement.size(); i++){

                ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(hexesInSettlement.get(i)));

                for (int j = 0; j < adjacentHexes.size(); j++){

                    if (builder.build(aiPlayer, islandMap, buildOption, adjacentHexes.get(j))){

                        int buildOptX = islandMap.getHex(adjacentHexes.get(j)).getX();
                        int buildOptY = islandMap.getHex(adjacentHexes.get(j)).getY();

                        int[] serverCoordinatesBuild = coordinateConverter.oursToServer(buildOptX, buildOptY);

                        info.setBuildOption(buildOption);
                        info.setBuildOptionX(serverCoordinatesBuild[0]);
                        info.setBuildOptionY(serverCoordinatesBuild[1]);
                        info.setBuildOptionZ(serverCoordinatesBuild[2]);

                        return info;
                    }
                }
            }

        }

        return addTileAndMeepleSomewhereInTheMap();
    }

    public int findLargestSettlement(Player aiPlayer) {

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        int largestSettlement = -1;

        for (int i = 1; i < settlements.size(); i++){

            if (islandMap.getSettlementsMap().get(settlements.get(i)).size() > largestSettlement){
                largestSettlement = settlements.get(i);
            }
        }

        return largestSettlement;
    }

    public BuildResult findAISettlements5orGreater(Player aiPlayer) {

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        int foundSettlementID = -1;

        for (int i = 1; i < settlements.size(); i++){
            if (islandMap.getSettlementsMap().get(settlements.get(i)).size() >= 5 && islandMap.getSettlementObj().doesNotHaveATotoro(settlements.get(i),aiPlayer)){
                foundSettlementID = settlements.get(i);

                return (new BuildResult(true, 3, foundSettlementID));
            }
        }

        return (new BuildResult(false));
    }

    public int isThereSettlementThatHasTotoroAlready(Player aiPlayer) {

        int settlementID = -1;

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        for (int i = 1; i < settlements.size(); i++){
            if (!(islandMap.getSettlementObj().doesNotHaveATotoro(settlements.get(i),aiPlayer))){
                settlementID = settlements.get(i);
            }
        }

        return settlementID;
    }

    public boolean itOnlyTouchingOneHexInTheSettlement(int settlementID) {

        ArrayList<Integer> listHexes = islandMap.getSettlementObj().getSettlementHexIDs(settlementID);

        int totoro = -1;

        for (int i = 0; i < listHexes.size(); i++){
            if (islandMap.getHex(listHexes.get(i)).getPieceOnHex().equals("Totoro")){
                totoro = listHexes.get(i);  //finds the totoro in the settlement
            }
        }

        int countHexes = 0;

        if (totoro != -1){

            ArrayList<Integer> adjacentHexesAroundTheTotoro = validity.searchTheSixAdjacentHexes(islandMap.getHex(totoro));

            for (int j = 0; j < adjacentHexesAroundTheTotoro.size(); j++){

                //if hexes is settled and next to a piece of the same player
                if (!(islandMap.getHex(adjacentHexesAroundTheTotoro.get(j)).checkIfHexIsNotSettled()) && islandMap.getHex(adjacentHexesAroundTheTotoro.get(j)).getPlayerColorOnHex() == aiPlayer.getPlayerColor()){
//                    System.out.println(adjacentHexesAroundTheTotoro.get(j));
                    this.touchingHex = adjacentHexesAroundTheTotoro.get(j);
                    countHexes++;
                }

            }
        }

        if (countHexes == 1) return true;

        return false;
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

    public void setTerrainsArray(String[] terrainsArray){

        this.terrainsArray = terrainsArray;
    }

    public ArrayList<Integer> findHexLevel3() {

        ArrayList<Integer> level3Hexes = new ArrayList<>();

        ArrayList<Integer> listHexesOnMap = islandMap.getAllHexesOnMap();

        for (int i = 0; i < listHexesOnMap.size(); i++){

            if(islandMap.getHex(listHexesOnMap.get(i)).getLevel() == 3 && !(islandMap.getHex(listHexesOnMap.get(i)).getTerrain().equals("Volcano"))){

                level3Hexes.add(listHexesOnMap.get(i));

                hexesLevel3 = true;
            }
        }

        return level3Hexes;
    }

    public boolean checkIfLevel3HexHasSettlementAdjacentToIt(int hexID) {

        ArrayList<Integer> level3Hexes = findHexLevel3();

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(aiPlayer);

        for (int i = 1; i < settlements.size(); i++){

            ArrayList<Integer> playerHexesInSettlements = islandMap.getSettlementObj().getSettlementHexIDs(settlements.get(i));

            for (int j = 0; j < playerHexesInSettlements.size(); j++){

                ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(hexID));

                for (int l = 0; l < adjacentHexes.size(); l++){

                    if (playerHexesInSettlements.contains(adjacentHexes.get(j))){

//                        System.out.println(adjacentHexes.get(j));
                        return true;
                    }

                }

            }
        }

        return false;
    }

    public NukeResult nukeOpponentWith3HexesOrMore() {

        boolean successfull = false;

        //find the opponent's settlement
        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(serverPlayer);

        int settlementSize = 3;

        int[] orientation = {0,60,120,180,240,300};

        for (int i = 1; i < settlements.size(); i++){

            boolean settlementDoesNotHaveTotoro = islandMap.getSettlementObj().doesNotHaveATotoro(settlements.get(i),serverPlayer);
            boolean isSettlementSizeGreaterThan3 = islandMap.getSettlementsMap().get(settlements.get(i)).size() >= settlementSize;

            //if settlement size is > 3 and it does not have a totoro
            if (isSettlementSizeGreaterThan3 && settlementDoesNotHaveTotoro){

                ArrayList<Integer> listHexesInSettlement = islandMap.getSettlementObj().getSettlementHexIDs(settlements.get(i));

                for (int j = 0; j < listHexesInSettlement.size(); j++){

                    ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(listHexesInSettlement.get(j)));

                    for (int k = 0; k < adjacentHexes.size(); k++){

                        System.out.println(adjacentHexes.get(k));

                        if (islandMap.getHex(adjacentHexes.get(k)).getTerrain().equals("Volcano")){

                            System.out.println(adjacentHexes.get(k));

                            Nuking nuker = new Nuking();

                            for ( int l = 0; l < orientation.length; l++){

                                tile = new RotateTile(adjacentHexes.get(k), orientation[l]);

                                int[] pairs = tile.checkPair();

                                if(nuker.canYouNukeSettlement(islandMap, pairs , adjacentHexes.get(k))){

                                    if (listHexesInSettlement.contains(pairs[1]) && listHexesInSettlement.contains(pairs[2])){

                                        if (islandMap.addTileToMap(adjacentHexes.get(k), orientation[l], terrainsArray, aiPlayer)){
                                            System.out.println("Nuked Both Meeples");
                                            successfull = true;

                                            return (new NukeResult(successfull, adjacentHexes.get(k), orientation[l]));
                                        }

                                    } else {

                                        if (islandMap.addTileToMap(adjacentHexes.get(k), orientation[l], terrainsArray, aiPlayer)){
                                            System.out.println("Nuked One Meeple");

                                            successfull = true;
                                            return (new NukeResult(successfull, adjacentHexes.get(k), orientation[l]));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return (new NukeResult(successfull));
    }

    public NukeResult nukeHexAdjacentToTotoro() {

        if (isThereSettlementThatHasTotoroAlready(aiPlayer) != -1) {

            int settlementID = isThereSettlementThatHasTotoroAlready(aiPlayer);

            if (itOnlyTouchingOneHexInTheSettlement(settlementID)) {

                //NUKE IT PLACING TILE AND RETURN NUKE RESULT

                if (touchingHex != -1) {

                    //find all the adjacent hexes next to the hex that is touching totoro
                    ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(touchingHex));

                    int[] orientation = {0, 60, 120, 180, 240, 300};

                    for (int i = 0; i < adjacentHexes.size(); i++) {

                        if (islandMap.getHex(adjacentHexes.get(i)).getTerrain().equals("Volcano")) {

                            Nuking nuker = new Nuking();

                            for (int j = 0; j < orientation.length; j++) {

                                tile = new RotateTile(adjacentHexes.get(i), orientation[j]);

                                int[] pairs = tile.checkPair();

                                if (nuker.canYouNukeSettlement(islandMap, pairs, adjacentHexes.get(i))) {

                                    if (pairs[1] == touchingHex || pairs[2] == touchingHex) {

                                        if (islandMap.addTileToMap(adjacentHexes.get(i), orientation[j], terrainsArray, aiPlayer)) {
                                            System.out.println(adjacentHexes.get(i));
                                            System.out.println(orientation[j]);


                                            return (new NukeResult(true, adjacentHexes.get(i), orientation[j]));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return (new NukeResult(false));
    }

    private MoveData makeFirstMove() {

        MoveData info = new MoveData();

        int hexId = coordinateSystem.getHexID(99,99);
        int orientation = 0;

        //either build on one side or the other of the mega tile
        if (islandMap.addTileToMap(hexId + 1, 120, terrainsArray, aiPlayer)){
            hexId = hexId + 1;
            orientation = 120;
        } else {
            islandMap.addTileToMap(hexId - 1, 300, terrainsArray, aiPlayer);
            orientation = 300;
        }

        tile = new RotateTile(hexId, orientation);

        int[] pairs = tile.checkPair();

        int buildOption = 1;

        builder.build(aiPlayer, islandMap, buildOption, pairs[1]);

        int tileX = islandMap.getHex(hexId).getX();
        int tileY = islandMap.getHex(hexId).getY();

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