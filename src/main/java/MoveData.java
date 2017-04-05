/**
 * Created by Eric on 4/4/2017.
 */
public class MoveData {
    private int tilePlacementX;
    private int tilePlacementY;
    private int tilePlacementZ;
    private int orientation;
    private int buildOption;
    private int buildOptionX;
    private int buildOptionY;
    private int buildOptionZ;
    private String extendTerrain;
    private String[] terrainsArray;

    public MoveData(){

    }

    public MoveData(String[] terrainsArray, int tilePlacementX, int tilePlacementY, int tilePlacementZ, int orientation, int buildOption,
                    int buildOptionX, int buildOptionY, int buildOptionZ){
        this.terrainsArray = terrainsArray;
        this.tilePlacementX = tilePlacementX;
        this.tilePlacementY = tilePlacementY;
        this.tilePlacementZ = tilePlacementZ;
        this.orientation = orientation;
        this.buildOption = buildOption;
        this.buildOptionX = buildOptionX;
        this.buildOptionY = buildOptionY;
        this.buildOptionZ = buildOptionZ;
        extendTerrain = "";
    }

    public MoveData(String[] terrainsArray, int tilePlacementX, int tilePlacementY, int tilePlacementZ, int orientation, int buildOption,
                    int buildOptionX, int buildOptionY, int buildOptionZ, String extendTerrain){
        this.terrainsArray = terrainsArray;
        this.tilePlacementX = tilePlacementX;
        this.tilePlacementY = tilePlacementY;
        this.tilePlacementZ = tilePlacementZ;
        this.orientation = orientation;
        this.buildOption = buildOption;
        this.buildOptionX = buildOptionX;
        this.buildOptionY = buildOptionY;
        this.buildOptionZ = buildOptionZ;
        this.extendTerrain = extendTerrain;
    }

    public int getTilePlacementX() {
        return tilePlacementX;
    }

    public void setTilePlacementX(int tilePlacementX) {
        this.tilePlacementX = tilePlacementX;
    }

    public int getTilePlacementY() {
        return tilePlacementY;
    }

    public void setTilePlacementY(int tilePlacementY) {
        this.tilePlacementY = tilePlacementY;
    }

    public int getTilePlacementZ() {
        return tilePlacementZ;
    }

    public void setTilePlacementZ(int tilePlacementZ) {
        this.tilePlacementZ = tilePlacementZ;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getBuildOption() {
        return buildOption;
    }

    public void setBuildOption(int buildOption) {
        this.buildOption = buildOption;
    }

    public int getBuildOptionX() {
        return buildOptionX;
    }

    public void setBuildOptionX(int buildOptionX) {
        this.buildOptionX = buildOptionX;
    }

    public int getBuildOptionY() {
        return buildOptionY;
    }

    public void setBuildOptionY(int buildOptionY) {
        this.buildOptionY = buildOptionY;
    }

    public int getBuildOptionZ() {
        return buildOptionZ;
    }

    public void setBuildOptionZ(int buildOptionZ) {
        this.buildOptionZ = buildOptionZ;
    }

    public String getExtendTerrain() {
        return extendTerrain;
    }

    public void setExtendTerrain(String extendTerrain) {
        this.extendTerrain = extendTerrain;
    }

    public String[] getTerrainsArray() {
        return terrainsArray;
    }

    public void setTerrainsArray(String[] terrainsArray) {
        this.terrainsArray = terrainsArray;
    }


}
