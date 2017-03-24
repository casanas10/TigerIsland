import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 * Created by Val on 3/24/2017.
 */
public class Settlement {

    private ArrayList<Integer> hexIDContainer;

    private HashMap<Integer, ArrayList<Integer>> settlementMap = new HashMap<Integer, ArrayList<Integer>>();
    private int settlementMapSize = 50;
    private Queue<Integer> emptySettlements;

    public void initializeEmptySettlements(int settlementMapSize){
        for(int i = 0; i < settlementMapSize; i++){
            emptySettlements.add(i);
        }
    }

    //Given: a meeple is placed on a hex
    public void createSettlement(int hexID){
        hexIDContainer = settlementMap.get(emptySettlements.peek());
        hexIDContainer.add(hexID);
        settlementMap.put(emptySettlements.remove(), hexIDContainer);
    }
}
