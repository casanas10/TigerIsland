import cucumber.api.java.cs.A;
import org.junit.Assert;
import org.junit.Test;

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



}
