import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Eric on 3/21/2017.
 */
public class TileGeneratorTest {
    TileGenerator myTestGen;

    @Before
    public void setUp() throws Exception {
        myTestGen = new TileGenerator();
    }

    @Test
    public void printTiles() throws Exception {

    }

    @Test
    public void getTileTerrains() throws Exception {
        Assert.assertEquals("Volcano", myTestGen.getTileTerrains(0)[0]);
        Assert.assertEquals("Lake", myTestGen.getTileTerrains(0)[1]);
        Assert.assertEquals("Lake", myTestGen.getTileTerrains(0)[2]);
    }

    @Test
    public void getNewTile() throws Exception {
        String[] testStringArray = myTestGen.getNewTile();
        Assert.assertEquals(47, myTestGen.getTilesRemaining());
        Assert.assertEquals(3, testStringArray.length);
    }

    @Test
    public void getTilesRemaining() throws Exception {
        Assert.assertEquals(48, myTestGen.getTilesRemaining());
    }

}