/**
 * Created by Eric on 3/15/2017.
 */
public class Hex {
    private int level;
    private Terrain terrain;

    public Hex(String terrainType, int level){
        this.level = level;
        terrain = new Terrain(terrainType, false);
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public String getTerrainType(){
        return terrain.getTerrainType();
    }

    public boolean checkIfFounded(){
        return terrain.getIsFounded();
    }
}
