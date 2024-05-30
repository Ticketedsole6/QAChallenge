package com.petstore.stepdefinitions.pet;

import com.petstore.models.Pets;
import com.petstore.questions.GetFindByStatusQuestion;
import com.petstore.questions.ResponseCodeQuestion;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import com.petstore.interactions.CheckHealth;
import com.petstore.tasks.*;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetFindByStatusSteps {
    private EnvironmentVariables environmentVariables;
    private Actor actor;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        RestAssured.baseURI = environmentVariables.getProperty("serenity.baseurl");
        actor = Actor.named("Tester").whoCan(CallAnApi.at(baseURI));
    }

    @Given("that the services of the pet store are available")
    public void thatTheServicesOfThePetStoreAreAvailable() {
        actor.attemptsTo(CheckHealth.petStore());
    }

    @When("^the tester send a get request to findByStatus endpoint by status (.+)$")
    public void theTesterSendAGetRequestToFindByStatusEndpointByStatus(String status) {
        actor.attemptsTo(GetFindByStatusTask.with().status(status));
    }

    @Then("the tester should obtain a status ok")
    public void theTesterShouldObtainAStatusOk() {
        actor.should(
                seeThat("response code", ResponseCodeQuestion.was(), equalTo(200))
        );
    }

    @And("^the tester should obtain all pets by status (.+)$")
    public void theTesterShouldObtainAllPetsByStatus(String statusWord) {
        List<Pets> pets = new GetFindByStatusQuestion().answeredBy(actor);
        for (Pets pet : pets) {
            actor.should(
                    seeThat("status", act -> pet.getStatus(), notNullValue())
            );
            actor.should(
                    seeThat("status", act -> pet.getStatus(), equalTo(statusWord))
            );
        }
    }
}
