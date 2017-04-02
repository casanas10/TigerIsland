/**
 * Created by Val on 3/20/2017.
 */
public class RotateTile {

    int HexID;
    int[] Tile = new int[3];
    int Orientation;

    RotateTile(int HexID, int orientation) {
        this.Orientation = orientation;
        this.HexID = HexID;
    }

    public int[] checkPair(){

        int[] Hex1Offset = new int[6];
        int[] Hex2Offset = new int[6];

        // Determine if the origin is on an odd or even row
        if((HexID/200) % 2 != 0) {
            Hex1Offset[0] = 200;
            Hex1Offset[1] = 201;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -199;
            Hex1Offset[4] = -200;
            Hex1Offset[5] = -1;

            Hex2Offset[0] = 201;
            Hex2Offset[1] = 1;
            Hex2Offset[2] = -199;
            Hex2Offset[3] = -200;
            Hex2Offset[4] = -1;
            Hex2Offset[5] = 200;
        }
        else{
            Hex1Offset[0] = 199;
            Hex1Offset[1] = 200;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -200;
            Hex1Offset[4] = -201;
            Hex1Offset[5] = -1;

            Hex2Offset[0] = 200;
            Hex2Offset[1] = 1;
            Hex2Offset[2] = -200;
            Hex2Offset[3] = -201;
            Hex2Offset[4] = -1;
            Hex2Offset[5] = 199;
        }

        Tile[0] = HexID;
        Tile[1] = this.HexID + Hex1Offset[Orientation/60];
        Tile[2] = this.HexID + Hex2Offset[Orientation/60];

        return Tile;

    }
}
