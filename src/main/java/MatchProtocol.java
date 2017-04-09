import java.io.*;
import java.net.*;
/**
 * Created by cyonkee on 4/4/17.
 */
public class MatchProtocol {
    private String opponentPID;
    public static String gid1 = null;
    public static String gid2 = null;

    public void playMatch(PrintWriter out, BufferedReader in) throws Exception{
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        int readAttempts = 0;
        while ((fromServer = in.readLine()) == null && readAttempts < 1000) {
            readAttempts++;
            Thread.sleep(50);
            //maybe add system exit
        }
        //Server: NEW MATCH BEGINNING NOW YOUR OPPONENT IS PLAYER <pid>
        if(fromServer.substring(0,3).equals("NEW")){
            opponentPID = fromServer.substring(48);
            System.out.println("Opponent PID: " + opponentPID);

            System.out.println("Server: " + fromServer);

            AI AI1 = new AI();
            AI AI2 = new AI();

            for(int i=0; i<48; i++) {
                MoveProtocol move = new MoveProtocol();
                move.makeMove(out, in, AI1, AI2, i, opponentPID);
            }
        }

        readAttempts = 0;
        while ((fromServer = in.readLine()) == null && readAttempts < 1000) {
            readAttempts++;
            Thread.sleep(50);
            //maybe add system exit
        }
        //Server: GAME <gid> OVER PLAYER <pid> <score> PLAYER <pid> <score>
        if(fromServer.substring(0,4).equals("GAME")){
            System.out.println("Server: " + fromServer);
        }
        
        gid1 = null;
        gid2 = null;
    }
}
