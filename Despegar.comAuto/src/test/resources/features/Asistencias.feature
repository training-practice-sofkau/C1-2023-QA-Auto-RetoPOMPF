Feature: Obtain assistance
  As: An air traveler
  I want: An assistance service for my flight
  So that

  Background: I am on the assistance page
    Given I went to Despegar assistance page with a 'browser'

  Scenario: Select an assistance option
    Given I selected the required fields for my family and me
    When I buy the recommended assistance option
    Then I will be redirected to the payment page

  Scenario: Pay the assistance
    Given I bought the recommended assistance option
    When I fill all the  purchase fields
    Then I will be redirected to the booking confirmation page and awaiting payment