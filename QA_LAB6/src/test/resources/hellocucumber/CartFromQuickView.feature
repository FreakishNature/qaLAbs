Feature: Quick view add
  Scenario: Testing adding to cart from quick view
    Given user accesses the shop
    When chooses a product
    When adds to cart
    Then product is in the cart