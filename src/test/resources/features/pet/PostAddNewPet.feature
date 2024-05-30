@PetStorePet
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @PET006 @addNewPet
  Scenario: the tester needs add new pet to the store
    When the tester send a post request to pet endpoint with a new pet info
    Then the tester should obtain a status ok
    And the tester in the response body should obtain the same request body