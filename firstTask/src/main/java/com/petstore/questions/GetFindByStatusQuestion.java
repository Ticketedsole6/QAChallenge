package com.petstore.questions;

import com.petstore.models.Pets;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Arrays;
import java.util.List;

public class GetFindByStatusQuestion implements Question {

    @Override
    public List<Pets> answeredBy(Actor actor) {
        Pets[] petsArray = SerenityRest.lastResponse().as(Pets[].class);
        return Arrays.asList(petsArray);
    }
}
