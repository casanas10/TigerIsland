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
                new Frame();
               // new AutoFramePlayer();
            }
        });

//        Client client = new Client();
//        client.OpenClient();
    }
}
