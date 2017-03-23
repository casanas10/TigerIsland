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



    public boolean checkIfHexesCanBePlaced(HexGrid hexGrid, int[] tileHexIDsArray, String[] tileTerrainsArray) {
        int counter = 0;

        for (int i = 0; i < tileHexIDsArray.length; i++) {
            if (hexGrid.getHexValue(tileHexIDsArray[i]).getTerrain().isEmpty() == true) {

                counter++;

            }
        }

        if (counter == tileHexIDsArray.length) {
            return true;
        }
        else {
            return false;
        }
    }


    public boolean SearchAdjacentTiles(HexGrid hexGrid, int[] tileHexIDsArray){

        int hex1;
        int hex2;
        int hex3;

       hex1= tileHexIDsArray[0];
       hex2= tileHexIDsArray[1];
       hex3= tileHexIDsArray[2];





       for(int i=0; i< tileHexIDsArray.length; i++) {

            int row = hex1/200;

           if( row%2 != 0 ) {



               givenHexID = hex1;

               xStart = searchCoordinates.getXCoordinate(givenHexID);
               yStart = searchCoordinates.getYCoordinate(givenHexID);



               testX = xStart + 1;
               testY = yStart;


               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;


                       }
                   }
               }



               testX = xStart + 1;
               testY = yStart - 1;



               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;

                       }
                   }
               }

               testX = xStart;
               testY = yStart-1;

               testerHexID = searchCoordinates.getHexID(testX, testY);

               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;

                       }
                   }
               }

               testX = xStart - 1;
               testY = yStart;



               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;

                       }
                   }
               }

               testX = xStart;
               testY = yStart + 1;

               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {

                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;


                       }
                   }
               }

               testX = xStart + 1;
               testY = yStart + 1;

               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       // Hex sub = findHex.getHexValue(testerHexID);
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {



                           counter++;
                       }
                   }
               }

           }else if(row %2 == 0 ) {


               //OTHER ROW
               givenHexID = hex1;

               xStart = searchCoordinates.getXCoordinate(givenHexID);
               yStart = searchCoordinates.getYCoordinate(givenHexID);




               testX = xStart+1;
               testY = yStart;


               testerHexID = searchCoordinates.getHexID(testX, testY);



               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;


                       }
                   }
               }


               testX = xStart;
               testY = yStart-1;



               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;

                       }
                   }
               }

               testX = xStart - 1;
               testY = yStart-1;

               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;

                       }
                   }
               }

               testX = xStart - 1;
               testY = yStart;


               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;

                       }
                   }
               }

               testX = xStart-1;
               testY = yStart +1;

               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {
                           counter++;


                       }
                   }
               }

               testX = xStart;
               testY = yStart + 1;

               testerHexID = searchCoordinates.getHexID(testX, testY);


               if (testerHexID != hex2) {
                   if (testerHexID != hex3) {
                       // Hex sub = findHex.getHexValue(testerHexID);
                       if (hexGrid.getHexValue(testerHexID).getTerrain().isEmpty() == false) {



                           counter++;
                       }
                   }
               }


           }




           if(i == 0){
               hex1 = tileHexIDsArray[1];
               hex2 = tileHexIDsArray[2];
               hex3 = tileHexIDsArray[0];
        }
         if(i == 1){

             hex1 = tileHexIDsArray[2];
             hex2 = tileHexIDsArray[0];
             hex3 = tileHexIDsArray[1];

         }



       }


        if(counter > 0){
            return true;
        }else{
            return false;
        }


    }




}
