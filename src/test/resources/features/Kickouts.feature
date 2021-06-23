@Registration
Feature: Not Eligible for One Stop Shop

  Scenario: Business is already registered in another county
    Given the user accesses the service
    And the user answers yes on the already-eu-registered page
    Then the user is on the return-later-already-eu-registered page

  Scenario: Business not selling goods from Northern Ireland
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers no on the sell-from-northern-ireland page
    Then the user is on the do-not-sell-from-northern-ireland page

  Scenario: Business not in control of moving goods
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the move-goods page
    Then the user is on the do-not-move-goods page

  Scenario: Incorrect UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the move-goods page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses No, details incorrect on the confirm-vat-details page
    Then the user is on the update-vat-details page

  Scenario: Use different UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the move-goods page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses No, wrong account on the confirm-vat-details page
    Then the user is on the register-different-business page
