@smokeTest

  Feature: Nuking

    Scenario: A player gets a tile, tries to nuke the board, and it fails

      Given There are tiles on the board and it is the players turn to place a tile
      When The tile is placed on another tile and the volcanoes do not match up
      Then The nuking fails

      Given There are tiles on the board and it is the players turn to place a tile
      When The tile is placed on a single tile
      Then The nuking fails

      Given There are tiles on the board and it is the players turn to place a tile
      When The tile is placed on tiles of various levels
      Then The nuking fails

      Given There are tiles on the board and it is the players turn to place a tile
      When The tile is placed on a hex containing a Totoro
      Then The nuking fails

      Given There are tiles on the board and it is the players turn to place a tile
      When The tile is placed on a hex with a size one settlement
      Then The nuking fails

      Given There are tiles on the board and it is the players turn to place a tile
      When The nuking tile completely wipes out a settlement
      Then The nuking fails

    Scenario: A player gets a new tile, decides to nuke the board, and it is successful

      Given There are tiles on the board and it is the players turn to place a tile
      When The tile is placed and all of the nuking conditions are satisfied
      Then The nuking is successful