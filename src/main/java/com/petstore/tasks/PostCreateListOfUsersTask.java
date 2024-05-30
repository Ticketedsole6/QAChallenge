package com.petstore.tasks;

import com.petstore.models.User;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCreateListOfUsersTask implements Task {

    private final User[] userInfo;

    public PostCreateListOfUsersTask(User[] userInfo) {
        this.userInfo = userInfo;
    }

    public static Performable withInfo(User[] userInfo) {
        return instrumented(PostCreateListOfUsersTask.class, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/user/createWithList").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }
}
