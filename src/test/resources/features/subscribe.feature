#Author: Mathumathi
Feature: Subscribe functionality

Background: User launched the app

  Scenario: Verify the presence of subscribe option
    Given User is on Trending tab
    When User click on three dots in any video
    And click on channel
    Then User should see the "subscribe" option
