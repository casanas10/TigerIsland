import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.junit.Assert;
/**
 * Created by NatalieGoldstein on 3/16/17.
 */
public class PlayerStep {

    private Player player;
    @cucumber.api.java.Before

    public void set(){
        player = new Player("White", 0);
    }


    @Given("^A new game is created")
    public void aNewGameIsCreated() throws Throwable{
        System.out.println("A game is created");
    }

    @When("^The game starts")
    public void theGameStarts() throws Throwable{
        System.out.println("The game starts");

    }

    @Then("^A player is successfully created with a start score of (\\d+)")
    public void playerCreation(int start) throws Throwable{
    Assert.assertEquals(start, player.getCurrentScore());

    }


    @And("^The player is assigned a color \"([^\"]*)\"$")
    public void thePlayerIsAssignedAColor(String color) throws Throwable {
       Assert.assertEquals(color, player.getPlayerColor());
    }
}


