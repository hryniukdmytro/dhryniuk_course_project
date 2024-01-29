Feature: [API] User Creation & User Removing Test Cases

  Scenario: Verify that user can be created & removed via API
    When Send user creation API request
    Then User should be created
    When Send user remove API request
    Then User should be removed