import java.io.*;
import java.net.*;
/**
 * Created by cyonkee on 4/3/17.
 */
public class ChallengeProtocol {
    private int rounds;

    public void playChallenge(PrintWriter out, BufferedReader in) throws Exception{
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        int readAttempts = 0;
        while ((fromServer = in.readLine()) == null && readAttempts < 1000) {
            readAttempts++;
            Thread.sleep(50);
            //maybe add system exit
        }
        System.out.println("Passed the while loop");

        //Server: NEW CHALLENGE <cid> YOU WILL PLAY <rounds> MATCH
        if(fromServer != null) {
            if (fromServer.substring(0, 3).equals("NEW")) {
                String fromServerArr[] = fromServer.split(" ");
                rounds = Integer.parseInt(fromServerArr[6]);
            }
            System.out.println("Server: " + fromServer);
        }

        //play rounds for this challenge
        for(int i=0; i<rounds; i++){
            RoundProtocol round = new RoundProtocol();
            round.playRound(out,in);
        }

        readAttempts = 0;
        while ((fromServer = in.readLine()) == null && readAttempts < 1000) {
            readAttempts++;
            Thread.sleep(50);
            //maybe add system exit
        }

        //Check for end of challenges or continuation
        if(fromServer == "WAIT FOR THE NEXT CHALLENGE TO BEGIN"){
            System.out.println("Server: " + fromServer);
            playChallenge(out,in);
        }
        else if(fromServer == "END OF CHALLENGES"){
            System.out.println("Server: " + fromServer);

            readAttempts = 0;
            while ((fromServer = in.readLine()) == null && readAttempts < 1000) {
                readAttempts++;
                Thread.sleep(50);
                //maybe add system exit
            }
            //Server: THANK YOU FOR PLAYING! GOODBYE
            fromServer = in.readLine();
            System.out.println("Server: " + fromServer);
            System.exit(1);
        }

    }
}
