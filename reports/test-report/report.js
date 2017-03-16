$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("pieces.feature");
formatter.feature({
  "line": 2,
  "name": "Meeples",
  "description": "",
  "id": "meeples",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
  "duration": 278009,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "A new game is created and all meeples are create",
  "description": "",
  "id": "meeples;a-new-game-is-created-and-all-meeples-are-create",
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
  "duration": 253069108,
  "status": "passed"
});
formatter.match({
  "location": "MeeplesStep.theGameBegins()"
});
formatter.result({
  "duration": 228205,
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
  "duration": 12629813,
  "status": "passed"
});
});