import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cyonkee on 3/24/17.
 */
public class ExtendSettlement {
    private int settlementSourceHexID;

    public ExtendSettlement(int settlementSourceHexID){
        this.settlementSourceHexID = settlementSourceHexID;
    }

    public void findHexesToExtendOn(){
        HashMap<Integer,ArrayList<Integer>> settlementsMap = Build.getSettlementsMap();
        ArrayList<Integer> adjacentHexIDsInSettlement = settlementsMap.get(settlementSourceHexID);
        ArrayList<Integer> hexesToExtendOn = new ArrayList<Integer>();
        ArrayList<Integer> hexesFoundPerHex = new ArrayList<Integer>();

        hexesFoundPerHex = bfs(settlementSourceHexID);

        int i=0;
        while(i<hexesFoundPerHex.size()){
            hexesToExtendOn.add(hexesFoundPerHex.get(i));
            i++;
        }

        hexesFoundPerHex.clear();

        i=0;
        int j=0;
        while(i<adjacentHexIDsInSettlement.size()){
            hexesFoundPerHex = bfs(adjacentHexIDsInSettlement.get(i));
            while(j<hexesFoundPerHex.size()){
                hexesToExtendOn.add(hexesFoundPerHex.get(j));
                j++;
            }
            hexesFoundPerHex.clear();
            j=0;
            i++;
        }
    }

    public ArrayList<Integer> bfs(int hexID){
        ArrayList<Integer> hexesFoundPerHex = new ArrayList<Integer>();
        //do bfs to find extensions

        return hexesFoundPerHex;
    }


}
