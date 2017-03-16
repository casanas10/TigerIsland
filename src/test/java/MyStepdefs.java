import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by alecasanas on 3/16/17.
 */
public class MyStepdefs {

    @Given("^something$")
    public void something() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given works");
    }

    @When("^I run the program$")
    public void iRunTheProgram() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When works");
    }


    @Then("^run should be successful$")
    public void runShouldBeSuccessful() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then works");
    }

}
