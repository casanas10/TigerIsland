import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alecasanas on 3/15/17.
 */
public class PlayerPieceContainerTest {

    @Test
    public void whenTheGameStartsThen20MeeplesAreCreated() throws Exception{

        // Arrange
        PlayerPieceContainer playerPieceContainer = new PlayerPieceContainer("White");

        // Act
        playerPieceContainer.create20Meeples();

        // Assert
        Assert.assertEquals(20, playerPieceContainer.getNumberOfMeeples());
    }

    @Test
    public void whenTheGameStartsThen3TotorosAreCreated() throws Exception{

        // Arrange
        PlayerPieceContainer playerPieceContainer = new PlayerPieceContainer("White");

        // Act
        playerPieceContainer.create3Totoros();

        // Assert
        Assert.assertEquals(3, playerPieceContainer.getNumberOfTotoros());
    }

    @Test
    public void whenTheGameStartsThen2TigersAreCreated() throws Exception{

        // Arrange
        PlayerPieceContainer playerPieceContainer = new PlayerPieceContainer("White");

        // Act
        playerPieceContainer.create2Tigers();

        // Assert
        Assert.assertEquals(2, playerPieceContainer.getNumberOfTigers());
    }

}
