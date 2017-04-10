/**
 * Created by alecasanas on 4/7/17.
 */
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Val on 4/3/2017.
 */
public class AITest {

    private Game game = new Game();
    //private ALE_AI ai = new ALE_AI(game);


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


        int i = 0;

        while(i < 48){

            ArrayList<Integer> tileArr = new ArrayList<Integer>() {{
                add(3014);
                add(2814);
                add(2815);
                add(3214);
                add(3215);
            }};

            //ai.getAllPossibleTilePlacementPosition(tileArr);

            //ai.play();
            System.out.println("# of meeple left: " + game.getWhitePlayer().getRemainingMeeples());
            System.out.println("---------------------------------------------------------------------------------------");


            i++;
        }

    }
}

