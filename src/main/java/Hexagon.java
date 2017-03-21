import java.awt.*;

/**
 * Created by ale on 3/21/17.
 */
public class Hexagon extends Polygon {

    private int x = 400;
    private int y = 400;
    private int h = 15;

    Polygon getHexagon(int x, int y) {

        Polygon hexagon = new Polygon();

        double rad ;
        for (int i = 0; i < 6; i++){
            rad = Math.PI / 3.0 * i;
            hexagon.addPoint((int)(Math.round(x + Math.sin(rad) * h)), (int)(Math.round(y + Math.cos(rad) * h)));
        }

        return hexagon;
    }


}
