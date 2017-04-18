import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by NatalieGoldstein on 3/16/17.
 */
public class PlayerTest {

    static private Player whitePlayer;
    static private Player blackPlayer;

    @BeforeClass
    static public void createPlayer() {
        whitePlayer = new Player("white", 0);
        blackPlayer = new Player("black", 0);
    }

    @Test
    public void checkColorOfPlayerAtStart(){
        Assert.assertEquals("white", whitePlayer.getPlayerColor());
    }

    @Test
    public void checkPlayerScoreAtStart(){
        Assert.assertEquals(0,blackPlayer.getCurrentScore() );
    }

    @Test
    public void newPlayerStartsWith20Meeples() {
        Assert.assertEquals(20, whitePlayer.getRemainingMeeples());
    }

    @Test
    public void newPlayerStartsWith3Totoros() {
        Assert.assertEquals(3, whitePlayer.getRemainingTotoros());
    }

    @Test
    public void newPlayerStartsWith2Tigers(){
        Assert.assertEquals(2, whitePlayer.getRemainingTigers());
    }

}