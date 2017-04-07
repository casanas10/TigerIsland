/**
 * Created by alecasanas on 4/2/17.
 */

import java.util.*;

public class ALE_AI {

    private Game game = new Game();
    private IslandMap islandMap;
    private Builder builder = new Builder();

    PlacementValidity validity = new PlacementValidity();

    private RotateTile tile;

    HashMap<Integer, int[]> allPossibleTiles = new HashMap<>();

    //CONSTANTS FOR FIRST TILE
    private static final int hex1  = 3014;
    private static final int hex2  = 2814;
    private static final int hex3  = 2815;
    private static final int hex4  = 3214;
    private static final int hex5  = 3215;


    public ALE_AI(Game game){
        this.game = game;
        this.islandMap = game.getIslandMap();
    }

    public void play() {

        ArrayList<Integer> settlements = islandMap.getPlayerSettlement(game.getWhitePlayer());  //gets player settlements

        int[] tileInfo = allPossibleTiles.get(0);

        boolean tileSuccessfullyPlaced = islandMap.addTileToMap(tileInfo[0], tileInfo[1], islandMap.getNewTile(), game.getWhitePlayer());

        tile = new RotateTile(tileInfo[0], tileInfo[1]);

        int[] pairs = tile.checkPair();

        builder.build(game.getWhitePlayer(), islandMap, 1, pairs[1]);
    }

//    private void placeTile() {
//
//        ArrayList<Integer> setOfSettlements = findOpponentsSettlementSizeThreeToFive();
//
//        if (setOfSettlements.size() <= 1) {
//            System.out.println("didn't found settlement of size 3 ++");
//        } else {
//            for (int i = 1; i < setOfSettlements.size(); i++){
//                ArrayList<Integer> hexIDs = islandMap.getSettlementObj().getSettlementsMap().get(setOfSettlements.get(i));
//                getAllPossibleTilePlacementPosition(hexIDs);
//            }
//        }
//    }
//
//    private void build(){
//
//    }

    //given a tile it gets all the possible tile placement positions
    public HashMap<Integer, int[]> getAllPossibleTilePlacementPosition(ArrayList<Integer> tileArr) {

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

    public ArrayList<Integer> findOpponentsSettlementSizeThreeToFive() {

        HashMap<Integer, ArrayList<Integer>> settlements = islandMap.getSettlementsMap();

        ArrayList<Integer> settleKey = new ArrayList<Integer>() {{
            add(-1);
        }};

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = settlements.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();

            if (entry.getValue().size() >= 3){
                settleKey.add(entry.getKey());
            }
        }

        return settleKey;
    }

    public void printAllPossibleTiles(){
        Iterator<Map.Entry<Integer, int[]>> iterator = allPossibleTiles.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, int[]> entry = iterator.next();
            System.out.print("Tile " + entry.getKey() + ": ");
            for(int i=0;i<2;i++){
                System.out.print(entry.getValue()[i] + " ");
            }
            System.out.println();
        }
    }
}