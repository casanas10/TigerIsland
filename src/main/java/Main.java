import javax.swing.*;
import java.awt.*;

/**
 * Created by alecasanas on 3/14/17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game game = new Game();
                new Frame(game);
            }
        });

        Client client = new Client();
        client.OpenClient();
    }
}
