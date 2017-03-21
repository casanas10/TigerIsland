import java.util.*;

/**
 * Created by cyonkee on 3/14/17.
 */
public class IslandMap {
    private HashMap<Integer, Hex> hashMap = new HashMap<Integer, Hex>();

    public void addHexToMap(Hex hex) {
        hashMap.put(hex.getHexID(), hex);
    }

    public void printMap(){
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();

            Hex hexObj = (Hex)mentry.getValue();
            System.out.print("key: "+ mentry.getKey() + " & Value: ");
            hexObj.printHexCoordinates();
        }
    }

    public boolean containsHexKey(Hex hex){
        if (hashMap.containsKey(hex.getHexID())){
            return true;
        }
        return false;
    }
}
