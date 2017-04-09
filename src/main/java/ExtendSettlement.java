import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by cyonkee on 3/24/17.
 */
public class ExtendSettlement {
    private int settlementSourceHexID;
    private String hexColor;
    private int settlementID;
    private boolean isSameTerrain = false;
    private boolean isValidTile = false;
    private CoordinateSystem coordinates = new CoordinateSystem();
    private int maxArrayLength = 200;
    private IslandMap islandMap;
    private Player player;
    private ArrayList<Integer> lakesToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> grasslandsToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> rockysToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> junglesToExtendOn = new  ArrayList<Integer>();

    public ExtendSettlement(int settlementSourceHexID, IslandMap islandMap, Player player){
        this.settlementSourceHexID = settlementSourceHexID;
        this.islandMap = islandMap;
        this.player = player;
        findHexesToExtendOn();
    }

    private void findHexesToExtendOn() {
        Hex hex;
        hex = islandMap.getHex(settlementSourceHexID);
        hexColor = hex.getPlayerColorOnHex();
        settlementID = hex.getSettlementID();
        HashMap<Integer, ArrayList<Integer>> settlementsMap = islandMap.getSettlementsMap();

        ArrayList<Integer> HexIDsInSettlement = settlementsMap.get(settlementID);

        int i = 0;
        while (i < HexIDsInSettlement.size()) {
            findExtensions(HexIDsInSettlement.get(i));
            i++;
        }

        printExtendOptions();
    }

    private void findExtensions(int hexID){
        goToTerrain(hexID,"Lake");
        goToTerrain(hexID,"Grassland");
        goToTerrain(hexID,"Rocky");
        goToTerrain(hexID,"Jungle");
    }

