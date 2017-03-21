import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by alecasanas on 3/21/17.
 */
public class HexGrid {

    private HashMap<Integer, Hex> hashMap = new HashMap<Integer, Hex>();

    public void generateHexGrid() {

        int hexID = 0;

        for (int i = 0; i < 200; i++){

            for (int j = 0; j < 200; j++){

                Hex hex = new Hex(hexID,i,j);

                hashMap.put(hexID, hex);

                hexID++;
            }

        }
    }

    public void printMap(){
        Set set = hashMap.entrySet();
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
        return hashMap.get(hexID);
    }
}
