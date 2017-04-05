import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by cyonkee on 4/4/17.
 */
public class MoveProtocol {
    private String currentGID;

    public void makeMove(PrintWriter out, BufferedReader in, MyRunnable r1, MyRunnable r2,
                         int moveNumber, String opponentPID) throws Exception {
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        //String fromUser;
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
                out.println(moveString);
                checkMessages(out, in, opponentPID);
            }
            else if((MatchProtocol.gid2 == null) && (fromServerArr[5] != MatchProtocol.gid1)){
                MatchProtocol.gid2 = fromServerArr[5];
                moveData = getTile(fromServerArr[12],MatchProtocol.gid2);
                moveString = constructMoveString(moveData, moveNumber, fromServerArr[12]);
                out.println(moveString);
                checkMessages(out,in,opponentPID);
            }
            else{
                currentGID = fromServerArr[5];
                moveData = getTile(fromServerArr[12],currentGID);
                moveString = constructMoveString(moveData, moveNumber, fromServerArr[12]);
                out.println(moveString);
                checkMessages(out,in,opponentPID);
            }
            System.out.println("Server: " + fromServer);
        }
    }

    private void checkMessages(PrintWriter out, BufferedReader in, String opponentPID) throws Exception{
        if(MatchProtocol.gid1 != "dead" && MatchProtocol.gid2 != "dead"){
            getTwoMessages(in, opponentPID);
        }
        else{
            getOneMessage(in,opponentPID);
        }
    }

    private void getTwoMessages(BufferedReader in, String opponentPID) throws IOException {
        String fromServer;
        String serverGID;
        String serverPID;
        MoveData moveData;

        //get two messages
        int i=0;
        while(i<2) {
            fromServer = in.readLine();
            if (fromServer.substring(0, 4).equals("GAME")) {
                String fromServerArr[] = fromServer.split(" ");
                serverGID = fromServerArr[1];
                serverPID = fromServerArr[5];

                if(serverGID == MatchProtocol.gid1 && serverPID == opponentPID){
                    //send opponent's move to AI1
                    moveData = parseMessage(fromServerArr);
                }
                else if(serverGID == MatchProtocol.gid2 && serverPID == opponentPID){
                    //send opponent's move to AI2
                    moveData = parseMessage(fromServerArr);
                }
                else{
                    //check if server says we lost; check which game if so.
                    moveData = parseMessage(fromServerArr);
                }
            }
            i++;
        }
    }

    private void getOneMessage(BufferedReader in, String opponentPID) throws Exception{
        String fromServer;
        String serverGID;
        String serverPID;
        MoveData moveData;

        fromServer = in.readLine();
        if (fromServer.substring(0, 4).equals("GAME")) {
            String fromServerArr[] = fromServer.split(" ");
            serverGID = fromServerArr[1];
            serverPID = fromServerArr[5];

            if (serverGID == MatchProtocol.gid1 && serverPID == opponentPID) {
                //send opponent's move to AI1
                moveData = parseMessage(fromServerArr);
            } else if (serverGID == MatchProtocol.gid2 && serverPID == opponentPID) {
                //send opponent's move to AI2
                moveData = parseMessage(fromServerArr);
            } else {
                //check if server says we lost; check which game if so.
                moveData = parseMessage(fromServerArr);
            }
        }
    }

    private MoveData parseMessage(String[] fromServerArr) {
        String tile = fromServerArr[5];
        tile = tile.replaceAll("[+]"," ");
        String givenTerrains[] = tile.split(" ");
        String terrainsArray[] = {"Volcano",givenTerrains[0],givenTerrains[1]};
        String serverGID;
        MoveData moveData;

        if(fromServerArr[11] == "FOUND") {
             moveData = new MoveData(terrainsArray,Integer.parseInt(fromServerArr[7]),
                    Integer.parseInt(fromServerArr[8]), Integer.parseInt(fromServerArr[9]),
                    Integer.parseInt(fromServerArr[10]), 1, Integer.parseInt(fromServerArr[14]),
                    Integer.parseInt(fromServerArr[15]),Integer.parseInt(fromServerArr[16]));

             return moveData;
        }
        else if(fromServerArr[11] == "EXPAND"){
             moveData = new MoveData(terrainsArray,Integer.parseInt(fromServerArr[7]),
                    Integer.parseInt(fromServerArr[8]), Integer.parseInt(fromServerArr[9]),
                    Integer.parseInt(fromServerArr[10]), 2, Integer.parseInt(fromServerArr[14]),
                    Integer.parseInt(fromServerArr[15]),Integer.parseInt(fromServerArr[16]),
                    fromServerArr[17]);

             return moveData;
        }
        else if(fromServerArr[12] == "TOTORO"){
            moveData = new MoveData(terrainsArray,Integer.parseInt(fromServerArr[7]),
                    Integer.parseInt(fromServerArr[8]), Integer.parseInt(fromServerArr[9]),
                    Integer.parseInt(fromServerArr[10]), 3, Integer.parseInt(fromServerArr[15]),
                    Integer.parseInt(fromServerArr[16]),Integer.parseInt(fromServerArr[17]));

            return moveData;
        }
        else if(fromServerArr[12] == "TIGER"){
            moveData = new MoveData(terrainsArray,Integer.parseInt(fromServerArr[7]),
                    Integer.parseInt(fromServerArr[8]), Integer.parseInt(fromServerArr[9]),
                    Integer.parseInt(fromServerArr[10]), 4, Integer.parseInt(fromServerArr[15]),
                    Integer.parseInt(fromServerArr[16]),Integer.parseInt(fromServerArr[17]));

            return moveData;
        }
        else{

            moveData = new MoveData();

            serverGID = fromServerArr[1];

            if(serverGID == MatchProtocol.gid1){
                MatchProtocol.gid1 = "dead";
            }
            else{
                MatchProtocol.gid2 = "dead";
            }
        }

        return moveData;

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
