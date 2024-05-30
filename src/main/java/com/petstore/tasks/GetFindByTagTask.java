package com.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetFindByTagTask implements Task {
    private String tag;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/findByTags?tags={tag}").with(request -> request.pathParam("tag", tag))
        );
    }

    public static GetFindByTagTask with() {
        return Tasks.instrumented(GetFindByTagTask.class);
    }

    public GetFindByTagTask tag(String tag) {
        this.tag = tag;
        return this;
    }
}
