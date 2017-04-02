import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by alecasanas on 3/27/17.
 */
public class AI {

    private Game game = new Game();
    private IslandMap islandMap;

    PlacementValidity validity = new PlacementValidity();

    private RotateTile tile;

    HashMap<Integer, int[]> allPossibleTiles = new HashMap<>();

    ArrayList<Integer> ActiveSettlements = new ArrayList<>();

    SettlementSizeChecker settlementSizeChecker;

    Settlement settlements;

    public Settlement settMap;


    public AI(Game game){
        this.game = game;
        this.islandMap = new IslandMap();
    }
/*
    public ArrayList<Integer> SettlementSmallerThanFive(HexGrid hexGrid, Player player){
        ArrayList<Integer> settlementIDs = new ArrayList<>();
        for(int i = 0; i<ActiveSettlements.size(); i++){
            if(settMap.getSettlementSize(ActiveSettlements.get(i)) < 5){
                settlementIDs = settMap.getSettlementIDs(ActiveSettlements.get(i));
                if(hexGrid.getHexValue(ActiveSettlements.get(i)).getPlayerColorOnHex() == player.getPlayerColor()){
                    settlementIDs = settMap.getSettlementIDs(ActiveSettlements.get(i));
                    return settlementIDs;
                }
            }
        }
        return settlementIDs;
    }
*/
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
