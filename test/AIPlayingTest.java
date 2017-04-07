import org.junit.Test;

/**
 * Created by Val on 4/3/2017.
 */
public class AIPlayingTest {
    private Game game = new Game();
    private AI ai = new AI(game);
    private AI server = new AI(game);

    private boolean aiTurn = false;

    @Test
    public void placeFirstTileTest(){
        //game.gameRunning();
        System.out.println(1);
        int[] toServer = ai.makeFirstMove(game.getIslandMap());


        for(int value : toServer)
            System.out.print(value + " ");

    }

    @Test
    public void testGamePlaying(){

        while(true){
            ai.playingAI();
            System.out.println("# of meeple left: " + game.getWhitePlayer().getPieces().getNumberOfMeeples());
            System.out.println("---------------------------------------------------------------------------------------");
        }

    }

    @Test
    public void whenTwoPlayersPlayGame(){

        int i = 0;

        while(i < 48){

            if (aiTurn){

                System.out.println("AI TURN");
                ai.playingAI();

            } else {

                System.out.println("SERVER TURN");
                server.playingAI();
            }

            i++;
        }

    }

    public boolean aiTurnToPlay() {
        return aiTurn = !aiTurn;
    }
}