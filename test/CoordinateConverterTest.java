import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Connor on 4/1/2017.
 */
public class CoordinateConverterTest {
    private CoordinateConverter convert = new CoordinateConverter();

    @Test
    public void testCoordinateConversion(){
        int[] XYZ = convert.oursToServer(99,101);

        for(int coordinate : XYZ){
            System.out.print(coordinate + " ");
        }
    }

}