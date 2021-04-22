@Registration
Feature: Registering for One Stop Shop

  Scenario: A signed in user can register
    Given a user is signed in
    When the user enters Foo Ltd on the Registered Company Name page
    Then the user should be on the Has Trading Name page
