$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("pieces.feature");
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
  "duration": 210833,
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
  "duration": 93897179,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 125730,
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
  "duration": 4940247,
  "status": "passed"
});
formatter.before({
  "duration": 44048,
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
  "duration": 34640,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 32929,
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
  "duration": 109052,
  "status": "passed"
});
});