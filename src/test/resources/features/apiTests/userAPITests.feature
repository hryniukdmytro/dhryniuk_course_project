Feature: [API] User Creation & User Removing Test Cases

  Scenario: Verify that user can be created & removed via API
    When User creation request was sent via API
    Then User should be created
    When Remove last created user request was sent via API
    Then User should be removed