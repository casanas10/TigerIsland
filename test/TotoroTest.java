import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by cyonkee on 3/14/17.
 */
public class TotoroTest {
    Totoro testTotoro;

    @Before
    public void setUp() throws Exception {
        testTotoro = new Totoro("white");
    }

    @Test
    public void calculateScoreTestLevel1() throws Exception{
        int score = testTotoro.calculateScore(1);
        Assert.assertEquals(200,score);
    }

    @Test
    public void calculateScoreTestLevel3() throws Exception{
        int score = testTotoro.calculateScore(3);
        Assert.assertEquals(200, score);
    }

    @Test
    public void checkName() throws Exception{
        String name = testTotoro.getName();
        Assert.assertEquals("Totoro", name);
    }

}
