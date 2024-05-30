package com.petstore.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUpdateExistingPetTask implements Task {

    private final Object newPetInfo;

    public PutUpdateExistingPetTask(Object petInfo) {
        this.newPetInfo = petInfo;
    }

    public static Performable withInfo(Object petInfo) {
        return instrumented(PutUpdateExistingPetTask.class, petInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/pet").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(newPetInfo)
                )
        );
    }
}
