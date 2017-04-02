import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Val on 4/2/2017.
 */
public class RotateConverterTest {

    private RotationConverter rotateTest = new RotationConverter();

    @Test
    public void rotateConverterServer0()throws Exception{
        Assert.assertEquals(4, rotateTest.oursToServer(0));
    }

    @Test
    public void rotateConverterServer60()throws Exception{
        Assert.assertEquals(3, rotateTest.oursToServer(60));
    }

    @Test
    public void rotateConverterServer120()throws Exception{
        Assert.assertEquals(2, rotateTest.oursToServer(120));
    }

    @Test
    public void rotateConverterServer180()throws Exception{
        Assert.assertEquals(1, rotateTest.oursToServer(180));
    }

    @Test
    public void rotateConverterServer240()throws Exception{
        Assert.assertEquals(6, rotateTest.oursToServer(240));
    }

    @Test
    public void rotateConverterServer300()throws Exception{
        Assert.assertEquals(5, rotateTest.oursToServer(300));
    }

    @Test
    public void rotateConverterOurs2()throws Exception{
        Assert.assertEquals(120, rotateTest.serverToOurs(2));
    }

    @Test
    public void rotateConverterOurs3()throws Exception{
        Assert.assertEquals(60, rotateTest.serverToOurs(3));
    }

    @Test
    public void rotateConverterOurs4()throws Exception{
        Assert.assertEquals(0, rotateTest.serverToOurs(4));
    }

    @Test
    public void rotateConverterOur5()throws Exception{
        Assert.assertEquals(300, rotateTest.serverToOurs(5));
    }

    @Test
    public void rotateConverterOurs6()throws Exception{
        Assert.assertEquals(240, rotateTest.serverToOurs(6));
    }

}
