/**
 * Created by alecasanas on 3/14/17.
 */
public class Meeple extends GamePiece{
    public Meeple(String color){
        requiredLevel = 1;
        requiredSettlementSize = 0;
        score = 1;
        this.color = color;
        name = "Meeple";
    }

    @Override
    public int calculateScore(int level){
        return (score * level);
    }
}
