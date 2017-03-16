import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by alecasanas on 3/16/17.
 */
public class TurnsStep {

    @Given("^A brand new game$")
    public void aBrandNewGame() throws Throwable {
        System.out.println("hi");
    }

    @When("^It’s time to begin$")
    public void itSTimeToBegin() throws Throwable {
        System.out.println("hi");
    }

    @Then("^A player is chosen at random to start the game$")
    public void aPlayerIsChosenAtRandomToStartTheGame() throws Throwable {
        System.out.println("hi");
    }
}
