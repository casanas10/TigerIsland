import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ale on 3/23/17.
 */
public class PlacementTileStep {

    private IslandMap islandMap;

    @Before
    public void setUp() {
        islandMap = new IslandMap();
    }

    @Given("^a tile is already place in the board$")
    public void aTileIsAlreadyPlaceInTheBoard() throws Throwable {

    }

    @When("^you place a tile$")
    public void youPlaceATile() throws Throwable {

    }

    @Then("^the tile is successfully placed in the map$")
    public void theTileIsSuccessfullyPlacedInTheMap() throws Throwable {

        Assert.assertTrue(islandMap.addTileToMap(402,0));
    }

    @When("^you place a tile next to another tile$")
    public void youPlaceATileNextToAnotherTile() throws Throwable {
        islandMap.addTileToMap(402,0);
    }

    @Then("^the tile is added to the map$")
    public void theTileIsAddedToTheMap() throws Throwable {
        Assert.assertTrue(islandMap.addTileToMap(404,0));
    }

    @When("^you place a tile directly on top of another tile$")
    public void youPlaceATileDirectlyOnTopOfAnotherTile() throws Throwable {
        islandMap.addTileToMap(402,0);
    }

    @Then("^the placement fails$")
    public void thePlacementFails() throws Throwable {
        Assert.assertFalse(islandMap.addTileToMap(402,0));
    }

    @When("^you place the tile unnconnected to another tile$")
    public void youPlaceTheTileUnnconnectedToAnotherTile() throws Throwable {
        islandMap.addTileToMap(800,0);
    }

    @Then("^the unnconnected placement fails$")
    public void theUnnconnectedPlacementFails() throws Throwable {
        Assert.assertFalse(islandMap.addTileToMap(900,0));
    }
}
