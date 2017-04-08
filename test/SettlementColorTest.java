import cucumber.api.java.ca.I;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Val on 4/8/2017.
 */
public class SettlementColorTest {
    private IslandMap islandMap = new IslandMap();
    private Settlement settlement = islandMap.getSettlementObj();
    private Builder builder = new Builder();
    private Player whitePlayer = new Player("White", 0);
    private Player blackPlayer = new Player("Black", 0);

    @Test
    public void checkNuking(){
        String[] terrains = {"Volcano", "Rocky", "Lake"};
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(608,0);
        islandMap.addTileToMap(607,180);

        builder.build(blackPlayer,islandMap,1,806);
        builder.build(blackPlayer, islandMap,1,807);
        builder.build(blackPlayer, islandMap, 1, 808);
        builder.build(blackPlayer, islandMap, 1, 809);
        builder.build(blackPlayer, islandMap, 1, 407);
        builder.build(whitePlayer, islandMap, 1, 408);

        islandMap.addTileToMap(607,0, terrains, whitePlayer);

        settlement.printAllSettlements(whitePlayer);

    }

    @Test
    public void checkingColorSettlements(){
        islandMap.addTileToMap(607,0);
        builder.build(whitePlayer,islandMap,1,808);
        builder.build(blackPlayer, islandMap,1,807);
        settlement.printAllSettlements(whitePlayer);
    }

    @Test
    public void placeTotoroInvalid(){
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(608,0);
        islandMap.addTileToMap(607,180);

        builder.build(blackPlayer,islandMap,1,806);
        builder.build(blackPlayer, islandMap,1,807);
        builder.build(blackPlayer, islandMap, 1, 808);
        builder.build(blackPlayer, islandMap, 1, 809);
        builder.build(blackPlayer, islandMap, 1, 810);
        builder.build(whitePlayer, islandMap, 3, 811);

        settlement.printAllSettlements(whitePlayer);
    }

    @Test
    public void placeTotoroValid(){
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(608,0);
        islandMap.addTileToMap(610,0);

        builder.build(blackPlayer,islandMap,1,806);
        builder.build(blackPlayer, islandMap,1,807);
        builder.build(blackPlayer, islandMap, 1, 808);
        builder.build(blackPlayer, islandMap, 1, 809);
        builder.build(blackPlayer, islandMap, 1, 810);
        builder.build(blackPlayer, islandMap, 3, 811);

        settlement.printAllSettlements(whitePlayer);
    }

    @Test
    public void placeTigerValid(){
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(608,0);
        islandMap.addTileToMap(607,180);
        islandMap.addTileToMap(609, 180);
        islandMap.addTileToMap(607,0);
        islandMap.addTileToMap(608,180);
        islandMap.addTileToMap(607, 120);

        builder.build(blackPlayer, islandMap, 1, 407);
        builder.build(blackPlayer, islandMap, 4, 408);
    }

    @Test
    public void placeTigerInvalid(){
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(608,0);
        islandMap.addTileToMap(607,180);
        islandMap.addTileToMap(609, 180);
        islandMap.addTileToMap(607,0);
        islandMap.addTileToMap(608,180);
        islandMap.addTileToMap(607, 120);

        builder.build(blackPlayer, islandMap, 1, 407);
        builder.build(whitePlayer, islandMap, 4, 408);
    }
}
