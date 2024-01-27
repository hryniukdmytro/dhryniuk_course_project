@Project
Feature: [UI] Project Test Сases

  Scenario: Verify that project can be created & removed via API
    When Send project creation API request
    Then Project should be created
    When Send project remove API request
    Then Project should be removed