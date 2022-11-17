Feature: Add user to database

  Scenario Outline: Create a new user
    Given I have filled username with "<username>" and password with "<password>"
    When I post the request
    Then the user is created

    Examples:
      | username | password |
      | Diamond  | Diamond  |
      | Paper    | Paper    |