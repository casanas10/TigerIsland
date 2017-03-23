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

<<<<<<< HEAD
        Hex hexo = hexGrid.getHexValue(26);
=======
        Hex hexo = hexGrid.getHexValue(200);
>>>>>>> d498c4f8b30d33cf7e6d948891d056b34abe729d

        Assert.assertEquals(0,hexo.getX());
        Assert.assertEquals(1,hexo.getY());
    }

}
