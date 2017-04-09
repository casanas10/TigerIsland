/**
 * Created by alecasanas on 4/8/17.
 */
public class MoveInfo {

    private int hexID;
    private Player player;
    private int orientation;
    private String[] tile;
    private int hexSettled;
    private int buildOption;

    public int getHexID() {
        return hexID;
    }

    public void setHexID(int hexID) {
        this.hexID = hexID;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public String[] getTile() {
        return tile;
    }

    public void setTile(String[] tile) {
        this.tile = tile;
    }

    public int getHexSettled() {
        return hexSettled;
    }

    public void setHexSettled(int hexSettled) {
        this.hexSettled = hexSettled;
    }

    public int getBuildOption() {
        return buildOption;
    }

    public void setBuildOption(int buildOption) {
        this.buildOption = buildOption;
    }
}
