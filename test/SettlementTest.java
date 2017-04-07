import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alecasanas on 3/25/17.
 */
public class SettlementTest {

    IslandMap islandMap;
    Player whitePlayer;
    Player blackPlayer;
    Builder builder;

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        blackPlayer = new Player("Black",0);
        whitePlayer = new Player("White",0);
        builder = new Builder();
    }

    @Test
    public void isNewSettlementTest() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(hexGrid);

        settlement.addSettlement(402,player);

        Assert.assertTrue(settlement.isNewSettlement(402,player));
    }

    @Test
    public void foundNewSettlement() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(hexGrid);

        settlement.addSettlement(402,player);

        Assert.assertTrue(settlement.isPiecePartOfASettlement(0,402));
    }

    @Test
    public void addPieceToAnExistingSettlement() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(hexGrid);

        settlement.addSettlement(3014,player);
        settlement.addSettlement(2815,player);
        settlement.addSettlement(3012,player);
        settlement.addSettlement(3013,player);

        settlement.printAllSettlements(player);

        //Assert.assertTrue(settlement.isPiecePartOfASettlement(0,3014));
    }

    @Test
    public void addSeperateSettlements() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(hexGrid);

        settlement.addSettlement(409,player);
        settlement.addSettlement(820, player);

        //settlement.printAllSettlements();

        Assert.assertTrue(settlement.isPiecePartOfASettlement(0,409));

    }


    @Test
    public void updateSettlementAfterNukeTest() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(hexGrid);

        settlement.addSettlement(407, player);
        settlement.addSettlement(606, player);
        settlement.addSettlement(607, player);
        settlement.addSettlement(807, player);
        settlement.addSettlement(808, player);
        settlement.addSettlement(806, player);
        settlement.addSettlement(1005, player);

        ArrayList<Integer> expectedHexes = new ArrayList<Integer>() {{
            add(1006);
            add(806);
            add(807);
        }};


        settlement.updateSettlementAfterNuke(expectedHexes, player);

        settlement.printAllSettlements(player);

        Assert.assertTrue(settlement.isPiecePartOfASettlement(7, 1005));
        Assert.assertTrue(settlement.isPiecePartOfASettlement(8, 606));
    }

    @Test
    public void updateSettlementAfterNukeTest2() {

        //PLACE STARTING TILE
        CoordinateSystem coors = new CoordinateSystem();
        // First tile will actually be placed in the center, this is for testing purposes
        //tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
        int[] tileHexIDsArray = {coors.getHexID(14,15), coors.getHexID(14,14),coors.getHexID(15,14),
                coors.getHexID(14,16), coors.getHexID(15, 16)};
        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grassland"};
        islandMap.placeFirstTile(tileHexIDsArray, tileTerrainsArray);

        islandMap.addTileToMap(3016,0);
        islandMap.getHex(3216).setTerrain("Jungle");
        islandMap.getHex(3217).setTerrain("Rocky");
        builder.build(whitePlayer, islandMap, 1, 2815);

        islandMap.getSettlementObj().printAllSettlements(whitePlayer);

        islandMap.addTileToMap(2616,0);
        islandMap.getHex(2816).setTerrain("Lake");
        islandMap.getHex(2817).setTerrain("Lake");
        builder.extend(2815,islandMap, whitePlayer,"Lake");

        islandMap.getSettlementObj().printAllSettlements(whitePlayer);

        islandMap.addTileToMap(2813, 0, islandMap.getNewTile(), whitePlayer);
        islandMap.getHex(3012).setTerrain("Jungle");
        islandMap.getHex(3013).setTerrain("Jungle");
        builder.build(whitePlayer, islandMap, 1, 2814);
        Hex currentHex = islandMap.getHex(2814);
        System.out.println(currentHex.getTerrain());

        islandMap.getSettlementObj().printAllSettlements(whitePlayer);
        builder.extend(2815,islandMap, whitePlayer,"Jungle");

        islandMap.getSettlementObj().printAllSettlements(whitePlayer);


        islandMap.addTileToMap(2418, 0, islandMap.getNewTile(), whitePlayer);
        islandMap.getHex(2617).setTerrain("Lake");
        islandMap.getHex(2618).setTerrain("Rocky");
        builder.build(whitePlayer, islandMap, 1, 2617);

        islandMap.getSettlementObj().printAllSettlements(whitePlayer);

        //Nuke
        islandMap.addTileToMap(3016, 180, islandMap.getNewTile(), whitePlayer);
        islandMap.getHex(2816).setTerrain("Lake");
        islandMap.getHex(2817).setTerrain("Rocky");

//        builder.extend(2617,islandMap,whitePlayer,"Rocky");

        Hex hex = islandMap.getHex(2617);
        System.out.println(hex.getSettlementID());


        islandMap.getSettlementObj().printAllSettlements(whitePlayer);

        //Nuke
//        islandMap.addTileToMap(3014, 240, islandMap.getNewTile(), whitePlayer);
//        islandMap.getHex(2814).setTerrain("Rocky");
//        islandMap.getHex(3013).setTerrain("Grassland");
//
//        islandMap.getSettlementObj().printAllSettlements();

        //Hex currentHex = islandMap.getHex(410);
        //Assert.assertEquals("No game piece on hex", currentHex.getPieceOnHex());

    }

    @Test
    public void isSizeIsLessThanFiveCantPlaceATotoro() {

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(809, 60);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);

        builder.build(whitePlayer,islandMap,1,406);
        builder.build(whitePlayer,islandMap,1,606);
        builder.build(whitePlayer,islandMap,1,807);
        builder.build(whitePlayer,islandMap,1,808);
        builder.build(whitePlayer,islandMap,1,809);
        builder.build(whitePlayer,islandMap,1,408);
        builder.build(whitePlayer,islandMap,1,409);
        builder.build(whitePlayer,islandMap,3,410);

        Hex currentHex = islandMap.getHex(410);
        Assert.assertEquals("No game piece on hex", currentHex.getPieceOnHex());

    }

    @Test
    public void ableToPlaceTotoroSinceSizeOfSettlementIsGreaterOrEqualTo5() {

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(1207, 120);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);

        builder.build(whitePlayer,islandMap,1,406);
        builder.build(whitePlayer,islandMap,1,606);
        builder.build(whitePlayer,islandMap,1,807);
        builder.build(whitePlayer,islandMap,1,808);
        builder.build(whitePlayer,islandMap,1,809);
        builder.build(whitePlayer,islandMap,1,408);
        builder.build(whitePlayer,islandMap,1,409);

        builder.build(whitePlayer,islandMap,3,1007);

        Hex currentHex = islandMap.getHex(1007);
        Assert.assertEquals("Totoro", currentHex.getPieceOnHex());

    }

    @Test
    public void mergingTwoTotoroSettlements() {

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(1207, 120);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);
        islandMap.addTileToMap(211, 0);
        islandMap.addTileToMap(213, 0);

        builder.build(whitePlayer,islandMap,1,406);

        builder.build(whitePlayer,islandMap,1,606);

        builder.build(whitePlayer,islandMap,1,807);

        builder.build(whitePlayer,islandMap,1,808);

        builder.build(whitePlayer,islandMap,1,809);

        builder.build(whitePlayer,islandMap,1,408);

        builder.build(whitePlayer,islandMap,1,409);

        builder.build(whitePlayer,islandMap,1,410);

        builder.build(whitePlayer,islandMap,1,411);

        builder.build(whitePlayer,islandMap,1,412);

        builder.build(whitePlayer,islandMap,3,1007);

        builder.build(whitePlayer,islandMap,3,407);

        Hex currentHex1 = islandMap.getHex(1007);
        Hex currentHex2 = islandMap.getHex(407);


        Assert.assertEquals("Totoro", currentHex1.getPieceOnHex());
        Assert.assertEquals("Totoro", currentHex2.getPieceOnHex());

    }

    @Test
    public void ableToPlaceTigerIfNoTigerPresentInTheCurrentSettlement() {

        islandMap.addTileToMap(806, 120);

        builder.build(whitePlayer,islandMap,1,606);

        Hex currentHex = islandMap.getHex(807);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(whitePlayer,islandMap,4,807);

        Assert.assertEquals("Tiger",currentHex.getPieceOnHex());

    }


    @Test
    public void checkIfSettlementContainsATigerAlreadyTest() {

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(607,180);

        builder.build(whitePlayer,islandMap,1,606);

        Hex currentHex = islandMap.getHex(807);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(whitePlayer,islandMap,4,807);

        currentHex = islandMap.getHex(407);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(whitePlayer,islandMap,4,407);


        Assert.assertEquals("No game piece on hex", currentHex.getPieceOnHex());

    }

    @Test
    public void whenTwoSettlementAreAdjacentWithDifferentPlayers(){

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(1207, 120);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);
        islandMap.addTileToMap(211, 0);
        islandMap.addTileToMap(213, 0);

        builder.build(whitePlayer,islandMap,1,406);
        builder.build(whitePlayer,islandMap,1,606);


        builder.build(blackPlayer,islandMap,1,809);
        builder.build(blackPlayer,islandMap,1,808);


        builder.build(whitePlayer, islandMap, 1, 807);

        islandMap.getSettlementObj().printAllSettlements(whitePlayer);

    }

}