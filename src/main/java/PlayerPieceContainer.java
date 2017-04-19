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


    public void removeMeeples(){
            meeples.remove(meeples.size()-1);
    }

    public void removeTotoros(){
        totoros.remove(totoros.size()-1);
    }

    public void removeTigers(){
        tigers.remove(tigers.size()-1);
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

    public GamePiece placeGamePiece(String pieceName){
        switch(pieceName){

            case "Meeple": if(getNumberOfMeeples() == 0){
                                break;
                           }
                           Meeple meeple = meeples.get(meeples.size() - 1);
                           meeples.remove(meeples.size()-1);
                           return meeple;

            case "Totoro": if(getNumberOfTotoros() == 0){
                                break;
                           }
                           Totoro totoro = totoros.get(totoros.size() - 1);
                           totoros.remove(totoros.size()-1);
                           return totoro;

            case "Tiger":  if(getNumberOfTigers() == 0){
                                break;
                           }
                           Tiger tiger = tigers.get(tigers.size() - 1);
                           tigers.remove(tigers.size()-1);
                           return tiger;

        }
        return null;
    }
}
