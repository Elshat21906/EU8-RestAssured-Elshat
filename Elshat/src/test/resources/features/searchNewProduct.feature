Feature: Default



  @SearchNewProduct
  Scenario: Posmanager search the new product that created
    When User login for testing other functionality
    Then  Posmanager click the inventory button
    Then  Posmanager click the product button
    Then  Posmanager search the product that created