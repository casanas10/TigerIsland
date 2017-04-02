import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Connor on 4/1/2017.
 */
public class CoordinateConverterTest {
    private CoordinateConverter convert = new CoordinateConverter();

    @Test
    public void testServerCoordinatesToOurs1(){
        int[] actualXY = convert.serverToOurs(0, 0, 0);
        int[] expectedXY = {99, 99};
        Assert.assertArrayEquals(expectedXY, actualXY);
    }

    @Test
    public void testServerCoordinatesToOurs2(){
        int[] actualXY = convert.serverToOurs(103, -704, 601);
        int[] expectedXY = {503, 700};
        Assert.assertArrayEquals(expectedXY, actualXY);
    }

    @Test
    public void testServerCoordinatesToOurs3(){
        int[] actualXY = convert.serverToOurs(1, -1, 0);
        int[] expectedXY = {100, 99};
        Assert.assertArrayEquals(expectedXY, actualXY);
    }

    @Test
    public void testOurCoordinatesToServers1(){
        int[] actualXYZ = convert.oursToServer(99,99);
        int[] expectedXYZ = {0, 0, 0};
        Assert.assertArrayEquals(expectedXYZ, actualXYZ);
    }

    @Test
    public void testOurCoordinatesToServers2(){
        int[] actualXYZ = convert.oursToServer(100, 99);
        int[] expectedXYZ = {1, -1, 0};
        Assert.assertArrayEquals(expectedXYZ, actualXYZ);
    }

    @Test
    public void testOurCoordinatesToServers3(){
        int[] actualXYZ = convert.oursToServer(99,101);
        int[] expectedXYZ = {-1, -1, 2};
        Assert.assertArrayEquals(expectedXYZ, actualXYZ);
    }

}