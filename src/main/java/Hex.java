import java.util.ArrayList;

/**
 * Created by Eric on 3/15/2017.
 */
public class Hex {
    private int level;
    private Terrain terrain;
    private ArrayList<Meeple> meepleContainer;
    private ArrayList<Totoro> totoroContainer;

    public Hex(String terrainType, int level){
        this.level = level;
        terrain = new Terrain(terrainType, false);
        meepleContainer = new ArrayList<Meeple>(1);
        totoroContainer = new ArrayList<Totoro>(1);
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

    public int getNumberOfMeeplesOnHex(){
        return meepleContainer.size();
    }

    public void addMeeple(Meeple meepleToAdd){
        meepleContainer.add(meepleToAdd);
    }

    public int getNumberOfTotorosOnHex(){
        return totoroContainer.size();
    }

    public void addTotoroToHex(Totoro totoroToAdd){
        totoroContainer.add(totoroToAdd);
    }
}
