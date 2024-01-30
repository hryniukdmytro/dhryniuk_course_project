Feature: [UI] Project Test Сases

  Scenario: Verify that new project can be created
    # Preconditions
    Given User should be logged in
    # Steps
    When New_Project_Button on Main_Page has been clicked
    And Text "Test Project" was entered into Project_Name_Modal_TextField on Project_Page
    And Modal_Save_Button on Project_Page has been clicked
    # Final Check
    Then Text "Test Project" should be displayed in Project_Title on Project_Page

  Scenario: Verify that project can be closed
    # Preconditions
    When API request to create a project with name "Project Closure Test" was sent
    Then Project with name "Project Closure Test" should be created
    Given User should be logged in
    And User should have project opened
    # Steps
    When Project_Configurations_Dropdown on Project_Page has been clicked
    And Configure_Project_Button on Project_Page has been clicked
    Then Trimmed text of the Project_State on Project_Page should be "open"
    When Close_Project_Button on Project_Page has been clicked
    And Yes_Modal_Button on Project_Page has been clicked
    Then Trimmed text of the Project_State on Project_Page should be "closed"


  Scenario: Clean up
    Given All projects should be removed

