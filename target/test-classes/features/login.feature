Feature: Login functionality

  Scenario Outline: Valid and Invalid Login
    Given user is on login page
    When user enters username "<username>" and password "<password>"
    And user clicks the login button
    Then login should be "<status>"

    Examples:
      | username   			| password   | status  |
      | standard_user  | secret_sauce  | success |
      | invalidUser | secret_sauce | failure |
      | standard_user  | invalidPass | failure |