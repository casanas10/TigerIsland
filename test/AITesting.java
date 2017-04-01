import gherkin.lexer.Ro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alecasanas on 3/27/17.
 */
public class AITesting {

    private AI ai;

    private IslandMap islandMap;
    private Player player;

    private RotateTile tile;

    Builder builder;

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        islandMap.addTileToMap(807, 0);
        player = new Player("Black", 0);

        Game game = new Game();
        ai = new AI(game, islandMap);

        builder = new Builder();
    }

    @Test
    public void getAllPossibleTilePosition() {

        Hex currentHex = islandMap.getHex(807);

        tile = new RotateTile(807, 0);
        int[] tileArr = tile.checkPair();

        HashMap<Integer, int[]> tileMap = new HashMap<>();

        ai.getAllPossibleTilePlacementPosition(tileArr);

        ai.printAllPossibleTiles();
    }

    @Test
    public void findOpponentsSettlementOfSizeThreeToFive(){

        Player player = new Player("Black", 0);

        islandMap.settlement.addSettlement(402,player);

        islandMap.settlement.printAllSettlements();

        ai.findOpponentsSettlementSizeThreeToFive();
    }
}
