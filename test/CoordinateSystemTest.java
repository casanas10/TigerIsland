
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertEquals(1003, coordinates.getHexID(3, 5));
    }

    @Test
    public void getXCoordinate() throws Exception {
        Assert.assertEquals(0, coordinates.getXCoordinate(200));
    }

    @Test
    public void getYCoordinate() throws Exception {
        Assert.assertEquals(1, coordinates.getYCoordinate(200));
    }

    @Test
    public void checkFirstHexID() throws Exception {
        Assert.assertEquals(0, coordinates.getHexID(0,0));
    }

    @Test
    public void checkLastHexID() throws Exception {
        Assert.assertEquals(39999, coordinates.getHexID(199,199));
    }

    @Test
    public void checkIfCoordinateArrayLengthIs200() throws Exception {
        Assert.assertEquals(200, coordinates.getHexID(0, 1));
    }

}
