/**
 * Created by alecasanas on 3/14/17.
 */
public class Game {

    private Player black;
    private Player white;

    public Game() {

        this.black = new Player("black", 0);
        this.white = new Player("white", 0);
    }

    public int getRemainingMeeples(){
        return (black.getRemainingMeeples() + white.getRemainingMeeples());
    }

    public int getRemainingTotoros(){
        return (black.getRemainingTotoros() + white.getRemainingTotoros());
    }

}
