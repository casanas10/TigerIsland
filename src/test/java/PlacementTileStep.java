import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ale on 3/23/17.
 */
public class PlacementTileStep {

    private IslandMap islandMap;

    @Given("^a tile is already place in the board$")
    public void aTileIsAlreadyPlaceInTheBoard() throws Throwable {
        islandMap = new IslandMap();
    }

    @When("^you place a tile$")
    public void youPlaceATile() throws Throwable {
        islandMap.addTileToMap(402,0);
    }

    @Then("^the tile is successfully placed in the map$")
    public void theTileIsSuccessfullyPlacedInTheMap() throws Throwable {
        Assert.assertTrue(islandMap.addTileToMap(402,0));
    }
}
