import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cyonkee on 3/24/17.
 */
public class ExtendSettlement {
    private int settlementSourceHexID;
    private IslandMap islandMap;
    private ArrayList<Integer> lakesToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> grasslandsToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> rockysToExtendOn = new  ArrayList<Integer>();
    private ArrayList<Integer> junglesToExtendOn = new  ArrayList<Integer>();

    public ExtendSettlement(int settlementSourceHexID, IslandMap islandMap){
        this.settlementSourceHexID = settlementSourceHexID;
        this.islandMap = islandMap;
    }

    public void findHexesToExtendOn(){
        HashMap<Integer,ArrayList<Integer>> settlementsMap = islandMap.getSettlementsMap();
        ArrayList<Integer> adjacentHexIDsInSettlement = settlementsMap.get(settlementSourceHexID);
        //ArrayList<Integer> hexesToExtendOn = new ArrayList<Integer>();
       // ArrayList<Integer> hexesFoundPerHex = new ArrayList<Integer>();

        //Source hex extension
        //hexesFoundPerHex = findExtensions(settlementSourceHexID);
        findExtensions(settlementSourceHexID);
        /*int i=0;
        while(i<hexesFoundPerHex.size()){
            hexesToExtendOn.add(hexesFoundPerHex.get(i));
            i++;
        }
        hexesFoundPerHex.clear();
        */

        //Adjacent hexes extension
        int i=0;
        //int j=0;
        while(i<adjacentHexIDsInSettlement.size()){
            //hexesFoundPerHex = findExtensions(adjacentHexIDsInSettlement.get(i));
            findExtensions(adjacentHexIDsInSettlement.get(i));
            /*while(j<hexesFoundPerHex.size()){
                hexesToExtendOn.add(hexesFoundPerHex.get(j));
                j++;
            }
            hexesFoundPerHex.clear();
            j=0;
            */
            i++;
        }
    }

    public void findExtensions(int hexID){
        Hex hex;
        ArrayList<Integer> hexesFoundPerHex = new ArrayList<Integer>();
        hex = islandMap.getHex(hexID);
        String terrain = hex.getTerrain();

        if(terrain == "Lake"){
            extendToLakes(hexID);
        }
        if(terrain == "Grassland"){
            extendToGrasslands(hexID);
        }
        if(terrain == "Rocky"){
            extendToRockys(hexID);
        }
        if(terrain == "Jungle"){
            extendToJungles(hexID);
        }
    }

    public void extendToLakes(int hexID){

    }

    public void extendToGrasslands(int hexID){

    }

    public void extendToRockys(int hexID){

    }

    public void extendToJungles(int hexID){

    }


}
