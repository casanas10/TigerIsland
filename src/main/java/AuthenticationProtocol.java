import java.io.*;
import java.net.*;

/**
 * Created by cyonkee on 4/3/17.
 */
public class AuthenticationProtocol {
    private String pid;

    public void authenticate(PrintWriter out, BufferedReader in) throws Exception{
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
            if(fromServer.substring(0,4).equals("WAIT")) {
                if (fromServer.substring(0, 33).equals("WAIT FOR THE TOURNAMENT TO BEGIN ")) {
                    pid = fromServer.substring(33);
                    //System.out.println("PID: " + pid);
                    break;
                }
            }
            fromUser = stdIn.readLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
            }
        }
    }
    public String getPID(){
        return pid;
    }
}
