@smokeTest
  Feature: Building

    Scenario: It's a player's turn to build and it fails
      Given A player chooses to place a meeple and create a new settlement
      When The player places the meeple on a volcano hex
      Then Placing the meeple fails and a warning message is shown

      Given A player chooses to place a meeple and create a new settlement
      When The player places the meeple on an already occupied hex
      Then Placing the meeple fails and a warning message is shown

      Given A player chooses to place a meeple and create a new settlement
      When The player places the meeple on a hex that is not level 1
      Then Placing the meeple fails and a warning message is shown

      Given A player chooses to expand
      When The player selects a terrain to expand on to but they don’t have enough meeples
      Then The expansion fails and a warning message is shown

      Given A player chooses to expand
      When The player selects a volcano terrain
      Then The expansion fails and a warning message is shown

      Given A player chooses to place a Totoro
      When The player places that Totoro on a hex that is not part of a settlement
      Then Placing the Totoro fails and a warning message is shown

      Given A player chooses to place a Totoro
      When The player places that Totoro on a hex in a settlement of size less than 5
      Then Placing the Totoro fails and a warning message is shown

      Given A player chooses to place a Totoro
      When The player places that Totoro on a volcano hex
      Then Placing the Totoro fails and a warning message is shown

      Given A player chooses to place a Tiger
      When The player places that Tiger on a volcano hex
      Then Placing the Tiger fails and a warning message is shown

      Given A player chooses to place a Tiger
      When The player places that Tiger on a hex that is not part of a settlement
      Then Placing the Tiger fails and a warning message is shown

      Given A player chooses to place a Tiger
      When The player places that Tiger on a hex that is not level 3 or higher
      Then Placing the Tiger fails and a warning message is shown

      Given A player chooses to place a Tiger
      When The player places that Tiger on a hex in a settlement with a Tiger already in it
      Then Placing the Tiger fails and a warning message is shown

    Scenario: It's a player's turn to build and it succeeds
      Given A player chooses to create a new settlement
      When The player places that Meeple on a level 1, non-volcano hex
      Then Placing the Meeple is successful

      Given A player chooses to place a Totoro and create a new Totoro sanctuary
      When The player places that Totoro on a size 5 settlement that doesn't have a Totoro and is not a volcano hex
      Then Placing the Totoro is successful

      Given A player chooses to place a Tiger and create a new Tiger playground
      When The player places that Tiger on a settlement that doesn't have a tiger, on a level 3 or higher hex thats not a volcano
      Then Placing the Tiger is successful