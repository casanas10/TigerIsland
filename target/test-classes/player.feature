@smokeTest

  Feature: Player

    Scenario: A new game is created

      Given A new game is created
      When The game starts
      Then A player is successfully created with a start score of 0
      And The player is assigned a color "White"


