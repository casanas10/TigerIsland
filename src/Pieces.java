import java.util.ArrayList;

/**
 * Created by Connor on 3/14/2017.
 */
public class Pieces {
    private ArrayList totoros;
    private ArrayList meeples;
    private String Color;

    public Pieces(String Color) {
        this.Color = Color;
        createMeeple();
        createTotoros();
    }

    public int getNumberOfTotoros() {
        return totoros.size();
    }

    public int getNumberOfMeeple() {
        return meeples.size();
    }

    public void createMeeple() {
        meeples = new ArrayList(20);
        setMeepleColor();
    }

    public void createTotoros() {
        totoros = new ArrayList(3);
    }

    private void setMeepleColor() {
        for(int i = 0; i < meeples.size(); i++) {
            meeples.get(i)
        }
    }

    private void setTotoroColor() {
        for(int i = 0; i < totoros.length; i++) {
            totoros[i].setColor(Color);
        }
    }

}
