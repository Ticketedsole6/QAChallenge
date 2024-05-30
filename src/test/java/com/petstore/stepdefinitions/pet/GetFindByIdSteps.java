package com.petstore.stepdefinitions.pet;

import com.petstore.models.Pets;
import com.petstore.models.Tag;
import com.petstore.questions.GetFindByIdQuestion;
import com.petstore.questions.GetFindByTagQuestion;
import com.petstore.tasks.GetFindByIdTask;
import com.petstore.tasks.GetFindByTagTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetFindByIdSteps {
    private EnvironmentVariables environmentVariables;
    private Actor actor;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        RestAssured.baseURI = environmentVariables.getProperty("serenity.baseurl");
        actor = Actor.named("Tester").whoCan(CallAnApi.at(baseURI));
    }

    @When("^the tester send a get request to findById endpoint by id (.+)$")
    public void theTesterSendAGetRequestToFindByIdEndpointById(Integer id) {
        actor.attemptsTo(GetFindByIdTask.with().id(id));
    }

    @And("^the tester should obtain all pets with id (.+)$")
    public void theTesterShouldObtainAllPetsWithId(Integer idNumber) {
        Pets pets = new GetFindByIdQuestion().answeredBy(actor);
        actor.should(
                seeThat("id", act -> pets.getId(), notNullValue())
        );
        actor.should(
                seeThat("id", act -> pets.getId(), equalTo(idNumber))
        );
    }
}
