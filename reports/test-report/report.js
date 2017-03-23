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
  "duration": 155474492,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
  "duration": 168496,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
  "duration": 2660856,
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
  "duration": 2803265,
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
  "duration": 295509,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 62010,
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
  "duration": 168067,
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
  "duration": 143691,
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
  "duration": 1921872,
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
  "duration": 164647,
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
  "duration": 175338,
  "status": "passed"
});
formatter.match({
  "location": "PlayerStep.theGameStarts()"
});
formatter.result({
  "duration": 138988,
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
  "duration": 131717,
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
  "duration": 118032,
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
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.anotherTileIsGoingToBePlacedOnTheBoard()"
});
formatter.result({
  "duration": 2222084,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat PlacingTileAfterFirstTilePlacedStep.anotherTileIsGoingToBePlacedOnTheBoard(PlacingTileAfterFirstTilePlacedStep.java:14)\r\n\tat ✽.Given another tile is going to be placed on the board(tile.feature:12)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.theTileIsPlacedUnconnectedToAnotherTile()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.placingTheTileFails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.thereIsAWarningMessage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.anotherTileIsGoingToBePlacedOnTheBoard()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.theTileIsPlacedOverlappingAnotherTile()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.placingTileFails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.warningMessage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.anotherTileIsGoingToBePlacedOnTheBoard()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.theTileIsPlacedWhileItsEdgesAreTouchingOneOrMoreOtherTiles()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlacingTileAfterFirstTilePlacedStep.theTileIsSuccessfullyPlaced()"
});
formatter.result({
  "status": "skipped"
});
});