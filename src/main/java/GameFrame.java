import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


/**
 * Created by ale on 3/21/17.
 */
public class GameFrame extends JFrame implements ActionListener {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 900;

    private JButton okButton;
    private JTextField hexField, orientationField;

    private boolean isOdd = false;
    CoordinateSystem coor = new CoordinateSystem();
    JLabel view;
    BufferedImage image;

    Hexagon hex = new Hexagon();

    Game game;

    GameFrame(Game game) {
        this.game = game;
        runGUI();
    }

    private void runGUI() {
        new JFrame("Tiger Island");
        setSize(WIDTH, HEIGHT); // Setting up the pane
        createGUI();
        setVisible(true);
        setResizable(false);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        image = new BufferedImage(6000, 6000, BufferedImage.TYPE_INT_RGB);
        view = new JLabel(new ImageIcon(image));
        Graphics g = image.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, 6000, 6000);

        g = image.getGraphics();

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

                System.out.println(e.getPoint());
                addNewElement(e.getPoint().x, e.getPoint().y);

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
                    System.out.println("x value: " + hexField.getText());
                    System.out.println("y value: " + orientationField.getText());
                }

                String getHex = hexField.getText();
                String getOrientation = GameFrame.this.orientationField.getText();

                int hexID = Integer.parseInt(getHex);
                int orientation = Integer.parseInt(getOrientation);

                RotateTile tile = new RotateTile(hexID,orientation);

                int[] hexes = tile.checkPair();

                Hex hex1 = game.getIslandMap().getHexGrid().getHexValue(hexes[0]);
                Hex hex2 = game.getIslandMap().getHexGrid().getHexValue(hexes[1]);
                Hex hex3 = game.getIslandMap().getHexGrid().getHexValue(hexes[2]);

                paintHexOnGrid(hex1.getX(), hex1.getY());
                paintHexOnGrid(hex2.getX(), hex2.getY());
                paintHexOnGrid(hex3.getX(), hex3.getY());
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

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == okButton) {

            String getHex = hexField.getText();
            String getOrientation = orientationField.getText();

            int hexID = Integer.parseInt(getHex);
            int orientation = Integer.parseInt(getOrientation);

            RotateTile tile = new RotateTile(hexID,orientation);

            int[] hexes = tile.checkPair();

            Hex hex1 = game.getIslandMap().getHexGrid().getHexValue(hexes[0]);
            Hex hex2 = game.getIslandMap().getHexGrid().getHexValue(hexes[1]);
            Hex hex3 = game.getIslandMap().getHexGrid().getHexValue(hexes[2]);

            paintHexOnGrid(hex1.getX(), hex1.getY());
            paintHexOnGrid(hex2.getX(), hex2.getY());
            paintHexOnGrid(hex3.getX(), hex3.getY());
        }

        hexField.setText("");
        orientationField.setText("");

    }

    public void paintHexOnGrid(int x, int y) {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setStroke(new BasicStroke(3));
        g2.setPaint(Color.red);

//        if (y%2 == 0){
//
//            x = x * 30 + 30;
//            y = y * 25 + 25;
//
//        } else {
//            x = x * 30 + 30 + 15;
//            y = y * 25 + 25;
//        }

        g2.drawPolygon(hex.getHexagon(x, y));

        g2.dispose();
        view.repaint();
    }

    public void addNewElement(int x,int y) {
        Graphics g = image.getGraphics();
        paintHexOnGrid(x, y);
        drawNode(x,y,g);
        g.dispose();
        view.repaint();
    }

    public void drawNode(int x, int y, Graphics g)
    {
        g.setColor(Color.white);
        g.fillOval(x, y, 8, 8);
        g.drawOval(x, y, 8, 8);
    }
}
