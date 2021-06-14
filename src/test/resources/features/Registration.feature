@Registration @ZAP
Feature: Registering for One Stop Shop

  Scenario: A signed in user can register
    Given the user accesses the service
    And the user signs in as an Organisation Admin with VAT enrolment 000000002 and strong credentials
    When the user answers yes on the Sells Goods From Ni page
    And the user answers yes on the In Control Of Moving Goods page
    And the user chooses Yes on the Check Vat Details page
    And the user answers yes on the Has Trading Name page
    And the user adds Foo on the first Trading Name page
    And the user answers yes on the Add Trading Name page
    And the user adds Foo Two on the second Trading Name page
    And the user answers no on the Add Trading Name page
    And the user answers yes on the Tax Registered In Eu page
    And the user selects France on the first Vat Registered Eu Member State page
    And the user chooses yes on the first Vat Registered In Eu page
    And the user adds FR123456789 on the first Eu Vat Number page
    And the user chooses no on the first Has Fixed Establishment page
    And the user clicks continue on the first Check Eu Vat Details page
    And the user answers yes on the Add Additional Eu Vat Details page
    And the user selects Germany on the second Vat Registered Eu Member State page
    And the user chooses yes on the second Vat Registered In Eu page
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
    And the user answers yes on the give-website-address page
    And the user adds www.example.com on the first website-address page
    And the user answers yes on the add-website-address page
    And the user adds www.second-example.com on the second website-address page
    And the user answers no on the add-website-address page
    And the user completes details on the business-contact-details page
      | data            | fieldId         |
      | Joe Bloggs      | fullName        |
      | 01234567890     | telephoneNumber |
      | email@test.com  | emailAddress    |
    And the user completes details on the bank-details page
      | data            | fieldId         |
      | Account Name    | accountName     |
      | 12345678        | bic             |
      | GB12345678      | iban            |
    Then the user is at the check-answers page
    Then the user submits their registration

