#Author:Anusuya S

@Search
Feature: Search Channel

Background:  

Given    User launched the app

Scenario: Validate Search for a valid channel name
Given User is on the Home screen	
When User taps on the search icon and enters a valid channel name	
Then Use should see matching channel results displayed
 

Scenario: Validate Tap and navigate to channel
Given User has a valid channel search results returned		
When User taps on a channel name from the results
Then User should be navigated to the channel page


Scenario: Validate Search with case-insensitive input
Given User is on the search tab		
When User enters a channel name in mixed case Ex:"NatGeo"
Then User should see matching channels should still appear

Scenario: Validate Search with partial channel name
Given User is on the search tab	
When User enters a part of a known channel name
Then 	User able to see related suggestions appeared


Scenario: Validate Search with leading/trailing spaces
Given User in on the search Tab	
When User enters " AB C " (with spaces)	
Then User should see results shown for "AB C"

Scenario: Validate Search history 
Given User is on the search Tab with searched channel details before		
When User clicks the search bar again
Then Recent searches should appear

Scenario: Validate Search for a non-existent channel
Given User in on the search Tab		
When User enters a random or invalid string
Then "No results found" message should appear

Scenario: Validate Search with special characters
Given User enters search input accepts text		
When User enters "@#$%^&"
Then No results should appear, and the app should not crash

Scenario: Validate Search with empty string
Given User in on the search Tab		
When User presses search without typing anything
Then Either all results should be shown or a message “Please enter search query”

Scenario: Validate Network failure during search
Given the network is disabled		
When User tries to search
Then an error toast or message like "No internet connection" should be displayed

Scenario: Validate App crash resilience
Given User is on the search Tab (multiple fast search inputs)
When User enters and deletes quickly
Then  the app should not freeze or crash
 

  
