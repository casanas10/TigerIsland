import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by alecasanas on 3/16/17.
 */
public class MeeplesStep {

    private Game game;

    @cucumber.api.java.Before
    public void setUp(){
        game = new Game();
    }

    @Given("^a new game is created$")
    public void aNewGameIsCreated() throws Throwable {
        System.out.println("Create a new game");
    }

    @When("^the game begins$")
    public void theGameBegins() throws Throwable {
        System.out.println("Start game");
    }

    @Then("^(\\d+) meeples are successfully created with the correct properties$")
    public void meeplesAreSuccessfullyCreatedWithTheCorrectProperties(int meeples) throws Throwable {
        Assert.assertEquals(meeples, game.getRemainingMeeples());
    }

}
