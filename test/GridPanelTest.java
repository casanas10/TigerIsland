import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ale on 3/21/17.
 */
public class GridPanelTest {

    @Test
    public void hexGridToPixelConversionTest() {

        GridPanel gridPanel = new GridPanel();

        Assert.assertEquals("2", gridPanel.hexGridToPixelConversion(90,25));
    }

}
