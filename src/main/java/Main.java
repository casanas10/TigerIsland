/**
 * Created by alecasanas on 3/14/17.
 */
public class Main {

    public static void main(String[] args){

        System.out.println("Game Starts");
        Game game = new Game();

        IslandMap map = new IslandMap();
        map.tileGenerator();
        map.printTiles();
        //map.PlaceTile(1);
    }
}
