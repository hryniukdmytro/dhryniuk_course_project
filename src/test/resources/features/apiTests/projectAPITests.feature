Feature: [UI] Project Test Сases

  Scenario: Verify that project can be created & removed via API
    When API request to create a project with name "Project Creation Test" was sent
    Then Project with name "Project Creation Test" should be created
    When API request to remove last created project has been sent
    Then Project should be removed