package com.patient.testcases;

import com.patient.apis.UpdateApi;
import com.patient.apis.UserApi;
import com.patient.models.Updated;
import com.patient.models.User;
import com.patient.steps.UserSteps;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PatientCases {

    @Test
    public void signUpTC1() {

        User user = new User("Hadeer","user11@example.com","Hadeertest","2023-10-20T08:51:00.670Z","female");
        Response response = UserApi.signUp(user);

        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.path("status"), equalTo("success"));
        assertThat(response.path("data.name"), equalTo("Hadeer"));
        assertThat(response.path("data.email"), equalTo("user11@example.com"));


    }

    @Test
    public void notSignUpByTheSameEmailTC2() {

        User user = new User("string","user5@example.com","Hadeertest","2023-10-20T08:51:00.670Z","female");
        Response response = UserApi.signUp(user);

        assertThat(response.statusCode(),equalTo(409));
        assertThat(response.path("status"), equalTo("fail"));
        assertThat(response.path("message"), equalTo("Duplicate field value: email"));

    }

    @Test
    public void logInTC3() {

        User user = new User("user@example.com","stringst4");
        Response response = UserApi.logIn(user);
        assertThat(response.statusCode(),equalTo(200));
        assertThat(response.path("data.email"), equalTo("user@example.com"));

    }

    @Test
    public void logInbyIncorrectPasswordTC4(){

        User user = new User("user5@example.com","testtttttt");
        Response response = UserApi.logIn(user);

        assertThat(response.statusCode(), equalTo(401));
        assertThat(response.path("status"), equalTo("fail"));
        assertThat(response.path("message"), equalTo("Email or password is incorrect"));
    }

    @Test
    public void detialsMeTC5() {

        String token = UserSteps.getUserToken();
        Response response = UpdateApi.getMe(token);

        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.path("status"), equalTo("success"));
    }

    @Test
    public void changePasswordTC6() {


        Updated updated = new Updated("stringst4", "Hadeertest1");
        String token = UserSteps.getUserToken();
        Response response = UpdateApi.changePassword(token);

        assertThat(response.statusCode(), equalTo(200));
    }


}
