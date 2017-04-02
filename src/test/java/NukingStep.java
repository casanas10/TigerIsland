import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * Created by alecasanas on 3/16/17.
 */
public class NukingStep {

    private IslandMap islandMap = new IslandMap();
    private Player player = new Player("White",0);
    private Builder builder = new Builder();
    Nuking nuking = new Nuking();
    HexGrid hexGrid = islandMap.getHexGrid();
    Settlement settlement = islandMap.getSettlementObj();

    boolean isNukeSuccessfull;

    @Given("^There are tiles on the board and it is the players turn to place a tile$")
    public void thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile() throws Throwable {
        islandMap.addTileToMap(606, 0);
        islandMap.addTileToMap(607, 60);
        islandMap.addTileToMap(809,0);
        builder.build(player, islandMap,1, 807);

        islandMap.addTileToMap(609,60);
        islandMap.addTileToMap(611,0);
        islandMap.addTileToMap(612,60);
        islandMap.addTileToMap(614,0);
        islandMap.addTileToMap(615,60);

        islandMap.addTileToMap(207,0);

        builder.build(player,islandMap,1,810);
        builder.build(player,islandMap,1,811);
        builder.build(player,islandMap,1,812);
        builder.build(player,islandMap,1,813);
        builder.build(player,islandMap,1,814);
        //build a Totoro sanctuary
        builder.build(player,islandMap,3,815);

        //build a size 2 settlement
        builder.build(player,islandMap,1,407);
        builder.build(player,islandMap,1,408);
    }

    @When("^The tile is placed on another tile and the volcanoes do not match up$")
    public void theTileIsPlacedOnAnotherTileAndTheVolcanoesDoNotMatchUp() throws Throwable {
        isNukeSuccessfull = islandMap.addTileToMap(808, 300);
    }

    @Then("^The nuking fails$")
    public void theNukingFails() throws Throwable {
        Assert.assertEquals(false, isNukeSuccessfull);
    }

    @When("^The tile is placed on a single tile$")
    public void theTileIsPlacedOnASingleTile() throws Throwable {
        isNukeSuccessfull = islandMap.addTileToMap(606, 0);
    }

    @When("^The tile is placed on tiles of various levels$")
    public void theTileIsPlacedOnTilesOfVariousLevels() throws Throwable {
        isNukeSuccessfull = islandMap.addTileToMap(606, 300);
    }

    @When("^The tile is placed on a hex containing a Totoro$")
    public void theTileIsPlacedOnAHexContainingATotoro() throws Throwable {
        isNukeSuccessfull = islandMap.addTileToMap(615, 0);
    }

    @When("^The tile is placed on a hex with a size one settlement$")
    public void theTileIsPlacedOnAHexWithASizeOneSettlement() throws Throwable {
        isNukeSuccessfull = islandMap.addTileToMap(607, 0);
    }

    @When("^The nuking tile completely wipes out a settlement$")
    public void theNukingTileCompletelyWipesOutASettlement() throws Throwable {
        isNukeSuccessfull = islandMap.addTileToMap(607, 180);
    }

    @When("^The tile is placed and all of the nuking conditions are satisfied$")
    public void theTileIsPlacedAndAllOfTheNukingConditionsAreSatisfied() throws Throwable {
        isNukeSuccessfull = islandMap.addTileToMap(809, 300);
    }

    @Then("^The nuking is successful$")
    public void theNukingIsSuccessful() throws Throwable {
        Assert.assertEquals(true, isNukeSuccessfull);
    }
}
