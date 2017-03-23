import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alecasanas on 3/20/17.
 */
public class IslandMapTest {

    private IslandMap islandMap;

    @Before
    public void setUp() {
        islandMap = new IslandMap();
    }

    @Test
    public void addingTileToEmptyMap(){

        Assert.assertTrue(islandMap.addTileToMap(403,0));

    }

//    @Test
//    public void addingInvalidTileToMap(){
//
//        IslandMap islandMap = new IslandMap();
//
//        Assert.assertNull(islandMap.addTileToMap(40000,0));
//    }

    @Test
    public void addingTileToAnAdjecentTile(){

        Assert.assertTrue(islandMap.addTileToMap(413,60));
    }

    @Test
    public void addingTileDirectlyOnTopOfEachOther(){

        islandMap.addTileToMap(412,0);
        Assert.assertFalse(islandMap.addTileToMap(412,0));
    }

    @Test
    public void addingTilePartlyOnTopOfAnotherTile(){

        islandMap.addTileToMap(412,0);
        Assert.assertFalse(islandMap.addTileToMap(412,300));
    }

    
}
