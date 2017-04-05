import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by cyonkee on 4/4/17.
 */
public class MoveProtocol {
    private String currentGID;

    public void makeMove(PrintWriter out, BufferedReader in, MyRunnable r1, MyRunnable r2, int moveNumber) throws Exception {
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;
        MoveData moveData;
        String moveString;

        //MAKE YOUR MOVE IN GAME <gid> WITHIN <time_move> SECOND(S): MOVE <#> PLACE <tile>
        fromServer = in.readLine();
        if(fromServer.substring(0,4).equals("MAKE")) {
            String fromServerArr[] = fromServer.split(" ");
            if(MatchProtocol.gid1 == null){
                MatchProtocol.gid1 = fromServerArr[5];
                moveData = getTile(fromServerArr[12],MatchProtocol.gid1);
                moveString = constructMoveString(moveData, moveNumber, fromServerArr[12]);
            }
            else if((MatchProtocol.gid2 == null) && (fromServerArr[5] != MatchProtocol.gid1)){
                MatchProtocol.gid2 = fromServerArr[5];
                moveData = getTile(fromServerArr[12],MatchProtocol.gid2);
                moveString = constructMoveString(moveData, moveNumber, fromServerArr[12]);
            }
            else{
                currentGID = fromServerArr[5];
                moveData = getTile(fromServerArr[12],currentGID);
                moveString = constructMoveString(moveData, moveNumber, fromServerArr[12]);
            }
            System.out.println("Server: " + fromServer);
        }
    }

    private MoveData getTile(String tile, String currentGID) {
        tile = tile.replaceAll("[+]"," ");
        String givenTerrains[] = tile.split(" ");
        String terrainsArray[] = {"Volcano",givenTerrains[0],givenTerrains[1]};

        if(currentGID == MatchProtocol.gid1){
            //AI1 gets terrains
           // MoveData moveData = AI1.makeMove(terrainsArray);
        }
        else{
            //AI2 gets terrains
            //MoveData moveData = AI2.makeMove(terrainsArray);
        }

        return null;
    }

    private String constructMoveString(MoveData moveData, int moveNumber, String tile){
        String moveString = "";

        switch(moveData.getBuildOption()){
            case 1: moveString = "GAME " + currentGID + " MOVE " + Integer.toString(moveNumber) + " PLACE " + tile + " AT "
                    + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                    + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                    + " FOUND SETTLEMENT AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                    Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ());
                    break;
            case 2: moveString = "GAME " + currentGID + " MOVE " + Integer.toString(moveNumber) + " PLACE " + tile + " AT "
                    + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                    + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                    + " EXPAND SETTLEMENT AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                    Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ())
                    + " " + moveData.getExtendTerrain();
                    break;
            case 3: moveString = "GAME " + currentGID + " MOVE " + Integer.toString(moveNumber) + " PLACE " + tile + " AT "
                    + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                    + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                    + " BUILD TOTORO SANCTUARY AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                    Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ());
                    break;
            case 4: moveString = "GAME " + currentGID + " MOVE " + Integer.toString(moveNumber) + " PLACE " + tile + " AT "
                    + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                    + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                    + " BUILD TIGER PLAYGROUND AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                    Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ());
                    break;
            case 5: moveString = "GAME " + currentGID + " MOVE " + Integer.toString(moveNumber) + " PLACE " + tile + " AT "
                    + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                    + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                    + " UNABLE TO BUILD";
                    break;
        }

        return moveString;
    }
}
