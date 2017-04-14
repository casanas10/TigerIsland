import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.crypto.Mac;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by cyonkee on 4/4/17.
 */
public class MoveProtocol {
    private String currentGID;

    public void makeMove(PrintWriter out, BufferedReader in, ALE_AI AI1, ALE_AI AI2, String opponentPID) throws Exception {
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        MoveData moveData;
        String moveString;
        String moveNumber;

        while ((fromServer = in.readLine()) == null){}
        //MAKE YOUR MOVE IN GAME <gid> WITHIN <time_move> SECOND(S): MOVE <#> PLACE <tile>
        if (fromServer.substring(0, 4).equals("MAKE")) {
            System.out.println("Server: " + fromServer);
            String fromServerArr[] = fromServer.split(" ");
            if ((MatchProtocol.gid1 == null) || (MatchProtocol.gid1 != null && MatchProtocol.gid2 == null)) {
                currentGID = fromServerArr[5];
                MatchProtocol.gid1 = fromServerArr[5];
                moveNumber = fromServerArr[10];
                moveData = getTile(fromServerArr[12], MatchProtocol.gid1, AI1, AI2);
                moveString = constructMoveString(moveData, moveNumber, fromServerArr[12]);
                moveString = moveString.toUpperCase();
                System.out.println("Client: " + moveString);
                out.println(moveString);
                checkMessages(out, in, opponentPID, AI1, AI2);
            }
            else {
                currentGID = fromServerArr[5];
                moveNumber = fromServerArr[10];
                moveData = getTile(fromServerArr[12], currentGID, AI1, AI2);
                moveString = constructMoveString(moveData, moveNumber, fromServerArr[12]);
                moveString = moveString.toUpperCase();
                System.out.println("Client: " + moveString);
                out.println(moveString);
                checkMessages(out, in, opponentPID, AI1, AI2);
            }
        }

        System.out.println("---------------------------------------------");
    }

    private MoveData getTile(String tile, String currentGID, ALE_AI AI1, ALE_AI AI2) {
        tile = tile.replaceAll("[+]", " ");
        String givenTerrains[] = tile.split(" ");
        givenTerrains[0] = givenTerrains[0].substring(0, 1).toUpperCase() + givenTerrains[0].substring(1).toLowerCase();
        givenTerrains[1] = givenTerrains[1].substring(0, 1).toUpperCase() + givenTerrains[1].substring(1).toLowerCase();

        if (givenTerrains[0].equals("Rock")) {
            givenTerrains[0] = "Rocky";
        }
        if (givenTerrains[1].equals("Rock")) {
            givenTerrains[1] = "Rocky";
        }

        if (givenTerrains[0].equals("Grass")) {
            givenTerrains[0] = "Grassland";
        }
        if (givenTerrains[1].equals("Grass")) {
            givenTerrains[1] = "Grassland";
        }
        String terrainsArray[] = {"Volcano", givenTerrains[0], givenTerrains[1]};

        if (currentGID.equals(MatchProtocol.gid1)) {
            //AI1 gets terrains
//            System.out.println("terrains: " + terrainsArray[0] + " " + terrainsArray[1] + " " + terrainsArray[2]);

            if (givenTerrains[0] != null && givenTerrains[1] != null)
                AI1.setTerrainsArray(terrainsArray);

            AI1.getIslandMap().getSettlementObj().printAllSettlements(AI1.getAiPlayer());
            return AI1.play();
        } else {
            //AI2 gets terrains
//            System.out.println("terrains: " + terrainsArray[0] + " " + terrainsArray[1] + " " + terrainsArray[2]);

            if (givenTerrains[0] != null && givenTerrains[1] != null)
                AI2.setTerrainsArray(terrainsArray);
//            AI2.getIslandMap().getSettlementObj().printAllSettlements(AI1.getAiPlayer());
            return AI2.play();
        }
    }

    private String constructMoveString(MoveData moveData, String moveNumber, String tile) {
        String moveString = "";

        switch (moveData.getBuildOption()) {
            case 1:
                moveString = "GAME " + currentGID + " MOVE " + moveNumber + " PLACE " + tile + " AT "
                        + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                        + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                        + " FOUND SETTLEMENT AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                        Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ());
                break;
            case 2:
                String terrain = moveData.getExtendTerrain();
                if (terrain.equals("Grassland")) {
                    terrain = "Grass";
                }
                if (terrain.equals("Rocky")) {
                    terrain = "Rock";
                }
                moveString = "GAME " + currentGID + " MOVE " + moveNumber + " PLACE " + tile + " AT "
                        + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                        + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                        + " EXPAND SETTLEMENT AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                        Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ())
                        + " " + terrain;
                break;
            case 3:
                moveString = "GAME " + currentGID + " MOVE " + moveNumber + " PLACE " + tile + " AT "
                        + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                        + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                        + " BUILD TOTORO SANCTUARY AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                        Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ());
                break;
            case 4:
                moveString = "GAME " + currentGID + " MOVE " + moveNumber + " PLACE " + tile + " AT "
                        + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                        + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                        + " BUILD TIGER PLAYGROUND AT " + Integer.toString(moveData.getBuildOptionX()) + " " +
                        Integer.toString(moveData.getBuildOptionY()) + " " + Integer.toString(moveData.getBuildOptionZ());
                break;
            case 5:
                moveString = "GAME " + currentGID + " MOVE " + moveNumber + " PLACE " + tile + " AT "
                        + Integer.toString(moveData.getTilePlacementX()) + " " + Integer.toString(moveData.getTilePlacementY())
                        + " " + Integer.toString(moveData.getTilePlacementZ()) + " " + Integer.toString(moveData.getOrientation())
                        + " UNABLE TO BUILD";
                break;
        }

        return moveString;
    }

