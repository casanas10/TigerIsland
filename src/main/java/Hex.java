import java.util.ArrayList;

/**
 * Created by Eric on 3/15/2017.
 */
public class Hex {
    private int hexID;
    private int settlementID;
    private int x;
    private int y;
    private String terrain;
    private int level;

    Hex (int hexID, int x, int y){
        this.hexID = hexID;
        this.x = x;
        this.y = y;
        this.terrain = "";
        this.level = 0;
    }

    public int getHexID() {
        return hexID;
    }

    public void setHexID(int hexID) {
        this.hexID = hexID;
    }

    public int getSettlementID(){ return settlementID; }

    public void setSettlementID(int settlementID){ this.settlementID = settlementID; }

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
}
