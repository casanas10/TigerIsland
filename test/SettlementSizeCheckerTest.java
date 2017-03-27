import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Connor on 3/25/2017.
 */
public class SettlementSizeCheckerTest {
    static Player blackPlayer;
    static Player whitePlayer;
    static HexGrid hexGrid;
    static SettlementSizeChecker checkSettlementSize;

    @BeforeClass
    static public void setupGameScenario() {
        blackPlayer = new Player("Black", 0);
        whitePlayer = new Player("White", 0);
        hexGrid = new HexGrid();

        hexGrid.generateHexGrid();
        hexGrid.getHexValue(609).setPlayerColorOnHex("Black");
        hexGrid.getHexValue(610).setPlayerColorOnHex("Black");
        hexGrid.getHexValue(809).setPlayerColorOnHex("Black");
        hexGrid.getHexValue(810).setPlayerColorOnHex("White");
        hexGrid.getHexValue(811).setPlayerColorOnHex("Black");
        hexGrid.getHexValue(1009).setPlayerColorOnHex("Black");
        hexGrid.getHexValue(1010).setPlayerColorOnHex("Black");
        hexGrid.getHexValue(1008).setPlayerColorOnHex("Black");

        checkSettlementSize = new SettlementSizeChecker(hexGrid);
    }

    @Test
    public void checkBFS() {
        Assert.assertEquals(0, checkSettlementSize.checkSettlementSize(810,blackPlayer).size());
    }

    @Test
    public void checkBFS2() {
        Assert.assertEquals(7, checkSettlementSize.checkSettlementSize(609,blackPlayer).size());
    }

    @Test
    public void checkBFS3() {
        Assert.assertEquals(1,checkSettlementSize.checkSettlementSize(810, whitePlayer).size());
    }

    @Test
    public void checkBFS4() {
        Assert.assertEquals(0,checkSettlementSize.checkSettlementSize(200,whitePlayer).size());
    }

}