Feature: List events
  As: Marvel comics fan
  I want: To know the events that have occurred in company's comics
  So that

  Scenario: All events by id
    Given I was granted a private and public key
    When I make a request to the Marvel API to get the list of events that occurred in their comics
    Then I will obtain the list of events, each one identified with a unique id