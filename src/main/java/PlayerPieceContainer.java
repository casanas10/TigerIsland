import java.util.ArrayList;

/**
 * Created by Connor on 3/14/2017.
 */
public class PlayerPieceContainer {

    private ArrayList<Meeple> meeples;
    private ArrayList<Totoro> totoros;
    private ArrayList<Tiger> tigers;
    private String color;

    public PlayerPieceContainer(String color) {
        this.color = color;
        this.meeples = new ArrayList(20);
        this.totoros = new ArrayList(3);
        this.tigers = new ArrayList(2);
    }

    // Getters for the remaining number of each piece a player has
    public int getNumberOfTotoros() {
        return totoros.size();
    }

    public int getNumberOfMeeples() {
        return meeples.size();
    }

    public int getNumberOfTigers(){ return tigers.size();}


    public ArrayList<Meeple> getMeeples() {
        return meeples;
    }

    public ArrayList<Totoro> getTotoros() {
        return totoros;
    }

    public String getColorOfPieces() {
        return color;
    }

    // Create the players pieces
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

    public void create2Tigers(){
        for(int i = 0;i < 2;i++){
            tigers.add(new Tiger(color));
        }
    }

}
