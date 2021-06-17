@Registration
Feature: Not Eligible for One Stop Shop

  Background:
    Given the user accesses the service
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials

  Scenario: Business not selling goods from Northern Ireland
    And the user answers no on the sell-online page
    Then the user is on the do-not-sell-online page

  Scenario: Business not in control of moving goods
    And the user answers yes on the sell-online page
    And the user answers no on the move-goods page
    Then the user is on the do-not-move-goods page

  Scenario: Incorrect UK VAT details
    And the user answers yes on the sell-online page
    And the user answers yes on the move-goods page
    And the user chooses No, details incorrect on the confirm-vat-details page
    Then the user is on the update-vat-details page

  Scenario: Use different UK VAT details
    And the user answers yes on the sell-online page
    And the user answers yes on the move-goods page
    And the user chooses No, wrong account on the confirm-vat-details page
    Then the user is on the register-different-business page
