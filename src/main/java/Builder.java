/**
 * Created by Eric on 3/24/2017.
 */
public class Builder {

    public boolean build(Player player, IslandMap islandMap, int buildOption, int hexID){
        switch(buildOption) {
            case 1: return(buildANewSettlement(player, islandMap, hexID));

            case 3: return(buildATotoroSanctuary(player, islandMap, hexID));

            case 4: return(buildATigerPlayground(player, islandMap, hexID));

        }

        return true;
    }

    public boolean buildANewSettlement(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        if(player.getRemainingMeeples() != 0 && verifyValidHexForSettlement(currentHex)){
            // Add scoring
            currentHex.addGamePieceToHex(player.placeGamePiece("Meeple"));
            return true;
        }
        else{
            System.out.println("Invalid hex to place a new settlement");
            return false;
        }
    }

    public boolean buildATotoroSanctuary(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        if(player.getRemainingTotoros() != 0 && verifyValidHexForTotoro(currentHex)){
            currentHex.addGamePieceToHex(player.placeGamePiece("Totoro"));
            return true;
        }
        else{
            System.out.println("Invalid hex to place a totoro sanctuary");
            return false;
        }
    }

    public boolean buildATigerPlayground(Player player, IslandMap islandMap, int hexID){
        Hex currentHex = islandMap.getHex(hexID);
        if(player.getRemainingTigers() != 0 && verifyValidHexForTiger(currentHex)){
            currentHex.addGamePieceToHex(player.placeGamePiece("Tiger"));
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
}
