import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by cyonkee on 3/24/17.
 */
public class TerrainsStep {
    private TileGenerator tileGenerator;
    private int tilesCount;
    private int volcanoCount;
    private int lakeCount;
    private int grasslandCount;
    private int rockyCount;
    private int jungleCount;

    @Given("^a new set of tiles$")
    public void aNewSetOfTiles() throws Throwable {
        tileGenerator = new TileGenerator();
    }

    @When("^the tiles are counted$")
    public void theTilesAreCounted() throws Throwable {
        tilesCount = tileGenerator.getTilesRemaining();
    }

    @Then("^there are (\\d+) total$")
    public void thereAreTotal(int arg0) throws Throwable {
        assertEquals(arg0,tilesCount);
    }

    @When("^the tiles are examined$")
    public void theTilesAreExamined() throws Throwable {
        /*String terrainList[] =  new String[3];
        volcanoCount=0;
        lakeCount=0;
        grasslandCount=0;
        rockyCount=0;
        jungleCount=0;
        for(int i=0; i<48; i++){
            terrainList = tileGenerator.getTileTerrains(i);
            for(int j=0; j<3; j++){
                if(terrainList[j] == "Volcano"){
                    volcanoCount++;
                }
                if(terrainList[j] == "Lake"){
                    lakeCount++;
                }
                if(terrainList[j] == "Grassland"){
                    grasslandCount++;
                }
                if(terrainList[j] ==  "Rocky"){
                    rockyCount++;
                }
                if(terrainList[j] == "Jungle"){
                    jungleCount++;
                }
            }
        }*/
    }

    @Then("^there are (\\d+) terrain types on each tile, (\\d+) volcano per tile, (\\d+) kinds of tiles, and (\\d+) tiles of each type$")
    public void thereAreTerrainTypesOnEachTileVolcanoPerTileKindsOfTilesAndTilesOfEachType(int arg0, int arg1, int arg2, int arg3) throws Throwable {
        /*assertEquals(48,volcanoCount);
        assertEquals(3,grasslandCount);
        assertEquals(3,lakeCount);
        assertEquals(3,rockyCount);
        assertEquals(3,jungleCount);*/

    }
}
