import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alecasanas on 3/15/17.
 */
public class PlayerPieceContainerTest {

    @Test
    public void whenTheGameStartsThen20MeeplesAreCreated(){

        // Arrange
        PlayerPieceContainer playerPieceContainer = new PlayerPieceContainer("White");

        // Act
        playerPieceContainer.create20Meeples();

        // Assert
        Assert.assertEquals(20, playerPieceContainer.getNumberOfMeeple());
    }

    @Test
    public void whenTheGameStartsThen3TotorosAreCreated(){

        // Arrange
        PlayerPieceContainer playerPieceContainer = new PlayerPieceContainer("White");

        // Act
        playerPieceContainer.create3Totoros();

        // Assert
        Assert.assertEquals(3, playerPieceContainer.getNumberOfTotoros());
    }

}
