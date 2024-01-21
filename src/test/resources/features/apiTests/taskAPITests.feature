Feature: [API] Task Creation & Task Removing Test Cases

  Scenario: Verify that task can be created and removed via API
    # Preconditions
    When Send project creation API request
    Then Project should be created
    # Steps & Checks
    When Send task creation API request
    Then Task should be created
    When Send task remove API request
    Then Task should be removed

  Scenario: Clean Up
    Given Remove all projects
