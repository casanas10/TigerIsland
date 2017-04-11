/**
 * Created by cyonkee on 4/2/17.
 */
import java.io.*;
import java.net.*;

public class Client {
    private String tournamentPW;
    private String username;
    private String password;


    public void OpenClient() throws Exception{
        String hostName = "10.136.15.20";
        int portNumber = 6969;

        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {

            TournamentProtocol tournament = new TournamentProtocol();
            tournament.playTournament(out,in,tournamentPW,username,password);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }

    public void setTournamentPassword(String tournamentPW){
        this.tournamentPW = tournamentPW;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