    private void checkMessages(PrintWriter out, BufferedReader in, String opponentPID,
                               ALE_AI AI1, ALE_AI AI2) throws Exception {
        if (MatchProtocol.gid2 == null) {
            getTwoMessages(in, opponentPID, AI1, AI2);
        } else {
            if ((!(MatchProtocol.gid1).equals("dead")) && (!(MatchProtocol.gid2).equals("dead"))) {
                getTwoMessages(in, opponentPID, AI1, AI2);
            } else {
                getOneMessage(in, opponentPID, AI1, AI2);
            }
        }
    }

    private void getTwoMessages(BufferedReader in, String opponentPID, ALE_AI AI1, ALE_AI AI2) throws Exception {
        String fromServer;
        String serverGID;
        String serverPID;
        MoveData moveData;

        //get two messages
        int i = 0;
        while (i < 2) {
            while ((fromServer = in.readLine()) == null){}
            //GAME x MOVE x PLAYER x PLACED GRASSLAND+ROCKY AT 1 -1 0 3 FOUNDED SETTLEMENT AT 2 -2 0
            if (fromServer.substring(0, 4).equals("GAME")) {
                System.out.println("Server: " + fromServer);
                String fromServerArr[] = fromServer.split(" ");
                serverGID = fromServerArr[1];
                serverPID = fromServerArr[5];

                if ((MatchProtocol.gid2 == null) && (!serverGID.equals(MatchProtocol.gid1))) {
                    MatchProtocol.gid2 = serverGID;
                }

                System.out.println("Get message " + i);
                System.out.println("Get two messages gid1: " + MatchProtocol.gid1);
                System.out.println("Get two messages gid2: " + MatchProtocol.gid2);

                if ((serverGID.equals(MatchProtocol.gid1)) && (serverPID.equals(opponentPID))) {
                    //send opponent's move to AI1
                    moveData = parseMessage(fromServerArr, in);
                    if (moveData.getTerrainsArray() != null)
                        AI1.updateOpponentMove(moveData);
                } else if ((serverGID.equals(MatchProtocol.gid2)) && (serverPID.equals(opponentPID))) {
                    //send opponent's move to AI2
                    moveData = parseMessage(fromServerArr, in);
                    if (moveData.getTerrainsArray() != null)
                        AI2.updateOpponentMove(moveData);
                } else {
                    //check if server says we lost; check which game if so.
                    moveData = parseMessage(fromServerArr, in);

                }
            }
            i++;
        }
    }

    private void getOneMessage(BufferedReader in, String opponentPID, ALE_AI AI1, ALE_AI AI2) throws Exception {
        String fromServer;
        String serverGID;
        String serverPID;
        MoveData moveData;

        while ((fromServer = in.readLine()) == null){}
        //GAME x MOVE x PLAYER x PLACED GRASSLAND+ROCKY AT 1 -1 0 3 FOUNDED SETTLEMENT AT 2 -2 0
        if (fromServer.substring(0, 4).equals("GAME")) {
            System.out.println("Server: " + fromServer);
            String fromServerArr[] = fromServer.split(" ");
            serverGID = fromServerArr[1];
            serverPID = fromServerArr[5];

            System.out.println("Get 1 message");
            System.out.println("Get one message gid1: " + MatchProtocol.gid1);
            System.out.println("Get one message gid2: " + MatchProtocol.gid2);

            if ((serverGID.equals(MatchProtocol.gid1)) && (serverPID.equals(opponentPID))) {
                //send opponent's move to AI1
                moveData = parseMessage(fromServerArr, in);
//                if (moveData.getTerrainsArray() != null)
                    AI1.updateOpponentMove(moveData);
            } else if ((serverGID.equals(MatchProtocol.gid2)) && (serverPID.equals(opponentPID))) {
                //send opponent's move to AI2
                moveData = parseMessage(fromServerArr, in);
//                if (moveData.getTerrainsArray() != null)
                    AI2.updateOpponentMove(moveData);
            } else {
                //check if server says we lost; check which game if so.
                moveData = parseMessage(fromServerArr, in);

            }
        }
    }

