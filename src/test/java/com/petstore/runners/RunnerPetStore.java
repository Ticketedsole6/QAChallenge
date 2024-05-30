package com.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@PetStorePet",
        glue = "com/petstore/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerPetStore {
}
