import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alecasanas on 3/25/17.
 */
public class PlacementValidityTest {

    @Test
    public void searchAroundAHex() {

        PlacementValidity validity = new PlacementValidity();

        HexGrid hexGrid = new HexGrid();

        hexGrid.generateHexGrid();

        Hex hex = new Hex(402,2,2);

        ArrayList<Integer> hexes = validity.searchTheSixAdjacentHexes(hex);

        ArrayList<Integer> expectedHexes = new ArrayList<Integer>() {{
            add(202);
            add(201);
            add(401);
            add(601);
            add(602);
            add(403);
        }};

        Assert.assertEquals(expectedHexes, hexes);
    }
}