@smokeTest
Feature: Turns

  Scenario: The game has just started
    Given a brand new game
    When it’s time to begin
    Then a player is chosen at random to start the game

    Given a player to begin
    When that player’s turn is over
    Then the turn changes to the next player

  Scenario: The game has been going on for a certain period of time
    Given one player’s turn is currently going on
    When that player’s turn is over
    Then the next player’s turn begins
