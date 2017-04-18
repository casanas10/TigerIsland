import cucumber.api.java.Before;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by NatalieGoldstein on 4/1/17.
 */
public class EndOfTurnTest {

    Player player2 = new Player("black", 0);
    EndOfTurn final1 = new EndOfTurn();
    Builder buildme = new Builder();
    IslandMap islandMap = new IslandMap();
    PlayerPieceContainer playerPiece = new PlayerPieceContainer("white");
    Player player1 = new Player("white", 0);

    @Test
    public void isGameDoneByPieces() throws Exception{
        for(int i = 0; i< 20; i++) {
            player2.removeMeeplesforTesting();
        }
        for(int j = 0; j<3; j++){
            player2.removeTotorosforTesting();
        }
        Assert.assertEquals("black", final1.isGameDone(player1, player2, 27));
    }

    @Test
    public void isGameDoneByScore () throws Exception{
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        islandMap.addTileToMap(809,0);
        buildme.build(player1, islandMap,1, 807);
        Assert.assertEquals("white", final1.isGameDone(player1,player2,48));
    }

    @Test
    public void isGameDoneByTieBreaker () throws Exception{
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        islandMap.addTileToMap(809,0);
        buildme.build(player2, islandMap,1, 807);

          islandMap.addTileToMap(610, 0);
            islandMap.addTileToMap(611, 60);
             islandMap.addTileToMap(613,0);
          buildme.build(player1, islandMap,1, 812);

        for(int j = 0; j<1; j++){
            player1.removeTotorosforTesting();
        }
       Assert.assertEquals("white", final1.isGameDone(player1,player2,48));
    }

    @Test
    public void twoTypesOfPiecesUsedUp() throws Exception{
        for(int i = 0; i< 20; i++) {
            player1.removeMeeplesforTesting();
        }
        for(int j = 0; j<3; j++){
            player1.removeTotorosforTesting();
        }
        Assert.assertEquals(true, final1.areTwoTypesOfPiecesUsed(player1));
    }

    @Test
    public void hasPlayerUsedUpTwoPieces() throws Exception{
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        islandMap.addTileToMap(809,0);
        buildme.build(player1, islandMap,1, 807);

        islandMap.addTileToMap(609,60);
        islandMap.addTileToMap(611,0);
        islandMap.addTileToMap(612,60);
        islandMap.addTileToMap(614,0);
        islandMap.addTileToMap(615,60);

        islandMap.addTileToMap(207,0);

        buildme.build(player1,islandMap,1,810);
        buildme.build(player1,islandMap,1,811);
        buildme.build(player1,islandMap,1,812);
        buildme.build(player1,islandMap,1,813);
        buildme.build(player1,islandMap,1,814);
        //build a Totoro sanctuary
        buildme.build(player1,islandMap,3,815);

        //final1.areTwoTypesOfPiecesUsed(player1);
        Assert.assertEquals(false, final1.areTwoTypesOfPiecesUsed(player1));
    }

    @Test
    public void tieBreakByMeeples() throws Exception{
        //Player 2 has used more Meeples

        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        islandMap.addTileToMap(809,0);
        buildme.build(player1, islandMap,1, 807);

        islandMap.addTileToMap(609,60);
        islandMap.addTileToMap(611,0);
        islandMap.addTileToMap(612,60);
        islandMap.addTileToMap(614,0);

        buildme.build(player2, islandMap, 1, 610);
        buildme.build(player2, islandMap, 1,815);

        Assert.assertEquals(2, final1.tieBreaker(player1,player2));
    }

    @Test
    public void tieBreakByTotoro() throws Exception{
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        islandMap.addTileToMap(809,0);
        buildme.build(player1, islandMap,1, 807);

        islandMap.addTileToMap(609,60);
        islandMap.addTileToMap(611,0);
        islandMap.addTileToMap(612,60);
        islandMap.addTileToMap(614,0);
        islandMap.addTileToMap(615,60);
        islandMap.addTileToMap(207,0);

        buildme.build(player1,islandMap,1,810);
        buildme.build(player1,islandMap,1,811);
        buildme.build(player1,islandMap,1,812);
        buildme.build(player1,islandMap,1,813);
        buildme.build(player1,islandMap,1,814);
        //build a Totoro sanctuary
        buildme.build(player1,islandMap,3,815);

        Assert.assertEquals(1, final1.tieBreaker(player1,player2));
    }

    @Test
    public void tieBreakByTigers() throws Exception{
        islandMap.addTileToMap(606, 0);
        Hex currentHex = islandMap.getHex(806);
        currentHex.incrementLevel();
        currentHex.incrementLevel();
        buildme.build(player1,islandMap,1,807);
        buildme.build(player1,islandMap,4,806);

        Assert.assertEquals(1,final1.tieBreaker(player1,player2));
    }
}
