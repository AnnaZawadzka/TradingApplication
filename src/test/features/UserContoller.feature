Feature: Add user to database

  Scenario Outline: Create a new user
    Given I have filled username with <username>
    And I have filled password with <password>
    When I post the request
    Then the response is 200

    Examples:
      | username | password |
      | Diamond  | Diamond  |
      | Paper    | Paper    |