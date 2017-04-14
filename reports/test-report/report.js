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
  "duration": 70672868,
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
  "duration": 1151894205,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAVolcanoHex()"
});
formatter.result({
  "duration": 164277725,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 136458,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 133772,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAnAlreadyOccupiedHex()"
});
formatter.result({
  "duration": 166948440,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 313725,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 39503,
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
  "duration": 138502125,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 179508,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 49123,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsATerrainToExpandOnToButTheyDonTHaveEnoughMeeples()"
});
formatter.result({
  "duration": 83857550,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 91580,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 43768,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsAVolcanoTerrain()"
});
formatter.result({
  "duration": 149753875,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 68755,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 69552,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 132900794,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 80057,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 35062,
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
  "duration": 220820842,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 67912,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 37097,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAHexInASettlementWithATotoroAlreadyInIt()"
});
formatter.result({
  "duration": 25019003,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 63850,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 70730,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAVolcanoHex()"
});
formatter.result({
  "duration": 131394110,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 134955,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 51727,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAVolcanoHex()"
});
formatter.result({
  "duration": 100267995,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 63005,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 66528,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 256196393,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 142910,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 52423,
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
  "duration": 1607733642,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 45270,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 33977,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexInASettlementWithATigerAlreadyInIt()"
});
formatter.result({
  "duration": 7957455,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 55985,
  "status": "passed"
});
formatter.before({
  "duration": 3699785,
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
  "duration": 121927,
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
  "duration": 8634485,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleIsSuccessful()"
});
formatter.result({
  "duration": 81525,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoroAndCreateANewTotoroSanctuary()"
});
formatter.result({
  "duration": 52023,
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
  "duration": 32836560,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroIsSuccessful()"
});
formatter.result({
  "duration": 92625,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATigerAndCreateANewTigerPlayground()"
});
formatter.result({
  "duration": 56835,
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
  "duration": 9949730,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerIsSuccessful()"
});
formatter.result({
  "duration": 69262,
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
  "duration": 4242605,
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
  "duration": 63527903,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAnotherTileAndTheVolcanoesDoNotMatchUp()"
});
formatter.result({
  "duration": 151652,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 69233,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 1073407,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnASingleTile()"
});
formatter.result({
  "duration": 175760,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 55768,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 144476280,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnTilesOfVariousLevels()"
});
formatter.result({
  "duration": 102555,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 40882,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 1201325,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexContainingATotoro()"
});
formatter.result({
  "duration": 198998,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 49695,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 527090,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexWithASizeOneSettlement()"
});
formatter.result({
  "duration": 98992,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 27812,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 446443,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingTileCompletelyWipesOutASettlement()"
});
formatter.result({
  "duration": 131315,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 33780,
  "status": "passed"
});
formatter.before({
  "duration": 91031290,
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
  "duration": 5847627,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedAndAllOfTheNukingConditionsAreSatisfied()"
});
formatter.result({
  "duration": 192177,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingIsSuccessful()"
});
formatter.result({
  "duration": 53360,
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
  "duration": 4710190,
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
  "duration": 39077,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATile()"
});
formatter.result({
  "duration": 29833,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsSuccessfullyPlacedInTheMap()"
});
formatter.result({
  "duration": 133123,
  "status": "passed"
});
formatter.before({
  "duration": 113290633,
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
  "duration": 32570,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileNextToAnotherTile()"
});
formatter.result({
  "duration": 126095,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsAddedToTheMap()"
});
formatter.result({
  "duration": 141330,
  "status": "passed"
});
formatter.before({
  "duration": 6234698,
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
  "duration": 35712,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileDirectlyOnTopOfAnotherTile()"
});
formatter.result({
  "duration": 99337,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.thePlacementFails()"
});
formatter.result({
  "duration": 115825,
  "status": "passed"
});
formatter.before({
  "duration": 4858317,
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
  "duration": 30983,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceTheTileUnnconnectedToAnotherTile()"
});
formatter.result({
  "duration": 105570,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theUnnconnectedPlacementFails()"
});
formatter.result({
  "duration": 122530,
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
  "duration": 4101123,
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
  "duration": 3140380,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreCounted()"
});
formatter.result({
  "duration": 73380,
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
  "duration": 9964577,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.aNewSetOfTiles()"
});
formatter.result({
  "duration": 96115,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreExamined()"
});
formatter.result({
  "duration": 126117,
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
  "duration": 1132162,
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
  "duration": 55648795,
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
formatter.before({
  "duration": 8003115,
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