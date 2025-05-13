#Author:Anusuya S

@Search
Feature: Search Channel

Background:  

Given User is on Trending tab

@Search
Scenario: Validate Search for a valid channel name
Given User is on the Home screen	
When User taps on the search icon and enters a valid channel name	
Then Use should see matching channel results displayed
 
@Search
Scenario: Validate Tap and navigate to channel
Given User has a valid channel search results returned		
When User taps on a channel name from the results
Then User should be navigated to the channel page

@Search
Scenario: Validate Search with case-insensitive input
Given User is on the search tab		
When User enters a channel name in mixed case Ex:"NatGeo"
Then User should see matching channels should still appear

#Flaky tests
#@Search
#Scenario: Validate Search with partial channel name
#Given User is on the search tab	
#When User enters a part of a known channel name
#Then 	User able to see related suggestions appeared

@Search
Scenario: Validate Search with leading/trailing spaces
Given User is on the search tab	
When  User enters search input with spaces	
Then User should see results shown for "AB C"

@Search
Scenario: Validate Search history 
Given User is on the search Tab with searched channel details before		
When User clicks the search bar again
Then Recent searches should appear

#@Search
#Scenario: Validate Search with special characters
#Given User is on the search tab	
#When  User enters "@#$%^&" 
#Then No results should appear, and the app should not crash

#Flaky tests
#@Search
#Scenario: Validate Search with empty string
#Given User is on the search tab	
#When User presses search without typing anything
#Then Either all results should be shown or a message “Please enter search query”

  
