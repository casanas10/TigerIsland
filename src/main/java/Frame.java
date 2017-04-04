import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by alecasanas on 4/3/17.
 */
public class Frame extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 900;

    private Game game;

    private boolean isOdd = false;
    CoordinateSystem coor = new CoordinateSystem();
    JLabel view;
    BufferedImage image;

    Hexagon hex = new Hexagon();

    public Frame (Game game){
        this.game = game;
        runGUI();
    }

    public void runGUI() {
        new JFrame("Tiger Island");
        setSize(WIDTH, HEIGHT); // Setting up the pane
        createGUI();
        setVisible(true);
        setLocationRelativeTo(null); // Center
        //setResizable(false);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        image = new BufferedImage(6000, 6000, BufferedImage.TYPE_INT_RGB);
        view = new JLabel(new ImageIcon(image));
        Graphics g = image.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, 6000, 6000);

        g = image.getGraphics();
        g.setColor(Color.black);

        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() / 1.4F);
        g.setFont(newFont);

        for (int i = 30; i < 6000; i++) {
            for (int j = 25; j < 6000; j++) {
                if (i % 30 == 0 && j % 25 == 0) {
                    if (isOdd) {

                        g.drawPolygon(hex.getHexagon(i + 15, j));
                        g.drawString(String.valueOf(hexGridToPixelConversion(i, j)), i + 15 - 10, j + 5);

                    } else {
                        g.drawPolygon(hex.getHexagon(i, j));
                        g.drawString(String.valueOf(hexGridToPixelConversion(i, j)), i - 10, j + 5);
                    }
                }
                isOdd();
            }
        }

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        JScrollPane jsp = new JScrollPane(view, v, h);
        jsp.setPreferredSize(new Dimension(800, 800));
        this.add(jsp);

        view.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                JTextField hexField = new JTextField(5);
                JTextField orientationField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("hex:"));
                myPanel.add(hexField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("rotation:"));
                myPanel.add(orientationField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "Please Enter Hex and Rotation Values", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    int hexID = Integer.parseInt(hexField.getText());
                    int orientation = Integer.parseInt(orientationField.getText());

                    RotateTile tile = new RotateTile(hexID,orientation);

                    int[] hexes = tile.checkPair();

                    Hex hex1 = game.getIslandMap().getHexGrid().getHexValue(hexes[0]);
                    Hex hex2 = game.getIslandMap().getHexGrid().getHexValue(hexes[1]);
                    Hex hex3 = game.getIslandMap().getHexGrid().getHexValue(hexes[2]);

                    paintHexOnGrid(hex1.getX(), hex1.getY(), game.getIslandMap().getHexGrid().getHexValue(hexes[0]).getTerrain());
                    paintHexOnGrid(hex2.getX(), hex2.getY(), game.getIslandMap().getHexGrid().getHexValue(hexes[1]).getTerrain());
                    paintHexOnGrid(hex3.getX(), hex3.getY(), game.getIslandMap().getHexGrid().getHexValue(hexes[2]).getTerrain());
                }
            }
        });

        window.add(jsp);
    }

    public boolean isOdd() {
        return isOdd = !isOdd;
    }

    public String hexGridToPixelConversion(int x, int y){

        int i = x/30 - 1;
        int j = y/25 - 1;

        int id = coor.getHexID(i, j);

        return String.valueOf(id);
    }

    public void paintHexOnGrid(int x, int y, String terrain) {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setStroke(new BasicStroke(3));

        switch (terrain) {
            case "Volcano":
                g2.setPaint(Color.red);
                break;
            case "Grassland":
                g2.setPaint(Color.green);
                break;
            case "Rocky":
                g2.setPaint(Color.darkGray);
                break;
            case "Lake":
                g2.setPaint(Color.blue);
                break;
            case "Jungle":
                g2.setPaint(Color.black);
                break;
            default:
                break;
        }

        if (y%2 == 0){

            x = x * 30 + 30;
            y = y * 25 + 25;

        } else {
            x = x * 30 + 30 + 15;
            y = y * 25 + 25;
        }

        g2.drawPolygon(hex.getHexagon(x, y));

        g2.dispose();
        view.repaint();
    }

}
