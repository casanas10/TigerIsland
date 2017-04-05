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

        //Server: NEW MATCH BEGINNING NOW YOUR OPPONENT IS PLAYER <pid>
        fromServer = in.readLine();
        if(fromServer.substring(0,3).equals("NEW")){
            opponentPID = fromServer.substring(48);
            System.out.println("Opponent PID: " + opponentPID);

            System.out.println("Server: " + fromServer);

            MyRunnable R1 = new MyRunnable("Thread for Game 1");
            R1.start();
            MyRunnable R2 = new MyRunnable("Thread for Game 2");
            R2.start();

            for(int i=0; i<48; i++) {
                MoveProtocol move = new MoveProtocol();
                move.makeMove(out, in, R1, R2, i + 1);
            }
        }
    }
}
