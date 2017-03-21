import java.util.*;

/**
 * Created by Eric on 3/20/2017.
 */
public class TileGenerator {
    private HashMap<Integer, String[]> terrainMap = new HashMap<Integer, String[]>();
    String terrainList[] = {"Lake", "Grassland", "Rocky", "Jungle"};
    ArrayList<Integer> randomNumberList = new ArrayList<Integer>(48);
    int tileId = 0;

    public TileGenerator(){
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    String currentTerrains[] = {"Volcano",terrainList[j],terrainList[k]};
                    terrainMap.put(tileId, currentTerrains);
                    tileId++;
                }
            }
        }

        for(int i=0;i<48;i++) {
            randomNumberList.add(i);
        }
    }

    public void printTiles(){
        for (Map.Entry<Integer, String[]> mapEntry : terrainMap.entrySet()) {
            System.out.println(mapEntry.getKey() + ".) " + mapEntry.getValue()[0] + " " +
                    mapEntry.getValue()[1] + " " +  mapEntry.getValue()[2]);
        }
    }

    public String[] getTileTerrains(int tileId){
        return terrainMap.get(tileId);
    }

    public String[] getNewTile(){
        String terrainArray[];

        if(randomNumberList.size() == 0){
            System.out.println("Out of Tiles!");
            return null;
        }

        Collections.shuffle(randomNumberList);

        terrainArray = terrainMap.get(randomNumberList.get(0));

        terrainMap.remove(randomNumberList.get(0));
        randomNumberList.remove(0);

        return terrainArray;
    }

    public int getTilesRemaining(){
        return terrainMap.size();
    }
}
