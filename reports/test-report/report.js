$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("game.feature");
formatter.feature({
  "line": 2,
  "name": "Game Board",
  "description": "",
  "id": "game-board",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
<<<<<<< .merge_file_vx9cec
  "duration": 21379630,
=======
  "duration": 7822272,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "A new game has started",
  "description": "",
  "id": "game-board;a-new-game-has-started",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Nothing has yet happened",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "The game initiates",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "A new game is successfully created",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "2 players are successfully created, each holding specific player attributes",
  "keyword": "And "
});
formatter.match({
  "location": "GameStep.nothingHasYetHappened()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 235184699,
=======
  "duration": 107044792,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 33218215,
=======
  "duration": 11141564,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 14725889,
=======
  "duration": 1489875,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 0
    }
  ],
  "location": "GameStep.playersAreSuccessfullyCreatedEachHoldingSpecificPlayerAttributes(int)"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 5752979,
=======
  "duration": 1754152,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.uri("pieces.feature");
formatter.feature({
  "line": 2,
  "name": "Pieces",
  "description": "",
  "id": "pieces",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
<<<<<<< .merge_file_vx9cec
  "duration": 11489050,
=======
  "duration": 8354248,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "A new game is created and all meeples are created",
  "description": "",
  "id": "pieces;a-new-game-is-created-and-all-meeples-are-created",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "a new game is created",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the game begins",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "40 meeples are successfully created with the correct properties",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "6 Totoros are successfully created with the correct properties",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the White player has 3 \"white\" Totoros",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the Black player has 3 \"black\" Totoros",
  "keyword": "And "
});
formatter.match({
  "location": "MeeplesStep.aNewGameIsCreated()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 7305549,
=======
  "duration": 5283412,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 86295,
=======
  "duration": 59868,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "40",
      "offset": 0
    }
  ],
  "location": "MeeplesStep.meeplesAreSuccessfullyCreatedWithTheCorrectProperties(int)"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 192271,
=======
  "duration": 107764,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 0
    }
  ],
  "location": "MeeplesStep.totorosAreSuccessfullyCratedWithTheCorrectProperties(int)"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 140705,
=======
  "duration": 130001,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 21
    },
    {
      "val": "white",
      "offset": 24
    }
  ],
  "location": "MeeplesStep.theWhitePlayerHasTotoros(int,String)"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 1988011,
=======
  "duration": 2391754,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 21
    },
    {
      "val": "black",
      "offset": 24
    }
  ],
  "location": "MeeplesStep.theBlackPlayerHasTotoros(int,String)"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 277473,
=======
  "duration": 339113,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.uri("placement.feature");
formatter.feature({
  "line": 2,
  "name": "Placing Tiles",
  "description": "",
  "id": "placing-tiles",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
<<<<<<< .merge_file_vx9cec
  "duration": 10348331,
=======
  "duration": 2372938,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "A new game has started",
  "description": "",
  "id": "placing-tiles;a-new-game-has-started",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a tile is already place in the board",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "you place a tile",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the tile is successfully placed in the map",
  "keyword": "Then "
});
formatter.match({
  "location": "PlacementTileStep.aTileIsAlreadyPlaceInTheBoard()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 50266,
=======
  "duration": 163784,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATile()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 40076,
=======
  "duration": 26941,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsSuccessfullyPlacedInTheMap()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 1118378,
  "status": "passed"
});
formatter.before({
  "duration": 7941938,
=======
  "duration": 931813,
  "status": "passed"
});
formatter.before({
  "duration": 2479419,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Placing tiles next to each other",
  "description": "",
  "id": "placing-tiles;placing-tiles-next-to-each-other",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "a tile is already place in the board",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "you place a tile next to another tile",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the tile is added to the map",
  "keyword": "Then "
});
formatter.match({
  "location": "PlacementTileStep.aTileIsAlreadyPlaceInTheBoard()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 27989,
=======
  "duration": 21809,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileNextToAnotherTile()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 168155,
=======
  "duration": 101776,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsAddedToTheMap()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 7533599,
  "status": "passed"
});
formatter.before({
  "duration": 15322424,
=======
  "duration": 303193,
  "status": "passed"
});
formatter.before({
  "duration": 7933029,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Placing a tile directly on top of another",
  "description": "",
  "id": "placing-tiles;placing-a-tile-directly-on-top-of-another",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "a tile is already place in the board",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "you place a tile directly on top of another tile",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the placement fails",
  "keyword": "Then "
});
formatter.match({
  "location": "PlacementTileStep.aTileIsAlreadyPlaceInTheBoard()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 34588,
=======
  "duration": 24375,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileDirectlyOnTopOfAnotherTile()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 265825,
=======
  "duration": 150954,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.thePlacementFails()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 1483101,
  "status": "passed"
});
formatter.before({
  "duration": 5859739,
=======
  "duration": 200560,
  "status": "passed"
});
formatter.before({
  "duration": 1899120,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Placing an unnconnected tile",
  "description": "",
  "id": "placing-tiles;placing-an-unnconnected-tile",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "a tile is already place in the board",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "you place the tile unnconnected to another tile",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "the unnconnected placement fails",
  "keyword": "Then "
});
formatter.match({
  "location": "PlacementTileStep.aTileIsAlreadyPlaceInTheBoard()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 39722,
=======
  "duration": 79112,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceTheTileUnnconnectedToAnotherTile()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 218518,
=======
  "duration": 217238,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theUnnconnectedPlacementFails()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 239734,
=======
  "duration": 176612,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.uri("player.feature");
formatter.feature({
  "line": 3,
  "name": "Player",
  "description": "",
  "id": "player",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
<<<<<<< .merge_file_vx9cec
  "duration": 2454174,
=======
  "duration": 1749877,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "A new game is created",
  "description": "",
  "id": "player;a-new-game-is-created",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "A new game is created",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "The game starts",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "A player is successfully created with a start score of 0",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "The player is assigned a color \"White\"",
  "keyword": "And "
});
formatter.match({
  "location": "PlayerStep.aNewGameIsCreated()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 182446,
=======
  "duration": 162500,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "location": "PlayerStep.theGameStarts()"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 123372,
=======
  "duration": 47040,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 55
    }
  ],
  "location": "PlayerStep.playerCreation(int)"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 260747,
=======
  "duration": 112040,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "White",
      "offset": 32
    }
  ],
  "location": "PlayerStep.thePlayerIsAssignedAColor(String)"
});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 4312218,
=======
  "duration": 73125,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.uri("terrains.feature");
