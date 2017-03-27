/**
 * Created by alecasanas on 3/25/17.
 */
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Val on 3/24/2017.
 */
public class Settlement {

    private ArrayList<Integer> hexIDContainer;

    private HashMap<Integer, ArrayList<Integer>> settlementMap = new HashMap<Integer, ArrayList<Integer>>();

    private PlacementValidity validatePlacement = new PlacementValidity();

    CoordinateSystem coor = new CoordinateSystem();

    private HexGrid hexGrid;

    private SettlementSizeChecker settlementSizeChecker;

    private int settleID = 0;

    Settlement(HexGrid hexGrid) {
        this.hexGrid = hexGrid;
        this.settlementSizeChecker = new SettlementSizeChecker(hexGrid);
    }

    public void updateSettlementAfterNuke(RotateTile tile, Player player){


    }

    public void addSettlement(int hexID, Player player){

        Hex hex = hexGrid.getHexValue(hexID);

        hex.setPlayerColorOnHex(player.getPlayerColor());

        if (isNewSettlement(hexID,player)){

            foundNewSettlement(hexID, player);

        } else {

            addPieceToAnExistingSettlement(hexID, player);
        }


    }

    public void addPieceToAnExistingSettlement(int hexID, Player player) {

        PlacementValidity validity = new PlacementValidity();

        ArrayList<Integer> hexes = validity.searchTheSixAdjacentHexes(hexGrid,hexGrid.getHexValue(hexID));

        int settID = 0;

        ArrayList<Integer> NewHexIDs = new ArrayList<Integer>();

        ArrayList<Integer> setIDPlaceHolder = new ArrayList<Integer>();

        for(int i = 0; i < hexes.size(); i++){

            NewHexIDs = new ArrayList<Integer>();

            if(hexGrid.getHexValue(hexes.get(i)).getSettlementID() != - 1){

                settID = getSettlementID(hexes.get(i));
                setIDPlaceHolder.add(settID);
            }
        }


        for(int i = 0; i<setIDPlaceHolder.size(); i++){

            settlementMap.remove(setIDPlaceHolder.get(i));
        }

        NewHexIDs = settlementSizeChecker.checkSettlementSize(hexID, player);

        settlementMap.put(settID,NewHexIDs);
        settleID++;

    }


    public void foundNewSettlement(int hexID, Player player) {

        hexIDContainer = new ArrayList<Integer>();

        hexIDContainer.add(hexID);

        setSettlementID(hexID, settleID);
        settlementMap.put(settleID, hexIDContainer);
        settleID++;
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

    public int getSettlementID(int hexID) {

        int settlementID = hexGrid.getHexValue(hexID).getSettlementID();

        return settlementID;
    }

    public void setSettlementID(int hexID, int settlementID) {

        hexGrid.getHexValue(hexID).setSettlementID(settlementID);
    }

    public void printAllSettlements(){
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = settlementMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();
            System.out.print("Settlement " + entry.getKey() + ": ");

            System.out.print( entry.getValue() + " ");


            System.out.println();
        }

    }
}
