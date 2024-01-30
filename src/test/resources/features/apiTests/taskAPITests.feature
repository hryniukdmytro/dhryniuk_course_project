Feature: [API] Project Task Test Cases

  Scenario: Verify that task can be created and removed via API
    # Preconditions
    When API request to create a project with name "Task Creation Test via API" was sent
    Then Project with name "Task Creation Test via API" should be created
    # Steps & Checks
    When Task with name "Task To Create via API" was added to the last created project via API
    Then Task with name "Task To Create via API" should be created
    When API request to remove last created task has been sent
    Then Task should be removed

  Scenario: Clean Up
    Given All projects should be removed
