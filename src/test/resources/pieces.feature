@smokeTest
Feature: Pieces

  Scenario: A new game is created and all meeples are create

    Given a new game is created
    When the game begins
    Then 40 meeples are successfully created with the correct properties

  Scenario: A new game is created and all Totoro are created

    Given a new game is created
    When the game begins
    Then 6 Totoros are successfully created with the correct properties