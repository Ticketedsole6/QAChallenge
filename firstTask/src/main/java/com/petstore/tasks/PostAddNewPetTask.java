package com.petstore.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostAddNewPetTask implements Task {

    private final Object petInfo;

    public PostAddNewPetTask(Object petInfo) {
        this.petInfo = petInfo;
    }

    public static Performable withInfo(Object petInfo) {
        return instrumented(PostAddNewPetTask.class, petInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/pet").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(petInfo)
                )
        );
    }
}
