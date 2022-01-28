Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario: Checking the change of Currency in Euro
    Given User opens 'https://www.amazon.com/' page
    And User go to language and currency setting
    When User select currency Euro
    Then User checks by '€' that change of Currency in Euro

  Scenario: Check that search results contains search word
    Given User opens 'https://www.amazon.com/' page
    When User search by word 'Harry Potter'
    Then User Check that search results contains search word 'Harry Potter'

  Scenario: Check the number of items on the search page
    Given User opens 'https://www.amazon.com/' page
    When User opens menu
    And User select computers
    And User select monitors
    Then User checks the number <33> of items on the search page

  Scenario: Check incorrect phone number
    Given User opens 'https://www.amazon.com/' page
    When User select button SignIn
    And User enters into the field incorrect phone '123456'
    And User select button continue
    Then User compares error message with message 'Incorrect phone number'

  Scenario: Check Add to cart headset
    Given User opens 'https://www.amazon.com/' page
    When User select menu headsets
    And  User choose product by <4> position
    And User product add to cart
    And User go to cart
    Then User checks the count <1> product in the cart

  Scenario: Check error in menu registry
    Given User opens 'https://www.amazon.com/' page
    When User selects the menu registry
    And User on the registry page click search button
    Then User checks error in menu registry is name 'Please enter a registrant name'

  Scenario: Check label count search video game in the page
    Given User opens 'https://www.amazon.com/' page
    When User selects the menu video game
    Then User checks label count search video game in the page

  Scenario: Check that is turn checkbox beauty
    Given User opens 'https://www.amazon.com/' page
    When User select menu NewDeals
    And User select bar beauty
    Then User checks that is turn checkbox beauty

  Scenario: Check that all titles contains search word
    Given User opens 'https://www.amazon.com/' page
    When User search by word 'Ukraine'
    Then User checks that all titles contains search word 'Ukraine'

  Scenario: Check that the product has been removed from the cart
    Given User opens 'https://www.amazon.com/' page
    When User search by word 'controller'
    And User choose product by <3> position
    And User add to cart product
    And User go to cart
    And User remove product from cart
    Then User checks text in the cart is name 'Your Amazon Cart is empty.'
    