/**
 * Created by cyonkee on 4/1/17.
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class ExtendTest {
    IslandMap islandMap;
    Player player1;
    Player player2;
    Builder builder;
    ExtendSettlement extend;

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        islandMap.addTileToMap(606,0);
        islandMap.addTileToMap(808,0);
        islandMap.addTileToMap(1206,180);
        player1 = new Player("Black",0);
        player2 = new Player("White", 0);
        builder = new Builder();
        builder.build(player1,islandMap,1,807);
        builder.build(player2,islandMap,1,1008);
        islandMap.getHex(807).setTerrain("Lake");
        islandMap.getHex(806).setTerrain("Lake");
        islandMap.getHex(1005).setTerrain("Lake");
        islandMap.getHex(1006).setTerrain("Rocky");
        islandMap.getHex(1007).setTerrain("Jungle");
        islandMap.getHex(1008).setTerrain("Lake");
    }

    @Test
    public void extendSettlementTest(){
        extend = new ExtendSettlement(807, islandMap, player1);
        ArrayList<Integer> lakesToExtendOn = extend.getLakesToExtendOn();
        ArrayList<Integer> grasslandsToExtendOn = extend.getGrasslandsToExtendOn();
        ArrayList<Integer> junglesToExtendOn = extend.getJunglesToExtendOn();
        ArrayList<Integer> rockysToExtendOn = extend.getRockysToExtendOn();

        int lake1 = lakesToExtendOn.get(0);
        int lake2 = lakesToExtendOn.get(1);

        Assert.assertEquals(806,lake1);
        Assert.assertEquals(1005,lake2);

        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        Assert.assertTrue(grasslandsToExtendOn.isEmpty());
        Assert.assertTrue(junglesToExtendOn.isEmpty());
        Assert.assertTrue(rockysToExtendOn.isEmpty());
    }

    @Test
    public void addingHexesTest(){
        extend = new ExtendSettlement(807,islandMap,player1);
        extend.extendOnTerrain("Lake");
        HashMap<Integer, ArrayList<Integer>> settlementsMap = islandMap.getSettlementsMap();

        ArrayList<Integer> hexesInSettlement = settlementsMap.get(0);
        ArrayList<Integer> expectedHexes = new ArrayList<Integer>();
        expectedHexes.add(1005);
        expectedHexes.add(806);
        expectedHexes.add(807);

        //Assert.assertSame(expectedHexes,hexesInSettlement);
        Assert.assertEquals(expectedHexes,hexesInSettlement);
    }

    @Test
    public void scoringTest(){
        islandMap.getHex(806).incrementLevel();
        islandMap.getHex(1005).incrementLevel();
        islandMap.getHex(1005).incrementLevel();
        extend = new ExtendSettlement(807,islandMap,player1);
        extend.extendOnTerrain("Lake");
        Assert.assertEquals(14,player1.getCurrentScore());
    }
}
