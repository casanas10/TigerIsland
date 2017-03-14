/**
 * Created by Connor on 3/14/2017.
 */
public class Pieces {
    private Totoro[] totoros;
    private Meeple[] meeples;

    public int getNumberOfTotoros() {
        return totoros.length;//
    }

    public int getNumberOfMeeple() {
        return meeples.length;
    }

    public void createMeeple() {
        meeples = new Meeple[20];
        System.out.println(meeples.length);
    }

    public void createTotoros() {
        totoros = new Totoro[3];
        System.out.println(totoros.length);
    }


}
