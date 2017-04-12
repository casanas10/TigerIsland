import org.junit.Test;

/**
 * Created by Val on 4/9/2017.
 */
public class AIPlayingAgaintSelfTest {
    private Game game1 = new Game();
    private Game game2 = new Game();
    private AI ai1 = new AI(game1);
    private AI ai2 = new AI(game2);
    private Boolean aiTurn = false;
    private MoveData moveData = new MoveData();
    private String[] Tile = {"Volcano", "Rocky", "Lake"};
//    private AI server = new AI(game);

    @Test
    public void placeAgainstSelfTest(){
        ai1.makeMove(Tile);
        moveData = ai1.getMoveData();
        for(int i = 0; i<24; i++) {

            ai2.updateOpponentMove(moveData);
            ai2.makeMove(Tile);
            moveData = ai1.getMoveData();

            ai1.updateOpponentMove(moveData);
            ai1.makeMove(Tile);
            moveData = ai1.getMoveData();
        }
    }
}
