import java.io.*;
import java.net.*;

/**
 * Created by cyonkee on 4/3/17.
 */
public class AuthenticationProtocol {
    private String pid;

    public void authenticate(PrintWriter out, BufferedReader in) throws Exception{
        //BufferedReader stdIn =
          //      new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        //while ((fromServer = in.readLine()) == null) {
            fromServer = in.readLine();
            System.out.println("Server: " + fromServer);
            if(fromServer.substring(0,7).equals("WELCOME")) {
                fromUser = "ENTER THUNDERDOME heygang";
                out.println(fromUser);
                System.out.println("Client: " + fromUser);
            }

            fromServer = in.readLine();
            System.out.println("Server: " + fromServer);
            if(fromServer.substring(0,3).equals("TWO")) {
                fromUser = "I AM C C";
                out.println(fromUser);
                System.out.println("Client: " + fromUser);
            }

            fromServer = in.readLine();
            System.out.println("Server: " + fromServer);
            if(fromServer.substring(0,4).equals("WAIT")) {
                System.out.println("Server: " + fromServer);
            }
//            fromUser = stdIn.readLine();
//            //if (fromUser != null) {
//                out.println(fromUser);
//                System.out.println("Client: " + fromUser);
//            //}
        //}
    }
    public String getPID(){
        return pid;
    }
}
