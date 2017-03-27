import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cyonkee on 3/24/17.
 */
public class ExtendSettlement {
    private int settlementSourceHexID;
    private boolean isSameTerrain = false;
    private boolean isValidTile = false;
    private CoordinateSystem coordinates = new CoordinateSystem();
    private int maxArrayLength = 200;
    private IslandMap islandMap;
    private ArrayList<Integer> lakesToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> grasslandsToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> rockysToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> junglesToExtendOn = new  ArrayList<Integer>();

    public ExtendSettlement(int settlementSourceHexID, IslandMap islandMap){
        this.settlementSourceHexID = settlementSourceHexID;
        this.islandMap = islandMap;
    }

    public void findHexesToExtendOn(){
        HashMap<Integer,ArrayList<Integer>> settlementsMap = islandMap.getSettlementsMap();
        ArrayList<Integer> adjacentHexIDsInSettlement = settlementsMap.get(settlementSourceHexID);

        findExtensions(settlementSourceHexID);

        int i=0;
        while(i<adjacentHexIDsInSettlement.size()){
            findExtensions(adjacentHexIDsInSettlement.get(i));
            i++;
        }
    }

    private void findExtensions(int hexID){
        Hex hex;
        hex = islandMap.getHex(hexID);
        String terrain = hex.getTerrain();

        if(terrain == "Lake"){
            extendToTerrain(hexID,terrain);
        }
        if(terrain == "Grassland"){
            extendToTerrain(hexID,terrain);
        }
        if(terrain == "Rocky"){
            extendToTerrain(hexID,terrain);
        }
        if(terrain == "Jungle"){
            extendToTerrain(hexID,terrain);
        }
    }

    private void extendToTerrain(int hexID, String terrain){
        checkUpperRightHexID(hexID, terrain);
        checkRightHexID(hexID,terrain);
        checkBottomRightHexID(hexID,terrain);
        checkBottomLeftHexID(hexID,terrain);
        checkLeftHexID(hexID,terrain);
        checkUpperLeftHexID(hexID,terrain);
    }

    private void checkUpperRightHexID(int hexID, String terrain) {
        if(hexIsInEvenRow(hexID)) {
            isSameTerrain = checkIfSameTerrain(hexID - maxArrayLength, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID - maxArrayLength, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID - maxArrayLength + 1, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID - maxArrayLength + 1, terrain);
            }
            else{ resetBooleans(); }
        }
    }

    private void checkRightHexID(int hexID, String terrain) {
        isSameTerrain = checkIfSameTerrain(hexID + 1, terrain);
        isValidTile = checkIfValidTile(hexID);
        if(isSameTerrain && isValidTile) {
            addToTerrainContainer(hexID, terrain);
            resetBooleans();
            extendToTerrain(hexID + 1, terrain);
        }
        else{ resetBooleans(); }
    }

    private void checkBottomRightHexID(int hexID, String terrain) {
        if(hexIsInEvenRow(hexID)) {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID + maxArrayLength, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength + 1, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID + maxArrayLength + 1, terrain);
            }
            else{ resetBooleans(); }
        }
    }

    private void checkBottomLeftHexID(int hexID, String terrain) {
        if(hexIsInEvenRow(hexID)) {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength - 1, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID + maxArrayLength - 1, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID + maxArrayLength, terrain);
            }
            else{ resetBooleans(); }
        }
    }

    private void checkLeftHexID(int hexID, String terrain) {
        isSameTerrain = checkIfSameTerrain(hexID - 1, terrain);
        isValidTile = checkIfValidTile(hexID);
        if(isSameTerrain && isValidTile) {
            addToTerrainContainer(hexID, terrain);
            resetBooleans();
            extendToTerrain(hexID - 1, terrain);
        }
        else{ resetBooleans(); }
    }

    private void checkUpperLeftHexID(int hexID, String terrain) {
        if(hexIsInEvenRow(hexID)) {
            isSameTerrain = checkIfSameTerrain(hexID - maxArrayLength - 1, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID - maxArrayLength - 1, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID - maxArrayLength, terrain);
            isValidTile = checkIfValidTile(hexID);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID, terrain);
                resetBooleans();
                extendToTerrain(hexID - maxArrayLength, terrain);
            }
            else{ resetBooleans(); }
        }
    }

    private boolean hexIsInEvenRow(int hexID) {
        if(coordinates.getYCoordinate(hexID)%2 == 0)
            return true;
        else
            return false;
    }

    private boolean checkIfSameTerrain(int hexID, String terrain) {
        Hex hex;
        hex = islandMap.getHex(hexID);
        if(terrain == hex.getTerrain()){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean checkIfValidTile(int hexID) {
        Hex hex;
        hex = islandMap.getHex(hexID);
        if(hex.getTile() == -1){
            return true;
        }
        else{
            return false;
        }
    }

    private void addToTerrainContainer(int hexID, String terrain) {
        if(terrain == "Lake"){
            lakesToExtendOn.add(hexID);
        }
        if(terrain == "Grassland"){
            grasslandsToExtendOn.add(hexID);
        }
        if(terrain == "Rocky"){
            rockysToExtendOn.add(hexID);
        }
        if(terrain == "Jungle"){
            junglesToExtendOn.add(hexID);
        }
    }

    private void resetBooleans() {
        isSameTerrain = false;
        isValidTile = false;
    }

}
