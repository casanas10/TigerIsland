import java.io.*;
import java.net.*;
/**
 * Created by cyonkee on 4/3/17.
 */
public class RoundProtocol {

    public void playRound(PrintWriter out, BufferedReader in) throws Exception{
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        //Server: BEGIN ROUND <rid> OF <rounds>
        fromServer = in.readLine();
        if(fromServer.substring(0,5).equals("BEGIN")){
            System.out.println("Server: " + fromServer);
            MatchProtocol match = new MatchProtocol();
            match.playMatch(out,in);
        }

        //Server: END OF ROUND <rid> OF <rounds> (WAIT FOR THE NEXT MATCH)
        fromServer = in.readLine();
        if(fromServer.substring(0,4).equals("END")){
            System.out.println("Server: " + fromServer);
        }

    }
}