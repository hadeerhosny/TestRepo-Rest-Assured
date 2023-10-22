package com.patient.steps;

import com.github.javafaker.Faker;
import com.patient.apis.UserApi;
import com.patient.models.User;
import io.restassured.response.Response;

public class UserSteps {



    public static User generateUser() {
        String email = "user@example.com";
        String password = "stringst4";
        return new User(email, password);

    }



    public static String getUserToken() {
        User user = generateUser();
        Response response = UserApi.logIn(user);
        return response.body().path("token");
    }
}
