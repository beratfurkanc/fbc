Feature: AMC
  @amc
  Scenario Outline: get available times for a movie
    Given User is on home page
    When User select a "<movie>"
    Then User click get tickets for the movie
    Then User change the location with "<zipCode>"
    And User search for available "<days>"
    Examples:
    |movie           |zipCode|days|
    |The Lion King   |20170  |3   |
    |IT Chapter Two  |20170  |3   |

