@contract
Feature: Random joke contract

  Background:
    Given I use the Official Joke API base url

  @datatable @smoke
  Scenario: Verify random joke contract fields and patterns
    When I request random joke for contract validation
    Then contract response status should be 200
    And response should contain required fields:
      | field     |
      | id        |
      | type      |
      | setup     |
      | punchline |
    And response fields should match patterns:
      | field     | pattern      |
      | id        | ^\d+$        |
      | type      | ^[a-zA-Z]+$  |
      | setup     | ^.+$         |
      | punchline | ^.+$         |