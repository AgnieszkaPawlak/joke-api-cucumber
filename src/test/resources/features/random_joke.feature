Feature: Random joke endpoint

  Scenario: Get random joke and verify response structure
    When I request a random joke
    Then the response status should be 200
    And the joke should contain id, type, setup and punchline