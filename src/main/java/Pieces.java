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
        this.totoros = new ArrayList(3);
    }

    public int getNumberOfTotoros() {
        return totoros.size();
    }

    public int getNumberOfMeeple() {
        return meeples.size();
    }

    public ArrayList<Meeple> getMeeples() {
        return meeples;
    }

    public ArrayList<Totoro> getTotoros() {
        return totoros;
    }

    public String getColorOfPieces() {
        return color;
    }

    public void create20Meeples() {
        for (int i = 0; i < 20; i++) {
            meeples.add(new Meeple(color));
        }
    }

    public void create3Totoros() {
        for (int i = 0; i < 3; i++) {
            totoros.add(new Totoro(color));
        }
    }

}
