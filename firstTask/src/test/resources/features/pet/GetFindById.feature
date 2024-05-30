@PetStorePet
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @PET005 @findPetById
  Scenario: the tester needs to obtain all pets by id
    When the tester send a get request to findById endpoint by id 10
    Then the tester should obtain a status ok
    And the tester should obtain all pets with id 10