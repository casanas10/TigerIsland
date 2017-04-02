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
  "duration": 22412653,
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
  "duration": 416861339,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAVolcanoHex()"
});
formatter.result({
  "duration": 77518600,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 76423,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 911472,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesTheMeepleOnAnAlreadyOccupiedHex()"
});
formatter.result({
  "duration": 80695834,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 383554,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceAMeepleAndCreateANewSettlement()"
});
formatter.result({
  "duration": 86665,
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
  "duration": 31286327,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 54013,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 32413,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsATerrainToExpandOnToButTheyDonTHaveEnoughMeeples()"
});
formatter.result({
  "duration": 193135132,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 101355,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToExpand()"
});
formatter.result({
  "duration": 58027,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerSelectsAVolcanoTerrain()"
});
formatter.result({
  "duration": 18784422,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.theExpansionFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 342116,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 92310,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 14692773,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 84035,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 35330,
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
  "duration": 96938158,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 53076,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoro()"
});
formatter.result({
  "duration": 86027,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTotoroOnAVolcanoHex()"
});
formatter.result({
  "duration": 11200511,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 444053,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 45784,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAVolcanoHex()"
});
formatter.result({
  "duration": 75345661,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 87894,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 32818,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexThatIsNotPartOfASettlement()"
});
formatter.result({
  "duration": 6902104,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 57429,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 30796,
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
  "duration": 20387840,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 410925,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATiger()"
});
formatter.result({
  "duration": 37074,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.thePlayerPlacesThatTigerOnAHexInASettlementWithATigerAlreadyInIt()"
});
formatter.result({
  "duration": 403975380,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerFailsAndAWarningMessageIsShown()"
});
formatter.result({
  "duration": 39679,
  "status": "passed"
});
formatter.before({
  "duration": 2432115,
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
  "duration": 88879,
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
  "duration": 5637693,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheMeepleIsSuccessful()"
});
formatter.result({
  "duration": 61318,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATotoroAndCreateANewTotoroSanctuary()"
});
formatter.result({
  "duration": 33788,
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
  "duration": 8576023,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTotoroIsSuccessful()"
});
formatter.result({
  "duration": 217171,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.aPlayerChoosesToPlaceATigerAndCreateANewTigerPlayground()"
});
formatter.result({
  "duration": 127061,
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
  "duration": 38626779,
  "status": "passed"
});
formatter.match({
  "location": "BuildStep.placingTheTigerIsSuccessful()"
});
formatter.result({
  "duration": 60096,
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
  "duration": 6494625,
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
  "duration": 4720949,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAnotherTileAndTheVolcanoesDoNotMatchUp()"
});
formatter.result({
  "duration": 441439,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 205545,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 2049661,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnASingleTile()"
});
formatter.result({
  "duration": 493101,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 915608,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 3204412,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnTilesOfVariousLevels()"
});
formatter.result({
  "duration": 195060,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 39622,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 1135740,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexContainingATotoro()"
});
formatter.result({
  "duration": 190055,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 51580,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 802619,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedOnAHexWithASizeOneSettlement()"
});
formatter.result({
  "duration": 266259,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 163336,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.thereAreTilesOnTheBoardAndItIsThePlayersTurnToPlaceATile()"
});
formatter.result({
  "duration": 5398294,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingTileCompletelyWipesOutASettlement()"
});
formatter.result({
  "duration": 1008809,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingFails()"
});
formatter.result({
  "duration": 319980,
  "status": "passed"
});
formatter.before({
  "duration": 2629083,
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
  "duration": 40685705,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theTileIsPlacedAndAllOfTheNukingConditionsAreSatisfied()"
});
formatter.result({
  "duration": 1198151,
  "status": "passed"
});
formatter.match({
  "location": "NukingStep.theNukingIsSuccessful()"
});
formatter.result({
  "duration": 51339,
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
  "duration": 11138140,
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
  "duration": 30503,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATile()"
});
formatter.result({
  "duration": 148921,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsSuccessfullyPlacedInTheMap()"
});
formatter.result({
  "duration": 135433,
  "status": "passed"
});
formatter.before({
  "duration": 7190336,
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
  "duration": 28527,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileNextToAnotherTile()"
});
formatter.result({
  "duration": 97940,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theTileIsAddedToTheMap()"
});
formatter.result({
  "duration": 104255,
  "status": "passed"
});
formatter.before({
  "duration": 3009179,
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
  "duration": 33179,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceATileDirectlyOnTopOfAnotherTile()"
});
formatter.result({
  "duration": 96038,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.thePlacementFails()"
});
formatter.result({
  "duration": 367606,
  "status": "passed"
});
formatter.before({
  "duration": 12636474,
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
  "duration": 89176,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.youPlaceTheTileUnnconnectedToAnotherTile()"
});
formatter.result({
  "duration": 270291,
  "status": "passed"
});
formatter.match({
  "location": "PlacementTileStep.theUnnconnectedPlacementFails()"
});
formatter.result({
  "duration": 106806,
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
  "duration": 2552753,
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
  "duration": 143169,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreCounted()"
});
formatter.result({
  "duration": 44441,
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
  "duration": 2956142,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.aNewSetOfTiles()"
});
formatter.result({
  "duration": 70582,
  "status": "passed"
});
formatter.match({
  "location": "TerrainsStep.theTilesAreExamined()"
});
formatter.result({
  "duration": 27917,
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
  "duration": 231075,
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
  "duration": 2979701,
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
  "duration": 1979961,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.itSTimeToBegin()"
});
formatter.result({
  "duration": 21494442,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerIsChosenAtRandomToStartTheGame()"
});
formatter.result({
  "duration": 86172,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.aPlayerToBegin()"
});
formatter.result({
  "duration": 96801,
  "status": "passed"
});
formatter.match({
  "location": "TurnsStep.thatPlayerSTurnIsOver()"
});
formatter.result({
  "duration": 7139337,
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
  "duration": 24899368,
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
  "duration": 871052,
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