import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

/**
 * Created by alecasanas on 3/20/17.
 */
public class IsMap {

    private HashMap <Integer, HexPoint> hashMap = new HashMap<Integer, HexPoint>();

    public void addHexToMap(HexPoint hex_point) {
        hashMap.put(hex_point.getHexID(), hex_point);
    }

    public void printMap(){
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();

            HexPoint hexObj = (HexPoint) mentry.getValue();
            System.out.print("key: "+ mentry.getKey() + " & Value: ");
            hexObj.printHexCoordinates();
        }
    }

    public boolean containsHexKey(HexPoint hex){
        if (hashMap.containsKey(hex.getHexID())){
            return true;
        }
        return false;
    }
}
