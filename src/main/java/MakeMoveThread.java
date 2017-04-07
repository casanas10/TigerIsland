/**
 * Created by cyonkee on 4/6/17.
 */
public class MakeMoveThread extends Thread{
    private String[] terrainsArray;
    private AI ai;
    private volatile MoveData moveData;

    public void setTerrains(String[] terrainsArray){
        this.terrainsArray = terrainsArray;
    }
    public void setAI(AI ai){
        this.ai = ai;
    }

    public MoveData getMoveData(){
        return moveData;
    }

    public void run(){
        System.out.println("Making move from MakeMoveThread...");
        moveData = ai.makeMove(terrainsArray);
    }

}
