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
public class AITesting {

    private ALE_AI ai;
    private Game game;
    private IslandMap islandMap;
    private Player player1;
    private Player player2;

    private RotateTile tile;

    Builder builder;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        islandMap = game.getIslandMap();
        islandMap.addTileToMap(807, 0);
        player1 = new Player("Black", 0);
        player2 = game.getWhitePlayer();

        Game game = new Game();
        ai = new ALE_AI(game);
        builder = game.builder;
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

        //int actualSettlement = ai.findOpponentsSettlementSizeThreeToFive().get(1);

        //Assert.assertEquals(0,actualSettlement);
    }

    @Test
    public void LookingForYourSettlementSize5OrMore() {

        Settlement settlement = islandMap.getSettlementObj();

        islandMap.addTileToMap(807, 0);
        islandMap.addTileToMap(809, 0);
        islandMap.addTileToMap(811, 0);
        islandMap.addTileToMap(813, 0);
        islandMap.addTileToMap(815, 0);
        islandMap.addTileToMap(817, 0);
        islandMap.addTileToMap(819, 0);
        islandMap.addTileToMap(821, 0);
        islandMap.addTileToMap(823, 0);


        builder.build(player1,islandMap,1,1006);
        builder.build(player1,islandMap,1,1007);
        builder.build(player1,islandMap,1,1008);
        builder.build(player1,islandMap,1,1009);
        builder.build(player1,islandMap,1,1010);

        builder.build(player2,islandMap,1,1011);
        builder.build(player2,islandMap,1,1012);
        builder.build(player2,islandMap,1,1013);
        builder.build(player2,islandMap,1,1014);
        builder.build(player2,islandMap,1,1015);

        builder.build(player1,islandMap,1,1016);

        islandMap.getSettlementObj().printAllSettlements();

        ai.play();

    }

}