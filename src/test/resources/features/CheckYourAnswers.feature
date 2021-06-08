
Feature: Check Your Answers

  Scenario: Changing answers in Check Your Answers
    Given the user accesses the service
    And the user signs in as an Organisation Admin with VAT enrolment 900000001 and strong credentials
    When the user answers yes on the Sells Goods From Ni page
    And the user answers yes on the In Control Of Moving Goods page
    And the user answers yes on the Check Vat Number page
    When the user enters Bar on the Registered Company Name page
    And the user answers no on the Part Of Vat Group page
    And the user provides date 01/01/2020 on the Uk Vat Effective Date page
    And the user answers yes on the Business Address In Uk page
    And the user completes details on the Business Address page
      | data         | fieldId    |
      | 1 The Street | line1      |
      | Village      | line2      |
      | Town         | townOrCity |
      | County       | county     |
      | AA1 1AA      | postCode   |
    And the user answers no on the Has Trading Name page
    And the user answers no on the Tax Registered In Eu page
    And the user answers no on the Previously Registered page
    And the user chooses Next Period on the Start Date page
    And the user answers no on the Has Website page
    And the user completes details on the Business Contact Details page
      | data            | fieldId         |
      | Joe Bloggs      | fullName        |
      | 01234567890     | telephoneNumber |
      | email@test.com  | emailAddress    |
    And the user completes details on the Bank Details page
      | data            | fieldId         |
      | Account Name    | accountName     |
      | 12345678        | bic             |
      | GB12345678      | iban            |
    Then the user is at the Check Your Answers page
    And the user changes the answers on the Check Your Answers page
      | page                    | data        |
      | Registered Company Name | Company Ltd |
    #When the user is at the Check Your Answers page
    #And the user selects the change button for Vat Registered In Eu
    #And the user answers yes on the Change Vat Registered In Eu page
    #And the user selects Spain on the first Change Vat Registered Eu Member State page
    #And the user chooses yes on the first Change Vat Registered In Eu page
    #And the user adds ES123456789 on the first Change Eu Vat Number page
    #And the user chooses no on the first Change Has Fixed Establishment page
    #And the user clicks continue on the first Check Eu Vat Details page
    #And the user answers no on the Add Additional Eu Vat Details page
    #Then the user is at the Check Your Answers page

