@smokeTest
Feature: Turns

  Scenario: The game has just started.
    Given A brand new game
    When It’s time to begin
    Then A player is chosen at random to start the game

