/**
 * Created by Connor on 3/14/2017.
 */
public class Pieces {
    private int numberOfTotoros;
    private int numberOfMeeple;

    public int getNumberOfTotoros() {
        return numberOfTotoros;
    }

    public int getNumberOfMeeple() {
        return numberOfMeeple;
    }

    public void createMeeple() {
        numberOfMeeple = 40;
    }

    public void createTotoros() {
        numberOfTotoros = 6;
    }


}
