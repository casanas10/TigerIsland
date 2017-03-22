import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ale on 3/22/17.
 */
public class GameView extends JPanel {

    HexGrid hexGrid = new HexGrid();

    JPanel southPanel = new JPanel();
    JButton okButton = new JButton("Ok");

    GridPanel gridPanel = new GridPanel();

    Hexagon hexagon = new Hexagon();

    GameView() {

        hexGrid.generateHexGrid();

        JTextField hexField = new JTextField(3);
        hexField.setFont(hexField.getFont().deriveFont(25f));


        JTextField orientationField = new JTextField(3);
        orientationField.setFont(orientationField.getFont().deriveFont(25f));

        this.setLayout(new BorderLayout(5, 10));

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String getHex = hexField.getText();
                String getOrientation = orientationField.getText();

                int hexID = Integer.parseInt(getHex);

                Hex hex = hexGrid.getHexValue(hexID);

                gridPanel.paintHexOnGrid(hex.getX(),hex.getY());

            }
        });

        southPanel.add(hexField);
        southPanel.add(orientationField);
        southPanel.add(okButton);
        add(southPanel, BorderLayout.SOUTH);
        add(gridPanel, BorderLayout.CENTER);
    }

}
