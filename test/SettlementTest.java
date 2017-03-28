import cucumber.api.java.cs.A;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alecasanas on 3/25/17.
 */
public class SettlementTest {

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

        settlement.addSettlement(202,player);
        settlement.addSettlement(403, player);
        settlement.addSettlement(603, player);
        settlement.addSettlement(604, player);
        settlement.addSettlement(605, player);


        ArrayList<Integer> expectedHexes = new ArrayList<Integer>() {{
            add(603);
            add(604);
            add(804);
        }};

        settlement.updateSettlementAfterNuke(expectedHexes, player);

        settlement.printAllSettlements();

        //settlement.printAllSettlements();

        Assert.assertEquals(2, settlement.getListOfActiveSettlementIDs().size());
    }

    @Test
    public void listOfActiveSettlementsTest() {
        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();
        Settlement settlement = new Settlement(hexGrid);

        hexGrid.generateHexGrid();

        settlement.addSettlement(402,player);
        settlement.addSettlement(602,player);
        settlement.addSettlement(604,player);
        settlement.addSettlement(603,player);
        settlement.addSettlement(850,player);
        settlement.addSettlement(205,player);
        settlement.addSettlement(405,player);
        settlement.addSettlement(1000,player);

        Assert.assertEquals(settlement.getListOfActiveSettlementIDs().size(), settlement.getSettlementMap().size());

    }

}
