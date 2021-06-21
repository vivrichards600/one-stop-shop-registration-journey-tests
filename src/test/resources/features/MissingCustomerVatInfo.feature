@Registration
Feature: Not all customer VAT details retrieved from DES
  Scenario: Missing Customer Vat Info from UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user signs in as an Organisation Admin with VAT enrolment 700000001 and strong credentials
    And the user answers yes on the sell-online page
    And the user answers yes on the move-goods page
    And the user chooses No on the Already Made Sales page
    And the user answers yes on the intendToSellGoodsThisQuarter page
    And the user clicks through the commencementDate page
    And the user chooses Yes on the confirm-vat-details page
    And the user enters foo on the business-name page
    And the user answers yes on the uk-vat-group page
    And the user provides date 01/01/1980 on the vat-effective-date page
    Then the user is on the have-uk-trading-name page
