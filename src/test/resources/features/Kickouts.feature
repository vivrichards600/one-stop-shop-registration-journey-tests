@Registration
Feature: Not Eligible for One Stop Shop

  Scenario: Business not selling goods from Northern Ireland
    Given the user accesses the service
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user answers no on the Sells Goods From Ni page
    Then the user is on the Cannot Register For Service page

  Scenario: Business not in control of moving goods
    Given the user accesses the service
    And the user signs in as an Organisation Admin with VAT enrolment 100000002 and strong credentials
    And the user answers yes on the Sells Goods From Ni page
    And the user answers no on the in Control Of Moving Goods page
    Then the user is on the Cannot Register For Service page

