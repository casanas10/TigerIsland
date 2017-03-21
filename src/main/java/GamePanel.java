import javax.swing.*;
import java.awt.*;

/**
 * Created by ale on 3/21/17.
 */
public class GamePanel extends JPanel{

    Hexagon hex = new Hexagon();

    private boolean isOdd;

    @Override
    protected void paintComponent(Graphics g){

        paintGrid(g);

    }

    private void paintGrid(Graphics g) {
        for (int i = 30; i < 800; i++){
            for (int j = 15; j < 800; j++){
                isOdd();
                if (i % 30 == 0 && j % 25 == 0){
                    if (isOdd){
                        g.drawPolygon(hex.getHexagon(i+15, j));
                    } else {
                        g.drawPolygon(hex.getHexagon(i, j));
                    }
                }
            }
        }
    }

    public boolean isOdd() {
        return isOdd = !isOdd;
    }

}
