Feature: Joke by id endpoint

  Scenario Outline: Get joke by id and verify returned id
    When I request a joke by id <id>
    Then the response status should be 200
    And the returned joke id should be <id>

    Examples:
      | id |
      | 1  |
      | 25 |
      | 100 |