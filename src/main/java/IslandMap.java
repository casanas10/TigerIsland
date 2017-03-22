import java.util.*;

/**
 * Created by cyonkee on 3/14/17.
 */
public class IslandMap {

    private HashMap<Integer, int[]> gameBoardMap;
    private TileGenerator tileGenerator;
    private HexGrid hexGrid;
    private int tileCount;

    public IslandMap(){
        gameBoardMap = new HashMap<Integer, int[]>();
        tileGenerator = new TileGenerator();
        hexGrid = new HexGrid();
        tileCount = 0;
    }


    public void addTileToMap(int hexID, int orientation) {
        int tileHexIDsArray[] = new int[3];
        RotateTile rotateTile = new RotateTile(hexID, orientation);
        tileHexIDsArray = rotateTile.checkPair();

        String tileTerrainsArray[] = new String[3];
        tileTerrainsArray = tileGenerator.getNewTile();


        boolean isValidPlacement = false;
        PlacementValidity placementValidity = new PlacementValidity();
        //I want the function below to take hexID array instead and also terrain array
        isValidPlacement = placementValidity.checkIfHexesCanBePlaced(tileHexIDsArray,tileTerrainsArray);

        if(isValidPlacement){
            Tile tile = new Tile(tileCount,tileHexIDsArray);
            hexGrid.setTerrains(tileHexIDsArray, tileTerrainsArray);
            gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
            tileCount++;
        }
        else{
            //return to user to request new hexID and Orientation
        }
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
