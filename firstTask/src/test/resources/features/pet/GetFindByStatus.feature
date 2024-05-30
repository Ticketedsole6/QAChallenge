@PetStorePet
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @PET001 @PET002 @PET003 @findPetByStatus
  Scenario Outline: the tester needs to obtain all pets by status
    When the tester send a get request to findByStatus endpoint by status <status>
    Then the tester should obtain a status ok
    And the tester should obtain all pets by status <status>

    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |