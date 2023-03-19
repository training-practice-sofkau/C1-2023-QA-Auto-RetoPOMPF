Feature: Normal Flight
  As: Potential flight buyer
  I want: To book a flight from Medellin to Leticia for my wife and 1 year old son
  So that

  Background: I am on the home page
    Given I went to Despegar flights page with a browser 'browser'
    And I selected the passengers
    And I selected the destinations
    Then I will be redirected to the flight selection page

  Scenario Outline: Dates
    When I select the <date of departure> and the <date of return>
    And I select the flight <class>
    Examples:
      | date of departure | date of return | class           |
      | '10 OCT'          | '12 OCT'       | Economy         |
      | '11 SEP'          | '13 SEP'       | First class     |
      | '22 AUG'          | '24 AUG'       | Premium economy |

  Scenario: No dates
    When I activate the I have not decided the dates yet toggle switch