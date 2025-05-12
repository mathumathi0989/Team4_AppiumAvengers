#Author:Anusuya S
 @VideoBlockFunctionality

Feature: Video Blocker Setup Functionality
 Background:  
   Given    User launched the app 

  @VideoBlockFunctionality  
  Scenario: Verify the block channel option in search results
    Given User is on the Search tab to block channel
    When User searches for a specific channel
    And User clicks the three-dot menu for that channel
    Then User should see the "Block Channel" option
 
   @VideoBlockFunctionality
  Scenario: Validate adding a channel to the block list
    Given User is on the Video Blocker settings page
    When User selects either the Deny List or Allow List
    Then User should see videos listed in the Block List
  
   @VideoBlockFunctionality  
  Scenario: Validate unblocking channel from blocklist
  
    Given User is on the Video Blocker settings page to unblock
    When User unblocks either the Deny List or Allow List
    Then User should see videos in playlist
 

 
 
 