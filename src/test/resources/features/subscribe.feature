#Author: Mathumathi
Feature: Subscribe functionality

Background: 
Given User is on Trending tab

  Scenario: Verify the presence of subscribe option
    Given User opens any video
    When User click on three dots in any video
    And click on channel
    Then User should see the subscribe option

   Scenario: Verify the presence of subscribe button
    Given User opens any video
   	When User click on any video
   	Then User should see the subscribe button
   
   Scenario: Validate if user able to subscribe the channel
    Given User opens any video
   	When User click on any video
   	And click on subscribe
   	Then Toast message "subscribe" should be displayed for subscribe
   
   Scenario: Validate if user able to subscribe the video
    Given User opens any video
   	When User click on three dots in any video
   	And click on channel
   	And click on subscribe link
   	Then Toast message "subscribe" should be displayed for subscribe
   	
  
    
   	 	
  
   	
