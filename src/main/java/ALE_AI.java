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

    PlacementValidity validity = new PlacementValidity();

    private RotateTile tile;
    private RotationConverter rotationConverter = new RotationConverter();
    private CoordinateConverter coordinateConverter = new CoordinateConverter();
    private CoordinateSystem coordinateSystem = new CoordinateSystem();

    ArrayList<Integer> activeHexes = new ArrayList<Integer>() {{
        add(3014);
        add(2814);
        add(2815);
        add(3214);
        add(3215);
    }};

    public ALE_AI(){
        this.islandMap = game.getIslandMap();
        this.aiPlayer = game.getWhitePlayer();
        this.serverPlayer = game.getBlackPlayer();

        //PLACE STARTING TILE
        CoordinateSystem coors = new CoordinateSystem();
        // First tile will actually be placed in the center, this is for testing purposes
        //tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
        int[] tileHexIDsArray = {coors.getHexID(14,15), coors.getHexID(14,14),coors.getHexID(15,14),
                coors.getHexID(14,16), coors.getHexID(15, 16)};
        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grassland"};
        islandMap.placeFirstTile(tileHexIDsArray, tileTerrainsArray);
    }

    public void updateOpponentMove(MoveData moveData){
        int ourOrientation = rotationConverter.serverToOurs(moveData.getOrientation());
        int[] ourCoordinatesTile = coordinateConverter.serverToOurs(moveData.getTilePlacementX(), moveData.getTilePlacementY(), moveData.getTilePlacementZ());

        String[] Terrains = moveData.getTerrainsArray();

        int hexID = coordinateSystem.getHexID(ourCoordinatesTile[0], ourCoordinatesTile[1]);

        islandMap.addTileToMap(hexID, ourOrientation, Terrains, serverPlayer);

        int buildOption = moveData.getBuildOption(); //1. found settlement, 2. expand, 3. totoro, 4. tiger
        String ExtendTerrain = "";
        int[] ourCoordinatesBuild = coordinateConverter.serverToOurs(moveData.getBuildOptionX(), moveData.getBuildOptionY(), moveData.getBuildOptionZ());
        switch (buildOption){
            case 1:
                builder.build(serverPlayer, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
            case 3:
                builder.build(serverPlayer, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
            case 4:
                builder.build(serverPlayer, islandMap, buildOption, coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]));
                break;
        }

        if(buildOption == 2){
            ExtendTerrain = moveData.getExtendTerrain();
            System.out.println("ExtendTerrain in moveData is: " + ExtendTerrain);
            System.out.println("X coordinate is: " + ourCoordinatesBuild[0] + "\nY coordinate is: " + ourCoordinatesBuild[1]);
            builder.extendForAI(coordinateSystem.getHexID(ourCoordinatesBuild[0], ourCoordinatesBuild[1]), islandMap, serverPlayer, ExtendTerrain);
        }
        tile = new RotateTile(hexID, ourOrientation);
        int[] Tile = tile.checkPair();

    }

    public MoveData play() {

        HashMap<Integer, int[]> allPossibleTiles = getAllPossibleTilePlacementPosition(activeHexes);

        MoveData info = new MoveData();

        int[] tileInfo = allPossibleTiles.get(0);

        String[] newTile = islandMap.getNewTile();

        islandMap.addTileToMap(tileInfo[0], tileInfo[1], newTile, game.getWhitePlayer());

        tile = new RotateTile(tileInfo[0], tileInfo[1]);

        int[] pairs = tile.checkPair();

        int buildOption = 1;

        builder.build(game.getWhitePlayer(), islandMap, buildOption, pairs[1]);

        info.setBuildOption(buildOption);
        info.setOrientation(tileInfo[1]);
        info.setTilePlacementX(tileInfo[0]);

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

}