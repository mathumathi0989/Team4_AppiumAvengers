#Author:Anusuya S



 @VideoBlockFunctionality

Feature: VideoBlock Functionality
 Background:  
   Given    User launched the app

 
 Scenario: Verify the video blocker and block videos with a specific keyword
    Given  the user navigates to the Video Blocker settings				
    When  the user enables the video blocker toggle
    And   the user adds the keyword "spoiler"
    Then  User should see the videos with the keyword "spoiler" not in the feed list
    
 Scenario: Validate Add Channel to Block List
    Given  the user is on the Video Blocker settings page				
    When  the user adds the channel "XXX" to the block list
    Then User should see videos from "XXX" not visible in the feed
    
 Scenario: Validate Disable Video Blocker to Show All Videos 
    Given User in video blocker settings as currently enabled			
    When  the user disables the video blocker toggle	
    Then  User should see all previously blocked videos should appear in the feed
 
 
 Scenario: Validate Blocking a Non-Existing Channel
    Given the user is on the Video Blocker settings page		
    When  the user enters "YYY" as a channel to block	
    Then  User should see a warning "Channel not found" and channel not in list
 
 
 