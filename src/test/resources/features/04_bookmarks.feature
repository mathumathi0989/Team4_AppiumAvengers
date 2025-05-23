Feature: Bookmark and Unbookmark Functionality

  Background:
    Given User launched the app
    And User is on Trending tab

  @Bookmark
  Scenario: Validate empty state message when no videos are bookmarked
    When User clicks Bookmark tab
    Then The user should see the message Bookmark some videos to find them here.

  @Bookmark
  Scenario: Verify the presence of bookmark option
    When User clicks on three dots in  video
    Then User should see the Bookmark option

  @Bookmark
  Scenario: Validate if user is able to bookmark the channel
    When User clicks on three dots in  video
    And Clicks on Bookmark
    # Then Toast message "Bookmarked" should be displayed

  @Unbookmark
  Scenario: Verify the presence of Unbookmark option
    When User clicks on three dots in bookmarked video
    Then User should see the Unbookmark option

#flakyTest
  @Unbookmark 
  Scenario: Verify the presence of Unbookmark button
    When User clicks on three dots in bookmarked video
    And clicks on Unbookmark button
  #   Then The Toast message "Unbookmarked" should be displayed


 

  @Unbookmark
  Scenario: Validate if user is able to unbookmark the channel in Bookmark tab
  When User clicks on three dots in bookmarked video for bookmark tab
  And User clicks Bookmark tab
  And Clicks on three dots in bookmarked tab
  When User clicks on Unbookmark in bookmarked tab
 Then The user should see the message Bookmark some videos to find them here.
