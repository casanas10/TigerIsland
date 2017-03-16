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
<<<<<<< HEAD
=======
formatter.before({
  "duration": 147968,
  "status": "passed"
});
formatter.before({
  "duration": 48324,
  "status": "passed"
});
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
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
<<<<<<< HEAD
  "duration": 197088834,
=======
  "duration": 94825186,
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
<<<<<<< HEAD
  "duration": 793508,
=======
  "duration": 40627,
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
<<<<<<< HEAD
  "duration": 6114966,
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
  "duration": 7704830,
=======
  "duration": 48753,
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
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
<<<<<<< HEAD
=======
formatter.before({
  "duration": 62865,
  "status": "passed"
});
formatter.before({
  "duration": 53884,
  "status": "passed"
});
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
formatter.scenario({
  "line": 4,
  "name": "A new game is created and all meeples are create",
  "description": "",
  "id": "pieces;a-new-game-is-created-and-all-meeples-are-create",
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
<<<<<<< HEAD
  "duration": 1740680,
=======
  "duration": 66714,
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
<<<<<<< HEAD
  "duration": 246090,
=======
  "duration": 47042,
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
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
<<<<<<< HEAD
  "duration": 506199,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "A new game is created and all Totoro are created",
  "description": "",
  "id": "pieces;a-new-game-is-created-and-all-totoro-are-created",
=======
  "duration": 1950098,
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
  "duration": 97077,
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
  "duration": 1336843,
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
  "duration": 136422,
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
  "duration": 27797,
  "status": "passed"
});
formatter.before({
  "duration": 17106,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "A new game is created",
  "description": "",
  "id": "player;a-new-game-is-created",
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
<<<<<<< HEAD
  "line": 12,
  "name": "a new game is created",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "the game begins",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "6 Totoros are successfully created with the correct properties",
  "keyword": "Then "
});
formatter.match({
  "location": "MeeplesStep.aNewGameIsCreated()"
});
formatter.result({
  "duration": 263301,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 217803,
=======
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
  "duration": 81681,
  "status": "passed"
});
formatter.match({
  "location": "PlayerStep.theGameStarts()"
});
formatter.result({
  "duration": 42765,
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
<<<<<<< HEAD
      "val": "6",
      "offset": 0
    }
  ],
  "location": "MeeplesStep.totorosAreSuccessfullyCreatedWithTheCorrectProperties(int)"
});
formatter.result({
  "duration": 403825,
=======
      "val": "0",
      "offset": 55
    }
  ],
  "location": "PlayerStep.playerCreation(int)"
});
formatter.result({
  "duration": 120170,
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
  "duration": 80399,
>>>>>>> 3ff3707e2c768e3559bb792df46eda2878d370ca
  "status": "passed"
});
});