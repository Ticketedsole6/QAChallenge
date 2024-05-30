@PetStorePet
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @PET007 @UpdateExistingPet
  Scenario: the tester needs to update an existing pet info
    When the tester send a put request to pet endpoint with an updated pet info
    Then the tester should obtain a status ok
    And the tester in the response body should obtain the same updated request body