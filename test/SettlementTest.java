import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alecasanas on 3/25/17.
 */
public class SettlementTest {

    @Test
    public void createNewSettlement() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();
        hexGrid.getHexValue(402).setColor("Black");

        Settlement settlement = new Settlement(hexGrid);

        Assert.assertTrue(settlement.isNewSettlement(402, player));
    }

    @Test
    public void foundNewSettlement() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();
        Hex hex = hexGrid.getHexValue(402);

        Settlement settlement = new Settlement(hexGrid);

        settlement.foundNewSettlement(810,player);

        settlement.foundNewSettlement(809, player);

        Assert.assertTrue(settlement.isPiecePartOfASettlement(0,810));
        Assert.assertTrue(settlement.isPiecePartOfASettlement(1,809));
    }

    @Test
    public void addPieceToAnExistingSettlement() {

        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();
        hexGrid.getHexValue(609).setColor("Black");
        hexGrid.getHexValue(610).setColor("Black");
        hexGrid.getHexValue(809).setColor("Black");
        hexGrid.getHexValue(810).setColor("White");
        hexGrid.getHexValue(811).setColor("Black");
        hexGrid.getHexValue(1009).setColor("Black");
        hexGrid.getHexValue(1010).setColor("Black");
        hexGrid.getHexValue(1008).setColor("Black");


        Settlement settlement = new Settlement(hexGrid);

        settlement.foundNewSettlement(810,player);

        settlement.addPieceToAnExistingSettlement(hexGrid, 809, player);




        //Assert.assertTrue(settlement.isPiecePartOfASettlement(1,610));

    }




}
