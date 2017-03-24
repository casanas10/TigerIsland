import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by cyonkee on 3/14/17.
 */
public class TotoroTest {

    static private Player whitePlayer;
    static private Player blackPlayer;

    @BeforeClass
    static public void createNewPlayerAndGame() {
        whitePlayer = new Player("white", 0);
        blackPlayer = new Player("black", 0);
    }

    @Test
    public void whenTheGameStartsThen3TotorosAreCreatedPerPlayer(){
        Assert.assertEquals(3, whitePlayer.getRemainingTotoros());
        Assert.assertEquals(3, blackPlayer.getRemainingTotoros());
    }

    @Test
    public void totoroColorMatchesPlayerColor() {
        Assert.assertEquals(whitePlayer.getPlayerColor(), whitePlayer.getPieces().getTotoros().get(0).getColor());
        Assert.assertEquals(blackPlayer.getPlayerColor(), blackPlayer.getPieces().getTotoros().get(0).getColor());
    }

    @Test
    public void totoroStatusIsNotPlayed() {
        Assert.assertEquals("Not Played", whitePlayer.getPieces().getTotoros().get(0).getStatus());
        Assert.assertEquals("Not Played", blackPlayer.getPieces().getTotoros().get(0).getStatus());
    }
}
