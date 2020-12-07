Feature: Cart
  Scenario: Checking whether cart works correctly
    Given user accesses the shop
    When user adds product to cart
    Then product is in cart