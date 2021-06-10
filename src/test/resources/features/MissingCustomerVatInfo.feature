@Registration
Feature: Not all customer VAT details retrieved from DES

  Scenario: Missing Customer Vat Info from UK VAT details
    Given the user accesses the service
    And the user signs in as an Organisation Admin with VAT enrolment 700000001 and strong credentials
    And the user answers yes on the Sells Goods From Ni page
    And the user answers yes on the in Control Of Moving Goods page
    And the user chooses Yes on the Check Vat Details page
    And the user enters foo on the registered Company Name page
    And the user answers yes on the part Of Vat Group page
    And the user provides date 01/01/1980 on the uk Vat Effective Date page
    Then the user is on the has Trading Name page
