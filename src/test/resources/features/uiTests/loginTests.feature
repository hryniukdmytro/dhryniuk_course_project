Feature: [UI] Login Test Cases

  Scenario: Verify that login with valid credentials is successful
    Given Login page should be opened
    When Text "admin" was entered into Login_Field on Login_Page
    And Text "admin" was entered into Password_Field on Login_Page
    And Login_Button on Login_Page has been clicked
    Then The Main_Page_Body on Main_Page should be displayed

  Scenario Outline: Verify that login with invalid credentials in unsuccessful
    Given Login page should be opened
    When Text "<username>" was entered into Login_Field on Login_Page
    And Text "<password>" was entered into Password_Field on Login_Page
    And Login_Button on Login_Page has been clicked
    Then The Bad_Credentials_Error on Login_Page should be displayed

    Examples:
      | username | password |
      | George   | Carlin   |
      | Ricky    | Gervais  |
      | Bill     | Burr     |