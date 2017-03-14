/**
 * Created by alecasanas on 3/14/17.
 */
public class Game {

    public Game() {

        Player Black = new Player("black", 0);
        Player White = new Player("white", 0);

        Black.getRemainingMeeples();
        Black.getRemainingTotoros();

        White.getRemainingMeeples();
        White.getRemainingTotoros();
    }



}
