import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by ale on 3/21/17.
 */
public class GameFrame {

    private JFrame frame;

    public static final int WIDTH = 850;
    public static final int HEIGHT = 860;

    GameFrame() {
        runGUI();
    }

    private void runGUI() {
        frame = new JFrame("Tiger Island");
        GameView view = new GameView();
        frame.getContentPane().add(view);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null); // Center
        frame.pack();
        frame.setVisible(true);

    }

}