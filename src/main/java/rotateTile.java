
/**
 * Created by Val on 3/20/2017.
 */
public class rotateTile {
    //Given HexID
    int hexID;
    //What terrain is the origin
    //Where should it be placed? x, y
    int x;
    int y;
    pair originCoordinates;
    CoordinateSystem coordinates = new CoordinateSystem();
    int[] Tile = new int[3];
    int orientation;

    rotateTile(int HexID, int orientation) {
        x = coordinates.getXCoordinate(hexID);
        y = coordinates.getYCoordinate(hexID);
        originCoordinates = new pair(x, y);
        this.orientation = orientation;
    }

    public int[] checkPair(){

        pair pair1 = new pair();
        pair pair2 = new pair();

        pair[] pair1Offset = new pair[6];
        //Initialize pair1Offset
        for(int i = 0; i<6; i++){
            pair1Offset[i] = new pair();
        }

        pair1Offset[0].x = 1; pair1Offset[0].y = 0;
        pair1Offset[1].x = 1; pair1Offset[1].y = 1;
        pair1Offset[2].x = 0; pair1Offset[2].y = 1;
        pair1Offset[3].x = -1; pair1Offset[3].y = 1;
        pair1Offset[4].x = -1; pair1Offset[4].y = 0;
        pair1Offset[5].x = 0; pair1Offset[5].y = -1;

        pair[] pair2Offset = new pair[6];
        //Initialize pair2Offset
        for(int i = 0; i<6; i++){
            pair2Offset[i] = new pair();
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
        Tile[0] = hexID;
        Tile[1] = coordinates.getHexID(pair1.x, pair1.y);
        Tile[2] = coordinates.getHexID(pair2.x, pair2.y);

        return Tile;

    }
}

