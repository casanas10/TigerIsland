import javax.swing.*;
import java.awt.*;

/**
 * Created by ale on 3/21/17.
 */
public class GridPanel extends JPanel{

    HexGrid hexGrid = new HexGrid();

    CoordinateSystem coor = new CoordinateSystem();

    private boolean isOdd;

    JTextField textField;

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        paintGrid(g);

    }

    private void paintGrid(Graphics g) {

        Hexagon hex = new Hexagon();

        for (int i = 30; i < 800; i++){
            for (int j = 25; j < 800; j++){
                if (i % 30 == 0 && j % 25 == 0){
                    if (isOdd){

                        g.drawPolygon(hex.getHexagon(i+15, j));
                        g.drawString(String.valueOf(hexGridToPixelConversion(i,j)), i+15-8, j+5);

                    } else {
                        g.drawPolygon(hex.getHexagon(i, j));
                        g.drawString(String.valueOf(hexGridToPixelConversion(i,j)), i-8, j+5);
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

}
