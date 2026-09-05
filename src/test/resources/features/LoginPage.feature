Feature: Evaluate Qainterview Login Page

@draft
Scenario: Verify Login Page
  Given Access Qainterview login page
  When Verify page name is correct
  Then Verify Username and Password entry fields existed
  And Verify login button is displayed



