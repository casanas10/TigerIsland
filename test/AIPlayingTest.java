import cucumber.api.java.eo.Se;
import org.junit.Test;

import java.util.*;

/**
 * Created by Val on 4/3/2017.
 */
public class AIPlayingTest {
    private Game game = new Game();
    private AI ai = new AI();
    private Settlement settlement = game.getIslandMap().getSettlementObj();
//    private AI server = new AI(game);


    @Test
    public void placeFirstTileTest(){
        //game.gameRunning();
        System.out.println(1);
        int[] toServer = ai.makeFirstMove(game.getIslandMap());


        //for(int value : toServer)
        //    System.out.print(value + " ");

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

            if(moveData.getBuildOption() == 5){
                System.out.println("GAME OVER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Final Score: " + game.getWhitePlayer().getCurrentScore());
                System.out.println("Number of Meeple placed: " + (20-game.getWhitePlayer().getRemainingMeeples()));
                System.out.println("Number of Totoros placed: " + (3-game.getWhitePlayer().getRemainingTotoros()));
                System.out.println("Number of Tigers placed: " + (2-game.getWhitePlayer().getRemainingTigers()));
                break;
            }
        }

    }

    @Test
    public void expandingTest(){
        IslandMap islandMap = new IslandMap();
        Player whitePlayer = new Player("White", 0);
        MoveData moveData = new MoveData();
        String[] terrains = {"Volcano", "Lake", "Rocky"};

        ai.makeMove(terrains);
        ai.makeMove(terrains);

        moveData = ai.getMoveData();
        System.out.println("Extend settlement is: " + moveData.getExtendTerrain());
    }

    @Test
    public void whenTwoPlayersPlayGame(){

    }

}