import java.io.*;
import java.net.*;

/**
 * Created by cyonkee on 4/3/17.
 */
public class AuthenticationProtocol {
    private String pid;

    public void authenticate(PrintWriter out, BufferedReader in, String tournamentPW, String username, String password) throws Exception{
        //BufferedReader stdIn =
          //      new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);
        if(fromServer.substring(0,7).equals("WELCOME")) {
            fromUser = "ENTER THUNDERDOME " + tournamentPW;
            out.println(fromUser);
            System.out.println("Client: " + fromUser);
        }

        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);
        if(fromServer.substring(0,3).equals("TWO")) {
            fromUser = "I AM " + username + " " + password;
            out.println(fromUser);
            System.out.println("Client: " + fromUser);
        }

        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);
        if(fromServer.substring(0,4).equals("WAIT")) {
            System.out.println("Server: " + fromServer);
        }

    }
    public String getPID(){
        return pid;
    }
}
