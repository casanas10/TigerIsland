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


    public boolean addTileToMap(int hexID, int orientation) {

        int tileHexIDsArray[] = new int[3];
        RotateTile rotateTile = new RotateTile(hexID, orientation);
        tileHexIDsArray = rotateTile.checkPair();

        System.out.println(Arrays.toString(tileHexIDsArray));

        String tileTerrainsArray[] = new String[3];
        tileTerrainsArray = myGen.getNewTile();

        // Place first tile in the middle of the map automatically
        if(getNumberOfTiles() == 47){
            placeFirstTile(tileHexIDsArray, tileTerrainsArray);
            System.out.println("First tile successfully placed!");
            return true;
        }

        boolean hexesCanBePlaced = false;
        boolean adjacentTilesValid = false;
        PlacementValidity placementValidity = new PlacementValidity();
        //I want the function below to take hexID array instead and also terrain array
        hexesCanBePlaced = placementValidity.checkIfHexesCanBePlaced(hexGrid, tileHexIDsArray, tileTerrainsArray);
        adjacentTilesValid = placementValidity.SearchAdjacentTiles(hexGrid, tileHexIDsArray);

        System.out.println(hexesCanBePlaced);
        System.out.println(adjacentTilesValid);

        if(hexesCanBePlaced && adjacentTilesValid){
            Tile tile = new Tile(tileCount,tileHexIDsArray);
            hexGrid.setTerrains(tileHexIDsArray, tileTerrainsArray);
            gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
            tileCount++;
            System.out.println("Tile Successfully Placed!");
            return true;
        }
        else{
            //return to user to request new hexID and Orientation
            System.out.println("Tile could not be placed, select another location");
            return false;
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

    public int getNumberOfTiles(){
        return myGen.getTilesRemaining();
    }

    public void placeFirstTile(int[] tileHexIDsArray, String[] tileTerrainsArray){
        Tile tile = new Tile(tileCount,tileHexIDsArray);
        hexGrid.setTerrains(tileHexIDsArray, tileTerrainsArray);
        gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
        tileCount++;
        System.out.println("Tile Successfully Placed!");
    }

    public void printTilesOnMap(){
        Iterator<Map.Entry<Integer, int[]>> iterator = gameBoardMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, int[]> entry = iterator.next();
            System.out.print("Tile " + entry.getKey() + ": ");
            for(int i=0;i<3;i++){
                System.out.print(entry.getValue()[i] + " ");
            }
            System.out.println();
        }

    }


    public ArrayList<Integer> getPlayerSettlement(Player player) {

        HashMap<Integer, ArrayList<Integer>> settlements = getSettlementsMap();

        ArrayList<Integer> playerSettlement = new ArrayList<Integer>() {{
            add(-1);
        }};

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = settlements.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();

            int hexID = entry.getValue().get(0);

            if (getHex(hexID).getPlayerColorOnHex() == player.getPlayerColor()){

                System.out.println(entry.getKey());
                playerSettlement.add(entry.getKey());
            }
        }

        return playerSettlement;
    }

}
