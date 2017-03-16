@smokeTest
Feature: Pieces

  Scenario: A new game is created and all meeples are create

    Given a new game is created
    When the game begins
    Then 40 meeples are successfully created with the correct properties
    And 6 Totoros are successfully created with the correct properties