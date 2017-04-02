/**
 * Created by alecasanas on 3/22/17.
 */
public class Tiger extends GamePiece{
    public Tiger(String color){
        requiredLevel = 3;
        requiredSettlementSize = 1;
        score = 75;
        this.color = color;
        name = "Tiger";
    }

    @Override
    public int calculateScore(int level){
        return score;
    }
}
