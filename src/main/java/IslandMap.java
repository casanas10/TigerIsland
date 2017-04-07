import java.util.*;

/**
 * Created by cyonkee on 3/14/17.
 */
public class IslandMap {

    private HashMap<Integer, int[]> gameBoardMap;
    private HexGrid hexGrid;
    private int tileCount;
    private TileGenerator myGen;
    Nuking nuker;
    Settlement settlement;

    String tileTerrainsArray[] = new String[3];


    public IslandMap(){
        gameBoardMap = new HashMap<Integer, int[]>();
        myGen = new TileGenerator();
        hexGrid = new HexGrid();
        hexGrid.generateHexGrid();
        tileCount = 0;
        nuker = new Nuking();
        settlement = new Settlement(hexGrid);
    }

    public String[] getNewTile() {
        return myGen.getNewTile();
    }


    public boolean addTileToMap(int hexID, int orientation, String[] newTile, Player player){

        int tileHexIDsArray[] = new int[3];
        RotateTile rotateTile = new RotateTile(hexID, orientation);
        tileHexIDsArray = rotateTile.checkPair();

        ArrayList<Integer> hexesList = new ArrayList<Integer>();
        for (int i = 0; i < tileHexIDsArray.length; i++) {
            hexesList.add(tileHexIDsArray[i]);
            //System.out.println(hexesList.get(i));
        }

        // Place first tile in the middle of the map automatically
        if(getNumberOfTiles() == 47 && tileCount == 0){
            placeFirstTile(tileHexIDsArray, newTile);   //changed
            System.out.println("First tile successfully placed!");
            return true;
        }

        // CHECK FOR NUKE
        if(nuker.canYouNukeSettlement(this, tileHexIDsArray, hexID)){

            nuker.performNuke(hexGrid, tileHexIDsArray, newTile, tileCount);

            Tile tile = new Tile(tileCount,tileHexIDsArray);
            gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
            tileCount++;
            System.out.println("Nuke Successful!");

            for (int i = 0; i < tileHexIDsArray.length; i++){
                System.out.print(tileHexIDsArray[i] + " ");
                System.out.println();
            }

            settlement.updateSettlementAfterNuke(hexesList, player);

            return true;
        }

        boolean hexesCanBePlaced = false;
        boolean adjacentTilesValid = false;
        PlacementValidity placementValidity = new PlacementValidity();
        //I want the function below to take hexID array instead and also terrain array
        hexesCanBePlaced = placementValidity.checkIfHexesCanBePlaced(hexGrid, tileHexIDsArray);
        adjacentTilesValid = placementValidity.SearchAdjacentTiles(hexGrid, tileHexIDsArray);

        if(hexesCanBePlaced && adjacentTilesValid){
            Tile tile = new Tile(tileCount,tileHexIDsArray);
            hexGrid.setTerrains(tileHexIDsArray, newTile);
            hexGrid.increaseLevelsByOne(tileHexIDsArray);
            gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
            hexGrid.setHexTileIDs(tileHexIDsArray, tileCount);
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

    public boolean addTileToMap(int hexID, int orientation) {

        int tileHexIDsArray[] = new int[3];
        RotateTile rotateTile = new RotateTile(hexID, orientation);
        tileHexIDsArray = rotateTile.checkPair();

        tileTerrainsArray = getNewTile();

        // Place first tile in the middle of the map automatically
        if(getNumberOfTiles() == 47 && tileCount == 0){
            placeFirstTile(tileHexIDsArray, tileTerrainsArray);   //changed
            System.out.println("First tile successfully placed!");
            return true;
        }

        // CHECK FOR NUKE
        if(nuker.canYouNukeSettlement(this, tileHexIDsArray, hexID)){

            nuker.performNuke(hexGrid, tileHexIDsArray, tileTerrainsArray, tileCount);

            Tile tile = new Tile(tileCount,tileHexIDsArray);
            gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
            tileCount++;
            System.out.println("Nuke Successful!");

            for (int i = 0; i < tileHexIDsArray.length; i++){
                System.out.print(tileHexIDsArray[i]);
            }

            return true;
        }

        boolean hexesCanBePlaced = false;
        boolean adjacentTilesValid = false;
        PlacementValidity placementValidity = new PlacementValidity();
        //I want the function below to take hexID array instead and also terrain array
        hexesCanBePlaced = placementValidity.checkIfHexesCanBePlaced(hexGrid, tileHexIDsArray);
        adjacentTilesValid = placementValidity.SearchAdjacentTiles(hexGrid, tileHexIDsArray);

        if(hexesCanBePlaced && adjacentTilesValid){
            Tile tile = new Tile(tileCount,tileHexIDsArray);
            hexGrid.setTerrains(tileHexIDsArray, tileTerrainsArray);
            hexGrid.increaseLevelsByOne(tileHexIDsArray);
            gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
            hexGrid.setHexTileIDs(tileHexIDsArray, tileCount);
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

    public boolean containsHexKey(int tileID){
        if (gameBoardMap.containsKey(tileID)){
            return true;
        }
        return false;
    }

    public int getNumberOfTiles(){
        return myGen.getTilesRemaining();
    }

    public void placeFirstTile(int[] tileHexIDsArray, String[] tileTerrainsArray){
        CoordinateSystem coors = new CoordinateSystem();

        Tile tile = new Tile(tileCount,tileHexIDsArray);
        hexGrid.setTerrains(tileHexIDsArray, tileTerrainsArray);
        hexGrid.increaseLevelsByOne(tileHexIDsArray);
        gameBoardMap.put(tile.getTileID(), tile.getHexIDContainer());
        hexGrid.setHexTileIDs(tileHexIDsArray, tileCount);
        tileCount++;
        System.out.println("Tile Successfully Placed!");
    }

    public void printTilesOnMap(){
        Iterator<Map.Entry<Integer, int[]>> iterator = gameBoardMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, int[]> mapValue = iterator.next();
            System.out.print("Tile " + mapValue.getKey() + ": ");
            for(int i=0;i<mapValue.getValue().length;i++){
                System.out.print(mapValue.getValue()[i] + " ");
            }
            System.out.println();

            //Prints tile's terrains
            for(int i=0; i<mapValue.getValue().length; i++)
                System.out.print(hexGrid.getHexValue(mapValue.getValue()[i]).getTerrain() + " ");
            System.out.println();
        }

    }

    public Hex getHex(int hexID){
        return hexGrid.getHexValue(hexID);
    }

    public HashMap<Integer, ArrayList<Integer>> getSettlementsMap(){
        return settlement.getSettlementsMap();
    }

    public Settlement getSettlementObj(){
        return settlement;
    }

    public int getTileCount(){return tileCount;}

    public HexGrid getHexGrid() {
        return hexGrid;
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

    public boolean isValidTilePlacement(RotateTile tile) {

        int tileHexIDsArray[];

        tileHexIDsArray = tile.checkPair();

        boolean hexesCanBePlaced = false;
        boolean adjacentTilesValid = false;
        PlacementValidity placementValidity = new PlacementValidity();

        hexesCanBePlaced = placementValidity.checkIfHexesCanBePlaced(hexGrid, tileHexIDsArray);
        adjacentTilesValid = placementValidity.SearchAdjacentTiles(hexGrid, tileHexIDsArray);

        if(hexesCanBePlaced && adjacentTilesValid){

            return true;
        }
        else{
            return false;
        }

    }

}