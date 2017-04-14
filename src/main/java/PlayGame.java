/**
 * Created by ale on 4/11/17.
 */
public class PlayGame {

    private ALE_AI ai = new ALE_AI();
    private ALE_AI serverAI = new ALE_AI();

    private boolean aiTurn = true;

    MoveData moveData = new MoveData();

    public PlayGame(){

        while(ai.getAiPlayer().getRemainingMeeples() > 0){

            if (aiTurn) {

                ai.setTerrainsArray(ai.getIslandMap().getNewTile());
                moveData = ai.play();

            } else {

                moveData = ai.getNewMove();
                moveData.setTerrainsArray(ai.getIslandMap().getNewTile());
                ai.updateOpponentMove(moveData);
            }

            ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

            aiTurnToPlay();

        }
    }

    public boolean aiTurnToPlay() {
        return aiTurn = !aiTurn;
    }

}
