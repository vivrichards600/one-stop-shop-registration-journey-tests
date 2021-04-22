@Registration
Feature: Registering for One Stop Shop

  Scenario: A signed in user can register
    Given a user is signed in
    When the user enters Foo Ltd on the Registered Company Name page
    When the user answers yes on the Has Trading Name page
    When the user enters Foo on the Trading Name page
    When the user answers no on the Part Of Vat Group page

