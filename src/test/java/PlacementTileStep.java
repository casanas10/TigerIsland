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
    private boolean isPlacedSuccessfully;

    @Given("^a tile is already place in the board$")
    public void aTileIsAlreadyPlaceInTheBoard() throws Throwable {
        islandMap = new IslandMap();
    }

    @When("^you place a tile$")
    public void youPlaceATile() throws Throwable {
        isPlacedSuccessfully = islandMap.addTileToMap(402,0);
    }

    @Then("^the tile is successfully placed in the map$")
    public void theTileIsSuccessfullyPlacedInTheMap() throws Throwable {
        Assert.assertTrue(isPlacedSuccessfully);
    }

    @Given("^a tile is already on the board$")
    public void aTileIsAlreadyOnTheBoard() throws Throwable {
        islandMap = new IslandMap();
        islandMap.addTileToMap(402, 0);
    }

    @When("^you place a new tile that overlaps the other$")
    public void youPlaceANewTileThatOverlapsTheOther() throws Throwable {
        isPlacedSuccessfully = islandMap.addTileToMap(402,0);
    }

    @Then("^the tile is unsuccessfully placed in the map$")
    public void theTileIsUnsuccessfullyPlacedInTheMap() throws Throwable {
        Assert.assertFalse(isPlacedSuccessfully);
    }

    @When("^you place a new tile that is adjacent to the other$")
    public void youPlaceANewTileThatIsAdjacentToTheOther() throws Throwable {
        isPlacedSuccessfully = islandMap.addTileToMap(403,180);
    }
}
