# TigerIsland



Game Features:
-Place tiles
-Correctly place all types of Game Pieces:
-Can nuke
-Can expand 
-Can keep track of score for each player

The whole game functions. 


Game Play:

To play the game, run the main file under src/main/java. Here, you can play against our AI in the console. It will print
the information that it needs in terms of the server. It will ask for the rotation (1-6), x,y,z coordinates, and the build options. 
The build options are: 1. Found a settlement, 2. Expand a settlement 3. Build a Totoro sanctuary, 4. Build a Tiger Playground,
5. No build option. It will ask you for the x,y,z of the coordinate that you want to build. If you choose build option 2, expansion, 
it will ask you to enter the x,y,z coordinates that you would like to expand from. Next, you will need to input the type of 
terrain to expand to. The terrains are: Lake, Grassland, Rocky, Jungle. 

Our game assumes that the inputs will be correct. If the input is incorrect, the game will skip to the AI's turn. 

Implementation Details:
-When playing in the console, the AI will take a Game object. 

Notes about classes:
- IslandMap is what keeps track of the actual map of the game. In order to place a tile, we call IslandMap.addTileToMap().
- Builder is what actually does the build options. The build options are 1, 2, 3, 4 (as specified in the paragraph above)
- TileGenerator allows you to randomly generate a tile with random terrains. You can use this class to grab new tiles to place.
