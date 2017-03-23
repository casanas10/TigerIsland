import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Val on 3/22/2017.
 */

public class RotateTileTest {

    RotateTile tile;

    @Before
    public void setUp()throws Exception {

    }

    @Test
<<<<<<< HEAD
    public void rotateTileTest0DegreesOriginEven()throws Exception{
        tile = new RotateTile(402, 0);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(601, TileArr[1]);
        Assert.assertEquals(602, TileArr[2]);
    }

    @Test
    public void rotateTileTest60DegreesOriginEven()throws Exception{
        tile = new RotateTile(402, 60);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(602, TileArr[1]);
=======
    public void rotateTileTest0Degrees()throws Exception{
        tile = new RotateTile(402, 0);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(602, TileArr[1]);
        Assert.assertEquals(603, TileArr[2]);
    }

    @Test
    public void rotateTileTest60Degrees()throws Exception{
        tile = new RotateTile(402, 60);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(603, TileArr[1]);
>>>>>>> master
        Assert.assertEquals(403, TileArr[2]);
    }

    @Test
<<<<<<< HEAD
    public void rotateTileTest120DegreesOriginEven()throws Exception{
=======
    public void rotateTileTest120Degrees()throws Exception{
>>>>>>> master
        tile = new RotateTile(402, 120);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(403, TileArr[1]);
<<<<<<< HEAD
        Assert.assertEquals(202, TileArr[2]);
    }

    @Test
    public void rotateTileTest180DegreesOriginEven()throws Exception{
        tile = new RotateTile(402, 180);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(202, TileArr[1]);
        Assert.assertEquals(201, TileArr[2]);
    }

    @Test
    public void rotateTileTest240DegreesOriginEven()throws Exception{
        tile = new RotateTile(402, 240);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(201, TileArr[1]);
=======
        Assert.assertEquals(203, TileArr[2]);
    }

    @Test
    public void rotateTileTest180Degrees()throws Exception{
        tile = new RotateTile(402, 180);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(203, TileArr[1]);
        Assert.assertEquals(202, TileArr[2]);
    }

    @Test
    public void rotateTileTest240Degrees()throws Exception{
        tile = new RotateTile(402, 240);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(202, TileArr[1]);
>>>>>>> master
        Assert.assertEquals(401, TileArr[2]);
    }

    @Test
<<<<<<< HEAD
    public void rotateTileTest300DegreesOriginEven()throws Exception{
=======
    public void rotateTileTest300Degrees()throws Exception{
>>>>>>> master
        tile = new RotateTile(402, 300);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(401, TileArr[1]);
<<<<<<< HEAD
        Assert.assertEquals(601, TileArr[2]);
    }

    @Test
    public void rotateTileTest0DegreesOriginOdd()throws Exception{
        tile = new RotateTile(602, 0);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(802, TileArr[1]);
        Assert.assertEquals(803, TileArr[2]);
    }

    @Test
    public void rotateTileTest60DegreesOriginOdd()throws Exception{
        tile = new RotateTile(602, 60);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(803, TileArr[1]);
        Assert.assertEquals(603, TileArr[2]);
    }

    @Test
    public void rotateTileTest120DegreesOriginOdd()throws Exception{
        tile = new RotateTile(602, 120);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(603, TileArr[1]);
        Assert.assertEquals(403, TileArr[2]);
    }

    @Test
    public void rotateTileTest180DegreesOriginOdd()throws Exception{
        tile = new RotateTile(602, 180);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(403, TileArr[1]);
        Assert.assertEquals(402, TileArr[2]);
    }

    @Test
    public void rotateTileTest240DegreesOriginOdd()throws Exception{
        tile = new RotateTile(602, 240);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(402, TileArr[1]);
        Assert.assertEquals(601, TileArr[2]);
    }

    @Test
    public void rotateTileTest300DegreesOriginOdd()throws Exception{
        tile = new RotateTile(602, 300);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(601, TileArr[1]);
        Assert.assertEquals(802, TileArr[2]);
=======
        Assert.assertEquals(602, TileArr[2]);
>>>>>>> master
    }

}
