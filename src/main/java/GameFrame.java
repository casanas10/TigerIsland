import javax.swing.*;

/**
 * Created by ale on 3/21/17.
 */
public class GameFrame {

    private JFrame frame;
    private GamePanel panel;

    public static final int WIDTH = 850;
    public static final int HEIGHT = 850;

    GameFrame() {
        frame = new JFrame("TigerIsland");
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new GamePanel();
        frame.add(panel);
    }
}
