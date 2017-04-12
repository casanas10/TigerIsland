import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by alecasanas on 3/14/17.
 */
public class Main {
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(new Runnable() {
        //    @Override
        //    public void run() {
                Game game = new Game();
                //new Frame(game);

                Scanner scan;
                scan = new Scanner(System.in);
                int i = 0;
                MoveData moveData = new MoveData();
                String[] terrains = {"Volcano", "Rocky", "Lake"};
                Boolean aiTurn = false;
                AI ai = new AI(game);
                CoordinateConverter coordinateConverter = new CoordinateConverter();
                RotationConverter rotationConverter = new RotationConverter();

                while(i < 24){

                    if (aiTurn){
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("AI TURN");

                        ai.makeMove(terrains);

                        moveData = ai.getMoveData();

                        System.out.println("Tile orientation: " + rotationConverter.serverToOurs(moveData.getOrientation()));
                        int serverTileX = moveData.getTilePlacementX();
                        int serverTileY = moveData.getTilePlacementY();
                        int serverTileZ = moveData.getTilePlacementZ();
                        int[] ourCoordinates = coordinateConverter.serverToOurs(serverTileX, serverTileY, serverTileZ);
                        System.out.println("Tile orientation x: " + ourCoordinates[0]);
                        System.out.println("Tile orientation y: " + ourCoordinates[1]);

                        int buildOption = moveData.getBuildOption();
                        System.out.println("Build option: " + buildOption);
                        int serverBuildX = moveData.getBuildOptionX();
                        int serverBuildY = moveData.getBuildOptionY();
                        int serverBuildZ = moveData.getBuildOptionZ();
                        int[] ourCoordinatesBuild = coordinateConverter.serverToOurs(serverBuildX, serverBuildY, serverBuildZ);
                        System.out.println("Build option x: " + ourCoordinatesBuild[0]);
                        System.out.println("Build option y: " + ourCoordinatesBuild[1]);

                        if(buildOption == 2){
                            System.out.println("Terrain to extend to: " + moveData.getExtendTerrain());
                        }
                        System.out.println("\nAI # of meeple remaining: " + game.getWhitePlayer().getRemainingMeeples());
                        System.out.println("AI # of Totoro remaining: " + game.getWhitePlayer().getRemainingTotoros());
                        System.out.println("AI # of Tigers remaining: " + game.getWhitePlayer().getRemainingTigers());
                        aiTurn = false;
                    }
                    else {
                        System.out.println("Terrains are: ");
                        for(int j = 0; j<3; j++){
                            System.out.print(terrains[j] + " ");
                        }

                        System.out.println();
                        System.out.println("SERVER TURN");
                        System.out.println("Enter tile orientation in degrees: ");
                        int degrees = scan.nextInt();
                        int rotationNumberServer = rotationConverter.oursToServer(degrees);
                        moveData.setOrientation(rotationNumberServer);

                        System.out.println("Enter tile x: ");
                        int ourTileX = scan.nextInt();

                        System.out.println("Enter tile y: ");
                        int ourTileY = scan.nextInt();

                        int[] serverTile = coordinateConverter.oursToServer(ourTileX,ourTileY);
                        moveData.setTilePlacementX(serverTile[0]);
                        moveData.setTilePlacementY(serverTile[1]);
                        moveData.setTilePlacementZ(serverTile[2]);

                        System.out.println("Enter build option: ");
                        int buildOption = scan.nextInt();
                        moveData.setBuildOption(buildOption);

                        System.out.println("Enter build x: ");
                        int  buildOptionX = (scan.nextInt());
                        System.out.println("Enter build y: ");
                        int  buildOptionY = (scan.nextInt());
                        int[] serverBuildOption = coordinateConverter.oursToServer(buildOptionX, buildOptionY);
                        moveData.setBuildOptionX(serverBuildOption[0]);
                        moveData.setBuildOptionY(serverBuildOption[1]);
                        moveData.setBuildOptionZ(serverBuildOption[2]);
                        moveData.setTerrainsArray(terrains);

                        if(buildOption == 2){
                            System.out.println("Enter terrain to extend to: ");
                            moveData.setExtendTerrain(scan.next());
                        }

                        ai.updateOpponentMove(moveData);
                        System.out.println("Our score: " + game.getBlackPlayer().getCurrentScore());
                        System.out.println("\nAI # of meeple remaining: " + game.getBlackPlayer().getRemainingMeeples());
                        System.out.println("AI # of Totoro remaining: " + game.getBlackPlayer().getRemainingTotoros());
                        System.out.println("AI # of Tigers remaining: " + game.getBlackPlayer().getRemainingTigers());
                        //server.playingAI();
                        aiTurn = true;
                    }

                    i++;
                }


          //  }
        //});



//        Game game = new Game();
//        game.gameRunning();
    }
}
