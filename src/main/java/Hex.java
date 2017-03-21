import java.util.ArrayList;

/**
 * Created by Eric on 3/15/2017.
 */
public class Hex {
    private int hexID;
    private int x;
    private int y;

    Hex (int hexID, int x, int y){
        this.hexID = hexID;
        this.x = x;
        this.y = y;
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

    public void printHexCoordinates() {
        System.out.print("x:" + x + " y:" + y);
    }
}
