/**
 * Created by Eric on 3/24/2017.
 */
public abstract class GamePiece {
    protected int requiredLevel;
    protected int requiredSettlementSize;
    protected int score;
    protected String color;
    protected String name;

    public String getColor(){
        return this.color;
    }

    public String getName(){
        return this.name;
    }

    public int getRequiredLevel(){
        return this.requiredLevel;
    }

    public int getRequiredSettlementSize(){
        return this.requiredSettlementSize;
    }

    public int calculateScore(int level){
        return score;
    }
}
