@PetStorePet
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @PET004 @findPetByTag
  Scenario: the tester needs to obtain all pets by tag
    When the tester send a get request to findByTags endpoint by tag "tag1"
    Then the tester should obtain a status ok
    And the tester should obtain all pets by tag "tag1"