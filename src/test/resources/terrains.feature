@smokeTest
  Feature: Terrain Types

    Scenario: a new set of tiles is created
      Given a new set of tiles
      When the tiles are counted
      Then there are 48 total

      Given a new set of tiles
      When the tiles are examined
      Then there are 2 terrain types on each tile, 1 volcano per tile, 16 kinds of tiles, and 3 tiles of each type
