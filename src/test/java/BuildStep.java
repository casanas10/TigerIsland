import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by Eric on 4/2/2017.
 */
public class BuildStep {
    private Builder builder;
    IslandMap islandMap;
    Game game;
    ExtendSettlement extend;
    private int buildChoice = 0;
    private int hexChoice = 0;

    public void setUp(){
        builder = new Builder();
        islandMap = new IslandMap();
        game = new Game();
        islandMap.addTileToMap(606,0);
        islandMap.addTileToMap(607,60);
    }

    @Given("^A player chooses to place a meeple and create a new settlement$")
    public void aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement() throws Throwable {
        buildChoice = 1;
        Assert.assertEquals(1,buildChoice);
    }

    @When("^The player places the meeple on a volcano hex$")
    public void thePlayerPlacesTheMeepleOnAVolcanoHex() throws Throwable {
        setUp();
        boolean buildSuccessful;
        hexChoice = 606;
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false,buildSuccessful);
    }

    @When("^The player places the meeple on an already occupied hex$")
    public void thePlayerPlacesTheMeepleOnAnAlreadyOccupiedHex() throws Throwable {
        setUp();
        boolean buildSuccessful;
        builder.build(game.getBlackPlayer(),islandMap,1,806);
        hexChoice = 806;
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false,buildSuccessful);
    }

    @When("^The player places the meeple on a hex that is not level (\\d+)$")
    public void thePlayerPlacesTheMeepleOnAHexThatIsNotLevel(int arg0) throws Throwable {
        setUp();
        boolean buildSuccessful;
        Hex hex = islandMap.getHex(807);
        hex.incrementLevel();
        hexChoice = 807;
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false, buildSuccessful);
    }

    @Then("^Placing the meeple fails and a warning message is shown$")
    public void placingTheMeepleFailsAndAWarningMessageIsShown() throws Throwable {
        System.out.println("Invalid hex to place a new settlement");
    }

    @Given("^A player chooses to expand$")
    public void aPlayerChoosesToExpand() throws Throwable {
        buildChoice = 2;
        Assert.assertEquals(2, buildChoice);
    }

    @When("^The player selects a terrain to expand on to but they don’t have enough meeples$")
    public void thePlayerSelectsATerrainToExpandOnToButTheyDonTHaveEnoughMeeples() throws Throwable {
        setUp();
        GamePiece gamepiece;
        boolean extendTrue;

        for(int i=0;i<19;i++){
            gamepiece = game.getBlackPlayer().placeGamePiece("Meeple");
        }

        builder.build(game.getBlackPlayer(),islandMap,1,806);

        extend = new ExtendSettlement(806,islandMap,game.getBlackPlayer());
        extendTrue = extend.extendOnTerrain("Lake");

        Assert.assertEquals(false, extendTrue);
    }

    @When("^The player selects a volcano terrain$")
    public void thePlayerSelectsAVolcanoTerrain() throws Throwable {
        setUp();
        boolean extendTrue;
        builder.build(game.getBlackPlayer(),islandMap,1,806);

        extend = new ExtendSettlement(806,islandMap,game.getBlackPlayer());
        extendTrue = extend.extendOnTerrain("Volcano");

        Assert.assertEquals(false, extendTrue);
    }

    @Then("^The expansion fails and a warning message is shown$")
    public void theExpansionFailsAndAWarningMessageIsShown() throws Throwable {
        System.out.println("Could not complete expansion!");

    }

    @Given("^A player chooses to place a Totoro$")
    public void aPlayerChoosesToPlaceATotoro() throws Throwable {
        buildChoice = 3;

        Assert.assertEquals(3,buildChoice);
    }

    @When("^The player places that Totoro on a hex that is not part of a settlement$")
    public void thePlayerPlacesThatTotoroOnAHexThatIsNotPartOfASettlement() throws Throwable {
       setUp();
       boolean buildSuccessful;
       hexChoice = 807;
       buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false, buildSuccessful);
    }

    @When("^The player places that Totoro on a hex in a settlement of size less than (\\d+)$")
    public void thePlayerPlacesThatTotoroOnAHexInASettlementOfSizeLessThan(int arg0) throws Throwable {
        setUp();
        boolean buildSuccessful;
        builder.build(game.getBlackPlayer(),islandMap,1,806);
        hexChoice = 807;
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);
        Assert.assertEquals(false,buildSuccessful);
    }


    @When("^The player places that Totoro on a hex in a settlement with a Totoro already in it$")
    public void thePlayerPlacesThatTotoroOnAHexInASettlementWithATotoroAlreadyInIt() throws Throwable {
        setUp();
        boolean buildSuccessful;
        islandMap.addTileToMap(609,0);
        islandMap.addTileToMap(610,60);
        islandMap.addTileToMap(612,0);

        builder.build(game.getBlackPlayer(),islandMap,1,807);
        builder.build(game.getBlackPlayer(),islandMap,1,808);
        builder.build(game.getBlackPlayer(),islandMap,1,809);
        builder.build(game.getBlackPlayer(),islandMap,1,810);
        builder.build(game.getBlackPlayer(),islandMap,1,811);
        builder.build(game.getBlackPlayer(),islandMap,3,806);

        hexChoice = 812;

        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,3,hexChoice);

        Assert.assertEquals(false, buildSuccessful);

    }


    @When("^The player places that Totoro on a volcano hex$")
    public void thePlayerPlacesThatTotoroOnAVolcanoHex() throws Throwable {
        setUp();
        boolean buildSuccessful;
        hexChoice = 606;
        islandMap.addTileToMap(609,0);
        islandMap.addTileToMap(610,60);
        islandMap.addTileToMap(612,0);

        builder.build(game.getBlackPlayer(),islandMap,1,807);
        builder.build(game.getBlackPlayer(),islandMap,1,808);
        builder.build(game.getBlackPlayer(),islandMap,1,809);
        builder.build(game.getBlackPlayer(),islandMap,1,810);
        builder.build(game.getBlackPlayer(),islandMap,1,811);

        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false, buildSuccessful);
    }

    @Then("^Placing the Totoro fails and a warning message is shown$")
    public void placingTheTotoroFailsAndAWarningMessageIsShown() throws Throwable {
        System.out.println("Invalid hex to place a Totoro sanctuary");
    }

    @Given("^A player chooses to place a Tiger$")
    public void aPlayerChoosesToPlaceATiger() throws Throwable {
        buildChoice = 4;

        Assert.assertEquals(4,buildChoice);
    }

    @When("^The player places that Tiger on a volcano hex$")
    public void thePlayerPlacesThatTigerOnAVolcanoHex() throws Throwable {
        setUp();
        boolean buildSuccessful;
        hexChoice = 606;
        builder.build(game.getBlackPlayer(),islandMap,1,806);
        islandMap.getHex(606).incrementLevel();
        islandMap.getHex(606).incrementLevel();
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false, buildSuccessful);
    }

    @When("^The player places that Tiger on a hex that is not part of a settlement$")
    public void thePlayerPlacesThatTigerOnAHexThatIsNotPartOfASettlement() throws Throwable {
        setUp();
        boolean buildSuccessful;
        hexChoice = 807;
        islandMap.getHex(807).incrementLevel();
        islandMap.getHex(807).incrementLevel();

        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false,buildSuccessful);
    }

    @When("^The player places that Tiger on a hex that is not level (\\d+) or higher$")
    public void thePlayerPlacesThatTigerOnAHexThatIsNotLevelOrHigher(int arg0) throws Throwable {
        setUp();
        boolean buildSuccessful;
        hexChoice = 807;
        builder.build(game.getBlackPlayer(),islandMap,1,806);
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false, buildSuccessful);
    }

    @When("^The player places that Tiger on a hex in a settlement with a Tiger already in it$")
    public void thePlayerPlacesThatTigerOnAHexInASettlementWithATigerAlreadyInIt() throws Throwable {
        setUp();
        boolean buildSuccessful;
        hexChoice = 808;
        builder.build(game.getBlackPlayer(),islandMap,1,806);
        islandMap.getHex(807).incrementLevel();
        islandMap.getHex(807).incrementLevel();
        builder.build(game.getBlackPlayer(),islandMap,1,807);
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(false, buildSuccessful);
    }

    @Then("^Placing the Tiger fails and a warning message is shown$")
    public void placingTheTigerFailsAndAWarningMessageIsShown() throws Throwable {
        System.out.println("Invalid hex to place a Tiger playground!");
    }

    // Successful Tests

    @Given("^A player chooses to create a new settlement$")
    public void aPlayerChoosesToCreateANewSettlement() throws Throwable {
        buildChoice = 1;

        Assert.assertEquals(1, buildChoice);
    }

    @When("^The player places that Meeple on a level (\\d+), non-volcano hex$")
    public void thePlayerPlacesThatMeepleOnALevelNonVolcanoHex(int arg0) throws Throwable {
        setUp();
        hexChoice = 806;
        boolean buildSuccessful;
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(true,buildSuccessful);
    }

    @Then("^Placing the Meeple is successful$")
    public void placingTheMeepleIsSuccessful() throws Throwable {
        System.out.println("New settlement successfully created!");
    }

    @Given("^A player chooses to place a Totoro and create a new Totoro sanctuary$")
    public void aPlayerChoosesToPlaceATotoroAndCreateANewTotoroSanctuary() throws Throwable {
        buildChoice = 3;
    }

    @When("^The player places that Totoro on a size (\\d+) settlement that doesn't have a Totoro and is not a volcano hex$")
    public void thePlayerPlacesThatTotoroOnASizeSettlementThatDoesnTHaveATotoroAndIsNotAVolcanoHex(int arg0) throws Throwable {
        setUp();
        hexChoice = 806;
        boolean buildSuccessful;
        islandMap.addTileToMap(609,0);
        islandMap.addTileToMap(610,60);
        islandMap.addTileToMap(612,0);

        builder.build(game.getBlackPlayer(),islandMap,1,807);
        builder.build(game.getBlackPlayer(),islandMap,1,808);
        builder.build(game.getBlackPlayer(),islandMap,1,809);
        builder.build(game.getBlackPlayer(),islandMap,1,810);
        builder.build(game.getBlackPlayer(),islandMap,1,811);

        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(true, buildSuccessful);
    }

    @Then("^Placing the Totoro is successful$")
    public void placingTheTotoroIsSuccessful() throws Throwable {
        System.out.println("Totoro sanctuary successfully created");
    }

    @Given("^A player chooses to place a Tiger and create a new Tiger playground$")
    public void aPlayerChoosesToPlaceATigerAndCreateANewTigerPlayground() throws Throwable {
        buildChoice = 4;
    }

    @When("^The player places that Tiger on a settlement that doesn't have a tiger, on a level (\\d+) or higher hex thats not a volcano$")
    public void thePlayerPlacesThatTigerOnASettlementThatDoesnTHaveATigerOnALevelOrHigherHexThatsNotAVolcano(int arg0) throws Throwable {
        setUp();
        boolean buildSuccessful;
        hexChoice = 807;
        builder.build(game.getBlackPlayer(),islandMap,1,806);
        islandMap.getHex(807).incrementLevel();
        islandMap.getHex(807).incrementLevel();
        buildSuccessful = builder.build(game.getBlackPlayer(),islandMap,buildChoice,hexChoice);

        Assert.assertEquals(true, buildSuccessful);
    }

    @Then("^Placing the Tiger is successful$")
    public void placingTheTigerIsSuccessful() throws Throwable {
        System.out.println("Tiger playground successfully created!");
    }
}
