Feature: Task Creation & Task Removing Test Cases

  Scenario: Verify that task can be created via API
    Given User should have a project
    When Send task creation API request
    Then Task should be created
    When Send task remove API request
    Then Task should be removed

  Scenario: Clean Up
    Given Remove all projects
