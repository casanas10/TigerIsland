//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Eric on 3/16/2017.
// */
//public class HexTest {
//    private Hex hexToTest;
//    @Before
//    public void setUp() throws Exception {
//        hexToTest = new Hex("Rock", 1);
//    }
//
//    @Test
//    public void getLevel() throws Exception {
//        //Assert.assertEquals(hexToTest.getLevel(), 1);
//    }
//
//    @Test
//    public void setLevel() throws Exception {
//        hexToTest.setLevel(2);
//        //Assert.assertEquals(hexToTest.getLevel(), 2);
//    }
//
//    @Test
//    public void getTerrainType() throws Exception {
//        //Assert.assertEquals(hexToTest.getTerrainType(), "Rock");
//    }
//
//    @Test
//    public void checkIfFounded() throws Exception {
//        //Assert.assertEquals(hexToTest.checkIfFounded(), false);
//    }
//
//    @Test
//    public void updateTerrainType() throws Exception {
//        //hexToTest.updateTerrainType("Lake");
//        //Assert.assertEquals(hexToTest.getTerrainType(), "Lake");
//    }
//
//    @Test
//    public void getNumberOfMeeplesOnHex() throws Exception {
//        //Assert.assertEquals(hexToTest.getNumberOfMeeplesOnHex(), 0);
//    }
//
//    @Test
//    public void foundOnTerrain() throws Exception {
//        //hexToTest.foundOnTerrain(true);
//        //Assert.assertEquals(hexToTest.checkIfFounded(), true);
//    }
//
//    @Test
//    public void addMeepleToHex() throws Exception {
//        Meeple testMeeple = new Meeple("Black");
//        hexToTest.addMeepleToHex(testMeeple);
////        Assert.assertEquals(hexToTest.getNumberOfMeeplesOnHex(), 1);
////        Assert.assertEquals(hexToTest.checkIfFounded(), true);
//    }
//
//    @Test
//    public void getNumberOfTotorosOnHex() throws Exception {
//        Assert.assertEquals(hexToTest.getNumberOfTotorosOnHex(), 0);
//    }
//
//    @Test
//    public void addTotoroToHex() throws Exception {
//        Totoro testTotoro = new Totoro("Black");
//        hexToTest.addTotoroToHex(testTotoro);
//        Assert.assertEquals(hexToTest.getNumberOfTotorosOnHex(), 1);
//        Assert.assertEquals(hexToTest.checkIfFounded(), true);
//    }
//
//}