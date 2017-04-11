import java.util.ArrayList;

/**
 * Created by ale on 4/11/17.
 */
public class PlayGame {

    private Game game = new Game();

    private ALE_AI ai = new ALE_AI();

    private boolean isOdd = false;
    private boolean aiTurn = false;

    MoveData playerMove = new MoveData();


    public PlayGame(){

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

            ai.play();

            i++;
        }


    }

    public boolean aiTurnToPlay() {
        return aiTurn = !aiTurn;
    }
}
