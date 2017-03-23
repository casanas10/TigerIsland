import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Connor on 3/21/2017.
 */
public class CoordinateSystemTest {
    CoordinateSystem coordinates;

    @Before
    public void setUp() throws Exception {
        coordinates = new CoordinateSystem();
    }

    @Test
    public void getTileNumber() throws Exception {
        Assert.assertEquals(133, coordinates.getHexID(3, 5));
    }

    @Test
    public void getXCoordinate() throws Exception {
        Assert.assertEquals(18, coordinates.getXCoordinate(200));
    }

    @Test
    public void getYCoordinate() throws Exception {
        Assert.assertEquals(7, coordinates.getYCoordinate(200));
    }

}