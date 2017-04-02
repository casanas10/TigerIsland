/**
 * Created by alecasanas on 4/2/17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    //given a tile it gets all the possible tile placement positions
    public HashMap<Integer, int[]> getAllPossibleTilePlacementPosition(int[] tileArr) {

        int[] orientation = {0,60,120,180,240,300};

        int index = 0;

        for (int i = 0; i < tileArr.length; i++){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(tileArr[i]));

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

    public void findOpponentsSettlementSizeThreeToFive() {
        islandMap.getSettlementObj().printAllSettlements();
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
