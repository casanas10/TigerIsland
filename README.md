# TigerIsland

Game Features:
- Place tiles
- Correctly place all types of Game Pieces:
- Can nuke
- Can expand 
- Can keep track of score for each player

The whole game functions. 


Game play:
In the main method, you can either run the AI against the server, watch the AI play against itself in a GUI, or 
play against the AI yourself in a GUI. In order to play in the GUI, make sure that the server portion in Main is commented 
out or deleted (the server code starts at line 21, beginning with Scanner s = new Scanner(System.in)), and runs to the end of Main. 
When you are playing with the GUI and you run Main, two GUIs will appear. When you click on one of the GUIs, you will be 
prompted to enter a HexID and a rotation (rotations are in degrees, i.e., 0, 60, 120, 180, 240, 300 and they rotate counterclockwise). The
AI that the game is running on is ALE_AI (not AI).

If you click on the other GUI that pops up, you will see the AI play against itself in the GUI every time you click.

If you want to play the AI in the server, make sure you comment out the GUI code (roughly lines 10-18). Inside of the Client class is where
you can changer the IP address and port.


Our game assumes that the inputs will be correct. If the input is incorrect, the game will skip to the AI's turn. 

Implementation Details:
-When playing in the console, the AI will take a Game object. 

Notes about classes:
- IslandMap is what keeps track of the actual map of the game. In order to place a tile, we call IslandMap.addTileToMap().
- Builder is what actually does the build options. The build options are 1, 2, 3, 4 (as specified in the paragraph above)
- TileGenerator allows you to randomly generate a tile with random terrains. You can use this class to grab new tiles to place.

Tests:
To run Cucumber tests, go to the CucumberRunner class, and run src/test/java/CucumberRunner to run all the acceptance tests.
To run the unit tests, go to TigerIsland/Test, right click the folder, and select run JUnit tests
