import java.util.*;

/**
 * Created by Eric on 3/15/2017.
 */
public class Hex {
    private int hexID;
    private int x;
    private int y;
    private String terrain;
    private int level;
    private HashMap<String, Integer> gamePiecesMap;

    Hex (int hexID, int x, int y){
        this.hexID = hexID;
        this.x = x;
        this.y = y;
        this.terrain = "";
        this.level = 0;
        gamePiecesMap = new HashMap<>();
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

    public String getPieceOnHex(){
        Iterator<Map.Entry<String, Integer>> iterator = gamePiecesMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            return entry.getKey();
        }

        return "No game piece on hex";
    }

    public void incrementLevel(){
        level++;
    }

    public boolean checkIfHexIsNotSettled(){
        return gamePiecesMap.isEmpty();
    }

    public void addGamePieceToHex(GamePiece piece){
        gamePiecesMap.put(piece.getName(), 1);
        System.out.println(piece.getName() + " successfully placed on Hex: " + getHexID());
    }
}
