import java.util.*;

/**
 * Created by Connor on 3/20/2017.
 */
public class TilesOnIsland {
    private HashMap<Integer, int[]> tilesPlaced;

    public void addTileToIsland(Tile tile, Hex hex1, Hex hex2, Hex hex3) {
        int[] threeHexes = {hex1.getHexID(), hex2.getHexID(), hex3.getHexID()};
        tilesPlaced.put(tile.getTileID(), threeHexes);
    }

    /*public void updateTerrains(Hex hex1, Hex hex2, Hex hex3) {
        hex1.setTerrain(); //Add the terrains in
        hex2.setTerrain();
        hex3.setTerrain();
    }*/

    public int[] getHexesIDFromTileOnMap(int tileNumber) {
        return tilesPlaced.get(tileNumber);
    }
}