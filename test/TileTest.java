import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Eric on 3/16/2017.
 */
public class TileTest {
    private Tile tileToTest;
    @Before
    public void setUp() throws Exception {
        tileToTest = new Tile("Volcano", "Rock", "Lake");
    }

    @Test
    public void printHexTerrains() throws Exception {
        Assert.assertEquals(tileToTest.getSpecificHexTerrain(0), "Volcano");
        Assert.assertEquals(tileToTest.getSpecificHexTerrain(1), "Rock");
        Assert.assertEquals(tileToTest.getSpecificHexTerrain(2), "Lake");
    }

    @Test
    public void updateSpecificHexTerrainType(){
        tileToTest.updateSpecificHexTerrainType(1, "Lake");
        tileToTest.updateSpecificHexTerrainType(2, "Rock");
        Assert.assertEquals(tileToTest.getSpecificHexTerrain(1), "Lake");
        Assert.assertEquals(tileToTest.getSpecificHexTerrain(2), "Rock");
    }
}