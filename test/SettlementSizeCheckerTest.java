import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Connor on 3/25/2017.
 */
public class SettlementSizeCheckerTest {

    @Test
    public void checkBFS() {
        Player player = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();
        hexGrid.getHexValue(609).setColor("Black");
        hexGrid.getHexValue(610).setColor("White");
        hexGrid.getHexValue(809).setColor("Black");
        hexGrid.getHexValue(810).setColor("Black");
        hexGrid.getHexValue(811).setColor("Black");
        hexGrid.getHexValue(1009).setColor("Black");
        hexGrid.getHexValue(1010).setColor("Black");


        SettlementSizeChecker checkSettlementSize = new SettlementSizeChecker(hexGrid);

//        Assert.assertEquals(1,checkSettlementSize.upperLeftHexID(201));
//        Assert.assertTrue(checkSettlementSize.playerColorMatchesHexColor(201,player));
//        Assert.assertFalse(checkSettlementSize.playerColorMatchesHexColor(401, player));

        //System.out.println(checkSettlementSize.checkSettlementSize(201, player));
        Assert.assertEquals(6, checkSettlementSize.checkSettlementSize(810,player));
    }

}