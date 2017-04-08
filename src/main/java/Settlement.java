
/**
 * Created by alecasanas on 3/25/17.
 */

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

    public int getSettlementSize(int SettlementID){
        return settlementMap.get(SettlementID).size();
    }

    public ArrayList<Integer> getSettlementHexIDs(int SettlementID){
        return settlementMap.get(SettlementID);
    }

    public ArrayList<Integer> getListOfActiveSettlementIDs() {
        return listOfActiveSettlementIDs;
    }

    public HashMap<Integer, ArrayList<Integer>> getSettlementMap() {
        return settlementMap;
    }

    public void updateSettlementAfterNuke(ArrayList<Integer> hexes, Player player) {

        ArrayList<Integer> NewHexIDs = new ArrayList<Integer>();

        for (int i =1; i < hexes.size(); i++ ) {
            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(hexGrid.getHexValue(hexes.get(i)));
            for(int j = 0; j < adjacentHexes.size(); j++){

                if (hexGrid.getHexValue(adjacentHexes.get(j)).getSettlementID() != -1) {

                    int hexID = adjacentHexes.get(j);

                    int settID = getSettlementID(hexID);

                    settlementMap.remove(settID);
                    listOfActiveSettlementIDs.remove(new Integer(settID));  //blah blah
                    NewHexIDs.add(hexID);

                }
            }
        }

        for (int i = 0 ; i < NewHexIDs.size(); i++){

            Player player2 = new Player(hexGrid.getHexValue(NewHexIDs.get(i)).getPlayerColorOnHex(), 0);

            ArrayList<Integer> hexesArr = settlementSizeChecker.checkSettlementSize(NewHexIDs.get(i), player2);

           setSettlementID(NewHexIDs.get(i),settleID);
            for(int hexID : hexesArr)
                setSettlementID(hexID, settleID);

            settlementMap.put(settleID, hexesArr);
            listOfActiveSettlementIDs.add(settleID);    //blah blah

            settleID++;
        }

    }

    private String settlementColor(int hexID) {

        if (hexGrid.getHexValue(hexID).getPlayerColorOnHex() == "Black"){
            return "Black";
        } else {
            return "White";
        }
    }

    public void addSettlement(int hexID, Player player){

        Hex hex = hexGrid.getHexValue(hexID);

        hex.setPlayerColorOnHex(player.getPlayerColor());

        if (!settlementMap.containsValue(hexID)) {

            if (isNewSettlement(hexID, player)) {

                foundNewSettlement(hexID, player);

            } else {

                addPieceToAnExistingSettlement(hexID, player);
            }
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
            listOfActiveSettlementIDs.remove(new Integer(setIDPlaceHolder.get(i))); //blah blah
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

    public void printAllSettlements(Player player){
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = settlementMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();


            System.out.print(hexGrid.getHexValue(entry.getValue().get(0)).getPlayerColorOnHex() + " Settlement " + entry.getKey() + ": ");

            System.out.print( entry.getValue() + " ");
            System.out.println();
        }

    }

    public HashMap<Integer, ArrayList<Integer>> getSettlementsMap(){
        return settlementMap;
    }

    public boolean addTotoroToSettlement(int hexID, Player player) {

        if (isSettlementSizeFiveOrMore(hexID, player)){

            addSettlement(hexID, player);

            return true;
        }

        return false;
    }


    public boolean isSettlementSizeFiveOrMore(int hexID, Player player){

        ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(hexGrid.getHexValue(hexID));

        for (int i = 0; i < adjacentHexes.size(); i++){

            int currentSettlement = getSettlementID(adjacentHexes.get(i));

            if(currentSettlement != -1) {

                int settlementSize = settlementMap.get(currentSettlement).size();

                if (settlementSize >= 5 && doesNotHaveATotoro(currentSettlement, player)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean addTigerToSettlement(int hexID, Player player) {

        isNewSettlement(hexID,player);

        if (isTigerNextToSettlement(hexID, player)){

            addSettlement(hexID, player);

            return true;
        }

        return false;
    }

    public boolean isTigerNextToSettlement(int hexID, Player player){

        ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(hexGrid.getHexValue(hexID));

        for (int i = 0; i < adjacentHexes.size(); i++){

            int currentSettlement = getSettlementID(adjacentHexes.get(i));

            if(currentSettlement != -1) {

                if (doesNotContainTigerAlready(currentSettlement, player)){
                    return true;
                }
            }

        }

        return false;
    }

    public boolean doesNotContainTigerAlready(int settlementID, Player player) {

        ArrayList<Integer> pickAHex = settlementMap.get(settlementID);

        for (int i = 0; i < pickAHex.size(); i++){

            if (hexGrid.getHexValue(pickAHex.get(i)).getPieceOnHex() == "Tiger"){
                return false;
            }
        }

        return true;
    }

    public boolean doesNotHaveATotoro(int settlementID, Player player) {

        ArrayList<Integer> pickAHex = settlementMap.get(settlementID);

        for (int i = 0; i < pickAHex.size(); i++){

            if (hexGrid.getHexValue(pickAHex.get(i)).getPieceOnHex() == "Totoro"){
                return false;
            }
        }
        return true;

    }

}