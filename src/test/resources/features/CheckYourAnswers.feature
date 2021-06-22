@wip
Feature: Check Your Answers

  Scenario: Changing answers in Check Your Answers
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user signs in as an Organisation Admin with VAT enrolment 000000001 and strong credentials
    When the user answers yes on the sell-online page
    And the user answers yes on the move-goods page
    And the user chooses No on the Already Made Sales page
    And the user answers yes on the intendToSellGoodsThisQuarter page
    And the user clicks through the commencementDate page
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers no on the tax-in-eu page
    And the user answers no on the deregistered page
    And the user answers no on the give-website-address page
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
    #Go back and change trading name once this is fixed
#    And the user adds Foo on the first uk-trading-name page
#    And the user answers yes on the add-uk-trading-name page
#    And the user adds Foo Two on the second uk-trading-name page
#    And the user answers no on the add-uk-trading-name page
#  /changeVatRegisteredEuMemberState/1/checking-answers needs to be changed
#    Then the user selects the change button for check-tax-in-eu
#    And the user answers yes on the check-tax-in-eu page
#    And the user selects France on the first eu-tax page
#    And the user chooses yes on the first eu-vat page
#    And the user adds FR123456789 on the first eu-vat-number page
#    And the user chooses no on the first eu-fixed-establishment page
#    And the user clicks continue on the first check-tax-details page
#    And the user answers yes on the add-tax-details page
#    And the user selects Germany on the second eu-tax page
#    And the user chooses yes on the second eu-vat page
#    And the user adds DE123456789 on the second eu-vat-number page
#    And the user chooses no on the second eu-fixed-establishment page
#    And the user clicks continue on the second check-tax-details page
#    And the user answers no on the add-tax-details page
#    Do two countries and use the mini CYA option for one of them
    Then the user selects the change button for check-deregistered
    And the user answers yes on the check-deregistered page
    And the user selects Austria on the first check-deregistered-country page
    And the user adds AT123 on the first check-deregistered-eu-vat-number page
    And the user answers no on the check-add-deregistration page
    Then the user is at the check-answers page
    Then the user selects the change button for check-give-website-address
    And the user answers yes on the check-give-website-address page
    And the user adds www.example.com on the first check-website-address page
    And the user answers yes on the check-add-website-address page
    And the user adds www.second-example.com on the second check-website-address page
    And the user selects the remove button for check-remove-website-address\/2
    Then the user answers yes on the check-remove-website-address/2 page
    And the user answers no on the check-add-website-address page
    Then the user is at the check-answers page

