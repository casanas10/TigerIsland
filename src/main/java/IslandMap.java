import java.util.*;

/**
 * Created by cyonkee on 3/14/17.
 */
public class IslandMap {

    private HashMap<Integer, int[]> gameBoardMap;
    private HexGrid hexGrid;
    private int tileCount;
    private TileGenerator myGen;

    public IslandMap(){
        gameBoardMap = new HashMap<Integer, int[]>();
        myGen = new TileGenerator();
        hexGrid = new HexGrid();
        hexGrid.generateHexGrid();
        tileCount = 0;
    }


    public void addTileToMap(int hexID, int orientation) {
        int tileHexIDsArray[] = new int[3];
        RotateTile rotateTile = new RotateTile(hexID, orientation);
        tileHexIDsArray = rotateTile.checkPair();

        String tileTerrainsArray[] = new String[3];
        tileTerrainsArray = myGen.getNewTile();




        boolean hexesCanBePlaced = false;
        boolean adjacentTilesValid = false;
        PlacementValidity placementValidity = new PlacementValidity();
        //I want the function below to take hexID array instead and also terrain array
        //hexesCanBePlaced = placementValidity.checkIfHexesCanBePlaced(hexGrid, tileHexIDsArray, tileTerrainsArray);
        //adjacentTilesValid = placementValidity.SearchAdjacentTiles(hexGrid, tileHexIDsArray);


        if(hexesCanBePlaced && adjacentTilesValid){
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
