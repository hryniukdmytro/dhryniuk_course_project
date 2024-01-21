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

  Scenario: Verify that new task can be created for a project
    # Preconditions
    When Send project creation API request
    Then Project should be created
    Given User should be logged in
    Given User should have project opened
    # Steps
    When Click on gear icon to open project configurations dropdown
    And Click 'Add a new task' dropdown option
    And Fill the task creation form
    And Click the 'Save' button to save the new task
    And Open the 'List' section
    And Click the title of a new task
    # Final Check
    Then Check that task status is 'open'


  Scenario: Verify that new task can be closed
    # Preconditions
    When Send project creation API request
    Then Project should be created
    When Send task creation API request
    Then Task should be created
    Given User should be logged in
    Given User should have task opened
    # Steps
    When Click the 'Close this task' button
    And Confirm task closing by clicking 'Yes' in 'Close Task' pop-up
    # Final Check
    Then Check that task status is 'closed'

  Scenario: Verify that comment can be added to the task
    # Preconditions
    When Send project creation API request
    Then Project should be created
    When Send task creation API request
    Then Task should be created
    Given User should be logged in
    Given User should have task opened
    # Steps
    When Click the 'Add a comment' button
    And Fill the comment form
    And Click 'Save' button to save the comment
    # Final Check
    Then Check that comment is displayed

  Scenario: Clean up
    Given Remove all projects

