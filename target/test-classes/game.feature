@smokeTest
  Feature: Game Board

    Scenario: A new game has started
      Given Nothing has yet happened
      When The game initiates
      Then A new game is successfully created
      And 2 players are successfully created, each holding specific player attributes

