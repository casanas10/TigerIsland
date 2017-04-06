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
    public void largestSettlementLessThanFiveTest(){
        Player bPlayer = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = islandMap.getSettlementObj();

        Builder builder = new Builder();

        builder.build(player, islandMap, 1, 806); //807 from 606

        islandMap.addTileToMap(608, 0);
        builder.build(bPlayer, islandMap, 1, 807);
        //builder.build(bPlayer, islandMap, 1, 808);
        builder.build(bPlayer, islandMap, 1, 809);

        ArrayList<Integer> playerSettlement = islandMap.getPlayerSettlement(bPlayer);

        ai.findTheLargestSettlementLessThanFive(islandMap, player);
    }


    @Test
    public void lookAroundAHexForAnEmptySettlementTest(){

        Player bPlayer = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = islandMap.getSettlementObj();

        Builder builder = new Builder();

        builder.build(player, islandMap, 1, 806); //807 from 606

        islandMap.addTileToMap(608, 0);
        builder.build(bPlayer, islandMap, 1, 807);
        //builder.build(bPlayer, islandMap, 1, 808);
        //builder.build(bPlayer, islandMap, 1, 809);

        ArrayList<Integer> playerSettlement = islandMap.getPlayerSettlement(bPlayer);

        ArrayList<Integer> availableHexIDs = ai.lookAroundAHexForAnEmptySettlement(islandMap, 807);

        System.out.println(availableHexIDs);
    }

    @Test
    public void canATotoroBePlacedTest(){
        islandMap.addTileToMap(606, 0);

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

        islandMap.addTileToMap(612, 0);
        System.out.println(ai.canATotoroBePlaced(islandMap,bPlayer));

    }


    @Test
    public void canYouNukeTest(){
        Player bPlayer = new Player("Black", 0);
        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Settlement settlement = islandMap.getSettlementObj();

        Builder builder = new Builder();

        //islandMap.addTileToMap(607, 60);
        int[] toServer = new int[4];
        toServer = ai.placeTile(islandMap, 19899, 0);
        for(int i = 0; i<4; i++){
            System.out.print(toServer[i] + " ");
        }
        System.out.println();
        toServer = ai.placeTile(islandMap, 19900, 60);
        for(int i = 0; i<4; i++){
            System.out.print(toServer[i] + " ");
        }
        System.out.println();
        Assert.assertEquals(true, ai.canYouNuke(islandMap));

    }

}
