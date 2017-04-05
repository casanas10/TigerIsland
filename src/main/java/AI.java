import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by alecasanas on 3/27/17.
 */
public class AI {

    private Game game = new Game();
    private IslandMap islandMap;

    private PlacementValidity validity = new PlacementValidity();

    private RotateTile tile;

    private HashMap<Integer, int[]> allPossibleTiles = new HashMap<>();

    private ArrayList<Integer> ActiveSettlements = new ArrayList<>();

    private CoordinateSystem coordinateSystem = new CoordinateSystem();

    private CoordinateConverter coordinateConverter = new CoordinateConverter();

    private RotationConverter rotationConverter = new RotationConverter();

    private SettlementSizeChecker settlementSizeChecker;

    private Settlement settlements;

    private ArrayList<Integer> volcanosOnMap = new ArrayList<>();

    private Settlement settMap;

    private Nuking nuker = new Nuking();

    private Builder builder = new Builder();

    private ArrayList<Integer> activeHexIDs = new ArrayList<>();
    private int maxHexID = 0;
    private int minHexID = 40000;

    private int[] possibleOrientation = {0, 60, 120, 180, 240, 300};



    /*
    * Strategy for building:
     *
    * 1st - Check if there is a settlement size 5 without a totoro
    *       If yes, place a totoro -- done: need to place a Totoro
    *       Else place a meeple in the largest settlement without a totoro --settlements of size smaller than 5 cannot have totoros -findTheLargestSettlementLessThanFive: need to place meeple
    *       Else place a meeple in the tile just placed
    *
    *
    *  Strategy for placing tiles:
    *  Check if nuking is possible by where the volcanos are
                If possible, nuke (number of volcanos >= 2)
                Else
    *               placeFirstTile (place volcano next to volcano of main tile)
       Check if nuking is possible by where the volcanos are
                If possible, nuke (number of volcanos >= 2)
                Else Remember where the other player placed their tile and check where we can place it -
                place volcanos close to each other (place volcano next to volcano of main tile)
                Else remember were self placed the first tile and place place tile there. (place volcano next to volcano of main tile)
    * */

    public AI(Game game){
        this.game = game;
        this.islandMap = new IslandMap();
    }

