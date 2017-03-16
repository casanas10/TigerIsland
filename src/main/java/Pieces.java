import java.util.ArrayList;

/**
 * Created by Connor on 3/14/2017.
 */
public class Pieces {

    private ArrayList<Meeple> meeples;
    private ArrayList<Totoro> totoros;
    private String color;

    public Pieces(String color) {
        this.color = color;
        this.meeples = new ArrayList(20);
        create20Meeples();
        this.totoros = new ArrayList(3);
        create3Totoros();
    }

    public int getNumberOfTotoros() {
        return totoros.size();
    }

    public int getNumberOfMeeple() {
        return meeples.size();
    }

    private void create20Meeples() {
        for (int i = 0; i < 20; i++) {
            meeples.add(new Meeple());
        }
    }

    private void create3Totoros() {
        for (int i = 0; i < 3; i++) {
            totoros.add(new Totoro());
        }
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
