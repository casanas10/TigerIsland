/**
 * Created by Connor on 4/1/2017.
 */
public class CoordinateConverter {
    private int maxArrayLength = 200;
    private int offset = maxArrayLength/2 - 1;

    public int[] oursToServer(int x, int y){
        int[] XYZ = new int[3];
        int serverX = (x-offset)-(y-offset+(evenRow(y)))/2;
        int serverZ = y-offset;
        int serverY = -serverX - serverZ;

        XYZ[0] = serverX;
        XYZ[1] = serverY;
        XYZ[2] = serverZ;

        return XYZ;
    }

    private int evenRow(int y){
        if(y%2 == 0)
            return 1;
        else
            return 0;
    }
}
