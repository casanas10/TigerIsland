/**
 * Created by alecasanas on 3/14/17.
 */
public class Game {

    public Game() {

        Player Black = new Player("Black", 0);
        Player White = new Player("White", 0);

        System.out.println("Player Color: " + Black.getPlayerColor());
        System.out.println("Meeples: " + Black.getRemainingMeeples());
        System.out.println("Totoros: " + Black.getRemainingTotoros());
        System.out.println("Score: " + Black.getCurrentScore());

        System.out.println("Player Color: " + White.getPlayerColor());
        System.out.println("Meeples: " + White.getRemainingMeeples());
        System.out.println("Totoros: " + White.getRemainingTotoros());
        System.out.println("Score: " + White.getCurrentScore());

    }

}
