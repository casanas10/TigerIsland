import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by cyonkee on 3/24/17.
 */
public class TurnsStep {
    private Game game;
    private String startingPlayer;

    @Given("^a brand new game$")
    public void aBrandNewGame() throws Throwable {
    }

    @When("^it’s time to begin$")
    public void itSTimeToBegin() throws Throwable {
        game = new Game();
    }

    @Then("^a player is chosen at random to start the game$")
    public void aPlayerIsChosenAtRandomToStartTheGame() throws Throwable {
        startingPlayer = game.getRandomStartingPlayer();
        Assert.assertNotNull(startingPlayer);
    }

    @Given("^a player to begin$")
    public void aPlayerToBegin() throws Throwable {
        startingPlayer = game.getRandomStartingPlayer();
    }

    @When("^that player’s turn is over$")
    public void thatPlayerSTurnIsOver() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the turn changes to the next player$")
    public void theTurnChangesToTheNextPlayer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^one player’s turn is currently going on$")
    public void onePlayerSTurnIsCurrentlyGoingOn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the next player’s turn begins$")
    public void theNextPlayerSTurnBegins() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
