/**
 * Created by Connor on 3/21/2017.
 */
public class CoordinateSystem {
    private int x, y;
    private int maxArrayLength = 200;

    public int getHexID(int x, int y) {
        return maxArrayLength * y + x;
    }

    public int getXCoordinate(int hexID) {
        return hexID%maxArrayLength;
    }

    public int getYCoordinate(int hexID) {
        return hexID/maxArrayLength;
    }

}
