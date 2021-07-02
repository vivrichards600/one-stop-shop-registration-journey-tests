@Registration @ZAP
Feature: Registering for One Stop Shop
  Scenario: A signed in user can register
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user answers yes on the already-made-sales page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user adds the day 1 the month 7 and the year 2021 on the date-of-first-sale date page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects France on the first eu-tax page
    And the user chooses yes on the first eu-vat page
    And the user adds FR123456789 on the first eu-vat-number page
    And the user chooses no on the first eu-fixed-establishment page
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Germany on the second eu-tax page
    And the user chooses yes on the second eu-vat page
    And the user adds DE123456789 on the second eu-vat-number page
    And the user chooses no on the second eu-fixed-establishment page
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers yes on the deregistered page
    And the user selects Austria on the first deregistered-country page
    And the user adds AT123 on the first deregistered-eu-vat-number page
    And the user answers no on the add-deregistration page
    And the user answers no on the online-marketplace page
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
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    Then the user is at the check-answers page
    Then the user submits their registration

