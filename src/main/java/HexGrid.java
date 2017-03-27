import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by alecasanas on 3/21/17.
 */
public class HexGrid {

    public static final int GRID_SIZE = 200;

    private HashMap<Integer, Hex> hexMap = new HashMap<Integer, Hex>();

    public void generateHexGrid() {
        int hexID = 0;
        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){
                Hex hex = new Hex(hexID,j,i);
                hexMap.put(hexID, hex);
                hexID++;
            }
        }
    }

    public void printMap(){
        Set set = hexMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();

            Hex hexObj = (Hex)mentry.getValue();
            System.out.print("key: "+ mentry.getKey() + " & Value: ");
            hexObj.printHexCoordinates();
            System.out.println();
        }
    }

    public Hex getHexValue(int hexID){
        return hexMap.get(hexID);
    }

    public void setTerrains(int hexIDs[], String hexTerrains[]) {
        Hex hex;
        for (int i = 0; i < 3; i++) {
            hex = getHexValue(hexIDs[i]);
            hex.setTerrain(hexTerrains[i]);
        }
    }

    public void setLevels(int hexIDs[]) {
        Hex hex;
        for (int i = 0; i < 3; i++) {
            hex = getHexValue(hexIDs[i]);
            int currentLevel = hex.getLevel();
            hex.setLevel(currentLevel++);
        }
    }
   /* public void increaseLevelsByOne(int hexIDs[]){
        Hex hex;
        for(int i=0; i<3; i++){
            hex = getHexValue(hexIDs[i]);
            hex.incrementLevel();

        }
    }
    */

}
