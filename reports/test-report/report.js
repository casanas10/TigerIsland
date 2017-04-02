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
  "duration": 23249151,
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
  "name": "The player places that Totoro on a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "Placing the Totoro fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "A player chooses to place a Tiger",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "The player places that Tiger on a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "Placing the Tiger fails and a warning message is shown",
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "A player chooses to place a Tiger",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "The player places that Tiger on a hex that is not part of a settlement",
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
  "name": "The player places that Tiger on a hex that is not level 3 or higher",
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
  "name": "The player places that Tiger on a hex in a settlement with a Tiger already in it",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "Placing the Tiger fails and a warning message is shown",
  "keyword": "Then "
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 272796821,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAVolcanoHex()"
});
formatter.result({
  "duration": 61120374,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 177040,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 50461,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAnAlreadyOccupiedHex()"
});
formatter.result({
  "duration": 20753054,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 103060,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 53454,
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
  "duration": 51472107,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 132139,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 62006,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsATerrainToExpandOnToButTheyDonTHaveEnoughMeeples()"
});
formatter.result({
  "duration": 14760198,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 112468,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 62434,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsAVolcanoTerrain()"
});
formatter.result({
  "duration": 60395963,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 96218,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 71843,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 11173209,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 138125,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 53455,
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
  "duration": 14731119,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 119737,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 58586,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAVolcanoHex()"
});
formatter.result({
  "duration": 23174315,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 93224,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 54737,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAVolcanoHex()"
});
formatter.result({
  "duration": 357121018,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 133849,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 65855,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 9572149,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 133850,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 69277,
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
  "duration": 10958537,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 89376,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 46184,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexInASettlementWithATigerAlreadyInIt()"
});
formatter.result({
  "duration": 9704714,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 109047,
  "status": "passed"
});
formatter.before({
  "duration": 31325865,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "It\u0027s a player\u0027s turn to build and it succeeds",
  "description": "",
  "id": "building;it\u0027s-a-player\u0027s-turn-to-build-and-it-succeeds",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 54,
  "name": "A player chooses to create a new settlement",
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "The player places that Meeple on a level 1, non-volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "Placing the Meeple is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 58,
  "name": "A player chooses to place a Totoro and create a new Totoro sanctuary",
  "keyword": "Given "
});
formatter.step({
  "line": 59,
  "name": "The player places that Totoro on a size 5 settlement that doesn\u0027t have a Totoro and is not a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "Placing the Totoro is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "A player chooses to place a Tiger and create a new Tiger playground",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "The player places that Tiger on a settlement that doesn\u0027t have a tiger, on a level 3 or higher hex thats not a volcano",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "Placing the Tiger is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToCreateANewSettlement()"
});
formatter.result({
  "duration": 120165,
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
  "duration": 7676877,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleIsSuccessful()"
});
formatter.result({
  "duration": 115888,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoroAndCreateANewTotoroSanctuary()"
});
formatter.result({
  "duration": 61579,
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
  "duration": 8741684,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroIsSuccessful()"
});
formatter.result({
  "duration": 76546,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATigerAndCreateANewTigerPlayground()"
});
formatter.result({
  "duration": 37204,
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
  "duration": 8739118,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerIsSuccessful()"
});
formatter.result({
  "duration": 79968,
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
  "duration": 3149093,
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
  "duration": 268126,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
  "duration": 3792254,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
  "duration": 96218,
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
  "duration": 271119,
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
  "duration": 7423718,
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
  "duration": 8881948,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAnotherTileAndTheVolcanoesDoNotMatchUp()"
});
formatter.result({
  "duration": 148817,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 86382,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 1464645,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnASingleTile()"
});
formatter.result({
  "duration": 278817,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 45757,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 1524941,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnTilesOfVariousLevels()"
});
formatter.result({
  "duration": 119737,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 36776,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 592700,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexContainingATotoro()"
});
formatter.result({
  "duration": 209968,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 33356,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 798391,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexWithASizeOneSettlement()"
});
formatter.result({
  "duration": 122303,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 35066,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 595266,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingTileCompletelyWipesOutASettlement()"
});
formatter.result({
  "duration": 155231,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 55165,
  "status": "passed"
});
formatter.before({
  "duration": 6913979,
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
  "duration": 9404516,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedAndAllOfTheNukingConditionsAreSatisfied()"
});
formatter.result({
  "duration": 173619,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingIsSuccessful()"
});
formatter.result({
  "duration": 42763,
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
  "duration": 24846362,
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
  "duration": 5319333,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 91086,
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
  "duration": 232206,
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
  "duration": 143685,
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
  "duration": 2497379,
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
  "duration": 238192,
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
  "duration": 3325278,
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
  "duration": 42763,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATile()"
});
formatter.result({
  "duration": 29079,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsSuccessfullyPlacedInTheMap()"
});
formatter.result({
  "duration": 213816,
  "status": "passed"
});
formatter.before({
  "duration": 3266265,
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
  "duration": 45329,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileNextToAnotherTile()"
});
formatter.result({
  "duration": 161645,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsAddedToTheMap()"
});
formatter.result({
  "duration": 156514,
  "status": "passed"
});
formatter.before({
  "duration": 3802090,
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
  "duration": 37204,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileDirectlyOnTopOfAnotherTile()"
});
formatter.result({
  "duration": 164639,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.thePlacementFails()"
});
formatter.result({
  "duration": 127862,
  "status": "passed"
});
formatter.before({
  "duration": 4632554,
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
  "duration": 38487,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceTheTileUnnconnectedToAnotherTile()"
});
formatter.result({
  "duration": 229639,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theUnnconnectedPlacementFails()"
});
formatter.result({
  "duration": 178751,
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
  "duration": 5275287,
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
  "duration": 308324,
  "status": "passed"
});
formatter.match({
  "location": "PlayerStep.theGameStarts()"
});
formatter.result({
  "duration": 94935,
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
  "duration": 198849,
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
  "duration": 169343,
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
  "duration": 3400114,
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
  "duration": 351087,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreCounted()"
});
formatter.result({
  "duration": 75691,
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
  "duration": 5386471,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.aNewSetOfTiles()"
});
formatter.result({
  "duration": 114606,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreExamined()"
});
formatter.result({
  "duration": 49606,
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
  "duration": 474673,
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
  "duration": 4363572,
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
  "duration": 159507,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.itSTimeToBegin()"
});
formatter.result({
  "duration": 4817291,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerIsChosenAtRandomToStartTheGame()"
});
formatter.result({
  "duration": 168060,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerToBegin()"
});
formatter.result({
  "duration": 62434,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.thatPlayerSTurnIsOver()"
});
formatter.result({
  "duration": 3797386,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat TurnsStep.thatPlayerSTurnIsOver(TurnsStep.java:38)\r\n\tat ✽.When that player’s turn is over(turns.feature:10)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "TurnsStep.theTurnChangesToTheNextPlayer()"
});
formatter.result({
  "status": "skipped"
});
formatter.before({
  "duration": 4499132,
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
  "duration": 540957,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat TurnsStep.onePlayerSTurnIsCurrentlyGoingOn(TurnsStep.java:50)\r\n\tat ✽.Given one player’s turn is currently going on(turns.feature:14)\r\n",
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