#Author:Anusuya S
 @VideoBlockFunctionality

Feature: Video Blocker Setup Functionality
 Background:  
   Given    User launched the app 

  @VideoBlockFunctionality
  
  Scenario: Verify the block channel option in search results
    Given User is on the Search tab
    When User searches for a specific channel
    And User clicks the three-dot menu for that channel
    Then User should see the "Block Channel" option
 
   @VideoBlockFunctionality
    
 
  Scenario: Validate adding a channel to the block list
    Given User is on the Video Blocker settings page
    When User selects either the Deny List or Allow List
    Then User should see videos listed in the Block List
  
   @VideoBlockFunctionality
    
  Scenario: Validate disabling Video Blocker to show all videos
    Given Video Blocker is currently enabled in settings
    When User disables the Video Blocker toggle
    Then Blocked videos should now be visible in the list
 

 
 
 