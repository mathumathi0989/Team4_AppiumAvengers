Feature: preferences functionality

  Background:
    Given User launched the app
    And User is on Trending tab


    Scenario: Verify the presence of preferences option
      When User click on three dots in top right page1
      Then User should see the preferences option

      Scenario: Verify the presence of preferences button
        When User click on three dots in top right page1
        And User click on preferences option
        Then User should be on preferences page

        Scenario: Verify Preferences page Buttons
        When User click on three dots in top right page1
        And User click on preferences option
        Then User should see the following buttons present:
      | Video Player         |
      | Video Blocker        |
      | SponsorBlock         |
      | Import/Export        |
      | Privacy              |
      | Network and Downloads|
      | Others               |
      | About                |

#flaky test
      Scenario: Verify the Video Player option
        When User click on three dots in top right page1
        And User click on preferences option
        And User taps on the "Video Player" option
        Then A dialog with title "Video Player" should appear
        And The radio option "Default" should be selected

#flaky test
        Scenario: Verify and change the Screen Orientation option
  When User click on three dots in top right page1
  And User click on preferences option
  And User taps on the "Video Player" option
  Then A dialog with title "Video Player" should appear
  And The orientation value should be set to "Auto"
  When User taps on the Screen Orientation option
  And User selects "Portrait" from the orientation dialog
  Then The orientation value should be set to "Portrait"
  
#    And User selects Landscape from the orientation dialog
#    Then The orientation value should be set to "Landscape"
#    And User selects Mirror from the orientation dialog
#    Then The orientation value should be set to "Mirror"
