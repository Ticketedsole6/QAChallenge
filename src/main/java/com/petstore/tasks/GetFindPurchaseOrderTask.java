package com.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetFindPurchaseOrderTask implements Task {
    private Integer id;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/store/order/{id}").with(request -> request.pathParam("id", id))
        );
    }

    public static GetFindPurchaseOrderTask with() {
        return Tasks.instrumented(GetFindPurchaseOrderTask.class);
    }

    public GetFindPurchaseOrderTask id(Integer id) {
        this.id = id;
        return this;
    }
}
