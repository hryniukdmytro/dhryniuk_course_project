Feature: Dashboard Project Test cases

  Scenario: Verify that new project can be created
    Given User should be logged in
    When Click on the 'New project' button
    And Fill the form with valid data (name 'Empty Project')
    And Click the 'Save' button
    Then New project should be opened and displayed

  Scenario: Verify that new task can be created for a project
    Given User should have a project (Project name for test: 'Project with one task')
    Given User should have project opened
    When Click on gear icon to open project configurations dropdown
    And Click 'Add a new task' dropdown option
    And Fill the task creation form (task name 'Task One' and description 'Description One')
    And Click the 'Save' button to save the new task
    And Open the 'List' section
    And Click the title of a new task
    Then Check that task status is 'open'


  Scenario: Verify that new task can be closed
      # --------------------Replace with an API precondition step-------------------------------
    Given User should be logged in
    When Click on the 'New project' button
    And Fill the form with valid data (name 'Project with closed task')
    And Click the 'Save' button
    Then New project should be opened and displayed
    When Click on gear icon to open project configurations dropdown
    # And Click 'Add a new task' dropdown option
    And Fill the task creation form (task name 'Task Two' and description 'Description Two')
    And Click the 'Save' button to save the new task
      # ----------------------------------------------------------------------------------------
    When Open the 'List' section
    And Click the title of a new task
    And Click the 'Close this task' button
    And Confirm task closing by clicking 'Yes' in 'Close Task' pop-up
    Then Check that task status is 'closed'

  Scenario: Verify that comment can be added to the task
      # --------------------Replace with an API precondition step-------------------------------
    Given User should be logged in
    When Click on the 'New project' button
    And Fill the form with valid data (name 'Project with commented task')
    And Click the 'Save' button
    Then New project should be opened and displayed
    When Click on gear icon to open project configurations dropdown
    # And Click 'Add a new task' dropdown option
    And Fill the task creation form (task name 'Task Three' and description 'Description Three')
    And Click the 'Save' button to save the new task
    And Open the 'List' section
    And Click the title of a new task
    Then Check that task status is 'open'
      # ----------------------------------------------------------------------------------------
    When Click the 'Add a comment' button
    And Fill the comment form with valid data ('Comment Text')
    And Click 'Save' button to save the comment
    Then Check that comment is displayed

