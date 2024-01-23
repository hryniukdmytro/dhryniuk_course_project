Feature: [UI] Project Task Test Cases

  Scenario: Verify that new task can be created
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
    And User should have task opened
    # Steps
    When Click the 'Close this task' button
    And Click 'Yes' in appeared modal window
    # Final Check
    Then Check that task status is 'closed'

  Scenario: Verify that comment can be added to the task
    # Preconditions
    When Send project creation API request
    Then Project should be created
    When Send task creation API request
    Then Task should be created
    Given User should be logged in
    And User should have task opened
    # Steps
    When Click the 'Add a comment' button
    And Fill the comment form
    And Click 'Save' button to save the comment
    # Final Check
    Then Check that comment is displayed

  Scenario: Verify that subtask can be created
    # Preconditions
    When Send project creation API request
    Then Project should be created
    When Send task creation API request
    Then Task should be created
    Given User should be logged in
    And User should have task opened
    # Steps
    When Click 'Add a sub-task' button
    And Fill the sub-task creation form
    And Click 'Save' button to save new sub-task
    Then Check that new sub-task in created

  Scenario: Verify that task can be copied from another project
    # Preconditions
    When Send project creation API request (name 'Project #1')
    Given User should be logged in
    Given User should have project opened
    When Click on 'Configure this project' button
    When Click on 'Permissions' button
    # TO DO!!! Create precondition steps that will add permissions on projects to admin. Should be done for both created projects.

    When Send project creation API request (name 'Project #2')
    When Send task creation API request
    Then Task should be created
    And User should have task opened
    # Steps
    When Click the 'Duplicate to project' button
    When Click 'Save' button to copy the task
    When Click the link to copied task
    # Final Check
    Then Check that task is opened in 'Project #1'




  #Scenario: Verify that task can be moved within phases


  Scenario: Clean up
    Given Remove all projects