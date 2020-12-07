Feature: Live web app test
  This feature tests several different features of Google Live Web Application

  Scenario: Testing Variant 3 of Lab 7

    Given user opens Google
    When user enters "calculator"
    Then check that calculator is displayed
    When user enters "converter"
    Then check that converter is at the top
    When user enters russian text
    Then check that user receives a result independently of language used
    When user enters english text
    Then check that user receives a result independently of language used
    When user enters upper case text
    Then check that user receives the same result as with lower case
