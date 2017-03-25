/**
 * Created by Eric on 3/24/2017.
 */
public class Builder {

    public boolean build(Player player, IslandMap islandMap, int buildOption, int hexID){
        switch(buildOption) {
            case 1: return(buildANewSettlement(player, islandMap, hexID));

            case 2: // Expand
                    break;
            case 3: return(buildATotoroSanctuary(player, islandMap, hexID));

            case 4: return(buildATigerPlayground(player, islandMap, hexID));

        }

        return true;
    }

    public boolean buildANewSettlement(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        GamePiece piece;
        if(player.getRemainingMeeples() != 0 && verifyValidHexForSettlement(currentHex)){

            piece = player.placeGamePiece("Meeple");    // Get the new Meeple piece
            currentHex.addGamePieceToHex(piece);                  // Place the piece on the current hex
            updateScore(player, piece, currentHex.getLevel());    // Update player score with 1 point
            return true;
        }
        else{
            System.out.println("Invalid hex to place a new settlement");
            return false;
        }
    }

    public boolean buildATotoroSanctuary(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        GamePiece piece;
        if(player.getRemainingTotoros() != 0 && verifyValidHexForTotoro(currentHex)){
            piece = player.placeGamePiece("Totoro");        // Get the new Totoro piece
            currentHex.addGamePieceToHex(piece);                      // Add the Totoro to the map
            updateScore(player, piece, currentHex.getLevel());        // Update the players score with 200 points

            return true;
        }
        else{
            System.out.println("Invalid hex to place a totoro sanctuary");
            return false;
        }
    }

    public boolean buildATigerPlayground(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        GamePiece piece;
        if(player.getRemainingTigers() != 0 && verifyValidHexForTiger(currentHex)){
            piece = player.placeGamePiece("Tiger");         // Get the new Tiger piece
            currentHex.addGamePieceToHex(piece);                      // Add the Tiger to the map
            updateScore(player, piece, currentHex.getLevel());        // Update the player score with 75 points
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
        // Need to check for a settlement of size 5
        if(currentHex.getLevel() >= 1 && currentHex.checkIfHexIsNotSettled()
                && !currentHex.getTerrain().equals("Volcano")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean verifyValidHexForTiger(Hex currentHex){
        // Need to add check for a settlement
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
