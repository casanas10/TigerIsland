import javax.swing.*;
import java.awt.*;
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
    private boolean aiTurn = false;
    CoordinateSystem coor = new CoordinateSystem();
    JLabel view;
    BufferedImage image;

    Hexagon hex = new Hexagon();

    //Game Logic
    private Player black = new Player("black", 0);
    private Player white = new Player("white", 0);
    private IslandMap islandMap = new IslandMap();
    Builder builder = new Builder();

    boolean tileSuccessfullyPlaced = false;

    public Frame (Game game){
        this.game = game;
        runGUI();
        playGame();
    }

    private void playGame() {

        Player ai = black;
        Player server = white;

        //PLACE STARTING TILE
        CoordinateSystem coors = new CoordinateSystem();
        // First tile will actually be placed in the center, this is for testing purposes
        //tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
        int[] tileHexIDsArray = {coors.getHexID(99,99), coors.getHexID(99,98),coors.getHexID(100,98),
                coors.getHexID(99,100), coors.getHexID(100, 100)};
        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grasslands"};
        islandMap.placeFirstTile(tileHexIDsArray, tileTerrainsArray);


        if (islandMap.containsHexKey(0)){

            int[] firstTileArr = {19899, 19699, 19700, 20099, 20100};

            for (int i = 0; i < firstTileArr.length; i++){

                Hex hex = game.getIslandMap().getHexGrid().getHexValue(firstTileArr[i]);
                paintHexOnGrid(hex.getX(), hex.getY(), islandMap.getHex(firstTileArr[i]).getTerrain());
            }
        }

        islandMap.printTilesOnMap();

        listenToClick();
    }

    public void runGUI() {
        new JFrame("Tiger Island");
        setSize(WIDTH, HEIGHT); // Setting up the pane
        createGUI();
        setVisible(true);
        setLocationRelativeTo(null); // Center
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        paintGrid();
        addScrollPanel(window);
    }

    private void listenToClick() {
        view.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                if (aiTurn){
                    System.out.println("AI TURN");
                } else {

                    int hexID = -1;
                    int orientation = -1;

                    System.out.println("SERVER TURN");

                    String[] newTile = islandMap.getNewTile();

                    String terrainsStr = "";
                    for (int i =0; i < newTile.length; i++){
                        terrainsStr += newTile[i] + " ";
                    }


                    JTextField hexField = new JTextField(5);
                    JTextField orientationField = new JTextField(5);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("Tile: " + terrainsStr));
                    myPanel.add(new JLabel("Hex ID:"));
                    myPanel.add(hexField);
                    myPanel.add(Box.createHorizontalStrut(15));
                    myPanel.add(new JLabel("Rotation:"));
                    myPanel.add(orientationField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter Hex and Rotation Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        hexID = Integer.parseInt(hexField.getText());
                        orientation = Integer.parseInt(orientationField.getText());

                        tileSuccessfullyPlaced = islandMap.addTileToMap(hexID, orientation, newTile);
                    }


                    if (tileSuccessfullyPlaced){

                        RotateTile tile = new RotateTile(hexID,orientation);

                        int[] hexes = tile.checkPair();

                        Hex hex1 = islandMap.getHexGrid().getHexValue(hexes[0]);
                        Hex hex2 = islandMap.getHexGrid().getHexValue(hexes[1]);
                        Hex hex3 = islandMap.getHexGrid().getHexValue(hexes[2]);

                        paintHexOnGrid(hex1.getX(), hex1.getY(), islandMap.getHexGrid().getHexValue(hexes[0]).getTerrain());
                        paintHexOnGrid(hex2.getX(), hex2.getY(), islandMap.getHexGrid().getHexValue(hexes[1]).getTerrain());
                        paintHexOnGrid(hex3.getX(), hex3.getY(), islandMap.getHexGrid().getHexValue(hexes[2]).getTerrain());

                        JTextField hexField2 = new JTextField(5);
                        JTextField buildOptionField = new JTextField(5);

                        JPanel buildPanel = new JPanel();
                        buildPanel.add(new JLabel("1,2,3,4"));
                        buildPanel.add(buildOptionField);

                        buildPanel.add(new JLabel("Hex ID:"));
                        buildPanel.add(hexField2);

                        int buildResult = JOptionPane.showConfirmDialog(null, buildPanel,
                                "Please Enter Build Option", JOptionPane.OK_CANCEL_OPTION);
                        if (buildResult == JOptionPane.OK_OPTION) {
                            hexID = Integer.parseInt(hexField2.getText());
                            int buildOption = Integer.parseInt(buildOptionField.getText());

                            if (builder.build(getActivePlayer(), islandMap, buildOption, hexID)){

                                addNewElement(islandMap.getHex(hexID).getX(),islandMap.getHex(hexID).getY());

                            }
                        }

                    } else {
                        System.out.println("False Placement");
                        aiTurnToPlay();
                    }
                }

                aiTurnToPlay();
            }


        });
    }

    public boolean aiTurnToPlay() {
        return aiTurn = !aiTurn;
    }

    public Player getActivePlayer () {

        if (aiTurn){
            return black;
        }

        return white;
    }

    private void addScrollPanel(Container window) {
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        JScrollPane jsp = new JScrollPane(view, v, h);
        jsp.setPreferredSize(new Dimension(800, 800));
        this.add(jsp);
        window.add(jsp);
    }

    private void paintGrid() {
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
            case "Grasslands":
                g2.setPaint(Color.green);
                break;
            case "Rocky":
                g2.setPaint(Color.white);
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


    public void addNewElement(int x,int y) {
        Graphics g = image.getGraphics();

        x = x*30 + 30 - 8;
        y = y*25 + 25 - 8;

        drawMeeple(x,y,g);
        g.dispose();
        view.repaint();
    }

    public void drawMeeple(int x, int y, Graphics g) {
        if (getActivePlayer() == black){
            g.setColor(Color.black);
        } else {
            g.setColor(Color.white);
        }
        g.fillOval(x, y, 4, 4);
        g.drawOval(x, y, 4, 4);
    }
}
