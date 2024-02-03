Feature: [API] Project Task Test Cases

  Scenario: Verify that task can be created and removed via API
    # Preconditions
    When API request to create a project with name "Task Creation Test via API" was sent
    Then Verify that project with name "Task Creation Test via API" is created
    # Steps & Checks
    When Task with name "Task To Create via API" was added to the last created project via API
    Then Verify that task with name "Task To Create via API" is created
    When API request to remove last created task has been sent
    Then Verify that task is removed

  Scenario: Clean Up
    Given All projects should be removed
