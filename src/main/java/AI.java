/**
 * Created by alecasanas on 4/2/17.
 */

import java.util.*;

public class AI {

    private Game game = new Game();
    private IslandMap islandMap;

    PlacementValidity validity = new PlacementValidity();

    private RotateTile tile;

    HashMap<Integer, int[]> allPossibleTiles = new HashMap<>();

    public AI(Game game, IslandMap islandMap){
        this.game = game;
        this.islandMap = islandMap;
    }

    public void play() {

        placeTile();
        build();
    }

    private void placeTile() {

        ArrayList<Integer> setOfSettlements = findOpponentsSettlementSizeThreeToFive();

        if (setOfSettlements.size() <= 1) {
            System.out.println("didn't found settlement of size 3 ++");
        } else {
            for (int i = 1; i < setOfSettlements.size(); i++){
                ArrayList<Integer> hexIDs = islandMap.getSettlementObj().getSettlementsMap().get(setOfSettlements.get(i));
                getAllPossibleTilePlacementPosition(hexIDs);
            }
        }
    }

    private void build(){

    }

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

                            allPossibleTiles.put(index, tile.checkPair());
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
            for(int i=0;i<3;i++){
                System.out.print(entry.getValue()[i] + " ");
            }
            System.out.println();
        }
    }
}
