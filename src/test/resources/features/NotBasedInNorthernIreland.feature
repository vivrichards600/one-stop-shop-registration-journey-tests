@Registration
Feature: Not Eligible for One Stop Shop

  Scenario: Business not based in Northern Ireland cannot register
    Given a user starts at the Is Business Based In Northern Ireland page
    And the user answers no on the Is Business Based In Northern Ireland page
    Then the user is on the Cannot Register For Service page