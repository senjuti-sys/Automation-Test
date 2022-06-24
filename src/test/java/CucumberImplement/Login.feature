Feature: Login

  Scenario: Verify Login with invalid credentials
    Given Open browser and navigate to Login page
    When Enter Email and Password
    Then Login Unsuccessful and close test
