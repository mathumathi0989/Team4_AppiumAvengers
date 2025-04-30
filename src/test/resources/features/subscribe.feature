#Author: Mathumathi
Feature: Subscribe functionality

Background: 
Given User is on Trending tab

  Scenario: Verify the presence of subscribe option
    When User click on three dots in any video
    And click on channel
    Then User should see the subscribe option

   Scenario: Verify the presence of subscribe button
   	When User click on any video
   	Then User should see the subscribe button
   
   Scenario: Validate if user able to subscribe the channel
   	When User click on any video
   	And click on subscribe
   	Then Toast message "subscribe" should be displayed for subscribe
   
   Scenario: Validate if user able to subscribe the video
   	When User click on three dots in any video
   	And click on channel
   	And click on subscribe
   	Then Toast message "subscribe" should be displayed for subscribe
   	
  
    
   	 	
  
   	
