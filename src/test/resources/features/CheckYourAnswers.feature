@Registration
Feature: Check Your Answers

  Scenario: Changing answers in Check Your Answers
    Given the user accesses the service
    And the business is responsible for reporting and paying VAT for all sales to consumers in EU countries
    And the user answers yes on the already-made-sales page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses to register for the one stop shop scheme
    And the user answers no on the have-uk-trading-name page
    And the user adds the day 1 the month 7 and the year 2021 on the date-of-first-sale date page
    And the user provides the business details
     | url                  | choice   |
     | start-date           | continue |
     | tax-in-eu            | no       |
     | deregistered         | no       |
     | online-marketplace   | no       |
     | give-website-address | no       |
    And the user provides business-contact-details
    And the user provides bank-details and continues to check-answers page
    Then the user changes the uk-trading-name
    And the user adds 2 trading names and continues to check-answers page
    Then the user changes the tax in EU option
    And the user answers yes on the check-tax-in-eu page
    And the user adds France as country for business registered for tax in the EU
    And the user clicks continue on the first change-check-tax-details page
    And adds Germany as another business registered with an establishment for tax in the EU from check-add-tax-details page
    And the user changes the second business to VAT not registered
    And continues to check your answers page from change check tax details page
    And the user adds de-registration details from check your answers page
    And continues to check your answers page from change check add deregistration page
    And the user adds 2 website addresses
    And the user removes website address 2 and continues to check your answers page