formatter.feature({
  "line": 2,
  "name": "Terrain Types",
  "description": "",
  "id": "terrain-types",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
<<<<<<< .merge_file_vx9cec
  "duration": 7602699,
=======
  "duration": 2588893,
>>>>>>> .merge_file_41lG9I
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "a new set of tiles is created",
  "description": "",
  "id": "terrain-types;a-new-set-of-tiles-is-created",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a new set of tiles",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the tiles are counted",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "there are 48 total",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "a new set of tiles",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the tiles are examined",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "there are 2 terrain types on each tile, 1 volcano per tile, 16 kinds of tiles, and 3 tiles of each type",
  "keyword": "Then "
});
formatter.match({
  "location": "TerrainsStep.aNewSetOfTiles()"
});
formatter.result({
  "duration": 196402,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreCounted()"
});
formatter.result({
  "duration": 52571,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "48",
      "offset": 10
    }
  ],
  "location": "TerrainsStep.thereAreTotal(int)"
});
formatter.result({
  "duration": 3400622,
  "status": "passed"
});
<<<<<<< .merge_file_vx9cec
formatter.match({
  "location": "TerrainsStep.aNewSetOfTiles()"
=======
formatter.before({
  "duration": 9515273,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "A tile has already been placed on the board",
  "description": "",
  "id": "tiles;a-tile-has-already-been-placed-on-the-board",
  "type": "scenario",
  "keyword": "Scenario"
>>>>>>> .merge_file_41lG9I
});
formatter.result({
  "duration": 85919,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreExamined()"
});
formatter.result({
  "duration": 101336,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 10
    },
    {
      "val": "1",
      "offset": 40
    },
    {
      "val": "16",
      "offset": 60
    },
    {
      "val": "3",
      "offset": 83
    }
  ],
  "location": "TerrainsStep.thereAreTerrainTypesOnEachTileVolcanoPerTileKindsOfTilesAndTilesOfEachType(int,int,int,int)"
});
formatter.result({
  "duration": 300657,
  "status": "passed"
});
formatter.uri("turns.feature");
formatter.feature({
  "line": 2,
  "name": "Turns",
  "description": "",
  "id": "turns",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
  "duration": 2272124,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "The game has just started",
  "description": "",
  "id": "turns;the-game-has-just-started",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a brand new game",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "it’s time to begin",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a player is chosen at random to start the game",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "a player to begin",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "that player’s turn is over",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the turn changes to the next player",
  "keyword": "Then "
});
<<<<<<< .merge_file_vx9cec
formatter.match({
  "location": "TurnsStep.aBrandNewGame()"
});
formatter.result({
  "duration": 94989,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.itSTimeToBegin()"
=======
formatter.match({});
formatter.result({
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 12139516,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerIsChosenAtRandomToStartTheGame()"
=======
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 215084,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerToBegin()"
=======
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 16394269,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat TurnsStep.aPlayerToBegin(TurnsStep.java:33)\n\tat ✽.Given a player to begin(turns.feature:9)\n",
  "status": "pending"
});
formatter.match({
  "location": "TurnsStep.thatPlayerSTurnIsOver()"
=======
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "status": "skipped"
});
formatter.match({
  "location": "TurnsStep.theTurnChangesToTheNextPlayer()"
=======
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "status": "skipped"
});
formatter.before({
  "duration": 5121403,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "The game has been going on for a certain period of time",
  "description": "",
  "id": "turns;the-game-has-been-going-on-for-a-certain-period-of-time",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "one player’s turn is currently going on",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "that player’s turn is over",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the next player’s turn begins",
  "keyword": "Then "
});
formatter.match({
  "location": "TurnsStep.onePlayerSTurnIsCurrentlyGoingOn()"
=======
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "duration": 290112,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat TurnsStep.onePlayerSTurnIsCurrentlyGoingOn(TurnsStep.java:51)\n\tat ✽.Given one player’s turn is currently going on(turns.feature:14)\n",
  "status": "pending"
});
formatter.match({
  "location": "TurnsStep.thatPlayerSTurnIsOver()"
=======
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
<<<<<<< .merge_file_vx9cec
  "status": "skipped"
});
formatter.match({
  "location": "TurnsStep.theNextPlayerSTurnBegins()"
=======
  "status": "undefined"
>>>>>>> .merge_file_41lG9I
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});