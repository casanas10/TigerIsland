/**
 * Created by alecasanas on 3/14/17.
 */
public class Tile {

    private int tileID;
    private int[] hexContainer;

    public Tile(int tileID, int[] tileContainer) {
        this.tileID = tileID;
        this.hexContainer = tileContainer;
    }

    public int getTileID() {
        return tileID;
    }

    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    public int[] getHexContainer() {
        return hexContainer;
    }

    public void setHexContainer(int[] hexContainer) {
        this.hexContainer = hexContainer;
    }
}
