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
    private ArrayList<Integer> listOfActiveSettlementIDs = new ArrayList<>();
    private PlacementValidity validatePlacement = new PlacementValidity();
    private CoordinateSystem coor = new CoordinateSystem();
    private HexGrid hexGrid;

    private SettlementSizeChecker settlementSizeChecker;
    private PlacementValidity validity = new PlacementValidity();
    private int settleID = 0;

    Settlement(HexGrid hexGrid) {
        this.hexGrid = hexGrid;
        this.settlementSizeChecker = new SettlementSizeChecker(hexGrid);
    }

    public ArrayList<Integer> getListOfActiveSettlementIDs() {
        return listOfActiveSettlementIDs;
    }

    public HashMap<Integer, ArrayList<Integer>> getSettlementMap() {
        return settlementMap;
    }

    public void updateSettlementAfterNuke(ArrayList<Integer> hexes, Player player){

        hexGrid.getHexValue(hexes.get(0)).resetPlayerColorOnHex(); //reset player color
        hexGrid.getHexValue(hexes.get(0)).setSettlementID(-1);  //and settlement id

        hexGrid.getHexValue(hexes.get(1)).resetPlayerColorOnHex();
        hexGrid.getHexValue(hexes.get(1)).setSettlementID(-1);

        hexGrid.getHexValue(hexes.get(2)).resetPlayerColorOnHex();
        hexGrid.getHexValue(hexes.get(2)).setSettlementID(-1);

        int hexID = 0;


        for (int index = 0; index < hexes.size(); index++ ){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(hexGrid.getHexValue(hexes.get(index)));

            ArrayList<Integer> NewHexIDs = new ArrayList<Integer>();

            for (int i = 0; i < adjacentHexes.size(); i++){

                if (hexGrid.getHexValue(adjacentHexes.get(i)).getSettlementID() != - 1){
                    hexID = adjacentHexes.get(i);

                    int settID = getSettlementID(hexID);
                    settlementMap.remove(settID);
                    listOfActiveSettlementIDs.remove(Integer.valueOf(settID));//NEW

                    NewHexIDs = settlementSizeChecker.checkSettlementSize(hexID, player);

                    for (int j = 0; j < NewHexIDs.size(); j++){
                        System.out.println(NewHexIDs.get(j));
                        setSettlementID(NewHexIDs.get(j),settID);
                    }

                    settlementMap.put(settleID,NewHexIDs);
                    listOfActiveSettlementIDs.add(settleID);//NEW
                    settleID++;

                }

            }
        }
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

        ArrayList<Integer> hexes = validity.searchTheSixAdjacentHexes(hexGrid.getHexValue(hexID));

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
            listOfActiveSettlementIDs.remove(setIDPlaceHolder.get(i));
        }

        NewHexIDs = settlementSizeChecker.checkSettlementSize(hexID, player);


        for (int i = 0; i < NewHexIDs.size(); i++){
            setSettlementID(NewHexIDs.get(i),settID);
        }

        settlementMap.put(settID,NewHexIDs);
        listOfActiveSettlementIDs.add(settID);
        settleID++;

    }


    public void foundNewSettlement(int hexID, Player player) {

        hexIDContainer = new ArrayList<Integer>();

        hexIDContainer.add(hexID);

        setSettlementID(hexID, settleID);
        settlementMap.put(settleID, hexIDContainer);
        listOfActiveSettlementIDs.add(settleID);
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

    public HashMap<Integer, ArrayList<Integer>> getSettlementsMap(){
        return settlementMap;
    }
}