    private MoveData parseMessage(String[] fromServerArr, BufferedReader in) throws Exception{
        String serverGID;
        String fromServer;
        MoveData moveData;

        if (fromServerArr[6].equals("FORFEITED:") || fromServerArr[6].equals("LOST:")) {

            System.out.println("forfeited");

            moveData = new MoveData();

            serverGID = fromServerArr[1];

            if (serverGID.equals(MatchProtocol.gid1)) {
                MatchProtocol.gid1 = "dead";
            }
            if(serverGID.equals(MatchProtocol.gid2)) {
                MatchProtocol.gid2 = "dead";
            }

            if(MatchProtocol.gid2 != null && MatchProtocol.gid1 != null) {

                if (MatchProtocol.gid1.equals("dead") && MatchProtocol.gid2.equals("dead")) {
                    MatchProtocol.isMatchDone = true;
                }
//                else{
//                    fromServer = in.readLine();
//                    System.out.println("Server: " + fromServer);
//                }

            }
            return moveData;
        }
        else {
            String tile = fromServerArr[7];
            tile = tile.replaceAll("[+]", " ");
            String givenTerrains[] = tile.split(" ");
            givenTerrains[0] = givenTerrains[0].substring(0, 1).toUpperCase() + givenTerrains[0].substring(1).toLowerCase();
            givenTerrains[1] = givenTerrains[1].substring(0, 1).toUpperCase() + givenTerrains[1].substring(1).toLowerCase();

            if (givenTerrains[0].equals("Rock")) {
                givenTerrains[0] = "Rocky";
            }
            if (givenTerrains[1].equals("Rock")) {
                givenTerrains[1] = "Rocky";
            }

            if (givenTerrains[0].equals("Grass")) {
                givenTerrains[0] = "Grassland";
            }
            if (givenTerrains[1].equals("Grass")) {
                givenTerrains[1] = "Grassland";
            }
            String terrainsArray[] = {"Volcano", givenTerrains[0], givenTerrains[1]};
            String extendTerrain = "";

            if ((fromServerArr[13].equals("FOUNDED")) || (fromServerArr[13].equals("FOUND"))) {
                moveData = new MoveData(terrainsArray, Integer.parseInt(fromServerArr[9]),
                        Integer.parseInt(fromServerArr[10]), Integer.parseInt(fromServerArr[11]),
                        Integer.parseInt(fromServerArr[12]), 1, Integer.parseInt(fromServerArr[16]),
                        Integer.parseInt(fromServerArr[17]), Integer.parseInt(fromServerArr[18]));

                return moveData;
            } else if ((fromServerArr[13].equals("EXPANDED")) || (fromServerArr[13].equals("EXPAND"))) {
                if(fromServerArr[19].equals("GRASS")){
                    extendTerrain = "Grassland";
                }
                if(fromServerArr[19].equals("ROCK")){
                    extendTerrain = "Rocky";
                }
                if(fromServerArr[19].equals("LAKE")){
                    extendTerrain = "Lake";
                }
                if(fromServerArr[19].equals("JUNGLE")){
                    extendTerrain = "Jungle";
                }
                moveData = new MoveData(terrainsArray, Integer.parseInt(fromServerArr[9]),
                        Integer.parseInt(fromServerArr[10]), Integer.parseInt(fromServerArr[11]),
                        Integer.parseInt(fromServerArr[12]), 2, Integer.parseInt(fromServerArr[16]),
                        Integer.parseInt(fromServerArr[17]), Integer.parseInt(fromServerArr[18]),
                        extendTerrain);

                return moveData;
            } else if (fromServerArr[14].equals("TOTORO")) {
                moveData = new MoveData(terrainsArray, Integer.parseInt(fromServerArr[9]),
                        Integer.parseInt(fromServerArr[10]), Integer.parseInt(fromServerArr[11]),
                        Integer.parseInt(fromServerArr[12]), 3, Integer.parseInt(fromServerArr[17]),
                        Integer.parseInt(fromServerArr[18]), Integer.parseInt(fromServerArr[19]));

                return moveData;
            } else if (fromServerArr[14].equals("TIGER")) {
                moveData = new MoveData(terrainsArray, Integer.parseInt(fromServerArr[9]),
                        Integer.parseInt(fromServerArr[10]), Integer.parseInt(fromServerArr[11]),
                        Integer.parseInt(fromServerArr[12]), 4, Integer.parseInt(fromServerArr[17]),
                        Integer.parseInt(fromServerArr[18]), Integer.parseInt(fromServerArr[19]));

                return moveData;
            } else {
                moveData = new MoveData();
                return moveData;
            }
        }
    }
}