package com.petstore.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPlaceOrderTask implements Task {
    private final Object orderInfo;

    public PostPlaceOrderTask(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public static Performable withInfo(Object orderInfo) {
        return instrumented(PostPlaceOrderTask.class, orderInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/store/order").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(orderInfo)
                )
        );
    }
}
