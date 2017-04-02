/**
 * Created by cyonkee on 3/14/17.
 */
public class Totoro extends GamePiece {
    public Totoro(String color){
        requiredLevel = 1;
        requiredSettlementSize = 5;
        score = 200;
        this.color = color;
        name = "Totoro";
    }

    @Override
    public int calculateScore(int level){
        return score;
    }
}
