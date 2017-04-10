import java.io.*;
import java.net.*;
/**
 * Created by cyonkee on 4/3/17.
 */
public class TournamentProtocol {

    public void playTournament(PrintWriter out, BufferedReader in) throws Exception{
        System.out.println("ABOUT TO AUTHENTICATE");
        AuthenticationProtocol authentication = new AuthenticationProtocol();
        authentication.authenticate(out,in);

        System.out.println("STARTING CHALLENGE PROTOCOL");
        ChallengeProtocol challenge = new ChallengeProtocol();
        challenge.playChallenge(out,in);
    }
}
