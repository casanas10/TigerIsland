import java.io.*;

/**
 * Created by cyonkee on 4/4/17.
 */
public class MatchProtocol {
    private String opponentPID;
    public static String gid1 = null;
    public static String gid2 = null;
    public static boolean isMatchDone = false;

    public void playMatch(PrintWriter out, BufferedReader in) throws Exception{
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) == null){}
        //Server: NEW MATCH BEGINNING NOW YOUR OPPONENT IS PLAYER <pid>
        if(fromServer.substring(0,3).equals("NEW")){
            opponentPID = fromServer.substring(48);
            System.out.println("Opponent PID: " + opponentPID);

            System.out.println("Server: " + fromServer);

            ALE_AI AI1 = new ALE_AI();
            ALE_AI AI2 = new ALE_AI();

            for(int i=0; i<48; i++) {
                if(isMatchDone){
                    break;
                }
                MoveProtocol move = new MoveProtocol();
                move.makeMove(out, in, AI1, AI2, opponentPID);
            }
        }

        while ((fromServer = in.readLine()) == null){}
        //Server: GAME <gid> OVER PLAYER <pid> <score> PLAYER <pid> <score>
        if(fromServer.substring(0,4).equals("GAME")){
            System.out.println("Server: " + fromServer);
        }
        while ((fromServer = in.readLine()) == null){}
        //Server: GAME <gid> OVER PLAYER <pid> <score> PLAYER <pid> <score>
        if(fromServer.substring(0,4).equals("GAME")){
            System.out.println("Server: " + fromServer);
        }

        gid1 = null;
        gid2 = null;
        isMatchDone = false;
    }
}
