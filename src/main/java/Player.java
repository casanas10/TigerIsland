/**
 * Created by Eric on 3/14/2017.
 */
public class Player {
    private String playerColor;
    private int currentScore;
    private PlayerPieceContainer playerPlayerPieceContainer;

    public static int numberOfPlayers = 0;

    public Player(String playerColor, int currentScore){

        numberOfPlayers++;
        this.playerColor = playerColor;
        this.currentScore = currentScore;
        playerPlayerPieceContainer = new PlayerPieceContainer(playerColor);
        playerPlayerPieceContainer.create20Meeples();
        playerPlayerPieceContainer.create3Totoros();
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

    public PlayerPieceContainer getPieces() {
        return playerPlayerPieceContainer;
    }

    public int getRemainingMeeples(){
        return playerPlayerPieceContainer.getNumberOfMeeple();
    }

    public int getRemainingTotoros(){
        return playerPlayerPieceContainer.getNumberOfTotoros();
    }
}
