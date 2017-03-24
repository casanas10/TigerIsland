/**
 * Created by Eric on 3/14/2017.
 */
public class Player {
    private String playerColor;
    private int currentScore;
    private PlayerPieceContainer playerPieceContainer;

    public static int numberOfPlayers = 0;

    public Player(String playerColor, int currentScore){

        numberOfPlayers++;
        this.playerColor = playerColor;
        this.currentScore = currentScore;
        playerPieceContainer = new PlayerPieceContainer(playerColor);
        playerPieceContainer.create20Meeples();
        playerPieceContainer.create3Totoros();
        playerPieceContainer.create2Tigers();
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
        return playerPieceContainer;
    }

    public int getRemainingMeeples(){
        return playerPieceContainer.getNumberOfMeeples();
    }

    public int getRemainingTotoros(){
        return playerPieceContainer.getNumberOfTotoros();
    }

    public int getRemainingTigers(){ return playerPieceContainer.getNumberOfTigers();}

    public void updateScore(int value){
        currentScore += value;
    }

    public GamePiece placeGamePiece(String pieceName){
        return playerPieceContainer.placeGamePiece(pieceName);
    }
}
