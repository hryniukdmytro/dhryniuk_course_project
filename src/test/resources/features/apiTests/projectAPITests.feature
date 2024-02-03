Feature: [UI] Project Test Сases

  Scenario: Verify that project can be created & removed via API
    When API request to create a project with name "Project Creation Test" was sent
    Then Verify that project with name "Project Creation Test" is created
    When API request to remove last created project has been sent
    Then Verify that project is removed