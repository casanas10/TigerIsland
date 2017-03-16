import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by cyonkee on 3/14/17.
 */
public class IslandMap {
    Scanner s = new Scanner(System.in);
    private ArrayList<Tile> tilesLeftToPickFrom;
    private int[][] map;

    public IslandMap(){
        map = new int[48][15];
        tilesLeftToPickFrom = new ArrayList<Tile>(48);
    }

    // Generates the correct 48 tiles at the start of the game
    public void tileGenerator(){
        String terrainList[] = {"Lake", "Grass", "Rock", "Desert"};
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    tilesLeftToPickFrom.add(new Tile("Volcano",terrainList[j],terrainList[k]));
                }
            }

        }
    }

    public void printTiles(){
        int counter = 0;
        for(Tile tile : tilesLeftToPickFrom){
            System.out.println(counter + ".) ");
            tile.printHexTerrains();
            counter++;
        }
    }


    public void PlaceTile(int currentTile){
        System.out.println("Enter how many tiles you will touch:");
        int numberOfTilesToTouch = s.nextInt();

        System.out.println("Enter which tile(s) you will touch:");
        int[] tilesToTouch = new int[numberOfTilesToTouch];
        for(int i=0; i<numberOfTilesToTouch; i++) {
            tilesToTouch[i] = s.nextInt();
        }

        for(int i=0; i<numberOfTilesToTouch; i++){
            System.out.println("Enter how many sides of tile " + tilesToTouch[i] + " will touch the current tile:");
            int numberOfSidesToTouch = s.nextInt();

            System.out.println("Enter which side(s) of tile " + tilesToTouch[i] + " will touch the current tile:");
            int sidesOfTileToTouchCurrentTile[] = new int[numberOfSidesToTouch];
            for(int j=0; j<numberOfSidesToTouch; j++){
                sidesOfTileToTouchCurrentTile[j] = s.nextInt();
            }

            for(int j=0; j<numberOfSidesToTouch; j++) {
                System.out.println("Enter which side of current tile touches side " + sidesOfTileToTouchCurrentTile[j] + " of tile " + tilesToTouch[i] + ":");
                int currentSideThatTouches = s.nextInt();

                map[currentTile][currentSideThatTouches] = tilesToTouch[i];
                map[tilesToTouch[i]][sidesOfTileToTouchCurrentTile[j]] = currentTile;

            }
        }

        PrintMap();

    }
    public void PrintMap(){
        for(int i=0; i<48; i++){
            for(int j=0; j<15; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


}
