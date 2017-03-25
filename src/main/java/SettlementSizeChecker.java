import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Connor on 3/24/2017.
 */
public class SettlementSizeChecker {
    private HexGrid hexGrid;
    private CoordinateSystem coordinates = new CoordinateSystem();
    private int maxArrayLength = 200;
    private int settlementCount = 0;

    public SettlementSizeChecker(HexGrid hexGrid) {
        this.hexGrid = hexGrid;
    }

    public int checkSettlementSize(int hexID, Player player) {
        if(playerColorMatchesHexColor(hexID, player))
            return BFS(hexID, player);
        else
            return 0;
    }

    public boolean playerColorMatchesHexColor(int hexID, Player player) {
        if(player.getPlayerColor() == hexGrid.getHexValue(hexID).getColor())
            return true;
        else
            return false;
    }

    public int BFS(int hexID, Player player) {
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
                settlementCount++;

        }

        return settlementCount;
    }

    public int upperRightHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID - maxArrayLength;
        else
            return hexID - (maxArrayLength - 1);
    }

    public int rightHexID(int hexID) {
        return hexID + 1;
    }

    public int bottomRightHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID + maxArrayLength;
        else
            return hexID + maxArrayLength + 1;
    }

    public int bottomLeftHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID + maxArrayLength - 1;
        else
            return hexID + maxArrayLength;
    }

    public int leftHexID(int hexID) {
        return  hexID - 1;
    }

    public int upperLeftHexID(int hexID) {
        if(hexIsInEvenRow(hexID))
            return hexID - maxArrayLength - 1;
        else
            return hexID - maxArrayLength;
    }

    public boolean hexIsInEvenRow(int hexID) {
        if(coordinates.getYCoordinate(hexID)%2 == 0)
            return true;
        else
            return false;
    }
}
