/**
 * Created by cyonkee on 4/2/17.
 */
import java.io.*;
import java.net.*;

public class Client {

    public void OpenClient() throws Exception{
        //String hostName = "192.168.1.142";
        //int portNumber = 6969;
        String hostName = "10.136.65.163";
        int portNumber = 6066;

        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {

            TournamentProtocol tournament = new TournamentProtocol();
            tournament.playTournament(out,in);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}