    private void goToTerrain(int hexID, String terrain){
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
            isValidTile = checkIfValidTile(hexID - maxArrayLength, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID - maxArrayLength, terrain);
                resetBooleans();
                goToTerrain(hexID - maxArrayLength, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID - maxArrayLength + 1, terrain);
            isValidTile = checkIfValidTile(hexID - maxArrayLength + 1, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID - maxArrayLength + 1, terrain);
                resetBooleans();
                goToTerrain(hexID - maxArrayLength + 1, terrain);
            }
            else{ resetBooleans(); }
        }
    }

    private void checkRightHexID(int hexID, String terrain) {
        isSameTerrain = checkIfSameTerrain(hexID + 1, terrain);
        isValidTile = checkIfValidTile(hexID + 1, terrain);
        if(isSameTerrain && isValidTile) {
            addToTerrainContainer(hexID + 1, terrain);
            resetBooleans();
            goToTerrain(hexID + 1, terrain);
        }
        else{ resetBooleans(); }
    }

    private void checkBottomRightHexID(int hexID, String terrain) {
        if(hexIsInEvenRow(hexID)) {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength, terrain);
            isValidTile = checkIfValidTile(hexID + maxArrayLength, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID + maxArrayLength, terrain);
                resetBooleans();
                goToTerrain(hexID + maxArrayLength, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength + 1, terrain);
            isValidTile = checkIfValidTile(hexID + maxArrayLength + 1, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID + maxArrayLength + 1, terrain);
                resetBooleans();
                goToTerrain(hexID + maxArrayLength + 1, terrain);
            }
            else{ resetBooleans(); }
        }
    }

    private void checkBottomLeftHexID(int hexID, String terrain) {
        if(hexIsInEvenRow(hexID)) {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength - 1, terrain);
            isValidTile = checkIfValidTile(hexID + maxArrayLength - 1, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID + maxArrayLength - 1, terrain);
                resetBooleans();
                goToTerrain(hexID + maxArrayLength - 1, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID + maxArrayLength, terrain);
            isValidTile = checkIfValidTile(hexID + maxArrayLength, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID + maxArrayLength, terrain);
                resetBooleans();
                goToTerrain(hexID + maxArrayLength, terrain);
            }
            else{ resetBooleans(); }
        }
    }

    private void checkLeftHexID(int hexID, String terrain) {
        isSameTerrain = checkIfSameTerrain(hexID - 1, terrain);
        isValidTile = checkIfValidTile(hexID - 1, terrain);
        if(isSameTerrain && isValidTile) {
            addToTerrainContainer(hexID - 1, terrain);
            resetBooleans();
            goToTerrain(hexID - 1, terrain);
        }
        else{ resetBooleans(); }
    }

    private void checkUpperLeftHexID(int hexID, String terrain) {
        if(hexIsInEvenRow(hexID)) {
            isSameTerrain = checkIfSameTerrain(hexID - maxArrayLength - 1, terrain);
            isValidTile = checkIfValidTile(hexID - maxArrayLength - 1, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID - maxArrayLength - 1, terrain);
                resetBooleans();
                goToTerrain(hexID - maxArrayLength - 1, terrain);
            }
            else{ resetBooleans(); }
        }
        else {
            isSameTerrain = checkIfSameTerrain(hexID - maxArrayLength, terrain);
            isValidTile = checkIfValidTile(hexID - maxArrayLength, terrain);

            if(isSameTerrain && isValidTile) {
                addToTerrainContainer(hexID - maxArrayLength, terrain);
                resetBooleans();
                goToTerrain(hexID - maxArrayLength, terrain);
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
        if(terrain.equals(hex.getTerrain())){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean checkIfValidTile(int hexID, String terrain) {
        Hex hex;
        hex = islandMap.getHex(hexID);
        if((hex.getTileID() != -1) && (hex.checkIfHexIsNotSettled()) &&
                (hex.getSettlementID() == -1) && (!hex.getTerrain().equals("Volcano"))
                && hasNotBeenVisited(hexID,terrain)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean hasNotBeenVisited(int hexID, String terrain) {
        int i=0;
        if(terrain.equals("Lake")){
            i=0;
            while(i<lakesToExtendOn.size()){
                if(lakesToExtendOn.get(i) == hexID){
                    return false;
                }
                i++;
            }
            return true;
        }
        if(terrain.equals("Grassland")){
            i=0;
            while(i<grasslandsToExtendOn.size()){
                if(grasslandsToExtendOn.get(i) == hexID){
                    return false;
                }
                i++;
            }
            return true;
        }
        if(terrain.equals("Rocky")){
            i=0;
            while(i<rockysToExtendOn.size()){
                if(rockysToExtendOn.get(i) == hexID){
                    return false;
                }
                i++;
            }
            return true;
        }
        if(terrain.equals("Jungle")){
            i = 0;
            while (i < junglesToExtendOn.size()) {
                if (junglesToExtendOn.get(i) == hexID) {
                    return false;
                }
                i++;
            }
            return true;
        }
        else{ return false; }
    }

    private void addToTerrainContainer(int hexID, String terrain) {
        if(terrain.equals("Lake")){
            lakesToExtendOn.add(hexID);
        }
        if(terrain.equals("Grassland")){
            grasslandsToExtendOn.add(hexID);
        }
        if(terrain.equals("Rocky")){
            rockysToExtendOn.add(hexID);
        }
        if(terrain.equals("Jungle")){
            junglesToExtendOn.add(hexID);
        }
    }

    private void resetBooleans() {
        isSameTerrain = false;
        isValidTile = false;
    }

    public void printExtendOptions(){
        int i=0;
        System.out.println("Lakes to extend on: ");
        while(i<lakesToExtendOn.size()){
            System.out.print(lakesToExtendOn.get(i) + " ");
            i++;
        }

        i=0;
        System.out.println("\nGrasslands to extend on: ");
        while(i<grasslandsToExtendOn.size()){
            System.out.print(grasslandsToExtendOn.get(i) + " ");
            i++;
        }

        i=0;
        System.out.println("\nRockys to extend on: ");
        while(i<rockysToExtendOn.size()){
            System.out.print(rockysToExtendOn.get(i) + " ");
            i++;
        }

        i=0;
        System.out.println("\nJungles to extend on: ");
        while(i<junglesToExtendOn.size()){
            System.out.print(junglesToExtendOn.get(i) + " ");
            i++;
        }
    }

    public boolean extendOnTerrain(String terrain){
        if(terrain.equals("invalid terrain")){
            return false;
        }
        if(terrain.equals("Lake")){
            if((lakesToExtendOn.isEmpty()) || (meeplesRequired(terrain) >= player.getRemainingMeeples())){
                return false;
            }
            else{
                int i=0;
                while(i<lakesToExtendOn.size()){
                    updateHex(lakesToExtendOn.get(i));
                    i++;
                }
                return true;
            }
        }
        if(terrain.equals("Grassland")){
            if((grasslandsToExtendOn.isEmpty()) || (meeplesRequired(terrain) >= player.getRemainingMeeples())){
                return false;
            }
            else{
                int i=0;
                while(i<grasslandsToExtendOn.size()){
                    updateHex(grasslandsToExtendOn.get(i));
                    i++;
                }
                return true;
            }
        }
        if(terrain.equals("Rocky")){
            if((rockysToExtendOn.isEmpty()) || (meeplesRequired(terrain) >= player.getRemainingMeeples())){
                return false;
            }
            else{
                int i=0;
                while(i<rockysToExtendOn.size()){
                    updateHex(rockysToExtendOn.get(i));
                    i++;
                }
                return true;
            }
        }
        if(terrain.equals("Jungle")){
            if((junglesToExtendOn.isEmpty()) || (meeplesRequired(terrain) >= player.getRemainingMeeples())){
                return false;
            }
            else{
                int i=0;
                while(i<junglesToExtendOn.size()){
                    updateHex(junglesToExtendOn.get(i));
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    private int meeplesRequired(String terrain) {
        Hex hex;
        int meeplesRequired = 0;
        int i=0;
        if(terrain.equals("Lake")){
            i=0;
            while(i<lakesToExtendOn.size()) {
                meeplesRequired += islandMap.getHex(lakesToExtendOn.get(i)).getLevel();
                i++;
            }
        }
        if(terrain.equals("Grassland")){
            i=0;
            while(i<grasslandsToExtendOn.size()){
                meeplesRequired += islandMap.getHex(grasslandsToExtendOn.get(i)).getLevel();
                i++;
            }
        }
        if(terrain.equals("Rocky")){
            i=0;
            while(i<rockysToExtendOn.size()){
                meeplesRequired += islandMap.getHex(rockysToExtendOn.get(i)).getLevel();
                i++;
            }
        }
        if(terrain.equals("Jungle")){
            i=0;
            while(i<junglesToExtendOn.size()){
                meeplesRequired += islandMap.getHex(junglesToExtendOn.get(i)).getLevel();
                i++;
            }
        }

        return meeplesRequired;
    }

    private void updateHex(int hexID) {
        Hex hex;
        GamePiece piece;
        hex = islandMap.getHex(hexID);
        int level = hex.getLevel();

        //Add hexIDs to settlement in settlements map and then check if now touching other settlements.
        Settlement settlement = islandMap.getSettlementObj();
        settlement.addSettlement(hexID,player);

        for(int i=0; i<level; i++){
            piece = player.placeMeepleForExtension();
            updateScore(player,piece,level);
        }
    }

    public void updateScore(Player player, GamePiece piece, int level){
        player.updateScore(piece.calculateScore(level));
        System.out.println(piece.calculateScore(level) + " point(s) added to " + player.getPlayerColor() + "'s score.");
        System.out.println(player.getPlayerColor() + " player's total score: " + player.getCurrentScore());

    }

    public String getTerrainToExtendOn(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter terrain name to extend to: \n");
        String terrain = s.nextLine();

        if((terrain.equals("Lake")) || (terrain.equals("Grassland")) ||
                (terrain.equals("Rocky")) || (terrain.equals("Jungle"))){
            return terrain;
        }
        else{
            return "invalid terrain";
        }
    }

    public ArrayList<Integer> getTerrainList(String terrain) {

        ArrayList<Integer> terrainsList = null;

        switch (terrain)
        {
            case "Lake" :
                terrainsList = getLakesToExtendOn();
                break;
            case "Grassland" :
                terrainsList = getGrasslandsToExtendOn();
                break;
            case "Jungle" :
                terrainsList = getJunglesToExtendOn();
                break;
            case "Rocky" :
                terrainsList = getRockysToExtendOn();
                break;
            default:
                break;
        }

        return terrainsList;
    }

    public ArrayList<Integer> getLakesToExtendOn(){ return lakesToExtendOn; }
    public ArrayList<Integer> getGrasslandsToExtendOn(){ return grasslandsToExtendOn; }
    public ArrayList<Integer> getJunglesToExtendOn(){ return junglesToExtendOn; }
    public ArrayList<Integer> getRockysToExtendOn(){ return rockysToExtendOn; }
    public int getSettlementID(){
        return settlementID;
    }
}
