@Registration
Feature: Not Eligible for One Stop Shop

  Background:
    Given the user accesses the service
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials

  Scenario: Business not selling goods from Northern Ireland
    And the user answers no on the Sells Goods From Ni page
    Then the user is on the Cannot Register For Service page

  Scenario: Business not in control of moving goods
    And the user answers yes on the Sells Goods From Ni page
    And the user answers no on the in Control Of Moving Goods page
    Then the user is on the Cannot Register For Service page

  Scenario: Incorrect UK VAT details
    And the user answers yes on the Sells Goods From Ni page
    And the user answers yes on the in Control Of Moving Goods page
    And the user chooses No, details incorrect on the Check Vat Details page
    Then the user is on the Update Vat Details page

  Scenario: Use different UK VAT details
    And the user answers yes on the Sells Goods From Ni page
    And the user answers yes on the in Control Of Moving Goods page
    And the user chooses No, wrong account on the Check Vat Details page
    Then the user is on the Use Other Account page
