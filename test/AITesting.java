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
        islandMap.addTileToMap(606, 0);
        player = new Player("Black", 0);

        Game game = new Game();
        ai = new AI(game);

    }

    @Test
    public void getAllPossibleTilePosition() {

        Hex currentHex = islandMap.getHex(606);

        tile = new RotateTile(606, 0);

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

    @Test
    public void lessThanFiveSettlementHexIDs(){
        Player bPlayer = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = islandMap.getSettlementObj();

        Builder builder = new Builder();

        builder.build(player, islandMap, 1, 806); //807 from 606

        islandMap.addTileToMap(608, 0);
        builder.build(bPlayer, islandMap, 1, 807);
        builder.build(bPlayer, islandMap, 1, 808);
        builder.build(bPlayer, islandMap, 1, 809);

        ArrayList<Integer> playerSettlement = islandMap.getPlayerSettlement(bPlayer);

        ArrayList<Integer> settlementHexIDs = ai.SettlementSmallerThanFive(settlement, islandMap, player);

        System.out.println(settlementHexIDs);
    }

    @Test
    public void canATotoroBePlacedTest(){
        Player bPlayer = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = islandMap.getSettlementObj();

        Builder builder = new Builder();

        builder.build(player, islandMap, 1, 806); //807 from 606

        islandMap.addTileToMap(608, 0);
        builder.build(bPlayer, islandMap, 1, 807);
        builder.build(bPlayer, islandMap, 1, 808);
        builder.build(bPlayer, islandMap, 1, 809);

        islandMap.addTileToMap(610, 0);
        builder.build(bPlayer, islandMap, 1, 810);

        System.out.println(ai.canATotoroBePlaced(settlement, settlement.getSettlementID(807), bPlayer));
    }
}
