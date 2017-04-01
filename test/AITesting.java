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

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        islandMap.addTileToMap(606, 4);
        player = new Player("Black", 0);

        Game game = new Game();
        ai = new AI(game);

    }

    @Test
    public void getAllPossibleTilePosition() {

        Hex currentHex = islandMap.getHex(606);

        tile = new RotateTile(606, 4);

        int[] tileArr = tile.checkPair();

        HashMap<Integer, int[]> tileMap = new HashMap<>();

        ArrayList<Integer> expectedHexes = new ArrayList<Integer>() {{
            add(407);
            add(607);
            add(408);
        }};

        tileMap = ai.getAllPossibleTilePlacementPosition(tileArr);


        ai.printAllPossibleTiles();
    }
}
