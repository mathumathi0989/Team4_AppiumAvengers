#Author: Mathumathi
Feature: UnSubscribe functionality

Background: 
Given User is on Trending tab

 	 Scenario: Verify the presence of Unsubscribe option
   	Given User open already subscribed video
   	When User click on three dots in any video
   	And click on channel
   	Then User should see the Unsubscribe option
   	
   Scenario: Verify the presence of Unsubscribe button
   	When User open already subscribed video
   	Then User should see the Unsubscribe button
   
   Scenario: Validate if user able to Unsubscribe the channel
   	When User open already subscribed video
   	And click on Unsubscribe
   	Then Toast message "Unsubscribed" should be displayed for unsubscribe
   	
   Scenario: Validate if user able to Unsubscribe the video
    Given User open already subscribed video
    When User click on three dots in any video
    And click on channel 
    And click on Unsubscribe
    Then Toast message "Unsubscribed" should be displayed for unsubscribe
    