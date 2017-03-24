import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alecasanas on 3/14/17.
 */
public class MeepleTest {
    Meeple testMeeple;

    @Before
    public void setUp() throws Exception {
        testMeeple = new Meeple("black");
    }

    @Test
    public void calculateScoreTestLevel1() throws Exception{
        int score = testMeeple.calculateScore(1);
        Assert.assertEquals(1,score);
    }

    @Test
    public void calculateScoreTestLevel3() throws Exception{
        int score = testMeeple.calculateScore(3);
        Assert.assertEquals(3, score);
    }

    @Test
    public void checkName() throws Exception{
        String name = testMeeple.getName();
        Assert.assertEquals("Meeple", name);
    }

}
