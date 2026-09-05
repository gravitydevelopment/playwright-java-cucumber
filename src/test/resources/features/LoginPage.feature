Feature: Evaluate Qainterview Login Page

  @sanity
  Scenario: Verify Login Page
    Given Access Qainterview login page
    When Verify page name is correct
    Then Verify Username and Password entry fields existed
    And Verify link for creating new user existed
    And Verify login button is visible with default disable

  @sanity
  Scenario Outline: Register new user
    Given Access Qainterview login page
    And Click register new user link
    When User redirected to the create new user page
    Then Fill up username entry field "<username>"
    And Fill up password entry field "<password>"
    And Click create account button
    Examples:
      | username          | password         |
      | test-1@test.com   | test-1-password  |
      | test-1            | test-1-password  |

  @sanity
  Scenario: User Login into the system
    Given Access Qainterview login page
    When User enter username "testing_01@test.com"
    And User enter password "Testing@0123"
    Then User click login button and access the system
    And User verify the system redirect user to the Stock Market Dashboard



