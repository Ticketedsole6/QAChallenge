package com.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetFindByStatusTask implements Task {
    private String status;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/findByStatus?status={status}").with(request -> request.pathParam("status", status))
        );
    }

    public static GetFindByStatusTask with() {
        return Tasks.instrumented(GetFindByStatusTask.class);
    }

    public GetFindByStatusTask status(String status) {
        this.status = status;
        return this;
    }
}
