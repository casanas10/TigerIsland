/**
 * Created by Eric on 3/24/2017.
 */
public class Builder {

    public boolean build(Player player, IslandMap islandMap, int buildOption, int hexID){
        switch(buildOption) {
            case 1: return(buildANewSettlement(player, islandMap, hexID));

            case 2: return(extend(hexID,islandMap,player));

            case 3: return(buildATotoroSanctuary(player, islandMap, hexID));

            case 4: return(buildATigerPlayground(player, islandMap, hexID));

        }

        return true;
    }

    public boolean build(Player player, IslandMap islandMap, int buildOption, int hexID, String terrain){
        switch(buildOption) {
            case 1: return(buildANewSettlement(player, islandMap, hexID));

            case 2: return(extend(hexID,islandMap,player, terrain));

            case 3: return(buildATotoroSanctuary(player, islandMap, hexID));

            case 4: return(buildATigerPlayground(player, islandMap, hexID));

        }

        return true;
    }

    public boolean buildANewSettlement(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        Settlement settlement = islandMap.getSettlementObj();
        GamePiece piece;
        if(verifyValidHexForSettlement(currentHex)){

            piece = player.placeGamePiece("Meeple");    // Get the new Meeple piece

            if(piece == null){
                System.out.println("Out of meeples!");
                return false;
            }

            currentHex.addGamePieceToHex(piece);                  // Place the piece on the current hex
            settlement.addSettlement(hexID, player);
            updateScore(player, piece, currentHex.getLevel());    // Update player score with 1 point

            settlement.printAllSettlements(player);
            return true;
        }
        else{
            System.out.println("Invalid hex to place a new settlement");
            return false;
        }
    }

    public boolean extendForAI(int hexID, IslandMap islandMap, Player player, String terrain){
        if(islandMap.getHex(hexID).getSettlementID() == -1){
            return false;
        }
        else {
            ExtendSettlement extend = new ExtendSettlement(hexID, islandMap, player);
            boolean extensionSuccessful = extend.extendOnTerrain(terrain);
            islandMap.getSettlementObj().printAllSettlements(player);
            return extensionSuccessful;
        }
    }

    public boolean extend(int hexID, IslandMap islandMap, Player player){
        if(islandMap.getHex(hexID).getSettlementID() == -1){
            return false;
        }
        else {

            ExtendSettlement extend = new ExtendSettlement(hexID, islandMap, player);
            boolean terrainToExtend = extend.extendOnTerrain(extend.getTerrainToExtendOn());
            islandMap.getSettlementObj().printAllSettlements(player);
            return terrainToExtend;
        }

    }

    public boolean extend(int hexID, IslandMap islandMap, Player player, String terrain){
        if(islandMap.getHex(hexID).getSettlementID() == -1){
            return false;
        }
        else {

            ExtendSettlement extend = new ExtendSettlement(hexID, islandMap, player);
            boolean terrainToExtend = extend.extendOnTerrain(terrain);
            islandMap.getSettlementObj().printAllSettlements(player);
            return terrainToExtend;
        }
    }

    public boolean buildATotoroSanctuary(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        Settlement settlement = islandMap.getSettlementObj();
        GamePiece piece;
        if(verifyValidHexForTotoro(currentHex) && settlement.isSettlementSizeFiveOrMore(hexID,player)){
            piece = player.placeGamePiece("Totoro");        // Get the new Totoro piece

            if(piece == null){
                System.out.println("Out of totoros!");
                return false;
            }

            currentHex.addGamePieceToHex(piece);                      // Add the Totoro to the map
            settlement.addTotoroToSettlement(hexID,player);
            updateScore(player, piece, currentHex.getLevel());        // Update the players score with 200 points
            settlement.printAllSettlements(player);
            return true;
        }
        else{
            System.out.println("Invalid hex to place a totoro sanctuary");
            return false;
        }
    }

    public boolean buildATigerPlayground(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        Settlement settlement = islandMap.getSettlementObj();
        GamePiece piece;
        if(verifyValidHexForTiger(currentHex) && settlement.isTigerNextToSettlement(hexID, player)){
            piece = player.placeGamePiece("Tiger");         // Get the new Tiger piece

            if(piece == null){
                System.out.println("Out of Tigers!");
                return false;
            }

            currentHex.addGamePieceToHex(piece);                      // Add the Tiger to the map
            settlement.addTigerToSettlement(hexID, player);
            updateScore(player, piece, currentHex.getLevel());        // Update the player score with 75 points
            settlement.printAllSettlements(player);
            return true;
        }
        else{
            System.out.println("Invalid hex to place a tiger playground");
            return false;
        }
    }

    public boolean verifyValidHexForSettlement(Hex currentHex){
        if(currentHex.getLevel() == 1 && currentHex.checkIfHexIsNotSettled()
                && !currentHex.getTerrain().equals("Volcano")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean verifyValidHexForTotoro(Hex currentHex){
        if(currentHex.getLevel() >= 1 && currentHex.checkIfHexIsNotSettled()
                && !currentHex.getTerrain().equals("Volcano")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean verifyValidHexForTiger(Hex currentHex){
        if(currentHex.getLevel() >= 3 && currentHex.checkIfHexIsNotSettled()
                && !currentHex.getTerrain().equals("Volcano")){
            return true;
        }
        else{
            return false;
        }
    }

    public void updateScore(Player player, GamePiece piece, int level){
        player.updateScore(piece.calculateScore(level));
        System.out.println(piece.calculateScore(level) + " point(s) added to " + player.getPlayerColor() + "'s score.");
        System.out.println(player.getPlayerColor() + " player's total score: " + player.getCurrentScore());

    }
}
