#Author: Mathumathi
Feature: Watched Video Cleaner functionality

Background: 
Given User is on Trending tab

 	 Scenario: Verify the presence of Watched Video Cleaner option
   	When User click on three dots in top right page
   	Then User should see the Watched video cleaner option
   
   Scenario: Verify watched video cleaner functionality for watched bookmarks
    Given User already watched bookmarks
    When User click on three dots in top right page
    And Click on watched video cleaner and click on Clean
    Then Toast message should be displayed for bookmarks
    
   Scenario: Verify watched video cleaner functionality for watched downloads
    Given User already watched downloads
    When User click on three dots in top right page
    And Click on watched video cleaner and click on Clean
    Then Toast message should be displayed for downloads
    
    
