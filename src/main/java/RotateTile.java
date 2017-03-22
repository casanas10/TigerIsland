
/**
 * Created by Val on 3/20/2017.
 */
public class RotateTile {
    //Given HexID
    private int hexID;
    //What terrain is the origin
    //Where should it be placed? x, y
    private int x;
    private int y;
    private Pair originCoordinates;
    private CoordinateSystem coordinates = new CoordinateSystem();
    private int[] tileInfoArray = new int[3];
    private int orientation;

    public RotateTile(int HexID, int orientation) {
        x = coordinates.getXCoordinate(hexID);
        y = coordinates.getYCoordinate(hexID);
        originCoordinates = new Pair(x, y);
        this.orientation = orientation;
    }

    public int[] checkPair(){

        Pair pair1 = new Pair();
        Pair pair2 = new Pair();

        Pair[] pair1Offset = new Pair[6];
        //Initialize pair1Offset
        for(int i = 0; i<6; i++){
            pair1Offset[i] = new Pair();
        }

        pair1Offset[0].x = 1; pair1Offset[0].y = 0;
        pair1Offset[1].x = 1; pair1Offset[1].y = 1;
        pair1Offset[2].x = 0; pair1Offset[2].y = 1;
        pair1Offset[3].x = -1; pair1Offset[3].y = 1;
        pair1Offset[4].x = -1; pair1Offset[4].y = 0;
        pair1Offset[5].x = 0; pair1Offset[5].y = -1;

        Pair[] pair2Offset = new Pair[6];
        //Initialize pair2Offset
        for(int i = 0; i<6; i++){
            pair2Offset[i] = new Pair();
        }

        pair2Offset[0].x = 1; pair2Offset[0].y = 1;
        pair2Offset[1].x = 0; pair2Offset[1].y = 1;
        pair2Offset[2].x = -1; pair2Offset[2].y = 1;
        pair2Offset[3].x = -1; pair2Offset[3].y = 0;
        pair2Offset[4].x = 0; pair2Offset[4].y = -1;
        pair2Offset[5].x = 1; pair2Offset[5].y = 0;

        //Getting offset
        pair1.x = originCoordinates.x + pair1Offset[orientation/60].x;
        pair1.y = originCoordinates.y + pair1Offset[orientation/60].y;

        pair2.x = originCoordinates.x + pair2Offset[orientation/60].x;
        pair2.y = originCoordinates.y + pair2Offset[orientation/60].y;

        //Looking for hexID to be returned
        tileInfoArray[0] = hexID;
        tileInfoArray[1] = coordinates.getHexID(pair1.x, pair1.y);
        tileInfoArray[2] = coordinates.getHexID(pair2.x, pair2.y);

        return tileInfoArray;

    }
}
