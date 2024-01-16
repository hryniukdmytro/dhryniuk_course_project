Feature: Login Test Cases

  Scenario: Verify that login with valid credentials is successful
    Given Navigate to login page in browser
    When Enter 'admin' as a username and 'admin' as a password
    And Click on login button
    Then Main page should be displayed after successful login


  Scenario Outline: Verify that login with invalid credentials in unsuccessful
    Given Navigate to login page in browser
    When Enter invalid username <username> and password <password>
    And Click on login button
    Then Error message should be displayed after unsuccessful login

    Examples:
      | username | password |
      | George   | Carlin   |
      | Ricky    | Gervais  |
      | Bill     | Burr     |