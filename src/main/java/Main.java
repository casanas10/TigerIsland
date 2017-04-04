import javax.swing.*;
import java.awt.*;

/**
 * Created by alecasanas on 3/14/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameFrame();
            }
        });

        Client client = new Client();
        client.OpenClient();

//        MyRunnable R1 = new MyRunnable("Thread for Game 1");
//        R1.start();
//
//        MyRunnable R2 = new MyRunnable("Thread for Game 2");
//        R2.start();

//    Game game = new Game();
//        game.gameRunning();
//    }
    }
}
