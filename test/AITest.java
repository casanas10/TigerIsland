/**
 * Created by alecasanas on 4/2/17.
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alecasanas on 3/27/17.
 */
public class AITest {

    private AI ai;

    private IslandMap islandMap;
    private Player player1;
    private Player player2;

    private RotateTile tile;

    Builder builder;

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        islandMap.addTileToMap(807, 0);
        player1 = new Player("Black", 0);
        player2 = new Player("White", 0);

        Game game = new Game();
        ai = new AI(game, islandMap);
        builder = new Builder();
    }

    @Test
    public void getAllPossibleTilePosition() {

        ArrayList<Integer> tileArr = new ArrayList<Integer>() {{
            add(807);
            add(1006);
            add(1007);
        }};

        ai.getAllPossibleTilePlacementPosition(tileArr);
        ai.printAllPossibleTiles();
    }

    @Test
    public void findSettlementsSize3To5() {

        Settlement settlement = islandMap.getSettlementObj();

        islandMap.addTileToMap(807, 0);
        islandMap.addTileToMap(809, 0);
        islandMap.addTileToMap(811, 0);
        islandMap.addTileToMap(813, 0);

        builder.build(player1,islandMap,1,1006);
        builder.build(player1,islandMap,1,1007);
        builder.build(player1,islandMap,1,1008);


        builder.build(player1,islandMap,1,1010);
        builder.build(player1,islandMap,1,1011);

        islandMap.getSettlementObj().printAllSettlements();

        int actualSettlement = ai.findOpponentsSettlementSizeThreeToFive().get(1);

        Assert.assertEquals(0,actualSettlement);
    }

    @Test
    public void PlacingScenarioWhenFindASettlementofSize3OrGreater() {

        Settlement settlement = islandMap.getSettlementObj();

        islandMap.addTileToMap(807, 0);
        islandMap.addTileToMap(809, 0);
        islandMap.addTileToMap(811, 0);
        islandMap.addTileToMap(813, 0);

        builder.build(player1,islandMap,1,1006);
        builder.build(player1,islandMap,1,1007);
        builder.build(player1,islandMap,1,1008);


        builder.build(player1,islandMap,1,1010);
        builder.build(player1,islandMap,1,1011);

        islandMap.getSettlementObj().printAllSettlements();

        ai.play();

        ai.printAllPossibleTiles();

    }
}