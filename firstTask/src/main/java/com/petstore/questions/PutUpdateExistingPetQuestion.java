package com.petstore.questions;

import com.petstore.models.Pets;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PutUpdateExistingPetQuestion implements Question {

    @Override
    public Pets answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Pets.class);
    }
}
