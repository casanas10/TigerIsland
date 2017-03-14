/**
 * Created by alecasanas on 3/14/17.
 */
public class Game {

    public Game() {

        Player Black = new Player();
        Player White = new Player();

        Pieces gamePieces = new Pieces();

        gamePieces.createMeeple();
        gamePieces.createTotoros();
    }



}
