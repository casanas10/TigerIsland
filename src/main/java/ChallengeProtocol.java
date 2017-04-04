import java.io.*;
import java.net.*;
/**
 * Created by cyonkee on 4/3/17.
 */
public class ChallengeProtocol {
    private int rounds;
    public void playChallenges(PrintWriter out, BufferedReader in) throws Exception{
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        int readAttempts = 0;
        while ((fromServer = in.readLine()) == null && readAttempts < 1000) {
            readAttempts++;
            Thread.sleep(50);
            //Add system exit
        }

        if(fromServer.substring(0,3).equals("NEW")){
            String fromServerArr[] = fromServer.split(fromServer);
            rounds = Integer.parseInt(fromServerArr[6]);
        }
        System.out.println("Server: " + fromServer);

        for(int i=0; i<rounds; i++){
            RoundProtocol round = new RoundProtocol();
            round.playRound(out,in);
        }


    }
}
