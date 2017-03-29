import cucumber.api.java.Before;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by NatalieGoldstein on 3/28/17.
 */
public class NukingTest {
    IslandMap islandMap;
    Player player;
    Builder builder;
    Nuking nuking;
    HexGrid hexGrid;

    //606 at 0
    //607 at 60
    //nuke at 606 at 60

    @Before
    public void setUp() throws Exception{
        islandMap = new IslandMap();
        player = new Player("White",0);
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        builder = new Builder();
        nuking = new Nuking();

    }



    @Test
    public void tileIDChange() throws Exception{


        int tile = 606;
       // builder.build(player, islandMap,1, 806);

       // Assert.assertEquals(true, nuking.isSettlementSizeOne(islandMap.getHexGrid(),tile));



    }


}
