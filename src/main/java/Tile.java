import java.util.ArrayList;

/**
 * Created by alecasanas on 3/14/17.
 */
public class Tile {
    private int edges[] = new int[12];
    private ArrayList<Hex> containerOfHexes;

    public Tile(String terrainType1, String terrainType2, String terrainType3){
        containerOfHexes = new ArrayList<Hex>(3);
        containerOfHexes.add(new Hex(terrainType1,1));
        containerOfHexes.add(new Hex(terrainType2,1));
        containerOfHexes.add(new Hex(terrainType3,1));
    }

    public void printHexTerrains(){
        for(Hex hex : containerOfHexes){
            System.out.print(hex.getTerrainType() + " ");
        }
        System.out.println();
    }

    public void setEdges(int edges[]){
        for (int edge : edges) {
            this.edges[edge] = edges[edge];
            System.out.println("hi");
        }
    }
    public int[] getEdges(){
        return edges;
    }
}
