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
////                new Frame();
////                new AutoFramePlayer();
//                new PlayGame();
//            }
//        });
//        Game game = new Game();
//        game.gameRunning();
        Scanner s = new Scanner(System.in);
        String tournamentPW = null;
        String username = null;
        String password = null;

        Client client = new Client();

        System.out.println("Enter Tournament Password: ");
        tournamentPW = s.next();
        System.out.println("Enter username: ");
        username = s.next();
        System.out.println("Enter password: ");
        password = s.next();

        client.setTournamentPassword(tournamentPW);
        client.setUsername(username);
        client.setPassword(password);
        client.OpenClient();
    }
}
