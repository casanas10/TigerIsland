import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alecasanas on 3/14/17.
 */
public class MeepleTest {


    @Test
    public void whenTheGameStartsThen40MeeplesAreCreated(){
        Pieces piecesTester = new Pieces();
        piecesTester.createMeeple();
        // Arrange
        Assert.assertEquals(piecesTester.getNumberOfMeeple(), 40);

        // Act


        // Assert

    }


}
