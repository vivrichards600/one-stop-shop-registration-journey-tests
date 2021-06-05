@Registration @ZAP
Feature: Registering for One Stop Shop

  Scenario: A signed in user can register
    Given a user starts at the Is Business Based In Northern Ireland page
    And the user answers yes on the Is Business Based In Northern Ireland page
    And the user signs in as an Organisation Admin with VAT enrolment 000000002 and strong credentials
    And the user answers yes on the Check Vat Details page
    And the user answers yes on the Has Trading Name page
    And the user adds Foo on the first Trading Name page
    And the user answers yes on the Add Trading Name page
    And the user adds Foo Two on the second Trading Name page
    And the user answers no on the Add Trading Name page
    And the user answers no on the Part Of Vat Group page
    And the user answers yes on the Vat Registered In Eu page
    And the user selects France on the first Vat Registered Eu Member State page
    And the user adds FR123456789 on the first Eu Vat Number page
    And the user chooses no on the first Has Fixed Establishment page
    And the user clicks continue on the first Check Eu Vat Details page
    And the user answers yes on the Add Additional Eu Vat Details page
    And the user selects Germany on the second Vat Registered Eu Member State page
    And the user adds DE123456789 on the second Eu Vat Number page
    And the user chooses no on the second Has Fixed Establishment page
    And the user clicks continue on the second Check Eu Vat Details page
    And the user answers no on the Add Additional Eu Vat Details page
    And the user answers no on the Currently Registered In Eu page
    And the user answers yes on the Previously Registered page
    And the user selects Austria on the first Previous Eu Country page
    And the user adds AT123 on the first Previous Eu Vat Number page
    And the user answers no on the Add Previous Registration page
    And the user chooses Next Period on the Start Date page
    And the user adds www.example.com on the first Website page
    And the user answers yes on the Add Website page
    And the user adds www.second-example.com on the second Website page
    And the user answers no on the Add Website page
    And the user completes details on the Business Contact Details page
      | data            | fieldId         |
      | Joe Bloggs      | fullName        |
      | 01234567890     | telephoneNumber |
      | email@test.com  | emailAddress    |
    Then the user is at the Check Your Answers page
    Then the user submits their registration

