import org.junit.Test;

/**
 * Created by Val on 4/3/2017.
 */
public class AIPlayingTest {
    private Game game = new Game();
    private AI ai = new AI(game);

    @Test
    public void placeFirstTileTest(){
        //game.gameRunning();
        System.out.println(1);
        int[] toServer = ai.placeOurFirstTile();


        for(int value : toServer)
            System.out.print(value + " ");

    }
}
