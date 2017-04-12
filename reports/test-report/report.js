$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("building.feature");
formatter.feature({
  "line": 2,
  "name": "Building",
  "description": "",
  "id": "building",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
  "duration": 29628741,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "It\u0027s a player\u0027s turn to build and it fails",
  "description": "",
  "id": "building;it\u0027s-a-player\u0027s-turn-to-build-and-it-fails",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "A player chooses to place a meeple and create a new settlement",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "The player places the meeple on a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Placing the meeple fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "A player chooses to place a meeple and create a new settlement",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "The player places the meeple on an already occupied hex",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Placing the meeple fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "A player chooses to place a meeple and create a new settlement",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "The player places the meeple on a hex that is not level 1",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "Placing the meeple fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "A player chooses to expand",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "The player selects a terrain to expand on to but they don’t have enough meeples",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "The expansion fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "A player chooses to expand",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "The player selects a volcano terrain",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "The expansion fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "A player chooses to place a Totoro",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "The player places that Totoro on a hex that is not part of a settlement",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Placing the Totoro fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "A player chooses to place a Totoro",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "The player places that Totoro on a hex in a settlement of size less than 5",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Placing the Totoro fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "A player chooses to place a Totoro",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "The player places that Totoro on a hex in a settlement with a Totoro already in it",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "Placing the Totoro fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "A player chooses to place a Totoro",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "The player places that Totoro on a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "Placing the Totoro fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "A player chooses to place a Tiger",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "The player places that Tiger on a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "Placing the Tiger fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "A player chooses to place a Tiger",
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "The player places that Tiger on a hex that is not part of a settlement",
  "keyword": "When "
});
formatter.step({
  "line": 47,
  "name": "Placing the Tiger fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "A player chooses to place a Tiger",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "The player places that Tiger on a hex that is not level 3 or higher",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "Placing the Tiger fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "A player chooses to place a Tiger",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "The player places that Tiger on a hex in a settlement with a Tiger already in it",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "Placing the Tiger fails and a warning message is shown",
  "keyword": "Then "
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 473200516,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAVolcanoHex()"
});
formatter.result({
  "duration": 24018050,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 121577,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 30211,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAnAlreadyOccupiedHex()"
});
formatter.result({
  "duration": 68272934,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 55336,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 30034,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 56
    }
  ],
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAHexThatIsNotLevel(int)"
});
formatter.result({
  "duration": 17495644,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 155659,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 56876,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsATerrainToExpandOnToButTheyDonTHaveEnoughMeeples()"
});
formatter.result({
  "duration": 65694128,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 69762,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 22443,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsAVolcanoTerrain()"
});
formatter.result({
  "duration": 14122729,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 82784,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 60402,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 6358420,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 82386,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 65926,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 73
    }
  ],
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAHexInASettlementOfSizeLessThan(int)"
});
formatter.result({
  "duration": 97434673,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 87390,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 36474,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAHexInASettlementWithATotoroAlreadyInIt()"
});
formatter.result({
  "duration": 8300545,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 47027,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 26011,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAVolcanoHex()"
});
formatter.result({
  "duration": 17051904,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 54069,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 54257,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAVolcanoHex()"
});
formatter.result({
  "duration": 29729633,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 78355,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 45475,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 43573518,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 56046,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 32484,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 56
    }
  ],
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexThatIsNotLevelOrHigher(int)"
});
formatter.result({
  "duration": 342924692,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 64154,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 37055,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexInASettlementWithATigerAlreadyInIt()"
});
formatter.result({
  "duration": 16295442,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 71282,
  "status": "passed"
});
formatter.before({
  "duration": 5273105,
  "status": "passed"
});
formatter.scenario({
  "line": 57,
  "name": "It\u0027s a player\u0027s turn to build and it succeeds",
  "description": "",
  "id": "building;it\u0027s-a-player\u0027s-turn-to-build-and-it-succeeds",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 58,
  "name": "A player chooses to create a new settlement",
  "keyword": "Given "
});
formatter.step({
  "line": 59,
  "name": "The player places that Meeple on a level 1, non-volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "Placing the Meeple is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "A player chooses to place a Totoro and create a new Totoro sanctuary",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "The player places that Totoro on a size 5 settlement that doesn\u0027t have a Totoro and is not a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "Placing the Totoro is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 66,
  "name": "A player chooses to place a Tiger and create a new Tiger playground",
  "keyword": "Given "
});
formatter.step({
  "line": 67,
  "name": "The player places that Tiger on a settlement that doesn\u0027t have a tiger, on a level 3 or higher hex thats not a volcano",
  "keyword": "When "
});
formatter.step({
  "line": 68,
  "name": "Placing the Tiger is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToCreateANewSettlement()"
});
formatter.result({
  "duration": 64988,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 41
    }
  ],
  "location": "BuildStep.thePlayerPlacesThatMeepleOnALevelNonVolcanoHex(int)"
});
formatter.result({
  "duration": 8933181,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleIsSuccessful()"
});
formatter.result({
  "duration": 93321,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoroAndCreateANewTotoroSanctuary()"
});
formatter.result({
  "duration": 47473,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 40
    }
  ],
  "location": "BuildStep.thePlayerPlacesThatTotoroOnASizeSettlementThatDoesnTHaveATotoroAndIsNotAVolcanoHex(int)"
});
formatter.result({
  "duration": 8439538,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroIsSuccessful()"
});
formatter.result({
  "duration": 101076,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATigerAndCreateANewTigerPlayground()"
});
formatter.result({
  "duration": 45852,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 83
    }
  ],
  "location": "BuildStep.thePlayerPlacesThatTigerOnASettlementThatDoesnTHaveATigerOnALevelOrHigherHexThatsNotAVolcano(int)"
});
formatter.result({
  "duration": 12763589,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerIsSuccessful()"
});
formatter.result({
  "duration": 160798,
  "status": "passed"
});
formatter.uri("game.feature");
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
  "duration": 3019166,
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
  "duration": 177756,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
  "duration": 95201162,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
  "duration": 75531,
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
  "duration": 541907,
  "status": "passed"
});
formatter.uri("nuking.feature");
formatter.feature({
  "line": 3,
  "name": "Nuking",
  "description": "",
  "id": "nuking",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
  "duration": 4519689,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "A player gets a tile, tries to nuke the board, and it fails",
  "description": "",
  "id": "nuking;a-player-gets-a-tile,-tries-to-nuke-the-board,-and-it-fails",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "There are tiles on the board and it is the players turn to place a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "The tile is placed on another tile and the volcanoes do not match up",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "The nuking fails",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "There are tiles on the board and it is the players turn to place a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "The tile is placed on a single tile",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "The nuking fails",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "There are tiles on the board and it is the players turn to place a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "The tile is placed on tiles of various levels",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "The nuking fails",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "There are tiles on the board and it is the players turn to place a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "The tile is placed on a hex containing a Totoro",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "The nuking fails",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "There are tiles on the board and it is the players turn to place a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "The tile is placed on a hex with a size one settlement",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "The nuking fails",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "There are tiles on the board and it is the players turn to place a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "The nuking tile completely wipes out a settlement",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "The nuking fails",
  "keyword": "Then "
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 4896596,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAnotherTileAndTheVolcanoesDoNotMatchUp()"
});
formatter.result({
  "duration": 154670,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 74775,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 624900,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnASingleTile()"
});
formatter.result({
  "duration": 104026,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 272687,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 2014682,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnTilesOfVariousLevels()"
});
formatter.result({
  "duration": 348178,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 43043,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 2407306,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexContainingATotoro()"
});
formatter.result({
  "duration": 191297,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 30166,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 1417982,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexWithASizeOneSettlement()"
});
formatter.result({
  "duration": 1761058,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 57997,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 509748,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingTileCompletelyWipesOutASettlement()"
});
formatter.result({
  "duration": 137943,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 35117,
  "status": "passed"
});
formatter.before({
  "duration": 3137295,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "A player gets a new tile, decides to nuke the board, and it is successful",
  "description": "",
  "id": "nuking;a-player-gets-a-new-tile,-decides-to-nuke-the-board,-and-it-is-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "There are tiles on the board and it is the players turn to place a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "The tile is placed and all of the nuking conditions are satisfied",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "The nuking is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 5266041,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedAndAllOfTheNukingConditionsAreSatisfied()"
});
formatter.result({
  "duration": 219053,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingIsSuccessful()"
});
formatter.result({
  "duration": 58673,
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
  "duration": 3279665,
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
  "duration": 7829982,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 84260,
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
  "duration": 244680,
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
  "duration": 166011,
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
  "duration": 2182890,
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
  "duration": 206385,
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
  "duration": 3498325,
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
  "duration": 55637,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATile()"
});
formatter.result({
  "duration": 64309,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsSuccessfullyPlacedInTheMap()"
});
formatter.result({
  "duration": 211908,
  "status": "passed"
});
formatter.before({
  "duration": 4431266,
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
  "duration": 28923,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileNextToAnotherTile()"
});
formatter.result({
  "duration": 116418,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsAddedToTheMap()"
});
formatter.result({
  "duration": 138359,
  "status": "passed"
});
formatter.before({
  "duration": 6111021,
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
  "duration": 462749,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileDirectlyOnTopOfAnotherTile()"
});
formatter.result({
  "duration": 129258,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.thePlacementFails()"
});
formatter.result({
  "duration": 126969,
  "status": "passed"
});
formatter.before({
  "duration": 16038499,
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
  "duration": 27479,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceTheTileUnnconnectedToAnotherTile()"
});
formatter.result({
  "duration": 105778,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theUnnconnectedPlacementFails()"
});
formatter.result({
  "duration": 92448,
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
  "duration": 6012927,
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
  "duration": 192810,
  "status": "passed"
});
formatter.match({
  "location": "PlayerStep.theGameStarts()"
});
formatter.result({
  "duration": 95425,
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
  "duration": 135923,
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
  "duration": 125515,
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
  "duration": 8287048,
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
  "duration": 175664,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreCounted()"
});
formatter.result({
  "duration": 64175,
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
  "duration": 3687664,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.aNewSetOfTiles()"
});
formatter.result({
  "duration": 124787,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreExamined()"
});
formatter.result({
  "duration": 30013,
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
  "duration": 383809,
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
  "duration": 16425528,
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
formatter.match({
  "location": "TurnsStep.aBrandNewGame()"
});
formatter.result({
  "duration": 259033,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.itSTimeToBegin()"
});
formatter.result({
  "duration": 86117838,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerIsChosenAtRandomToStartTheGame()"
});
formatter.result({
  "duration": 128988,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerToBegin()"
});
formatter.result({
  "duration": 54957,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.thatPlayerSTurnIsOver()"
});
formatter.result({
  "duration": 4067106,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat TurnsStep.thatPlayerSTurnIsOver(TurnsStep.java:38)\n\tat ✽.When that player’s turn is over(turns.feature:10)\n",
  "status": "pending"
});
formatter.match({
  "location": "TurnsStep.theTurnChangesToTheNextPlayer()"
});
formatter.result({
  "status": "skipped"
});
formatter.before({
  "duration": 13323687,
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
});
formatter.result({
  "duration": 461996,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat TurnsStep.onePlayerSTurnIsCurrentlyGoingOn(TurnsStep.java:50)\n\tat ✽.Given one player’s turn is currently going on(turns.feature:14)\n",
  "status": "pending"
});
formatter.match({
  "location": "TurnsStep.thatPlayerSTurnIsOver()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TurnsStep.theNextPlayerSTurnBegins()"
});
formatter.result({
  "status": "skipped"
});
});