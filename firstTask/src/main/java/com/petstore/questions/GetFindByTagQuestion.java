package com.petstore.questions;

import com.petstore.models.Tag;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Arrays;
import java.util.List;

public class GetFindByTagQuestion implements Question {

    @Override
    public List<Tag> answeredBy(Actor actor) {
        Tag[] tagsArray = SerenityRest.lastResponse().as(Tag[].class);
        return Arrays.asList(tagsArray);
    }
}
