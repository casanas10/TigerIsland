/**
 * Created by alecasanas on 3/21/17.
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;

public class Test extends JPanel {
    private static final int PREF_W = 500;
    private static final int PREF_H = PREF_W;
    private Map<Point, String> pointTextMap = new LinkedHashMap<>();

    public Test() {
        addMouseListener(new MyMouse());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(getFont().deriveFont(Font.BOLD));
        for (Point p : pointTextMap.keySet()) {
            String text = pointTextMap.get(p);
            g.drawString(text, p.x, p.y);
        }
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            String prompt = "Please add text to display";
            String input = JOptionPane.showInputDialog(Test.this, prompt);
            pointTextMap.put(e.getPoint(), input);
            repaint();
        }
    }

    private static void createAndShowGui() {
        Test mainPanel = new Test();

        JFrame frame = new JFrame("AddingText2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}