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
  "duration": 197088834,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
  "duration": 793508,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
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
formatter.match({
  "location": "MeeplesStep.aNewGameIsCreated()"
});
formatter.result({
  "duration": 1740680,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 246090,
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
  "duration": 506199,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "A new game is created and all Totoro are created",
  "description": "",
  "id": "pieces;a-new-game-is-created-and-all-totoro-are-created",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
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
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 0
    }
  ],
  "location": "MeeplesStep.totorosAreSuccessfullyCreatedWithTheCorrectProperties(int)"
});
formatter.result({
  "duration": 403825,
  "status": "passed"
});
});