Feature: Product review
  Scenario: Checking whether product review works correctly
    Given user accesses the shop
    Given chooses a product
    Given and clicks review
    When user tries leave a review
    Then a review is left