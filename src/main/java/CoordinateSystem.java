/**
 * Created by Connor on 3/21/2017.
 */
public class CoordinateSystem {
    private int x, y;
    private int maxArrayLength = 200;

    public int getTileNumber(int x, int y) {
        return maxArrayLength*y + x;
    }

    public int getXCoordinate(int tileNumber) {
        return tileNumber%maxArrayLength;
    }

    public int getYCoordinate(int tileNumber) {
        return tileNumber/maxArrayLength;
    }


}
