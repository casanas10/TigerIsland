@smokeTest
Feature: Pieces

  Scenario: A new game is created and all meeples are created

    Given a new game is created
    When the game begins
    Then 40 meeples are successfully created with the correct properties
    And 6 Totoros are successfully created with the correct properties
    And the White player has 3 "white" Totoros
    And the Black player has 3 "black" Totoros