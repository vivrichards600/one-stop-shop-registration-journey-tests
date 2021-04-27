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

