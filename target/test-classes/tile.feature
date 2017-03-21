@smokeTest
Feature: Tiles

  Scenario: A new game board has been created

    Given an empty game board
    When a tile is placed
    Then it should successfully become part of the game board

  Scenario: A tile has already been placed on the board

    Given another tile is going to be placed on the board
    When the tile is placed unconnected to another tile
    Then placing the tile fails
    And there is a warning message

    Given another tile is going to be placed on the board
    When the tile is placed overlapping another tile
    Then placing tile fails
    And warning message

    Given another tile is going to be placed on the board
    When the tile is placed while its edges are touching one or more other tiles
    Then The tile is successfully placed


