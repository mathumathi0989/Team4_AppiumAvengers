Feature: Product functionality

  Scenario: Complete product functionality
    Given user is on product page
    When user enters "Sauce Labs Onesie" and click search
    And select that product and proceed the checkout process
    Then validate if user get successfull message "THANK YOU FOR YOU ORDER"