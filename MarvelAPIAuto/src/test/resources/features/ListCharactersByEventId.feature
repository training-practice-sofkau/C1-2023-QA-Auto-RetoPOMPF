Feature: List characters who were at an event
  As: Marvel comics fan
  I want: To know the characters who participated in an event that occurred in company's comics
  So that

  Scenario: Characters in an event
    Given I was given a private and public key
    When I make a request to the Marvel API to get the characters who participated in an event with id '303'
    Then I will obtain a list of characters who participated in an event with id '303', each one identified with unique id