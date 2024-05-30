package com.petstore.questions;

import com.petstore.models.Order;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetFindPurchaseOrderQuestion implements Question {

    @Override
    public Order answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Order.class);
    }
}
