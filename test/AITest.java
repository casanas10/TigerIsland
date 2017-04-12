/**
 * Created by alecasanas on 4/7/17.
 */
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Val on 4/3/2017.
 */
public class AITest {

    private ALE_AI ai = new ALE_AI();

    private boolean aiTurn = true;

    MoveData moveData = new MoveData();

    public boolean aiTurnToPlay() {
        return aiTurn = !aiTurn;
    }

    @Test
    public void PlayGame() {

//        while(ai.getAiPlayer().getRemainingMeeples() > 0){
//
//            if (aiTurn) {
//
//                moveData = ai.play();
//
//            } else {
//
//                moveData = ai.getNewMove();
//                moveData.setTerrainsArray(ai.getIslandMap().getNewTile());
//                ai.updateOpponentMove(moveData);
//            }
//
//            ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());
//
//            aiTurnToPlay();
//
//        }

    }

    @Test
    public void getAllSettlement5orMore(){

        ai.getIslandMap().getSettlementObj().addSettlement(19701, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19702, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19703, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19503, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19304, ai.getAiPlayer());

        ai.getIslandMap().getSettlementObj().addSettlement(19502, ai.getServerPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19102, ai.getServerPlayer());

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        int id = ai.findAISettlements5orGreater(ai.getAiPlayer());

        Assert.assertEquals(0, id);
    }


    @Test
    public void addTotoroIfYouSeeSettlementOfSize5orMore(){

        ai.getIslandMap().getSettlementObj().addSettlement(19701, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19702, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19703, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19503, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19304, ai.getAiPlayer());

        ai.getIslandMap().getSettlementObj().addSettlement(19502, ai.getServerPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19102, ai.getServerPlayer());

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        String[] terrains = ai.getIslandMap().getNewTile();
        ai.setTerrainsArray(terrains);
        int id = ai.findAISettlements5orGreater(ai.getAiPlayer());

        ai.buildATotoroSantuary();
    }

    @Test
    public void expandSettlements(){

        ai.getIslandMap().addTileToMap(19900, 60);
        ai.getIslandMap().getHex(19701).setTerrain("Lake");
        ai.getIslandMap().getHex(19901).setTerrain("Rocky");
        ai.getIslandMap().getSettlementObj().addSettlement(19701, ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19300, 0);
        ai.getIslandMap().getHex(19499).setTerrain("Lake");
        ai.getIslandMap().getHex(19500).setTerrain("Lake");

        String[] terrains = ai.getIslandMap().getNewTile();
        ai.setTerrainsArray(terrains);

        //ai.expandSettlement();

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());
    }
}

