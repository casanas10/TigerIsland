import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by alecasanas on 3/14/17.
 */
public class MeepleTest {
    static private Player whitePlayer;
    static private Player blackPlayer;

    @BeforeClass
    static public void createNewPlayerAndGame() {
        whitePlayer = new Player("white", 0);
        blackPlayer = new Player("black", 0);
    }

    @Test
    public void whenTheGameStartsThen20MeeplesAreCreatedPerPlayer(){
        Assert.assertEquals(20, whitePlayer.getRemainingMeeples());
        Assert.assertEquals(20, blackPlayer.getRemainingMeeples());
    }

    @Test
    public void meepleColorMatchesPlayerColor() {
        Assert.assertEquals(whitePlayer.getPlayerColor(), whitePlayer.getPieces().getMeeples().get(0).getColor());
        Assert.assertEquals(blackPlayer.getPlayerColor(), blackPlayer.getPieces().getMeeples().get(0).getColor());
    }

    @Test
    public void meepleStatusIsNotPlayed() {
        Assert.assertEquals("Not Played", whitePlayer.getPieces().getMeeples().get(0).getStatus());
        Assert.assertEquals("Not Played", blackPlayer.getPieces().getMeeples().get(0).getStatus());
    }

}
