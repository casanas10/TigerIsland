import org.junit.Test;
import org.junit.Assert;

/**
 * Created by NatalieGoldstein on 3/16/17.
 */
public class PlayerTest {


@Test
    public void checkColorOfPlayerAtStart(){

    Player player = new Player("White", 0);

    Assert.assertEquals("White", player.getPlayerColor());


}

@Test
    public void checkPlayerScoreAtStart(){
        Player player = new Player("Black", 0);

        Assert.assertEquals(0,player.getCurrentScore() );

}






}
