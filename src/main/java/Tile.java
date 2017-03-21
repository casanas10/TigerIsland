/**
 * Created by alecasanas on 3/14/17.
 */
public class Tile {

    private int tileID;
    private int[] tileContainer;

    public Tile(int tileID, int[] tileContainer) {
        this.tileID = tileID;
        this.tileContainer = tileContainer;
    }


    public int getTileID() {
        return tileID;
    }

    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    public int[] getTileContainer() {
        return tileContainer;
    }

    public void setTileContainer(int[] tileContainer) {
        this.tileContainer = tileContainer;
    }
}
