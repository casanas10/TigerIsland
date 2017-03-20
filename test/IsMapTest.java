import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alecasanas on 3/20/17.
 */
public class IsMapTest {

    @Test
    public void whenUserAddAHexThenItShouldBeOnTheMap(){

        //Arrange
        HexPoint hex = new HexPoint();

        hex.setPoint(2,0,0);

        IsMap map = new IsMap();

        //Act
        map.addHexToMap(hex);

        //Assert
        Assert.assertTrue(map.containsHexKey(hex));

        map.printMap();
    }

    
}
