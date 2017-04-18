import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Eric on 3/24/2017.
 */
public class TigerTest {
    Tiger testTiger;
    @Before
    public void setUp() throws Exception {
        testTiger = new Tiger("white");
    }

    @Test
    public void calculateScoreTestLevel1() throws Exception {
        int score = testTiger.calculateScore(1);
        Assert.assertEquals(75, score);
    }

    @Test
    public void calculateScoreTestLevel3() throws Exception {
        int score = testTiger.calculateScore(3);
        Assert.assertEquals(75, score);
    }

    @Test
    public void checkName() throws Exception {
        String name = testTiger.getName();
        Assert.assertEquals("Tiger", name);
    }

}