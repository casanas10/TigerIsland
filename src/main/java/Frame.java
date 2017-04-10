//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
//
///**
// * Created by alecasanas on 4/3/17.
// */
//public class Frame extends JFrame {
//
//    public static final int WIDTH = 1000;
//    public static final int HEIGHT = 900;
//
//    private Game game = new Game();
//
//    private boolean isOdd = false;
//    private boolean aiTurn = false;
//    CoordinateSystem coor = new CoordinateSystem();
//    JLabel view;
//    BufferedImage image;
//
//    Hexagon hex = new Hexagon();
//
//    //Game Logic
//    private Player aiPlayer = game.getWhitePlayer();
//    private Player serverPlayer = game.getBlackPlayer();
//    private IslandMap islandMap = game.getIslandMap();
//    Builder builder = new Builder();
//
//    private ALE_AI ai = new ALE_AI(game);
//
//    boolean tileSuccessfullyPlaced = false;
//
//    MoveInfo playerMove = new MoveInfo();
//
//    ArrayList<Integer> activeHexes = new ArrayList<Integer>() {{
//        add(3014);
//        add(2814);
//        add(2815);
//        add(3214);
//        add(3215);
//    }};
//
//    public Frame (){
//        runGUI();
//        playGame();
//    }
//
//    private void playGame() {
//
//        //PLACE STARTING TILE
//        CoordinateSystem coors = new CoordinateSystem();
//        // First tile will actually be placed in the center, this is for testing purposes
//        //tileSuccessfullyPlaced = islandMap.addTileToMap(606, 0);
//        int[] tileHexIDsArray = {coors.getHexID(14,15), coors.getHexID(14,14),coors.getHexID(15,14),
//                coors.getHexID(14,16), coors.getHexID(15, 16)};
//        String[] tileTerrainsArray = {"Volcano", "Jungle", "Lake", "Rocky", "Grassland"};
//        islandMap.placeFirstTile(tileHexIDsArray, tileTerrainsArray);
//
//
//        if (islandMap.containsHexKey(0)){
//
//            int[] firstTileArr = {3014, 2814, 2815, 3214, 3215};
//
//            for (int i = 0; i < firstTileArr.length; i++){
//
//                Hex hex = game.getIslandMap().getHexGrid().getHexValue(firstTileArr[i]);
//                paintHexOnGrid(hex.getX(), hex.getY(), islandMap.getHex(firstTileArr[i]).getTerrain(), islandMap.getHex(firstTileArr[i]).getLevel());
//            }
//        }
//
//        listenToClick();
//    }
//
//    public void runGUI() {
//        new JFrame("Tiger Island");
//        setSize(WIDTH, HEIGHT); // Setting up the pane
//        createGUI();
//        setVisible(true);
//        setLocationRelativeTo(null); // Center
//    }
//
//    private void createGUI() {
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        Container window = getContentPane();
//        paintGrid();
//        addScrollPanel(window);
//    }
//
//    private void listenToClick() {
//        view.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//
//                if (aiTurn){
//
//                    System.out.println("AI TURN");
//                    playerMove = ai.play(activeHexes);
//
//                    RotateTile tile = new RotateTile(playerMove.getHexID(),playerMove.getOrientation());
//
//                    drawTile(tile);
//
//                    // CHECK FOR NUKE
//                    int tileHexIDsArray[] = new int[3];
//                    RotateTile rotateTile = new RotateTile(playerMove.getHexID(), playerMove.getOrientation());
//                    tileHexIDsArray = rotateTile.checkPair();
//
//                    ArrayList<Integer> hexesList = new ArrayList<Integer>();
//                    for (int i = 0; i < tileHexIDsArray.length; i++) {
//                        hexesList.add(tileHexIDsArray[i]);
//                    }
//
//                    if (islandMap.getHasNuked()){
//
//                        for (int i = 0; i < tileHexIDsArray.length; i++){
//                            addNewElement(islandMap.getHex(tileHexIDsArray[i]).getX(),islandMap.getHex(tileHexIDsArray[i]).getY(), 5);
//                        }
//                    }
//
//                    addNewElement(islandMap.getHex(playerMove.getHexSettled()).getX(),islandMap.getHex(playerMove.getHexSettled()).getY(), playerMove.getBuildOption());
//
//                } else {
//
//                    String[] newTile = islandMap.getNewTile();
//
//                    String terrainsStr = "";
//                    for (int i =0; i < newTile.length; i++){
//                        terrainsStr += newTile[i] + " ";
//                    }
//
//                    int hexID = -1;
//                    int orientation = -1;
//
//                    System.out.println("SERVER TURN");
//
//                    JTextField hexField = new JTextField(5);
//                    JTextField orientationField = new JTextField(5);
//
//                    JPanel myPanel = new JPanel();
//                    myPanel.add(new JLabel("Tile: " + terrainsStr));
//                    myPanel.add(new JLabel("Hex ID:"));
//                    myPanel.add(hexField);
//                    myPanel.add(Box.createHorizontalStrut(15));
//                    myPanel.add(new JLabel("Rotation:"));
//                    myPanel.add(orientationField);
//
//                    int result = JOptionPane.showConfirmDialog(null, myPanel,
//                            "Please Enter Hex and Rotation Values", JOptionPane.OK_CANCEL_OPTION);
//                    if (result == JOptionPane.OK_OPTION) {
//                        hexID = Integer.parseInt(hexField.getText());
//                        orientation = Integer.parseInt(orientationField.getText());
//
//                        tileSuccessfullyPlaced = islandMap.addTileToMap(hexID, orientation, newTile, getActivePlayer());
//
//                        // CHECK FOR NUKE
//                        int tileHexIDsArray[] = new int[3];
//                        RotateTile rotateTile = new RotateTile(hexID, orientation);
//                        tileHexIDsArray = rotateTile.checkPair();
//
//                        ArrayList<Integer> hexesList = new ArrayList<Integer>();
//                        for (int i = 0; i < tileHexIDsArray.length; i++) {
//                            hexesList.add(tileHexIDsArray[i]);
//                        }
//
//                        if (islandMap.getHasNuked()){
//
//                            for (int i = 0; i < tileHexIDsArray.length; i++){
//                                addNewElement(islandMap.getHex(tileHexIDsArray[i]).getX(),islandMap.getHex(tileHexIDsArray[i]).getY(), 5);
//                            }
//                        }
//
//                    }
//
//                    if (tileSuccessfullyPlaced){
//
//                        int buildOption = -1;
//
//                        RotateTile tile = new RotateTile(hexID,orientation);
//
//                        drawTile(tile);
//
//                        JTextField hexField2 = new JTextField(5);
//                        JTextField buildOptionField = new JTextField(5);
//
//                        JPanel buildPanel = new JPanel();
//                        buildPanel.add(new JLabel("1,2,3,4"));
//                        buildPanel.add(buildOptionField);
//
//                        buildPanel.add(new JLabel("Hex ID:"));
//                        buildPanel.add(hexField2);
//
//                        int buildResult = JOptionPane.showConfirmDialog(null, buildPanel,
//                                "Please Enter Build Option", JOptionPane.OK_CANCEL_OPTION);
//                        if (buildResult == JOptionPane.OK_OPTION) {
//                            hexID = Integer.parseInt(hexField2.getText());
//                            buildOption = Integer.parseInt(buildOptionField.getText());
//                        }
//
//                        if (buildOption == 2){
//
//                            ExtendSettlement extend = new ExtendSettlement(hexID, islandMap, getActivePlayer());
//
//                            JTextField extendField = new JTextField(5);
//
//                            JPanel extendPanel = new JPanel();
//                            extendPanel.add(new JLabel("Which Terrain will you like to extend:"));
//                            extendPanel.add(extendField);
//
//                            int extendResult = JOptionPane.showConfirmDialog(null, extendPanel,
//                                    "Please Enter Build Option", JOptionPane.OK_CANCEL_OPTION);
//                            if (extendResult == JOptionPane.OK_OPTION) {
//
//                                int terrainNum = Integer.parseInt(extendField.getText());
//
//                                String terrain = "";
//                                switch (terrainNum){
//                                    case 1 : terrain = "Jungle"; break;
//                                    case 2 : terrain = "Lake"; break;
//                                    case 3 : terrain = "Rocky"; break;
//                                    case 4 : terrain = "Grassland"; break;
//
//                                }
//
//                                builder.extend(hexID, islandMap, getActivePlayer(), terrain);
//                                ArrayList<Integer> hexList = extend.getTerrainList(terrain);
//
//                                for (int i = 0; i < hexList.size(); i++){
//                                    addNewElement(islandMap.getHex(hexList.get(i)).getX(),islandMap.getHex(hexList.get(i)).getY(), buildOption);
//                                }
//                            }
//
//                        } else if (builder.build(getActivePlayer(), islandMap, buildOption, hexID)){
//
//                            addNewElement(islandMap.getHex(hexID).getX(),islandMap.getHex(hexID).getY(), buildOption);
//
//                        }
//
//                    } else {
//                        System.out.println("False Placement");
//                        aiTurnToPlay();
//                    }
//                }
//
//                System.out.println("----------------------------------------");
//
//                aiTurnToPlay();
//
//            }
//
//
//        });
//    }
//
//    private void drawTile(RotateTile tile) {
//        int[] hexes = tile.checkPair();
//
//        Hex hex1 = islandMap.getHexGrid().getHexValue(hexes[0]);
//        Hex hex2 = islandMap.getHexGrid().getHexValue(hexes[1]);
//        Hex hex3 = islandMap.getHexGrid().getHexValue(hexes[2]);
//
//        paintHexOnGrid(hex1.getX(), hex1.getY(), islandMap.getHexGrid().getHexValue(hexes[0]).getTerrain(), islandMap.getHexGrid().getHexValue(hexes[0]).getLevel());
//        paintHexOnGrid(hex2.getX(), hex2.getY(), islandMap.getHexGrid().getHexValue(hexes[1]).getTerrain(), islandMap.getHexGrid().getHexValue(hexes[0]).getLevel());
//        paintHexOnGrid(hex3.getX(), hex3.getY(), islandMap.getHexGrid().getHexValue(hexes[2]).getTerrain(), islandMap.getHexGrid().getHexValue(hexes[0]).getLevel());
//    }
//
//    public boolean aiTurnToPlay() {
//        return aiTurn = !aiTurn;
//    }
//
//    public Player getActivePlayer () {
//
//        if (aiTurn){
//            return aiPlayer;
//        }
//
//        return serverPlayer;
//    }
//
//    private void addScrollPanel(Container window) {
//        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
//        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
//        JScrollPane jsp = new JScrollPane(view, v, h);
//        jsp.setPreferredSize(new Dimension(800, 800));
//        this.add(jsp);
//        window.add(jsp);
//    }
//
//    private void paintGrid() {
//        image = new BufferedImage(6000, 6000, BufferedImage.TYPE_INT_RGB);
//        view = new JLabel(new ImageIcon(image));
//        Graphics g = image.getGraphics();
//        g.setColor(Color.ORANGE);
//        g.fillRect(0, 0, 6000, 6000);
//
//        g = image.getGraphics();
//        g.setColor(Color.black);
//
//        Font currentFont = g.getFont();
//        Font newFont = currentFont.deriveFont(currentFont.getSize() / 1.4F);
//        g.setFont(newFont);
//
//        for (int i = 30; i < 6000; i++) {
//            for (int j = 25; j < 6000; j++) {
//                if (i % 30 == 0 && j % 25 == 0) {
//                    if (isOdd) {
//
//                        g.drawPolygon(hex.getHexagon(i + 15, j));
//                        g.drawString(String.valueOf(hexGridToPixelConversion(i, j)), i + 15 - 12, j + 5);
//
//                    } else {
//                        g.drawPolygon(hex.getHexagon(i, j));
//                        g.drawString(String.valueOf(hexGridToPixelConversion(i, j)), i - 12, j + 5);
//                    }
//                }
//                isOdd();
//            }
//        }
//    }
//
//    public boolean isOdd() {
//        return isOdd = !isOdd;
//    }
//
//    public String hexGridToPixelConversion(int x, int y){
//
//        int i = x/30 - 1;
//        int j = y/25 - 1;
//
//        int id = coor.getHexID(i, j);
//
//        return String.valueOf(id);
//    }
//
//    public void paintHexOnGrid(int x, int y, String terrain, int level) {
//        Graphics2D g2 = (Graphics2D) image.getGraphics();
//
//
//        if (level == 1) {
//            g2.setStroke(new BasicStroke(2));
//        } else if (level == 2){
//            g2.setStroke(new BasicStroke(4));
//        } else if (level == 3){
//            g2.setStroke(new BasicStroke(6));
//        } else {
//            g2.setStroke(new BasicStroke(2));
//        }
//
//
//        switch (terrain) {
//            case "Volcano":
//                g2.setPaint(Color.red);
//                break;
//            case "Grassland":
//                g2.setPaint(Color.green);
//                break;
//            case "Rocky":
//                g2.setPaint(Color.cyan);
//                break;
//            case "Lake":
//                g2.setPaint(Color.blue);
//                break;
//            case "Jungle":
//                g2.setPaint(Color.black);
//                break;
//            default:
//                break;
//        }
//
//        if (y%2 == 0){
//
//            x = x * 30 + 30;
//            y = y * 25 + 25;
//
//        } else {
//            x = x * 30 + 30 + 15;
//            y = y * 25 + 25;
//        }
//
//        g2.drawPolygon(hex.getHexagon(x, y));
//
//        g2.dispose();
//        view.repaint();
//    }
//
//    public void removePieceFromHex(int x, int y){
//        Graphics g = image.getGraphics();
//
//        if (y%2 == 0){
//
//            x = x * 30 + 30 - 8;
//            y = y * 25 + 25 - 8;
//
//        } else {
//            x = x * 30 + 30 + 15 - 8;
//            y = y * 25 + 25 - 8;
//        }
//
//        g.setColor(Color.orange);
//
//
//        g.fillOval(x, y, 4, 4);
//        g.drawOval(x, y, 4, 4);
//
//        g.dispose();
//        view.repaint();
//    }
//
//    public void addNewElement(int x,int y, int buildOption) {
//        Graphics g = image.getGraphics();
//
//        if (y%2 == 0){
//
//            x = x * 30 + 30 - 8;
//            y = y * 25 + 25 - 8;
//
//        } else {
//            x = x * 30 + 30 + 15 - 8;
//            y = y * 25 + 25 - 8;
//        }
//
//        if (buildOption == 1 || buildOption == 2){
//            drawMeeple(x,y,g);
//        } else if (buildOption == 3){
//            drawTotoro(x,y,g);
//        } else if (buildOption == 4){
//            drawTiger(x,y,g);
//        } else if (buildOption == 5){
//            removeMeeple(x,y,g);
//        }
//
//        g.dispose();
//        view.repaint();
//    }
//
//    private void drawTiger(int x, int y, Graphics g) {
//        if (getActivePlayer() == serverPlayer){
//            g.setColor(Color.black);
//        } else {
//            g.setColor(Color.white);
//        }
//        g.setFont(new Font("serif", Font.BOLD, 15));
//        g.drawString("Ti", x, y + 8);
//
//    }
//
//    private void drawTotoro(int x, int y, Graphics g) {
//
//        if (getActivePlayer() == serverPlayer){
//            g.setColor(Color.black);
//        } else {
//            g.setColor(Color.white);
//        }
//
//        g.setFont(new Font("serif", Font.BOLD, 15));
//        g.drawString("To", x, y + 8);
//    }
//
//    public void drawMeeple(int x, int y, Graphics g) {
//        if (getActivePlayer() == serverPlayer){
//            g.setColor(Color.black);
//        } else {
//            g.setColor(Color.white);
//        }
//        g.fillOval(x, y, 4, 4);
//        g.drawOval(x, y, 4, 4);
//    }
//
//    public void removeMeeple(int x, int y, Graphics g) {
//
//        g.setColor(Color.orange);
//
//        g.fillOval(x, y, 4, 4);
//        g.drawOval(x, y, 4, 4);
//    }
//}
