import java.util.*;

/**
 * Created by Eric on 3/15/2017.
 */
public class Hex {
    private int hexID;
    private int tileID;
    private int x;
    private int y;
    private String terrain;
    private int level;
    private HashMap<String, Integer> gamePiecesMap;
    private String playerColorOnHex;
    private int settlementID;

    Hex (int hexID, int x, int y){
        this.hexID = hexID;
        this.x = x;
        this.y = y;
        this.terrain = "";
        this.level = 0;
        gamePiecesMap = new HashMap<>();
        playerColorOnHex = "";
        this.settlementID = -1;
        tileID = -1;
    }

    public int getHexID() {
        return hexID;
    }

    public void setHexID(int hexID) {
        this.hexID = hexID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTerrain(){ return terrain; }

    public void setTerrain(String terrain){ this.terrain = terrain; }

    public void printHexCoordinates() {
        System.out.print("x:" + x + " y:" + y);
    }

    public int getLevel(){
        return this.level;
    }

    public void setPlayerColorOnHex(String color){
        playerColorOnHex = color;
    }

    public void resetPlayerColorOnHex(){
        playerColorOnHex = "";
    }

    public String getPlayerColorOnHex(){
        return playerColorOnHex;
    }

    public String getPieceOnHex(){
        Iterator<Map.Entry<String, Integer>> iterator = gamePiecesMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            return entry.getKey();
        }
        return "No game piece on hex";
    }

    public void removeGamePiecesFromMap(){
        gamePiecesMap.clear();
    }

    public void incrementLevel(){
        level++;
    }

    public boolean checkIfHexIsNotSettled(){
        if(gamePiecesMap.isEmpty() && settlementID == -1) {
            return true;
        }
        else{ return false; }
    }

    public void addGamePieceToHex(GamePiece piece){
        gamePiecesMap.put(piece.getName(), 1);
        setPlayerColorOnHex(piece.getColor());
        System.out.println(getPlayerColorOnHex() + " " + piece.getName() + " successfully placed on Hex: " + getHexID());
    }

    public int getSettlementID() {
        //System.out.println("Settlement ID of Hex " + hexID + " is: " + settlementID);
        return settlementID;
    }

    public void setSettlementID(int settlementID) {
        this.settlementID = settlementID;
    }

    public int getTileID(){ return tileID; }

    public void setTileID(int tileCount){ tileID = tileCount; }
}