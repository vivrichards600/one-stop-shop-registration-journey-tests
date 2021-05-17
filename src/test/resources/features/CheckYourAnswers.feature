@Registration
Feature: Check Your Answers

  Scenario: Changing answers in Check Your Answers
    Given a user starts at the Is Business Based In Northern Ireland page
    And the user answers yes on the Is Business Based In Northern Ireland page
    Then a user is signed in
    When the user enters Foo Ltd on the Registered Company Name page
    And the user answers no on the Has Trading Name page
    And the user answers no on the Part Of Vat Group page
    And the user enters GB987654321 on the Uk Vat Number page
    And the user provides date 01/01/2020 on the Uk Vat Effective Date page
    And the user enters ZZ11 9BB on the Uk Vat Registered Postcode page
    And the user answers no on the Vat Registered In Eu page
    And the user completes details on the Business Address page
      | data         | fieldId    |
      | 1 The Street | line1      |
      | Village      | line2      |
      | Town         | townOrCity |
      | County       | county     |
      | AA1 1AA      | postCode   |
    And the user completes details on the Business Contact Details page
      | data            | fieldId         |
      | Joe Bloggs      | fullName        |
      | 01234567890     | telephoneNumber |
      | email@test.com  | emailAddress    |
      | www.website.com | websiteAddress  |
    Then the user is at the Check Your Answers page
    And the user changes the answers on the Check Your Answers page
      | page                    | data        |
      | Registered Company Name | Company Ltd |
      | Uk Vat Number           | GB987366554 |
    When the user is at the Check Your Answers page
    And the user selects the change button for Vat Registered In Eu
    And the user answers yes on the Change Vat Registered In Eu page
    And the user adds Spain on the first Change Vat Registered Eu Member State page
    And the user adds ES123456789 on the first Change Eu Vat Number page
    And the user answers no on the Change Add Additional Eu Vat Details page
    Then the user is at the Check Your Answers page

