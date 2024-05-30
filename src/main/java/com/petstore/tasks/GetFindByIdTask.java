package com.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetFindByIdTask implements Task {
    private Integer id;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/{id}").with(request -> request.pathParam("id", id))
        );
    }

    public static GetFindByIdTask with() {
        return Tasks.instrumented(GetFindByIdTask.class);
    }

    public GetFindByIdTask id(Integer id) {
        this.id = id;
        return this;
    }
}
