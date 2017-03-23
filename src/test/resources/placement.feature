@smokeTest
Feature: Placing Tiles

  Scenario: A new game has started
    Given a tile is already place in the board
    When you place a tile
    Then the tile is successfully placed in the map

  Scenario: Overlapping Tile Placement
    Given a tile is already on the board
    When you place a new tile that overlaps the other
    Then the tile is unsuccessfully placed in the map

