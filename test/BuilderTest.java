import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Eric on 3/24/2017.
 */
public class BuilderTest {
    IslandMap islandMap;
    Player player;
    Builder builder;

    @Before
    public void setUp() throws Exception {
        islandMap = new IslandMap();
        islandMap.addTileToMap(606, 4);
        player = new Player("Black",0);
        builder = new Builder();
    }

    @Test
    public void buildSettlementSuccessfully() throws Exception {
        Hex currentHex = islandMap.getHex(806);
        builder.build(player,islandMap,1,806);

        Assert.assertEquals("Meeple",currentHex.getPieceOnHex());
    }

    @Test
    public void buildTotoroSanctuarySuccessfully() throws Exception {
        Hex currentHex = islandMap.getHex(806);
        builder.build(player,islandMap,3,806);

        Assert.assertEquals("Totoro",currentHex.getPieceOnHex());
    }

    @Test
    public void buildTigerPlaygroundSuccessfully() throws Exception {
        Hex currentHex = islandMap.getHex(806);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,806);

        Assert.assertEquals("Tiger",currentHex.getPieceOnHex());
    }

    @Test
    public void buildANewSettlement() throws Exception {
        builder.build(player,islandMap,1,806);

        Hex currentHex = islandMap.getHex(806);

        Assert.assertEquals("Meeple", currentHex.getPieceOnHex());
    }

    @Test
    public void buildATotoroSanctuary() throws Exception {
        builder.build(player,islandMap,3,806);

        Hex currentHex = islandMap.getHex(806);

        Assert.assertEquals("Totoro", currentHex.getPieceOnHex());
    }

    @Test
    public void buildATigerPlayground() throws Exception {
        Hex currentHex = islandMap.getHex(806);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,806);

        Assert.assertEquals("Tiger", currentHex.getPieceOnHex());
    }

    @Test
    public void verifyValidHexForSettlementSucceeds() throws Exception {
        Hex currentHex = islandMap.getHex(806);

        Assert.assertEquals(true, builder.verifyValidHexForSettlement(currentHex));
    }

    @Test
    public void verifyValidHexForTotoroSucceeds() throws Exception {
        Hex currentHex = islandMap.getHex(806);

        Assert.assertEquals(true, builder.verifyValidHexForTotoro(currentHex));
    }

    @Test
    public void verifyValidHexForTigerSucceeds() throws Exception {
        Hex currentHex = islandMap.getHex(806);
        currentHex.incrementLevel();
        currentHex.incrementLevel();

        Assert.assertEquals(true, builder.verifyValidHexForTiger(currentHex));
    }

    @Test
    public void verifyValidHexForSettlementFailsForInvalidLevelAndNotPlaced() throws Exception {
        Hex currentHex = islandMap.getHex(1000);

        Assert.assertEquals(false, builder.verifyValidHexForSettlement(currentHex));
    }

    @Test
    public void verifyValidHexForTotoroFailsForInvalidLevelAndNotPlaced() throws Exception {
        Hex currentHex = islandMap.getHex(1000);

        Assert.assertEquals(false, builder.verifyValidHexForTotoro(currentHex));
    }

    @Test
    public void verifyValidHexForTigerFailsForInvalidLevelAndNotPlaced() throws Exception {
        Hex currentHex = islandMap.getHex(1000);

        Assert.assertEquals(false, builder.verifyValidHexForTiger(currentHex));
    }

    @Test
    public void verifyValidHexForTigerFailsForInvalidLevel() throws Exception {
        Hex currentHex = islandMap.getHex(806);
        currentHex.incrementLevel();

        Assert.assertEquals(false, builder.verifyValidHexForTiger(currentHex));
    }

    @Test
    public void verifyValidHexForSettlementFailsForBeingAlreadyFounded() throws Exception {
        builder.build(player,islandMap,1,806);

        Hex currentHex = islandMap.getHex(806);

        Assert.assertEquals(false, builder.verifyValidHexForSettlement(currentHex));
    }

    @Test
    public void verifyValidHexForTotoroFailsForBeingAlreadyFounded() throws Exception {
        builder.build(player,islandMap,1,806);

        Hex currentHex = islandMap.getHex(806);

        Assert.assertEquals(false, builder.verifyValidHexForTotoro(currentHex));
    }

    @Test
    public void verifyValidHexForTigerFailsForBeingAlreadyFounded() throws Exception {
        builder.build(player,islandMap,1,806);

        Hex currentHex = islandMap.getHex(806);
        currentHex.incrementLevel();
        currentHex.incrementLevel();

        Assert.assertEquals(false, builder.verifyValidHexForTiger(currentHex));
    }

    @Test
    public void verifyValidHexForSettlementFailsForBeingAVolcanoTerrain() throws Exception {
        Hex currentHex = islandMap.getHex(606);

        Assert.assertEquals(false, builder.verifyValidHexForSettlement(currentHex));
    }

    @Test
    public void verifyValidHexForTotoroFailsForBeingAVolcanoTerrain() throws Exception {
        Hex currentHex = islandMap.getHex(606);

        Assert.assertEquals(false, builder.verifyValidHexForTotoro(currentHex));
    }

    @Test
    public void verifyValidHexForTigerFailsForBeingAVolcanoTerrain() throws Exception {
        Hex currentHex = islandMap.getHex(606);
        currentHex.incrementLevel();
        currentHex.incrementLevel();

        Assert.assertEquals(false, builder.verifyValidHexForTiger(currentHex));
    }

    @Test
    public void updateScoreForAddingANewSettlement(){
        builder.build(player,islandMap,1,806);

        Assert.assertEquals(1,player.getCurrentScore());
    }

    @Test
    public void updateScoreForAddingATotoro(){
        builder.build(player,islandMap,3,806);

        Assert.assertEquals(200,player.getCurrentScore());
    }

    @Test
    public void updateScoreForAddingATiger(){
        Hex currentHex = islandMap.getHex(806);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        builder.build(player,islandMap,4,806);

        Assert.assertEquals(75,player.getCurrentScore());
    }

}