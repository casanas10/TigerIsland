import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alecasanas on 3/21/17.
 */
public class HexGridTest {

    @Test
    public void generateHexGridTest() {

        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Hex hexo = hexGrid.getHexValue(200);

        Assert.assertEquals(0,hexo.getX());
        Assert.assertEquals(1,hexo.getY());
    }

}
