import cucumber.api.java.eo.Se;
import org.junit.Test;

/**
 * Created by Val on 4/3/2017.
 */
public class AIPlayingTest {
    private Game game = new Game();
    private AI ai = new AI();
    private Settlement settlement = game.getIslandMap().getSettlementObj();
//    private AI server = new AI(game);

    private boolean aiTurn = false;

    @Test
    public void placeFirstTileTest(){
        //game.gameRunning();
        System.out.println(1);
        int[] toServer = ai.makeFirstMove(game.getIslandMap());


        for(int value : toServer)
            System.out.print(value + " ");

    }

    @Test
    public void testGamePlaying(){
        MoveData moveData;

        for(int i = 0; i < 48; i++){
            String[] terrains = {"Volcano", "Rocky", "Lake"};
            ai.makeMove(terrains);
            System.out.println("# of meeple left: " + game.getWhitePlayer().getPieces().getNumberOfMeeples());
            System.out.println("\nSettlements:");
            settlement.printAllSettlements(game.getWhitePlayer());
            System.out.println("*************************************************");
            moveData = ai.getMoveData();
            System.out.println("Tile Placement: " + moveData.getTilePlacementX() + " " + moveData.getTilePlacementY() + " " + moveData.getTilePlacementZ());
            System.out.println("Tile Orientation: " + moveData.getOrientation());
            System.out.println("Build option: " + moveData.getBuildOption());
            System.out.println("Extend option: " + moveData.getExtendTerrain() + " " + moveData.getBuildOptionX() + " " + moveData.getBuildOptionY() + " " + moveData.getBuildOptionZ());
            System.out.println("---------------------------------------------------------------------------------------");
        }

    }

    @Test
    public void whenTwoPlayersPlayGame(){

        int i = 0;

        while(i < 48){

            if (aiTurn){

                System.out.println("AI TURN");
                ai.playingAI();

            } else {

                System.out.println("SERVER TURN");
                //server.playingAI();
            }

            i++;
        }

    }

    public boolean aiTurnToPlay() {
        return aiTurn = !aiTurn;
    }
}