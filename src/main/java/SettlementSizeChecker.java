import java.util.*;

/**
 * Created by Connor on 3/24/2017.
 */
public class SettlementSizeChecker {
    private HexGrid hexGrid;
    private CoordinateSystem coordinates = new CoordinateSystem();
    private int maxArrayLength = 200;
    private int settlementCount = 0;
    private ArrayList<Integer> hexesInSettlement;

    public SettlementSizeChecker(HexGrid hexGrid) {
        this.hexGrid = hexGrid;
    }

    public ArrayList<Integer> checkSettlementSize(int hexID, Player player) {
        hexesInSettlement = new ArrayList<Integer>();

        if(playerColorMatchesHexColor(hexID, player))
            return BFS(hexID, player);
        else
            return hexesInSettlement;
    }

    public boolean playerColorMatchesHexColor(int hexID, Player player) {
        if(player.getPlayerColor() == hexGrid.getHexValue(hexID).getPlayerColorOnHex())
            return true;
        else
            return false;
    }

    private ArrayList<Integer> BFS(int hexID, Player player) {
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        Queue<Integer> queue = new LinkedList<Integer>();

        visited.put(hexID, true);
        queue.add(hexID);

        while(queue.size() != 0) {

            hexID = queue.remove();
            visited.put(hexID, true);

            if(playerColorMatchesHexColor(upperRightHexID(hexID), player))
                if(visited.get(upperRightHexID(hexID)) == null) {
                    queue.add(upperRightHexID(hexID));
                    visited.put(upperRightHexID(hexID), true);
                }
            if(playerColorMatchesHexColor(rightHexID(hexID), player))
                if(visited.get(rightHexID(hexID)) == null) {
                    queue.add(rightHexID(hexID));
                    visited.put(rightHexID(hexID), true);
                }
            if(playerColorMatchesHexColor(bottomRightHexID(hexID), player))
                if(visited.get(bottomRightHexID(hexID)) == null) {
                    queue.add(bottomRightHexID(hexID));
                    visited.put(bottomRightHexID(hexID), true);
                }
            if(playerColorMatchesHexColor(bottomLeftHexID(hexID), player))
                if(visited.get(bottomLeftHexID(hexID)) == null) {
                    queue.add(bottomLeftHexID(hexID));
                    visited.put(bottomLeftHexID(hexID), true);
                }
            if(playerColorMatchesHexColor(leftHexID(hexID), player))
                if(visited.get(leftHexID(hexID)) == null) {
                    queue.add(leftHexID(hexID));
                    visited.put(leftHexID(hexID), true);
                }
            if(playerColorMatchesHexColor(upperLeftHexID(hexID), player))
                if(visited.get(upperLeftHexID(hexID)) == null) {
                    queue.add(upperLeftHexID(hexID));
                    visited.put(upperLeftHexID(hexID), true);
                }



            if(playerColorMatchesHexColor(hexID, player))
                hexesInSettlement.add(hexID);

        }

        return hexesInSettlement;
    }

    private int upperRightHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID - maxArrayLength;
        else
            return hexID - (maxArrayLength - 1);
    }

    private int rightHexID(int hexID) {
        return hexID + 1;
    }

    private int bottomRightHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID + maxArrayLength;
        else
            return hexID + maxArrayLength + 1;
    }

    private int bottomLeftHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID + maxArrayLength - 1;
        else
            return hexID + maxArrayLength;
    }

    private int leftHexID(int hexID) {
        return  hexID - 1;
    }

    private int upperLeftHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID - maxArrayLength - 1;
        else
            return hexID - maxArrayLength;
    }

    private boolean hexIsInEvenRow(int hexID) {
        if(coordinates.getYCoordinate(hexID)%2 == 0)
            return true;
        else
            return false;
    }
}
