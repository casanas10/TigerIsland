/**
 * Created by cyonkee on 4/6/17.
 */
public class OpponentMoveThread extends Thread {
    private MoveData moveData;
    private AI ai;

    public void setMoveData(MoveData moveData){
        this.moveData = moveData;
    }
    public void setAI(AI ai){
        this.ai = ai;
    }

    public void run(){
        System.out.println("Making move from OpponentMoveThread...");
        ai.updateOpponentMove(moveData);
    }
}
