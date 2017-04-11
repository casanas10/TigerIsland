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
//public class AutoFramePlayer extends JFrame {
//
//    public static final int WIDTH = 1000;
//    public static final int HEIGHT = 900;
//
//    private Game game = new Game();
//    private ALE_AI ai = new ALE_AI(game);
//    private ALE_AI serverAI = new ALE_AI(game);
//
//    private boolean isOdd = false;
//    private boolean aiTurn = false;
//    CoordinateSystem coor = new CoordinateSystem();
//    JLabel view;
//    BufferedImage image;
//
//    Hexagon hex = new Hexagon();
//
//    ArrayList<Integer> activeHexes = new ArrayList<Integer>() {{
//        add(3014);
//        add(2814);
//        add(2815);
//        add(3214);
//        add(3215);
//    }};
//
//    MoveInfo playerMove = new MoveInfo();
//
//    public AutoFramePlayer (){
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
//        game.getIslandMap().placeFirstTile(tileHexIDsArray, tileTerrainsArray);
//
//
//        if (game.getIslandMap().containsHexKey(0)){
//
//            int[] firstTileArr = {3014, 2814, 2815, 3214, 3215};
//
//            for (int i = 0; i < firstTileArr.length; i++){
//
//                Hex hex = game.getIslandMap().getHexGrid().getHexValue(firstTileArr[i]);
//                paintHexOnGrid(hex.getX(), hex.getY(), game.getIslandMap().getHex(firstTileArr[i]).getTerrain(), game.getIslandMap().getHex(firstTileArr[i]).getLevel());
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
//
//    }
//
//    private void listenToClick() {
//        view.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//
////                while(game.getWhitePlayer().getRemainingMeeples() != 0){
////
////                    playerMove = ai.play(activeHexes);
////                    game.getIslandMap().printTilesOnMap();
////                    System.out.println("# of meeple left: " + game.getWhitePlayer().getRemainingMeeples());
////                    System.out.println("---------------------------------------------------------------------------------------");
////                    activeHexes = game.getIslandMap().getAllHexesOnMap();
////
////
////                    RotateTile tile = new RotateTile(playerMove.getHexID(),playerMove.getOrientation());
////
////                    drawTile(tile);
////
////                    addNewElement(game.getIslandMap().getHex(playerMove.getHexSettled()).getX(),game.getIslandMap().getHex(playerMove.getHexSettled()).getY(), playerMove.getBuildOption());
////
////                }
//
//                if (aiTurn){
//
//                    System.out.println("AI TURN");
//
//                    playerMove = ai.play(activeHexes);
//
//                    RotateTile tile = new RotateTile(playerMove.getHexID(),playerMove.getOrientation());
//
//                    drawTile(tile);
//
//                    addNewElement(game.getIslandMap().getHex(playerMove.getHexSettled()).getX(),game.getIslandMap().getHex(playerMove.getHexSettled()).getY(), playerMove.getBuildOption());
//
//
//                } else {
//
//                    System.out.println("SERVER TURN");
//
//                    playerMove = serverAI.play(activeHexes);
//
//                    RotateTile tile = new RotateTile(playerMove.getHexID(),playerMove.getOrientation());
//
//                    drawTile(tile);
//
//                    addNewElement(game.getIslandMap().getHex(playerMove.getHexSettled()).getX(),game.getIslandMap().getHex(playerMove.getHexSettled()).getY(), playerMove.getBuildOption());
//
//                }
//
//                activeHexes = game.getIslandMap().getAllHexesOnMap();
//
//                aiTurnToPlay();
//            }
//        });
//    }
//
//    private void drawTile(RotateTile tile) {
//        int[] hexes = tile.checkPair();
//
//        Hex hex1 = game.getIslandMap().getHexGrid().getHexValue(hexes[0]);
//        Hex hex2 = game.getIslandMap().getHexGrid().getHexValue(hexes[1]);
//        Hex hex3 = game.getIslandMap().getHexGrid().getHexValue(hexes[2]);
//
//        paintHexOnGrid(hex1.getX(), hex1.getY(), game.getIslandMap().getHexGrid().getHexValue(hexes[0]).getTerrain(), game.getIslandMap().getHexGrid().getHexValue(hexes[0]).getLevel());
//        paintHexOnGrid(hex2.getX(), hex2.getY(), game.getIslandMap().getHexGrid().getHexValue(hexes[1]).getTerrain(), game.getIslandMap().getHexGrid().getHexValue(hexes[0]).getLevel());
//        paintHexOnGrid(hex3.getX(), hex3.getY(), game.getIslandMap().getHexGrid().getHexValue(hexes[2]).getTerrain(), game.getIslandMap().getHexGrid().getHexValue(hexes[0]).getLevel());
//    }
//
//    public boolean aiTurnToPlay() {
//        return aiTurn = !aiTurn;
//    }
//
//    public Player getActivePlayer () {
//
//        if (aiTurn){
//            return game.getWhitePlayer();
//        }
//
//        return game.getBlackPlayer();
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
//        }
//
//        g.dispose();
//        view.repaint();
//    }
//
//    private void drawTiger(int x, int y, Graphics g) {
//        if (getActivePlayer() == game.getBlackPlayer()){
//            g.setColor(Color.black);
//        } else {
//            g.setColor(Color.white);
//        }
//        g.drawString("Ti", x, y + 8);
//
//    }
//
//    private void drawTotoro(int x, int y, Graphics g) {
//
//        if (getActivePlayer() == game.getBlackPlayer()){
//            g.setColor(Color.black);
//        } else {
//            g.setColor(Color.white);
//        }
//        g.drawString("To", x, y + 8);
//    }
//
//    public void drawMeeple(int x, int y, Graphics g) {
//        if (getActivePlayer() == game.getBlackPlayer()){
//            g.setColor(Color.black);
//        } else {
//            g.setColor(Color.white);
//        }
//        g.fillOval(x, y, 4, 4);
//        g.drawOval(x, y, 4, 4);
//    }
//}
