import java.util.*;

/**
 * Created by alecasanas on 3/14/17.
 */
public class Game {

    private Player black;
    private Player white;
    private IslandMap islandMap;
    private boolean gameOver;
    private boolean activePlayerBlack;
    private boolean activePlayerWhite;
    private int numberOfTurns;
    Scanner input = new Scanner(System.in);

    public Game() {
        this.black = new Player("black", 0);
        this.white = new Player("white", 0);
        this.islandMap = new IslandMap();
        gameOver = false;
        numberOfTurns = 0;
    }

    public Player getBlackPlayer() {
        return black;
    }

    public Player getWhitePlayer() {
        return white;
    }

    public int getRemainingMeeples(){
        return (black.getRemainingMeeples() + white.getRemainingMeeples());
    }

    public int getRemainingTotoros(){
        return (black.getRemainingTotoros() + white.getRemainingTotoros());
    }

    public void setActivePlayerBlack(boolean status){
        activePlayerBlack = status;
    }

    public boolean getActivePlayerBlack(){
        return activePlayerBlack;
    }

    public void setActivePlayerWhite(boolean status){
        activePlayerWhite = status;
    }

    public boolean getActivePlayerWhite(){
        return activePlayerWhite;
    }

    public String getRandomStartingPlayer(){
        ArrayList<String> playerList = new ArrayList<String>();
        playerList.add("black");
        playerList.add("white");

        Collections.shuffle(playerList);

        System.out.println(playerList.get(0));

        return playerList.get(0);
    }

    public void setActiveStartingPlayer(){
        switch(getRandomStartingPlayer()){
            case "black":   setActivePlayerBlack(true);
                            setActivePlayerWhite(false);
                            break;
            case "white":   setActivePlayerBlack(false);
                            setActivePlayerWhite(true);
                            break;
        }
    }

    public void gameRunning(){
        setActiveStartingPlayer();
        int hexID = -1;
        int tileOrientation = -1;
        boolean tileSuccessfullyPlaced = false;
        int quit;

        while(!gameOver){
            tileSuccessfullyPlaced = false;
            while(!tileSuccessfullyPlaced) {

                if(numberOfTurns == 0){
                    // First tile will actually be placed in the center, this is for testing purposes
                    tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
                    break;
                }

                System.out.print("Enter a hex ID for your volcano to be placed: ");
                hexID = input.nextInt();


                System.out.print("\nEnter an orientation for your tile: ");
                tileOrientation = input.nextInt();

                tileSuccessfullyPlaced = islandMap.addTileToMap(hexID, tileOrientation);

                islandMap.printTilesOnMap();
            }

            numberOfTurns++;

            System.out.print("Would you like to quit(1 or 0)? ");
            quit = input.nextInt();

            if(quit == 1){
                gameOver = true;
            }

        }
    }


}
