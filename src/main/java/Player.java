/**
 * Created by Eric on 3/14/2017.
 */
public class Player {
    private String playerColor;
    private int currentScore;
    private Pieces playerPieces;

    public Player(String playerColor, int currentScore){
        this.playerColor = playerColor;
        this.currentScore = currentScore;
        playerPieces = new Pieces(playerColor);
        playerPieces.create20Meeples();
        playerPieces.create3Totoros();
    }

    public String getPlayerColor(){
        return this.playerColor;
    }

    public void setPlayerColor(String playerColor){
        this.playerColor = playerColor;
    }

    public int getCurrentScore(){
        return this.currentScore;
    }

    public void setPlayerScore(int score){
        this.currentScore = score;
    }

    public int getRemainingMeeples(){
        return playerPieces.getNumberOfMeeple();
    }

    public int getRemainingTotoros(){
        return playerPieces.getNumberOfTotoros();
    }
}
