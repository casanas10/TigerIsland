import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by alecasanas on 3/14/17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Frame();
//                new AutoFramePlayer();
//                new PlayGame();
//            }
//        });
//        Game game = new Game();
//        game.gameRunning();

        if (args.length != 3){

            System.out.println("Invalid args");
            return;
        }

        Client client = new Client();

        client.setTournamentPassword(args[0]);
        client.setUsername(args[1]);
        client.setPassword(args[2]);
        client.OpenClient();
    }
}
