import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by ale on 3/21/17.
 */
public class GameFrame {

    private JFrame frame;
    private GridPanel panel;

    public static final int WIDTH = 850;
    public static final int HEIGHT = 850;

    GameFrame() {
        runGUI();
    }

    private void runGUI() {
        JFrame frame = new JFrame("Splashing");
        GameView view = new GameView();
        frame.getContentPane().add(view);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(850, 860));
        frame.setLocationRelativeTo(null); // Center
        frame.pack();
        frame.setVisible(true);

    }

    static class GameView extends JPanel {
        JPanel southPanel = new JPanel();
        JTextField textField;
        JButton okButton = new JButton("Ok");

        GridPanel gridPanel = new GridPanel();

        GameView() {

            textField = new JTextField(3);
            textField.setFont(textField.getFont().deriveFont(25f));
            southPanel.add(textField);

            textField = new JTextField(3);
            textField.setFont(textField.getFont().deriveFont(25f));
            southPanel.add(textField);


            this.setLayout(new BorderLayout(5, 10));

            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            gridPanel.setBackground(Color.CYAN);
                        }
                    });
                }
            });

            southPanel.add(okButton);
            add(southPanel, BorderLayout.SOUTH);
            add(gridPanel, BorderLayout.CENTER);
        }

    }

}