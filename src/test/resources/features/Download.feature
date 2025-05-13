Feature: Download & Delete Download

  Background:
   Given User launched the app
    And User is on Trending tab

  # Download Scenarios

    @Download
  Scenario: Validate empty state message when no videos are Downloaded
    When User clicks Download tab
    Then The user should see the message Download some videos to find them here.

  @Download
  Scenario: Verify the presence of Download option
    When User clicks on three dots in  video
    Then User should see the Download option

  Scenario: Validate if user is able to Download the channel
     When User clicks on three dots in  video
    And clicks on Download
  #   Then Toast message Download should be displayed

   @DeleteDownload
  Scenario: Verify the presence of DeleteDownload option
    When User clicks on three dots in Downloaded video
    Then User should see the DeleteDownload option

  @DeleteDownload
  Scenario: Verify the presence of DeleteDownload button
    When User clicks on three dots in Downloaded video
    And clicks on DeleteDownload button
  #   Then The Toast message "Unbookmarked" should be displayed



  @DeleteDownload
  Scenario: Validate if user is able to DeleteDownload the channel in Download tab
   When User clicks on three dots in  video
    And clicks on Download
    And User clicks Download tab
    And Clicks on three dots in Downloaded tab
    When User clicks on DeleteDownload in Downloaded tab
    Then The user should see the message Download some videos to find them here.
 