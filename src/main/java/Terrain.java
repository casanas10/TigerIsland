/**
 * Created by alecasanas on 3/14/17.
 */
public class Terrain {
    private String terrainType;
    private boolean isFounded;

    public Terrain(String terrainType, boolean isFounded){
        this.terrainType = terrainType;
        this.isFounded = isFounded;
    }

    public void setType(String type){
        this.terrainType = type;
    }
    public String getTerrainType(){
        return terrainType;
    }

    public void setIsFounded(boolean isFounded){
        this.isFounded = isFounded;
    }
    public boolean getIsFounded(){
        return isFounded;
    }
}
