import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by ale on 3/21/17.
 */
public class GamePanel extends JPanel{

    HexGrid hexGrid = new HexGrid();

    CoordinateSystem coor = new CoordinateSystem();

    private boolean isOdd;

    JTextField textField;

    @Override
    protected void paintComponent(Graphics g){

        paintGrid(g);

        DrawTexfields(g);

        drawButton();

    }

    private void drawButton() {
        JButton okButton = new JButton("OK");
        okButton.setBounds(950,250,100,40);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Ok clicked");
            }
        });
        
        this.add(okButton);
        
        
    }

    private void DrawTexfields(Graphics g) {
        g.drawString("Tiger Island" , 950, 50);
        
        g.drawString("Pick a Hex: " , 875, 100);

        textField = new JTextField(3);
        textField.setBounds(950, 75, 100, 40); // to get height, set large font
        textField.setFont(textField.getFont().deriveFont(40f));
        this.add(textField);

        g.drawString("Orientation: " , 870, 200);

        textField = new JTextField(3);
        textField.setBounds(950, 175, 100, 40); // to get height, set large font
        textField.setFont(textField.getFont().deriveFont(40f));
        this.add(textField);
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
