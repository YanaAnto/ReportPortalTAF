Feature: User is able to login via UI

  @ui
  Scenario Outline: User can't log in using invalid credentials
    When open report portal login page
    And user logs in with login <username> and password <password>
    Then report portal login page is opened

    Examples:
      | username | password |
      | admin    | admin    |
      | username |          |
      |          | password |
      | 123      | 123      |
      | @$.      | password |

  @ui
  Scenario: User logs in using default valid credentials
    When open report portal login page
    And user logs in with default credentials
    Then dashboard page is opened