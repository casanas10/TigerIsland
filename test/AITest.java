/**
 * Created by alecasanas on 4/2/17.
 */
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
    private Player player;

    private RotateTile tile;

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        islandMap.addTileToMap(807, 4);
        player = new Player("Black", 0);

        Game game = new Game();
        ai = new AI(game, islandMap);

    }

    @Test
    public void getAllPossibleTilePosition() {

        tile = new RotateTile(807, 4);
        int[] tileArr = tile.checkPair();

        ai.getAllPossibleTilePlacementPosition(tileArr);
        ai.printAllPossibleTiles();
    }
}