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
  "duration": 247224,
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
formatter.match({
  "location": "GameStep.nothingHasYetHappened()"
});
formatter.result({
  "duration": 254956253,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.theGameInitiates()"
});
formatter.result({
  "duration": 177895,
  "status": "passed"
});
formatter.match({
  "location": "GameStep.aNewGameIsSuccessfullyCreated()"
});
formatter.result({
  "duration": 8191565,
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
  "duration": 256937,
  "status": "passed"
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
  "duration": 245787,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 223103,
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
  "duration": 11562212,
  "status": "passed"
});
});