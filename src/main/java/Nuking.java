import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by NatalieGoldstein on 3/28/17.
 */
public class Nuking {

        public boolean areBelowHexesOnSameLevel(HexGrid hexGrid, int[] tileHexIDsArray){

            int placement1= hexGrid.getHexValue(tileHexIDsArray[0]).getLevel();
            int placement2= hexGrid.getHexValue(tileHexIDsArray[1]).getLevel();
            int placement3= hexGrid.getHexValue(tileHexIDsArray[2]).getLevel();

            if(placement1 == placement2 && placement2 == placement3){
                return true;
            }
            return false;
        }


        public boolean canYouNukeSettlement(IslandMap islandMap, int[] HexIDSArray, int hexID) {
            HexGrid hexGrid = islandMap.getHexGrid();

            if(isVolcanoOverVolcano(hexGrid, hexID) && areBelowHexesOnSameLevel(hexGrid,HexIDSArray) &&
                    doesNukeSpanTwoTiles(hexGrid, HexIDSArray) && !isSettlementSizeOne(islandMap, HexIDSArray) &&
                    !doLowerHexesHaveATotoro(hexGrid, HexIDSArray) && !doLowerHexesHaveATiger(hexGrid, HexIDSArray) &&
                    !willNukingCompletelyDestroyASettlement(islandMap,HexIDSArray)){
                return true;

            }
            else return false;

        }

    private boolean willNukingCompletelyDestroyASettlement(IslandMap islandMap, int[] hexIDSArray) {
        Settlement settlement = islandMap.getSettlementObj();
        HexGrid hexGrid = islandMap.getHexGrid();
        int previousSettlementID = -1;
        int currentSettlementID;

        for (int hexID : hexIDSArray) {
            currentSettlementID = hexGrid.getHexValue(hexID).getSettlementID();

            if (currentSettlementID == -1)
                continue;
            else if (settlement.getSettlementMap().get(currentSettlementID).size() == 2) {
                if(currentSettlementID == previousSettlementID)
                    return true;
                else
                    previousSettlementID = currentSettlementID;
            }
        }

        return false;
    }

    //currently do not have a unit test for tiger in NukingTest
    private boolean doLowerHexesHaveATiger(HexGrid hexGrid, int[] hexIDsArray) {
        for (int hexID : hexIDsArray) {
            if (hexGrid.getHexValue(hexID).getPieceOnHex() == "Tiger")
                return true;
        }
        return false;
    }

    public boolean doLowerHexesHaveATotoro(HexGrid hexGrid, int[] hexIDsArray){
            for (int hexID : hexIDsArray) {
                if (hexGrid.getHexValue(hexID).getPieceOnHex() == "Totoro")
                    return true;
            }
            return false;
        }


        public boolean isSettlementSizeOne(IslandMap islandMap, int[] hexID){
            Settlement settlement = islandMap.getSettlementObj();
            HexGrid hexGrid = islandMap.getHexGrid();

            for(int i = 0; i < hexID.length; i++) {
                int settlementID = hexGrid.getHexValue(hexID[i]).getSettlementID();

                if (settlementID == -1)
                    continue;
                else if (settlement.getSettlementMap().get(settlementID).size() == 1)
                    return true;

            }

            return false;
        }



        public boolean doesNukeSpanTwoTiles(HexGrid hexGrid, int[] HexIDsArray){

            int tileID1;
            int tileID2;
            int tileID3;

            tileID1 = hexGrid.getHexValue(HexIDsArray[0]).getTileID();
            tileID2 = hexGrid.getHexValue(HexIDsArray[1]).getTileID();
            tileID3 = hexGrid.getHexValue(HexIDsArray[2]).getTileID();

            if(tileID1 != -1 && tileID2 != -1 && tileID3 != -1) {
                if (tileID1 == tileID2 && tileID2 == tileID3) {
                    return false;
                }
                else{
                    return true;
                }

            }

            return false;
        }

        public boolean isVolcanoOverVolcano(HexGrid hexGrid, int hexID){
            if(hexGrid.getHexValue(hexID).getTerrain() == "Volcano"){
                return true;
            }
            else return false;
        }

        public void performNuke(HexGrid hexGrid, int[] hexIDS, String[] hexTerrains, int nextTile){

            for(int i=0; i<hexIDS.length; i++){
                hexGrid.getHexValue(hexIDS[i]).incrementLevel();
                hexGrid.getHexValue(hexIDS[i]).setTerrain(hexTerrains[i]);
                hexGrid.getHexValue(hexIDS[i]).removeGamePiecesFromMap();
                hexGrid.getHexValue(hexIDS[i]).setTileID(nextTile);
            }
    }
}
