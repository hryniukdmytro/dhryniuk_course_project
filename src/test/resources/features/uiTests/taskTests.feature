Feature: [UI] Project Task Test Cases

  Scenario: Verify that new task can be created
    # Preconditions
    When API request to create a project with name "Task Adding Test" was sent
    Then Project with name "Task Adding Test" should be created
    Given User should be logged in
    Given User should have project opened
    # Steps
    When Project_Configurations_Dropdown on Project_Page has been clicked
    And Add_Task_Button on Project_Page has been clicked
    And Text "Task to create" was entered into Form_Title_TextField on Project_Page
    And Modal_Save_Button on Project_Page has been clicked
    And View_Task_List_Button on Project_Page has been clicked
    And Existing_Task_Title on Project_Page has been clicked
    # Final Check
    Then Trimmed text of the Task_State on Project_Page should be "open"

  # Task State is shown as "closed" and element text is "closed" however test is getting "open"
  Scenario: Verify that new task can be closed
    # Preconditions
    When API request to create a project with name "Task Closure Test" was sent
    Then Project with name "Task Closure Test" should be created
    When Task with name "Task To Close" was added to the last created project via API
    Then Task with name "Task To Close" should be created
    Given User should be logged in
    And User should have last created task opened
    # Steps
    When Close_Task_Button on Project_Page has been clicked
    And Yes_Modal_Button on Project_Page has been clicked
    # Final Check
    Then Trimmed text of the Task_State on Project_Page should be "closed"

  Scenario: Verify that comment can be added to the task
    # Preconditions
    When API request to create a project with name "Comment Adding Test" was sent
    Then Project with name "Comment Adding Test" should be created
    When Task with name "Task To Comment" was added to the last created project via API
    Then Task with name "Task To Comment" should be created
    Given User should be logged in
    And User should have last created task opened
    # Steps
    When Add_Comment_Button on Project_Page has been clicked
    And Text "Test Comment" was entered into Comment_Modal_TextArea on Project_Page
    And Save_Comment_Button on Project_Page has been clicked
    # Final Check
    Then Text "Test Comment" should be displayed in Added_Comment on Project_Page

  Scenario: Verify that subtask can be created
    # Preconditions
    When API request to create a project with name "Sub-Task Adding Test" was sent
    Then Project with name "Sub-Task Adding Test" should be created
    When Task with name "Task For Sub-Task" was added to the last created project via API
    Then Task with name "Task For Sub-Task" should be created
    Given User should be logged in
    And User should have last created task opened
    # Steps
    When Add_SubTask_Button on Project_Page has been clicked
    And Text "Test Sub-Task" was entered into Form_Title_TextField on Project_Page
    And Save_SubTask_Button on Project_Page has been clicked
    Then Text "Test Sub-Task" should be displayed in Existing_SubTask_Title on Project_Page

  Scenario: Verify that task can be copied from another project
    # Preconditions
    When API request to create a project with name "Task Copying Test Project #1" was sent
    And User was set as member of last created project via API
    And API request to create a project with name "Task Copying Test Project #2" was sent
    And User was set as member of last created project via API
    And API request to create a project with name "Task Copying Test Project #3" was sent
    And User was set as member of last created project via API
    When Task with name "Task To Copy" was added to the last created project via API
    Then Task with name "Task To Copy" should be created
    Given User should be logged in
    And User should have last created task opened
    # Steps
    When Duplicate_To_Project_Button on Project_Page has been clicked
    And Select_Project_To_CopyTo_Dropdown on Project_Page has been clicked
    And Selected project to copy to is "Task Copying Test Project #1"
    And Duplicate_Task_Save_Button on Project_Page has been clicked
    And Link_To_Duplicated_Task on Project_Page has been clicked
    # Final Check
    Then Text "Task Copying Test Project #1" should be displayed in Project_Title on Project_Page

  Scenario: Verify that task can be moved within phases
    # Preconditions
    When API request to create a project with name "Moving Task Over Board Test" was sent
    Then Project with name "Moving Task Over Board Test" should be created
    When Task with name "Task To Move" was added to the last created project via API
    Then Task with name "Task To Move" should be created
    Given User should be logged in
    And User should have project opened
    # Steps & Checks
    When Task "Task To Move" was moved to "Ready" column
    Then Task "Task To Move" should be in "Ready" column
    When Task "Task To Move" was moved to "Work in progress" column
    Then Task "Task To Move" should be in "Work in progress" column
    When Task "Task To Move" was moved to "Done" column
    Then Task "Task To Move" should be in "Done" column
    When Task "Task To Move" was moved to "Backlog" column
    Then Task "Task To Move" should be in "Backlog" column

  Scenario: Clean up
    Given All projects should be removed