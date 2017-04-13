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

        Assert.assertEquals("Totoro", ai.getIslandMap().getHex(19700).getPieceOnHex());
    }

    @Test
    public void ableToExpand() {

        String[] terrains = ai.getIslandMap().getNewTile();
        ai.setTerrainsArray(terrains);

        System.out.println(ai.ableToExpand());

        ai.getIslandMap().addTileToMap(19500, 60);
        ai.getIslandMap().getHex(19701).setTerrain("Grassland");
        ai.getIslandMap().getHex(19501).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19501, ai.getAiPlayer());

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        System.out.println(ai.ableToExpand());

        ai.getIslandMap().addTileToMap(19499, 180);
        ai.getIslandMap().getHex(19300).setTerrain("Rocky");
        ai.getIslandMap().getHex(19299).setTerrain("Rocky");
        ai.getIslandMap().getSettlementObj().addSettlement(19299, ai.getAiPlayer());

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        ai.ableToExpand();

        ai.expandSettlement();

        Assert.assertTrue(ai.ableToExpand());
    }


    @Test
    public void ExpandingTest1() {

        String[] terrains = ai.getIslandMap().getNewTile();
        ai.setTerrainsArray(terrains);

        System.out.println(ai.ableToExpand());

        ai.getIslandMap().addTileToMap(19500, 60);
        ai.getIslandMap().getHex(19701).setTerrain("Grassland");
        ai.getIslandMap().getHex(19501).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19501, ai.getAiPlayer());

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());
        System.out.println(ai.ableToExpand());

        ai.getIslandMap().addTileToMap(19499, 180);
        ai.getIslandMap().getHex(19300).setTerrain("Rocky");
        ai.getIslandMap().getHex(19299).setTerrain("Rocky");
        ai.getIslandMap().getSettlementObj().addSettlement(19299, ai.getServerPlayer());

        ai.getIslandMap().getSettlementObj().addSettlement(19701, ai.getAiPlayer());

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19900, 60);
        ai.getIslandMap().getHex(20101).setTerrain("Rocky");
        ai.getIslandMap().getHex(19901).setTerrain("Jungle");

        ai.getIslandMap().getSettlementObj().addSettlement(19700, ai.getAiPlayer());

        ai.play();

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        Assert.assertTrue(ai.ableToExpand());

    }


    @Test
    public void findSettlementsWithTotoros() {

        String[] terrains = ai.getIslandMap().getNewTile();
        ai.setTerrainsArray(terrains);

        ai.getIslandMap().addTileToMap(19500, 60);
        ai.getIslandMap().getHex(19701).setTerrain("Grassland");
        ai.getIslandMap().getHex(19501).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19501, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19701, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19700, ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19101, 0);
        ai.getIslandMap().getHex(19301).setTerrain("Rocky");
        ai.getIslandMap().getHex(19302).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19301, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19302, ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19499, 180);
        ai.getIslandMap().getHex(19300).setTerrain("Grassland");
        ai.getIslandMap().getHex(19299).setTerrain("Grassland");
        ai.buildATotoroSantuary();

        System.out.println(ai.getIslandMap().getHex(19300).getPieceOnHex());
        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        int settlementID = ai.isThereSettlementThatHasTotoroAlready(ai.getAiPlayer());

        Assert.assertEquals(0, settlementID);
    }


    @Test
    public void doesTotoroOnlyTouchOneHexInSettlement() {

        String[] terrains = ai.getIslandMap().getNewTile();
        ai.setTerrainsArray(terrains);

        ai.getIslandMap().addTileToMap(19500, 60);
        ai.getIslandMap().getHex(19701).setTerrain("Grassland");
        ai.getIslandMap().getHex(19501).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19501, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19701, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19700, ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19101, 0);
        ai.getIslandMap().getHex(19301).setTerrain("Rocky");
        ai.getIslandMap().getHex(19302).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19301, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19302, ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19499, 180);
        ai.getIslandMap().getHex(19300).setTerrain("Grassland");
        ai.getIslandMap().getHex(19299).setTerrain("Grassland");
//        ai.getIslandMap().getSettlementObj().addSettlement(19299, ai.getAiPlayer());  //this will return false since more than 2 hexes touches totoro

        ai.buildATotoroSantuary();

        System.out.println(ai.getIslandMap().getHex(19300).getPieceOnHex());
        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        int settlementID = ai.isThereSettlementThatHasTotoroAlready(ai.getAiPlayer());

        boolean touchesOneHex = ai.itOnlyTouchingOneHexInTheSettlement(settlementID);

        Assert.assertTrue(touchesOneHex);
    }

    @Test
    public void nukeHexNextToTotoro() {

        String[] terrains = ai.getIslandMap().getNewTile();
        ai.setTerrainsArray(terrains);

        ai.getIslandMap().addTileToMap(19500, 60);
        ai.getIslandMap().getHex(19701).setTerrain("Grassland");
        ai.getIslandMap().getHex(19501).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19501, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19701, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19700, ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19101, 0);
        ai.getIslandMap().getHex(19301).setTerrain("Rocky");
        ai.getIslandMap().getHex(19302).setTerrain("Grassland");
        ai.getIslandMap().getSettlementObj().addSettlement(19301, ai.getAiPlayer());
        ai.getIslandMap().getSettlementObj().addSettlement(19302, ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19499, 180);
        ai.getIslandMap().getHex(19300).setTerrain("Grassland");
        ai.getIslandMap().getHex(19299).setTerrain("Grassland");
//        ai.getIslandMap().getSettlementObj().addSettlement(19299, ai.getAiPlayer());  //this will return false since more than 2 hexes touches totoro

        ai.buildATotoroSantuary();

        System.out.println(ai.getIslandMap().getHex(19300).getPieceOnHex());
        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        ai.getIslandMap().addTileToMap(19100, 180);

        ai.play();

        ai.getIslandMap().getSettlementObj().printAllSettlements(ai.getAiPlayer());

        Assert.assertTrue(ai.getIslandMap().getSettlementObj().getSettlementID(19301) == -1);
    }

    @Test
    public void addMeepleToAnExistingSettlementTest(){


    }
}

