/**
 * Created by alecasanas on 3/20/17.
 */
public class HexPoint {

    private int x;
    private int y;
    private int hexID;

    public void setPoint(int hexID, int x, int y){
        this.hexID = hexID;
        this.x = x;
        this.y = y;
    }

    public int getHexID() {
        return hexID;
    }

    public void printHexCoordinates() {
        System.out.print("x:" + x + " y:" + y);
    }
}
