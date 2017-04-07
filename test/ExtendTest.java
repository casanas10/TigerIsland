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

        Assert.assertTrue(lakesToExtendOn.contains(806));
        Assert.assertTrue(lakesToExtendOn.contains(1005));
    }

    @Test
    public void extendSettlementTest2(){
        islandMap = new IslandMap();
        islandMap.addTileToMap(2608,0);
        islandMap.addTileToMap(2610,0);
        islandMap.addTileToMap(2612,0);
        islandMap.addTileToMap(2414,0);
        islandMap.addTileToMap(3210,180);
        islandMap.getHex(2808).setTerrain("Grassland");
        islandMap.getHex(2809).setTerrain("Grassland");
        islandMap.getHex(2810).setTerrain("Grassland");
        islandMap.getHex(3215).setTerrain("Grassland");
        islandMap.getHex(3009).setTerrain("Rocky");
        islandMap.getHex(3010).setTerrain("Rocky");
        islandMap.getHex(2811).setTerrain("Rocky");
        islandMap.getHex(2812).setTerrain("Rocky");
        islandMap.getHex(2813).setTerrain("Jungle");
        islandMap.getHex(2814).setTerrain("Jungle");
        islandMap.getHex(2613).setTerrain("Jungle");
        islandMap.getHex(2614).setTerrain("Lake");
        islandMap.getHex(2815).setTerrain("Lake");
        islandMap.getHex(3214).setTerrain("Rocky");
        player1 = new Player("Black",0);
        player2 = new Player("White", 0);
        builder = new Builder();
        builder.build(player1,islandMap,1,2813);
        builder.build(player2,islandMap,1,3016);
        builder.build(player1,islandMap,1,2811);
        builder.extendForAI(3016,islandMap,player2,"Rocky");
        builder.extendForAI(2811,islandMap,player1,"Rocky");
        builder.build(player2,islandMap,3,2810);
        //builder.extendForAI(3009,islandMap,player1,"Grassland");

        extend = new ExtendSettlement(3009, islandMap, player1);
        ArrayList<Integer> lakesToExtendOn = extend.getLakesToExtendOn();
        ArrayList<Integer> grasslandsToExtendOn = extend.getGrasslandsToExtendOn();
        ArrayList<Integer> junglesToExtendOn = extend.getJunglesToExtendOn();
        ArrayList<Integer> rockysToExtendOn = extend.getRockysToExtendOn();

        Assert.assertTrue(grasslandsToExtendOn.contains(2808));
        Assert.assertTrue(grasslandsToExtendOn.contains(2809));
        //Assert.assertTrue(grasslandsToExtendOn.contains(2810));

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

    @Test
    public void pieceDecrementTest(){
        islandMap.getHex(806).incrementLevel();
        islandMap.getHex(1005).incrementLevel();
        islandMap.getHex(1005).incrementLevel();
        extend = new ExtendSettlement(807,islandMap,player1);
        extend.extendOnTerrain("Lake");
        Assert.assertEquals(14,player1.getRemainingMeeples());
    }

    @Test
    public void notEnoughMeeplesTest(){
        islandMap.getHex(806).incrementLevel();
        for(int i=0; i<20; i++) {
            islandMap.getHex(1005).incrementLevel();
        }
        extend = new ExtendSettlement(807,islandMap,player1);
        Assert.assertFalse(extend.extendOnTerrain("Lake"));
    }
}