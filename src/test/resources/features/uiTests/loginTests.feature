Feature: [UI] Login Test Cases

  @Chrome
  Scenario: Verify that login with valid credentials is successful
    Given Login page should be opened
    When Enter valid credentials
    And Click on login button
    Then Main page should be displayed after successful login

  @Chrome
  Scenario Outline: Verify that login with invalid credentials in unsuccessful
    Given Login page should be opened
    When Enter invalid username <username> and password <password>
    And Click on login button
    Then Error message should be displayed after unsuccessful login

    Examples:
      | username | password |
      | George   | Carlin   |
      | Ricky    | Gervais  |
      | Bill     | Burr     |