Feature: Go to my hotel
  As: An air traveler
  I want: A ride from the airport to my hotel when my flight lands
  So that

  Background: I am on the transfers page
    Given I went to Despegar transfer page with a 'browser'

  Scenario: Select a transfer option
    Given I selected the required fields for my family and me
    When I buy the first transfer option
    Then I will be redirected to the payment page

  Scenario: Compare prices
    Given I selected the required fields only for me
    When I focus on the price of the first transfer option
    Then I will see a lower price than with my family