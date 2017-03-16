import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by alecasanas on 3/16/17.
 */
public class GameStep {

    private Game game;

    @Given("^Nothing has yet happened$")
    public void nothingHasYetHappened() throws Throwable {
        System.out.println("Nothing has happened");
    }

    @When("^The game initiates$")
    public void theGameInitiates() throws Throwable {
        game = new Game();
    }

    @Then("^A new game is successfully created$")
    public void aNewGameIsSuccessfullyCreated() throws Throwable {
        Assert.assertNotNull(game);
    }


}
