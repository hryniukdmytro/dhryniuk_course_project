Feature: [UI] Project Test Сases

  Scenario: Verify that new project can be created
    # Preconditions
    Given User should be logged in
    # Steps
    When Click on the 'New project' button
    And Fill the project creation form
    And Click the 'Save' button
    # Final Check
    Then New project should be opened and displayed

  Scenario: Verify that project can be closed
    # Preconditions
    When Send project creation API request
    Then Project should be created
    Given User should be logged in
    And User should have project opened
    # Steps
    When Click on gear icon to open project configurations dropdown
    And Click on 'Configure this project' button
    Then Check the that project status is 'open'
    When Click on 'Close this project' button
    And Click 'Yes' in appeared modal window
    Then Check the that project status is 'closed'


  Scenario: Clean up
    Given All projects should be removed

