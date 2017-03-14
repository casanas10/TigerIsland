/**
 * Created by alecasanas on 3/14/17.
 */
public class Tile {
    private int edges[] = new int[12];
    private String terrains[] = new String[3];

    public void setEdges(int edges[]){
        for (int edge : edges) {
            this.edges[edge] = edges[edge];
            System.out.println("hi");
        }
    }
    public int[] getEdges(){
        return edges;
    }

    public void setTerrains(String terrains[]){
        for (int i = 0; i < terrains.length; i++) {
            this.terrains[i] = terrains[i];
        }
    }
    public String[] getTerrains(){
        return terrains;
    }



}
