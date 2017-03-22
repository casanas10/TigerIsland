/**
 * Created by NatalieGoldstein on 3/21/17.
 */
public class PlacementValidity {

        private int testX;
        private int testY;

        private int xStart;
        private int yStart;

        private int givenHexID;
        private int testerHexID;

        private int counter=0;

    CoordinateSystem searchCoordinates = new CoordinateSystem();

    HexGrid findHex = new HexGrid();


    public boolean checkIfHexesCanBePlaced(Hex desiredHex){

        givenHexID = desiredHex.getHexID();

        if(findHex.getHexValue(givenHexID).getTerrain().isEmpty() == false){

            return false;
        }else return true;



    }




    public boolean SearchAdjacentTiles(Hex hex1, Hex hex2, Hex hex3){
        findHex.generateHexGrid();

        givenHexID = hex1.getHexID();

        xStart = searchCoordinates.getXCoordinate(givenHexID);
        yStart= searchCoordinates.getYCoordinate(givenHexID);

        testX = xStart;
        testY = yStart+1;


        testerHexID= searchCoordinates.getHexID(testX, testY);

        if(testerHexID != hex2.getHexID()) {
            if (testerHexID != hex3.getHexID()) {
                if (findHex.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                    counter++;
                }
            }
        }


        testX = xStart-1;
        testY = yStart+1;

        testerHexID= searchCoordinates.getHexID(testX, testY);


        if(testerHexID != hex2.getHexID()) {
            if (testerHexID != hex3.getHexID()) {
                if (findHex.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                    counter++;
                }
            }
        }

        testX = xStart-1;
        testY = yStart;

        testerHexID= searchCoordinates.getHexID(testX, testY);

        if(testerHexID != hex2.getHexID()) {
            if (testerHexID != hex3.getHexID()) {
                if (findHex.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                    counter++;
                }
            }
        }

        testX = xStart;
        testY = yStart-1;


        testerHexID= searchCoordinates.getHexID(testX, testY);

       //COMEBACK

        if(testerHexID != hex2.getHexID()) {
            if (testerHexID != hex3.getHexID()) {
               if (findHex.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                    counter++;
                }
            }
        }

        testX = xStart+1;
        testY = yStart;

        testerHexID= searchCoordinates.getHexID(testX, testY);


        if(testerHexID != hex2.getHexID()) {
            if (testerHexID != hex3.getHexID()) {
                if (findHex.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                    counter++;
                }
            }
        }

        testX = xStart+1;
        testY = yStart+1;

        testerHexID= searchCoordinates.getHexID(testX, testY);
       

        if(testerHexID != hex2.getHexID()) {
            if (testerHexID != hex3.getHexID()) {
                // Hex sub = findHex.getHexValue(testerHexID);
                if (findHex.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                    counter++;
                }
            }
        }


        if(counter > 0){
            return true;
        }else{
            return false;
        }


    }




}
