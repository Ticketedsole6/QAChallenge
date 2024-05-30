@PetStorePet
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @STO002 @placeOrder
  Scenario: the tester needs to find purchase order
    When the tester send a get request to order endpoint with 10 orderId
    Then the tester should obtain a status ok
    And And the tester in the response body should get the purchase information for 10 orderId