import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Val on 4/3/2017.
 */
public class AIPlayingTest {

    private Game game = new Game();
    private ALE_AI ai = new ALE_AI(game);

    private MoveInfo playerMove = new MoveInfo();

    @Test
    public void PlayGame() {


        //PLACE STARTING TILE
        CoordinateSystem coors = new CoordinateSystem();
        // First tile will actually be placed in the center, this is for testing purposes
        //tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
        int[] tileHexIDsArray = {coors.getHexID(14,15), coors.getHexID(14,14),coors.getHexID(15,14),
                coors.getHexID(14,16), coors.getHexID(15, 16)};
        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grassland"};
        game.getIslandMap().placeFirstTile(tileHexIDsArray, tileTerrainsArray);

        ArrayList<Integer> hexesArray = game.getIslandMap().getAllHexesOnMap();

        while(game.getWhitePlayer().getRemainingMeeples() != 0){

            ai.play(hexesArray);
            game.getIslandMap().printTilesOnMap();
            System.out.println("# of meeple left: " + game.getWhitePlayer().getRemainingMeeples());
            System.out.println("---------------------------------------------------------------------------------------");

            hexesArray = game.getIslandMap().getAllHexesOnMap();
        }

    }
}
