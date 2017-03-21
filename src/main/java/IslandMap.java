import java.util.*;

/**
 * Created by cyonkee on 3/14/17.
 */
public class IslandMap {

    private HashMap<Integer, int[]> gameBoardMap = new HashMap<Integer, int[]>();

    public void addTileToMap(Tile tile) {
        gameBoardMap.put(tile.getTileID(), tile.getTileContainer());
    }

    public void printMap(){
        Set set = gameBoardMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();

            Hex hexObj = (Hex)mentry.getValue();
            System.out.print("key: "+ mentry.getKey() + " & Value: ");
            hexObj.printHexCoordinates();
        }
    }

    public boolean containsHexKey(Tile tile){
        if (gameBoardMap.containsKey(tile.getTileID())){
            return true;
        }
        return false;
    }


}
