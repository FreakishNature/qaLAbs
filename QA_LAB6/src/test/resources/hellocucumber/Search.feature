Feature: Search button

  Scenario: Testing search button
    Given user accesses the shop
    When user fills in search bar with dummy data and presses search
    Then is directed to items