@Registration
Feature: Registering for One Stop Shop

  Scenario: A signed in user can register
    Given a user is signed in
    When the user enters Foo Ltd on the Registered Company Name page
    And the user answers yes on the Has Trading Name page
    And the user enters Foo on the Trading Name page
    And the user answers no on the Part Of Vat Group page
    And the user enters GB987654321 on the Uk Vat Number page
    And the user provides date 01/01/2020 on the Uk Vat Effective Date page
    And the user enters ZZ11 9BB on the Uk Vat Registered Postcode page
    And the user answers yes on the Vat Registered In Eu page
    And the user adds first member state France on the Vat Registered Eu Member State page
    And the user adds first VAT number FR123456789 on the Eu Vat Number page
    And the user answers yes on the Add Additional Eu Vat Details page
    And the user adds second member state Germany on the Vat Registered Eu Member State page
    And the user adds second VAT number DE123456789 on the Eu Vat Number page
    And the user answers no on the Add Additional Eu Vat Details page
    And the user completes details on the Business Address page
      | data         | fieldId    |
      | 1 The Street | line1      |
      | Village      | Line2      |
      | Town         | townOrCity |
      | County       | county     |
      | AA1 1AA      | postCode   |
    And the user completes details on the Business Contact Details page
      | data            | fieldId         |
      | Joe Bloggs      | fullName        |
      | 01234567890     | telephoneNumber |
      | email@test.com  | emailAddress    |
      | www.website.com | websiteAddress  |

