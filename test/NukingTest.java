import cucumber.api.java.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

/**
 * Created by NatalieGoldstein on 3/28/17.
 */
public class NukingTest {
    static IslandMap islandMap = new IslandMap();
    static Player player = new Player("White",0);
    static Builder builder = new Builder();
    Nuking nuking = new Nuking();
    HexGrid hexGrid = islandMap.getHexGrid();
    Settlement settlement = islandMap.getSettlementObj();

    @BeforeClass
    static public void setUp(){
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        islandMap.addTileToMap(809,0);
        builder.build(player, islandMap,1, 807);

        islandMap.addTileToMap(609,60);
        islandMap.addTileToMap(611,0);
        islandMap.addTileToMap(612,60);
        islandMap.addTileToMap(614,0);
        islandMap.addTileToMap(615,60);
        builder.build(player,islandMap,1,810);
        builder.build(player,islandMap,1,811);
        builder.build(player,islandMap,1,812);
        builder.build(player,islandMap,1,813);
        builder.build(player,islandMap,1,814);
        //build a Totoro sanctuary
        builder.build(player,islandMap,3,815);

    }

    @Test
    public void canNukeSuccessfully() throws Exception{
        //Testing if nuking works when all conditions are satisfied
        int tile[] = {809, 808, 1008};
        Assert.assertEquals(true, nuking.canYouNukeSettlement(islandMap,tile, tile[0]));
    }

    @Test
    public void nukeFailsIfTilesAreOverlapping() throws Exception{
        //Testing that nuking fails if the new tile is overlapping an entire existing tile
        int tile2[] = {606, 806, 807};
        Assert.assertEquals(false,nuking.canYouNukeSettlement(islandMap,tile2, tile2[0]));
    }

    @Test
    public void nukeFailsIfLowerTilesAreNotTheSameLevel() throws Exception{
        //Testing that nuking fails if the new tile is not placed on tiles of the same level
        int tile3[] = {606, 605, 806};
        Assert.assertEquals(false,nuking.canYouNukeSettlement(islandMap,tile3,tile3[0]));
    }

    @Test
    public void nukeFailsIfVolcanoesAreNotPlacedOnTopOfEachOther() throws Exception{
        //Testing that nuking fails if volcanoes are not placed on top of each other
        int tile4[] = {808, 807, 607};
        Assert.assertEquals(false,nuking.canYouNukeSettlement(islandMap,tile4,tile4[0]));
    }

    @Test
    public void nukeFailsIfYouTryToNukeASettlementOfSizeOne() throws Exception{
        //Testing that a settlement of size 1 cannot be nuked
        int tile5[] = {607, 807, 808};
        Assert.assertEquals(false, nuking.canYouNukeSettlement(islandMap, tile5, tile5[0]));
    }

    @Test
    public void nukeFailsIfYouTryToNukeATotoro() throws Exception{
        int tile6[] = {615,815,816};
        Assert.assertEquals(false, nuking.canYouNukeSettlement(islandMap, tile6, tile6[0]));
    }

}
