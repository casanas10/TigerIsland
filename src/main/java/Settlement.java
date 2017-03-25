/**
 * Created by alecasanas on 3/25/17.
 */
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Val on 3/24/2017.
 */
public class Settlement {

    private ArrayList<Integer> hexIDContainer = new ArrayList<Integer>();

    private HashMap<Integer, ArrayList<Integer>> settlementMap = new HashMap<Integer, ArrayList<Integer>>();

    private PlacementValidity validatePlacement = new PlacementValidity();

    CoordinateSystem coor = new CoordinateSystem();

    private HexGrid hexGrid;

    private SettlementSizeChecker settlementSizeChecker;

    private int id = 0;

    Settlement(HexGrid hexGrid) {
        this.hexGrid = hexGrid;
        this.settlementSizeChecker = new SettlementSizeChecker(hexGrid);
    }

    public void addToSettlement(int hexID, Player player){

        if (isNewSettlement(hexID,player)){
            foundNewSettlement(hexID, player);
        } else {
            addPieceToAnExistingSettlement(hexGrid, hexID, player);
        }
    }




    public void addPieceToAnExistingSettlement(HexGrid hexGrid, int hexID, Player player) {

        PlacementValidity validity = new PlacementValidity();

        ArrayList<Integer> hexes = validity.searchTheSixAdjacentHexes(hexGrid,hexGrid.getHexValue(hexID));

        ArrayList<Integer> setIDPlaceHolder = new ArrayList<Integer>();

        int settID = 0;


        for (int i = 0; i < hexes.size(); i++){

            if(hexGrid.getHexValue(hexes.get(i)).getSettlementID() != - 1){

                settID = getSettlementID(hexGrid, hexes.get(i));
                setIDPlaceHolder.add(hexGrid.getHexValue(hexes.get(i)).getSettlementID());
                settlementMap.remove(hexGrid.getHexValue(hexes.get(i)).getSettlementID());


            }
        }
        System.out.println("here");
        ArrayList<Integer> NewHexIDs = new ArrayList<Integer>();
        NewHexIDs = settlementSizeChecker.BFS(hexID, player);

        System.out.println("here");

        for(int i = 0; i<NewHexIDs.size(); i++){

            System.out.println(NewHexIDs.get(i));
            //setSettlementID(hexGrid, NewHexIDs.get(i), id);
        }


        settlementMap.put(settID, NewHexIDs);
        id++;
    }


    public void foundNewSettlement(int hexID, Player player) {

        hexIDContainer.add(hexID);

        setSettlementID(hexGrid,hexID, id);
        settlementMap.put(id, hexIDContainer);

        id++;

    }

    public boolean isPiecePartOfASettlement(int settlementID, int hexID) {

        ArrayList<Integer> HexIDs =  settlementMap.get(settlementID);

        for (int i = 0; i < HexIDs.size(); i++){
            if (HexIDs.contains(hexID)){
                return true;
            }
        }

        return false;
    }

    public boolean isNewSettlement(int hexID, Player player){

        if(settlementSizeChecker.checkSettlementSize(hexID, player).size() == 1){
            return true;
        }

        return false;
    }

    public int getSettlementID(HexGrid hexGrid, int hexID) {

        int settlementID = hexGrid.getHexValue(hexID).getSettlementID();

        return settlementID;
    }

    public void setSettlementID(HexGrid hexGrid, int hexID, int settlementID) {

        hexGrid.getHexValue(hexID).setSettlementID(settlementID);
    }

//    private int settlementMapSize = 50;
//    private Queue<Integer> emptySettlements;
//
//    public void initializeEmptySettlements(int settlementMapSize){
//        for(int i = 0; i < settlementMapSize; i++){
//            emptySettlements.add(i);
//        }
//    }
//
//    //Given: a meeple is placed on a hex
//    public void createSettlement(int hexID){
//        hexIDContainer = settlementMap.get(emptySettlements.peek());
//        hexIDContainer.add(hexID);
//        settlementMap.put(emptySettlements.remove(), hexIDContainer);
//    }



}
