import cucumber.api.java.cs.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alecasanas on 3/25/17.
 */
public class SettlementTest {

    IslandMap islandMap;
    Player player;
    Builder builder;

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        player = new Player("Black",0);
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

        settlement.addSettlement(402,player);
        settlement.addSettlement(602,player);

        settlement.addSettlement(604,player);

        settlement.addSettlement(603,player);

        settlement.addSettlement(850,player);
        settlement.addSettlement(205,player);
        settlement.addSettlement(405,player);

        //settlement.printAllSettlements();

        Assert.assertTrue(settlement.isPiecePartOfASettlement(2,405));
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

        settlement.addSettlement(202, player);
        settlement.addSettlement(403, player);
        settlement.addSettlement(603, player);
        settlement.addSettlement(604, player);
        settlement.addSettlement(605, player);

        ArrayList<Integer> expectedHexes = new ArrayList<Integer>() {{
            add(603);
            add(604);
            add(804);
        }};

        settlement.printAllSettlements();
        settlement.updateSettlementAfterNuke(expectedHexes, player);

        settlement.printAllSettlements();

        Assert.assertTrue(settlement.isPiecePartOfASettlement(5, 403));
    }

    @Test
    public void ifSizeFiveOrMorePlaceATotoro() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(hexGrid);

        settlement.addSettlement(406, player);
        settlement.addSettlement(606, player);
        settlement.addSettlement(807, player);
        settlement.addSettlement(808, player);
        settlement.addSettlement(809, player);

        settlement.addSettlement(408,player);
        settlement.addSettlement(409,player);

        settlement.addTotoroToSettlement(1007,player);

        //settlement.printAllSettlements();
        Assert.assertTrue(settlement.isPiecePartOfASettlement(0,1007));

    }

    @Test
    public void isSizeIsLessThanFiveCantPlaceATotoro() {

        HexGrid hexGrid = new HexGrid();
        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(islandMap.getHexGrid());

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(809, 60);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);

        builder.build(player,islandMap,1,406);
        settlement.addSettlement(406, player);

        builder.build(player,islandMap,1,606);
        settlement.addSettlement(606, player);

        settlement.addSettlement(807, player);
        builder.build(player,islandMap,1,807);

        settlement.addSettlement(808, player);
        builder.build(player,islandMap,1,808);

        settlement.addSettlement(809, player);
        builder.build(player,islandMap,1,809);

        settlement.addSettlement(408,player);
        builder.build(player,islandMap,1,408);

        settlement.addSettlement(409,player);
        builder.build(player,islandMap,1,409);

        settlement.addTotoroToSettlement(410,player);

        settlement.printAllSettlements();

        Assert.assertFalse(settlement.isPiecePartOfASettlement(0,410));

    }

    @Test
    public void ableToPlaceTotoroSinceSizeOfSettlementIsGreaterOrEqualTo5() {

        HexGrid hexGrid = new HexGrid();
        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(islandMap.getHexGrid());

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(1207, 120);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);

        builder.build(player,islandMap,1,406);
        builder.build(player,islandMap,1,606);
        builder.build(player,islandMap,1,807);
        builder.build(player,islandMap,1,808);
        builder.build(player,islandMap,1,809);
        builder.build(player,islandMap,1,408);
        builder.build(player,islandMap,1,409);

        settlement.printAllSettlements();

        //System.out.println(settlement.isSettlementSizeFiveOrMore(606, player));
        builder.build(player,islandMap,3,1007);
       // System.out.println(settlement.isSettlementSizeFiveOrMore(409, player));


        settlement.printAllSettlements();
        //Assert.assertTrue(settlement.isPiecePartOfASettlement(0,1007));

    }

    @Test
    public void checkIfSettlementContainsATotoroAlreadyTest() {

        HexGrid hexGrid = new HexGrid();
        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(islandMap.getHexGrid());

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(1207, 120);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);
        islandMap.addTileToMap(211, 0);
        islandMap.addTileToMap(213, 0);

        builder.build(player,islandMap,1,406);
        settlement.addSettlement(406, player);

        builder.build(player,islandMap,1,606);
        settlement.addSettlement(606, player);

        settlement.addSettlement(807, player);
        builder.build(player,islandMap,1,807);

        settlement.addSettlement(808, player);
        builder.build(player,islandMap,1,808);

        settlement.addSettlement(809, player);
        builder.build(player,islandMap,1,809);

        settlement.addSettlement(408,player);
        builder.build(player,islandMap,1,408);

        settlement.addSettlement(409,player);
        builder.build(player,islandMap,1,409);

        settlement.addSettlement(410,player);
        builder.build(player,islandMap,1,410);

        settlement.addSettlement(411,player);
        builder.build(player,islandMap,1,411);

        settlement.addSettlement(412,player);
        builder.build(player,islandMap,1,412);

        settlement.addTotoroToSettlement(1007,player);
        builder.build(player,islandMap,3,1007);

        settlement.addTotoroToSettlement(407,player);
        builder.build(player,islandMap,3,407);

        settlement.printAllSettlements();

//        Hex currentHex = islandMap.getHex(1007);
//        System.out.println(currentHex.getPieceOnHex());

        Assert.assertTrue(settlement.isPiecePartOfASettlement(5,1007));
        Assert.assertTrue(settlement.isPiecePartOfASettlement(5,407));

    }

    @Test
    public void ableToPlaceTigerIfNoTigerPresentInTheCurrentSettlement() {

        HexGrid hexGrid = new HexGrid();
        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(islandMap.getHexGrid());

        islandMap.addTileToMap(806, 120);

        builder.build(player,islandMap,1,606);

        Hex currentHex = islandMap.getHex(807);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,807);

        settlement.printAllSettlements();

        //Assert.assertTrue(settlement.isPiecePartOfASettlement(0,807));

    }


    @Test
    public void checkIfSettlementContainsATigerAlreadyTest() {

        HexGrid hexGrid = new HexGrid();
        hexGrid.generateHexGrid();

        Settlement settlement = new Settlement(islandMap.getHexGrid());

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(607,180);

        builder.build(player,islandMap,1,606);
        settlement.addSettlement(606, player);

        Hex currentHex = islandMap.getHex(807);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,807);

        currentHex = islandMap.getHex(407);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,407);

        settlement.printAllSettlements();

        Assert.assertFalse(settlement.isPiecePartOfASettlement(0,407));

    }

}
