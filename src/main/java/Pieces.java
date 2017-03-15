import java.util.ArrayList;

/**
 * Created by Connor on 3/14/2017.
 */
public class Pieces {

    private Meeple meeples[];
    private Totoro totoros[];
    private String color;

    public Pieces(String color) {
        this.color = color;
        this.meeples = new Meeple[20];
        this.totoros = new Totoro[3];
    }

    public int getNumberOfTotoros() {
        return totoros.length;
    }

    public int getNumberOfMeeple() {
        return meeples.length;
    }

    private void setMeepleColor() {
        for (Meeple meeple : meeples){
            meeple.setColor(color);
        }
    }

    private void setTotoroColor() {
        for (Totoro totoro : totoros){
            totoro.setColor(color);
        }
    }

}
