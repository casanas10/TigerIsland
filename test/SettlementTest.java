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

        settlement.printAllSettlements();

        Assert.assertTrue(settlement.isPiecePartOfASettlement(7, 1005));
        Assert.assertTrue(settlement.isPiecePartOfASettlement(8, 606));
    }

    @Test
    public void isSizeIsLessThanFiveCantPlaceATotoro() {

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(206, 0);
        islandMap.addTileToMap(1008, 180);
        islandMap.addTileToMap(809, 60);
        islandMap.addTileToMap(208, 0);
        islandMap.addTileToMap(209, 60);

        builder.build(player,islandMap,1,406);
        builder.build(player,islandMap,1,606);
        builder.build(player,islandMap,1,807);
        builder.build(player,islandMap,1,808);
        builder.build(player,islandMap,1,809);
        builder.build(player,islandMap,1,408);
        builder.build(player,islandMap,1,409);
        builder.build(player,islandMap,3,410);

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

        builder.build(player,islandMap,1,406);
        builder.build(player,islandMap,1,606);
        builder.build(player,islandMap,1,807);
        builder.build(player,islandMap,1,808);
        builder.build(player,islandMap,1,809);
        builder.build(player,islandMap,1,408);
        builder.build(player,islandMap,1,409);

        builder.build(player,islandMap,3,1007);

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

        builder.build(player,islandMap,1,406);

        builder.build(player,islandMap,1,606);

        builder.build(player,islandMap,1,807);

        builder.build(player,islandMap,1,808);

        builder.build(player,islandMap,1,809);

        builder.build(player,islandMap,1,408);

        builder.build(player,islandMap,1,409);

        builder.build(player,islandMap,1,410);

        builder.build(player,islandMap,1,411);

        builder.build(player,islandMap,1,412);

        builder.build(player,islandMap,3,1007);

        builder.build(player,islandMap,3,407);

        Hex currentHex1 = islandMap.getHex(1007);
        Hex currentHex2 = islandMap.getHex(407);


        Assert.assertEquals("Totoro", currentHex1.getPieceOnHex());
        Assert.assertEquals("Totoro", currentHex2.getPieceOnHex());

    }

    @Test
    public void ableToPlaceTigerIfNoTigerPresentInTheCurrentSettlement() {

        islandMap.addTileToMap(806, 120);

        builder.build(player,islandMap,1,606);

        Hex currentHex = islandMap.getHex(807);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,807);

        Assert.assertEquals("Tiger",currentHex.getPieceOnHex());

    }


    @Test
    public void checkIfSettlementContainsATigerAlreadyTest() {

        islandMap.addTileToMap(806, 120);
        islandMap.addTileToMap(607,180);

        builder.build(player,islandMap,1,606);

        Hex currentHex = islandMap.getHex(807);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,807);

        currentHex = islandMap.getHex(407);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,407);


        Assert.assertEquals("No game piece on hex", currentHex.getPieceOnHex());

    }

}
