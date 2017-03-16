$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "line": 2,
  "name": "Test Cucumber",
  "description": "",
  "id": "test-cucumber",
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
  "name": "cucumber setup",
  "description": "",
  "id": "test-cucumber;cucumber-setup",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "something",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I run the program",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "run should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.something()"
});
formatter.result({
  "duration": 244981513,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iRunTheProgram()"
});
formatter.result({
  "duration": 48108,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.runShouldBeSuccessful()"
});
formatter.result({
  "duration": 37933,
  "status": "passed"
});
});