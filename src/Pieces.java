/**
 * Created by Connor on 3/14/2017.
 */
public class Pieces {
    private Totoro[] totoros;
    private Meeple[] meeples;
    private String Color;

    public void Pieces(String Color) {
        this.Color = Color;
        createMeeple();
        createTotoros();
    }

    public int getNumberOfTotoros() {
        return totoros.length;
    }

    public int getNumberOfMeeple() {
        return meeples.length;
    }

    public void createMeeple() {
        meeples = new Meeple[20];
        setMeepleColor();
    }

    public void createTotoros() {
        totoros = new Totoro[3];
    }

    private void setMeepleColor() {
        for(int i = 0; i < meeples.length; i++) {
            meeples[i].setColor(Color);
        }
    }

    private void setTotoroColor() {
        for(int i = 0; i < totoros.length; i++) {
            totoros[i].setColor(Color);
        }
    }

}
