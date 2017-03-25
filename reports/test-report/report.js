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
  "duration": 14479044,
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
  "duration": 379107445,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
  "duration": 28663435,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
  "duration": 7237170,
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
  "duration": 6162478,
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
  "duration": 7064398,
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
  "duration": 7268817,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 118032,
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
  "duration": 263007,
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
  "duration": 647466,
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
  "duration": 5313159,
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
  "duration": 419100,
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
  "duration": 7811936,
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
  "duration": 261724,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATile()"
});
formatter.result({
  "duration": 82109,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsSuccessfullyPlacedInTheMap()"
});
formatter.result({
  "duration": 1698210,
  "status": "passed"
});
formatter.before({
  "duration": 5331549,
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
  "duration": 50463,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileNextToAnotherTile()"
});
formatter.result({
  "duration": 509334,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsAddedToTheMap()"
});
formatter.result({
  "duration": 508052,
  "status": "passed"
});
formatter.before({
  "duration": 18545595,
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
  "duration": 49607,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileDirectlyOnTopOfAnotherTile()"
});
formatter.result({
  "duration": 289094,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.thePlacementFails()"
});
formatter.result({
  "duration": 391730,
  "status": "passed"
});
formatter.before({
  "duration": 3818940,
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
  "duration": 176621,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceTheTileUnnconnectedToAnotherTile()"
});
formatter.result({
  "duration": 517032,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theUnnconnectedPlacementFails()"
});
formatter.result({
  "duration": 326727,
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
  "duration": 5748510,
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
  "duration": 387453,
  "status": "passed"
});
formatter.match({
  "location": "PlayerStep.theGameStarts()"
});
formatter.result({
  "duration": 163363,
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
  "duration": 339984,
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
  "duration": 235637,
  "status": "passed"
});
formatter.uri("tile.feature");
formatter.feature({
  "line": 2,
  "name": "Tiles",
  "description": "",
  "id": "tiles",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
  "duration": 4492921,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "A new game board has been created",
  "description": "",
  "id": "tiles;a-new-game-board-has-been-created",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "an empty game board",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "a tile is placed",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "it should successfully become part of the game board",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 5626629,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "A tile has already been placed on the board",
  "description": "",
  "id": "tiles;a-tile-has-already-been-placed-on-the-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "another tile is going to be placed on the board",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "the tile is placed unconnected to another tile",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "placing the tile fails",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "there is a warning message",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "another tile is going to be placed on the board",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "the tile is placed overlapping another tile",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "placing tile fails",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "warning message",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "another tile is going to be placed on the board",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "the tile is placed while its edges are touching one or more other tiles",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "The tile is successfully placed",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});