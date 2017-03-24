@smokeTest
Feature: Placing Tiles

  Scenario: A new game has started
    Given a tile is already place in the board
    When you place a tile
    Then the tile is successfully placed in the map

  Scenario: Placing tiles next to each other
    Given a tile is already place in the board
    When you place a tile next to another tile
    Then the tile is added to the map

  Scenario: Placing a tile directly on top of another
    Given a tile is already place in the board
    When you place a tile directly on top of another tile
    Then the placement fails

  Scenario: Placing an unnconnected tile
    Given a tile is already place in the board
    When you place the tile unnconnected to another tile
    Then the unnconnected placement fails

