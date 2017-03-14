/**
 * Created by alecasanas on 3/14/17.
 */
public class Game {

    public Game() {

        Player Black = new Player();
        Player White = new Player();

        Pieces meeples = new Pieces();
        Pieces totoros = new Pieces();

        meeples.createMeeple();
        totoros.createTotoros();
    }



}
