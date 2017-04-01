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
    public void rotateTileTestOrientation1OriginEven()throws Exception{
        tile = new RotateTile(402, 1);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(201, TileArr[1]);
        Assert.assertEquals(202, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation2OriginEven()throws Exception{
        tile = new RotateTile(402, 2);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(202, TileArr[1]);
        Assert.assertEquals(403, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation3OriginEven()throws Exception{
        tile = new RotateTile(402, 3);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(403, TileArr[1]);
        Assert.assertEquals(602, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation4riginEven()throws Exception{
        tile = new RotateTile(402, 4);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(602, TileArr[1]);
        Assert.assertEquals(601, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation5OriginEven()throws Exception{
        tile = new RotateTile(402, 5);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(601, TileArr[1]);
        Assert.assertEquals(401, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation6OriginEven()throws Exception{
        tile = new RotateTile(402, 6);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(402, TileArr[0]);
        Assert.assertEquals(401, TileArr[1]);
        Assert.assertEquals(201, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation1OriginOdd()throws Exception{
        tile = new RotateTile(602, 1);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(402, TileArr[1]);
        Assert.assertEquals(403, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation2OriginOdd()throws Exception{
        tile = new RotateTile(602, 2);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(403, TileArr[1]);
        Assert.assertEquals(603, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation3OriginOdd()throws Exception{
        tile = new RotateTile(602, 3);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(603, TileArr[1]);
        Assert.assertEquals(804, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation4OriginOdd()throws Exception{
        tile = new RotateTile(602, 4);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(804, TileArr[1]);
        Assert.assertEquals(803, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation5OriginOdd()throws Exception{
        tile = new RotateTile(602, 5);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(803, TileArr[1]);
        Assert.assertEquals(601, TileArr[2]);
    }

    @Test
    public void rotateTileTestOrientation6OriginOdd()throws Exception{
        tile = new RotateTile(602, 6);
        int[] TileArr = tile.checkPair();
        Assert.assertEquals(602, TileArr[0]);
        Assert.assertEquals(601, TileArr[1]);
        Assert.assertEquals(402, TileArr[2]);
    }

}