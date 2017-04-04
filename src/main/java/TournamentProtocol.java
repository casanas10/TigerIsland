import java.io.*;
import java.net.*;
/**
 * Created by cyonkee on 4/3/17.
 */
public class TournamentProtocol {

    public void playTournament(PrintWriter out, BufferedReader in) throws Exception{
        AuthenticationProtocol authentication = new AuthenticationProtocol();
        authentication.authenticate(out,in);

        ChallengeProtocol challenge = new ChallengeProtocol();
        challenge.playChallenges(out,in);
    }
}