    public boolean canYouNuke(IslandMap islandMap){
        int[] Tile = new int[3];
        String[] tileTerrains = new String[3];
        RotateTile rotateTile;
        HexGrid hexGrid = islandMap.getHexGrid();
        for(int k = 0; k<volcanosOnMap.size(); k++){
            if(volcanosOnMap.size() >= 2){
                for (int i = 0; i < 6; i++) {
                    rotateTile = new RotateTile(volcanosOnMap.get(k), possibleOrientation[i]);
                    Tile = rotateTile.checkPair();
                    for(int j = 0; j < 3; j++){
                        tileTerrains[j] = islandMap.getHex(Tile[j]).getTerrain();
                    }
                    if (nuker.canYouNukeSettlement(islandMap, Tile, volcanosOnMap.get(k))) {
                        //Nuke
                        //nuker.performNuke(islandMap.getHexGrid(), Tile, tileTerrains, islandMap.getTileCount());
                        for(int l = 0; l<3; l++) {
                            volcanosOnMap.remove(new Integer(Tile[l]));
                        }
                        placeTile(islandMap, Tile[0], possibleOrientation[i]);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public ArrayList<Integer> SettlementSmallerThanFive(Settlement settlements, IslandMap islandMap, Player player){

        ArrayList<Integer> settlementHexIDs = new ArrayList<>();
        ActiveSettlements = settlements.getListOfActiveSettlementIDs();



        System.out.println("Active Settlements are " + ActiveSettlements);

        for(int i = 0; i<ActiveSettlements.size(); i++){

            if(settlements.getSettlementSize(ActiveSettlements.get(i)) < 5){

                settlementHexIDs = settlements.getSettlementHexIDs(ActiveSettlements.get(i));
                String playerColorOnHex = islandMap.getHex(settlementHexIDs.get(0)).getPlayerColorOnHex();
                String playerPlayingColor = player.getPlayerColor();
                System.out.println(playerColorOnHex + " vs " + playerPlayingColor);
                System.out.println(playerColorOnHex == playerPlayingColor);

                if(islandMap.getHex(settlementHexIDs.get(0)).getPlayerColorOnHex() == player.getPlayerColor()){
                    settlementHexIDs = settlements.getSettlementHexIDs(ActiveSettlements.get(i));
                    return settlementHexIDs;
                }
            }
            settlementHexIDs = new ArrayList<>();
        }
        return settlementHexIDs;
    }

    public ArrayList<Integer> findTheLargestSettlementLessThanFive(Settlement settlements, IslandMap islandMap, Player player){

        ArrayList<Integer> settlementHexIDs = new ArrayList<>();
        ActiveSettlements = settlements.getListOfActiveSettlementIDs();
        ArrayList<Integer> settlementHexIDsTemp = new ArrayList<>();
        int maxSize = 0;

        for(int i = 0; i<ActiveSettlements.size(); i++){

            if((settlements.getSettlementSize(ActiveSettlements.get(i)) > maxSize) && (settlements.getSettlementSize(ActiveSettlements.get(i)) < 5)){

                settlementHexIDsTemp = settlements.getSettlementHexIDs(ActiveSettlements.get(i));

                if(islandMap.getHex(settlementHexIDsTemp.get(0)).getPlayerColorOnHex() == player.getPlayerColor()){
                    settlementHexIDs = settlements.getSettlementHexIDs(ActiveSettlements.get(i));
                    maxSize = (settlements.getSettlementSize(ActiveSettlements.get(i)));
                }
            }
        }
        return settlementHexIDs;
    }

    public Boolean canATotoroBePlaced(IslandMap islandMap, int settlementID, Player player ){
        Settlement settlements = islandMap.getSettlementObj();
        int maxSettlementHexID = 0;
        int minSettlementHexID = 4000;
        int[] maxMin = new int[2];
        ArrayList<Integer> settlementHexIDs = new ArrayList<>();

        if(settlements.getSettlementSize(settlementID) >= 5){

            if(settlements.doesNotHaveATotoro(settlementID, player)) {
                settlementHexIDs = settlements.getSettlementHexIDs(settlementID);

            }
        }
        maxMin[0] = maxSettlementHexID;
        maxMin[1] = minSettlementHexID;
        ArrayList<Integer> availableHexIDs = new ArrayList<>();
        for(int i = 0; i < settlementHexIDs.size(); i++){
            availableHexIDs = lookAroundAHexForAnEmptySettlement(islandMap, settlementHexIDs.get(i));
            if(!availableHexIDs.isEmpty()){
                //place Totoro
                builder.build(player, islandMap, 3, availableHexIDs.get(0));
                return true;
            }
        }

        return false;
    }

    public void nuking(IslandMap islandMap, int hexID){
        ArrayList<Integer> availableHexIDs = lookAroundAHexForAnEmptySettlement(islandMap, hexID);
    }

    public ArrayList<Integer> lookAroundAHexForAnEmptySettlement(IslandMap islandMap, int HexID){
        ArrayList<Integer> availableHexIDs = new ArrayList<>();
        int hexLevel;
        int hexIDTest;
        String hexColor = "";
        String hexTerrain = "";
        int[] Hex1Offset = new int[6];

        // Determine if the origin is on an odd or even row
        if((HexID/200) % 2 != 0) {
            Hex1Offset[0] = 200;
            Hex1Offset[1] = 201;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -199;
            Hex1Offset[4] = -200;
            Hex1Offset[5] = -1;
        }

        else{
            Hex1Offset[0] = 199;
            Hex1Offset[1] = 200;
            Hex1Offset[2] = 1;
            Hex1Offset[3] = -200;
            Hex1Offset[4] = -201;
            Hex1Offset[5] = -1;
        }

        for(int i = 0; i < 6; i++) {
            hexIDTest = HexID + Hex1Offset[i];
            hexLevel = islandMap.getHex(hexIDTest).getLevel();
            hexColor = islandMap.getHex(hexIDTest).getPlayerColorOnHex();
            hexTerrain = islandMap.getHex(hexIDTest).getTerrain();
            if(hexLevel != 0){
                if(hexColor == "") {
                    if (hexTerrain != "Volcano") {
                        availableHexIDs.add(hexIDTest);
                    }
                }
            }
        }

        return availableHexIDs;
    }

    public void updateMaxAndMin(){
        for(int i = activeHexIDs.size()-1; i>activeHexIDs.size()-4; i--){
            if(activeHexIDs.get(i) >= maxHexID){
                maxHexID = activeHexIDs.get(i);
            }
            if(activeHexIDs.get(i) <= minHexID){
                minHexID = activeHexIDs.get(i);
            }
        }
    }

    public int[] placeOurFirstTile(){
        int[] toServer = new int[4];
        int ourX;
        int ourY;
        int[] serverCoordinates = new int[3];
        int serverOrientation = 0;

        //Check right side
        if(islandMap.addTileToMap(19900,60)){
            //return x, y, z and orientation
            ourX = coordinateSystem.getXCoordinate(19900);
            ourY = coordinateSystem.getYCoordinate(19900);
            serverCoordinates = coordinateConverter.oursToServer(ourX, ourY);
            serverOrientation = rotationConverter.oursToServer(60);
            volcanosOnMap.add(19900);
            RotateTile rotateTile = new RotateTile(19900, 60);
            int[] Tile = rotateTile.checkPair();
            for(int i = 0; i<3; i++) {
                activeHexIDs.add(Tile[i]);
            }
        }
        else if(islandMap.addTileToMap(19898,240)){
            //return x, y, z and orientation
            ourX = coordinateSystem.getXCoordinate(19898);
            ourY = coordinateSystem.getYCoordinate(19898);
            serverCoordinates = coordinateConverter.oursToServer(ourX, ourY);
            serverOrientation = rotationConverter.oursToServer(240);
            volcanosOnMap.add(19898);
            RotateTile rotateTile = new RotateTile(19898, 240);
            int[] Tile = rotateTile.checkPair();
            for(int i = 0; i<3; i++) {
                activeHexIDs.add(Tile[i]);
            }
        }

        updateMaxAndMin();

        for(int i = 0; i < serverCoordinates.length; i++) {
            toServer[i] = serverCoordinates[i];
        }

        toServer[3] = serverOrientation;

        return toServer;

    }

    public int[] placeTile(IslandMap islandMap, int volcanoHexID, int orientation){
        int[] toServer = new int[4];
        islandMap.addTileToMap(volcanoHexID, orientation);
        RotateTile rotateTile = new RotateTile(volcanoHexID, orientation);
        int[] Tile = rotateTile.checkPair();
        for(int i = 0; i<3; i++) {
            activeHexIDs.add(Tile[i]);
        }

        volcanosOnMap.add(volcanoHexID);

        int ourX = coordinateSystem.getXCoordinate(volcanoHexID);
        int ourY = coordinateSystem.getYCoordinate(volcanoHexID);
        int[] serverCoordinates = coordinateConverter.oursToServer(ourX, ourY);
        int serverOrientation = rotationConverter.oursToServer(orientation);

        for(int i=0; i<3; i++)
            toServer[i] = serverCoordinates[i];

        toServer[3] = serverOrientation;

        return toServer;
    }

    public int[] findLocationToPlaceTile(IslandMap islandMap){

        //worst case scenario
        return placeTile(islandMap, maxHexID + 1, 0);
        //or you could do placeTile.(islandMap, minHexID - 1, 180);
    }
    /*
    public void expandSettlement(HexGrid hexGrid, Player player){
        updateActiveSettlements(hexGrid);
        ArrayList<Integer> settlementSmallerThanFive = SettlementSmallerThanFive(hexGrid, player);

    }
    */

    public HashMap<Integer, int[]> getAllPossibleTilePlacementPosition(int[] tileArr) {

        int[] orientation = {0, 60, 120, 180, 240, 300};

        for (int i = 0; i < tileArr.length; i++){

            ArrayList<Integer> adjacentHexes = validity.searchTheSixAdjacentHexes(islandMap.getHex(tileArr[i]));

            for (int j = 0; j < adjacentHexes.size(); j++){

                System.out.println(adjacentHexes.get(j));

                for (int k = 0; k < orientation.length; k++){

                    tile = new RotateTile(adjacentHexes.get(j), orientation[k]);

                    allPossibleTiles.put(k, tile.checkPair());

                }

//                if(validity.SearchAdjacentTiles(islandMap.getHexGrid(),tileArr) && validity.checkIfHexesCanBePlaced(islandMap.getHexGrid(), tileArr)){
//
////                    System.out.println(adjacentHexes.get(j));
//                }
            }
        }

        return allPossibleTiles;
    }

    public void printAllPossibleTiles(){
        Iterator<Map.Entry<Integer, int[]>> iterator = allPossibleTiles.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, int[]> entry = iterator.next();
            System.out.print("Tile " + entry.getKey() + ": ");
            for(int i=0;i<3;i++){
                System.out.print(entry.getValue()[i] + " ");
            }
            System.out.println();
        }
    }


}
