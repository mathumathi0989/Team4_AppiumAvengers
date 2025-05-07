#Author: Mathumathi
Feature: Video play functionality

Background: 
Given User is on Trending tab

  Scenario: Verify the video play functionality
    Given User opens any video to test the video play
    When User click on video and watch sometime
    Then video plays
    
  Scenario: Verify the video pause
    Given User opens any video to test the video play
    When User click on video and watch sometime
    Then video paused
    
    Scenario: Verify the fast forward 
    Given User opens any video to test the video play
    When User click on video and watch sometime
    And User click on fast forward
    Then video fast forwarded
    
     Scenario: Verify the fast rewind
    Given User opens any video to test the video play
    When User click on video and watch sometime
    And User click on fast rewind 
    Then video fast rewinded
    
     Scenario: Verify the phone rotate in landscape
    Given User opens any video to test the video play
    When User click on video and watch sometime
    And User click on lanscape mode
    Then video plays in landscape mode
    
      Scenario: Verify resume alert popup 
    Given User opens any watched videos
    When User click on watched video
    Then Resume Alert popup
    
         Scenario: Verify start from beginning functionality
    Given User opens any watched videos
    When User click on watched video
    And Resume popup appears and click on No
    Then video starts from beginning
    
        Scenario: Verify resume functionality
    Given User opens any watched videos
    When User click on watched video
    And Resume popup appears and click on Resume
    Then video continues 
    
   
    
     