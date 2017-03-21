import org.junit.Test;

/**
 * Created by alecasanas on 3/21/17.
 */
public class HexGridTest {

    @Test
    public void generateHexGridTest() {

        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Hex hexo = hexGrid.getHexValue(1);

        System.out.println(hexo.getX());
        System.out.println(hexo.getY());


        //hexGrid.printMap();
    }
}
