import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by cyonkee on 4/4/17.
 */
public class MoveProtocol {
    private String currentGID;

    public void makeMove(PrintWriter out, BufferedReader in, MyRunnable r1, MyRunnable r2) throws Exception {
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        //MAKE YOUR MOVE IN GAME <gid> WITHIN <time_move> SECOND(S): MOVE <#> PLACE <tile>
        fromServer = in.readLine();
        if(fromServer.substring(0,4).equals("MAKE")) {
            String fromServerArr[] = fromServer.split(" ");
            if(MatchProtocol.gid1 == null){
                MatchProtocol.gid1 = fromServerArr[5];
                getTile(fromServerArr[12],MatchProtocol.gid1);
            }
            else if((MatchProtocol.gid2 == null) && (fromServerArr[5] != MatchProtocol.gid1)){
                MatchProtocol.gid2 = fromServerArr[5];
                getTile(fromServerArr[12],MatchProtocol.gid2);
            }
            else{
                currentGID = fromServerArr[5];
                getTile(fromServerArr[12],currentGID);
            }
            System.out.println("Server: " + fromServer);
        }
    }

    private void getTile(String tile, String gid) {
        tile = tile.replaceAll("[+]"," +");
        String givenTerrains[] = tile.split(" +");
        String terrainsArray[] = {"Volcano",givenTerrains[0],givenTerrains[1]};

        if(gid == MatchProtocol.gid1){
            //AI1 gets terrains
        }
        if(gid == MatchProtocol.gid2){
            //AI2 gets terrains
        }
    }
}
