/**
 * Created by alecasanas on 3/14/17.
 */
public class Tile {

    private int tileID;
    private int[] hexIDContainer;

    public Tile(int tileID, int[] hexIDContainer) {
        this.tileID = tileID;
        this.hexIDContainer = hexIDContainer;
    }

    public int getTileID() {
        return tileID;
    }

    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    public int[] getHexIDContainer() {
        return hexIDContainer;
    }

    public void setHexIDContainer(int[] hexIDContainer) {
        this.hexIDContainer = hexIDContainer;
    }
}
