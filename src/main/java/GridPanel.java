import javax.swing.*;
import java.awt.*;

/**
 * Created by ale on 3/21/17.
 */
public class GridPanel extends JPanel{

    CoordinateSystem coor = new CoordinateSystem();

    private boolean isOdd = false;
    private int x;
    private int y;

    Hexagon hex = new Hexagon();

    @Override
    protected void paintComponent(Graphics g){

        paintGrid(g);

    }

    public void paintHexOnGrid(int x, int y) {
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setStroke(new BasicStroke(3));
        g2.setPaint(Color.red);

        if (y%2 == 0){

            x = x * 30 + 30;
            y = y * 25 + 25;

        } else {
            x = x * 30 + 30 + 15;
            y = y * 25 + 25;
        }

        g2.drawPolygon(hex.getHexagon(x, y));
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

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }


    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
