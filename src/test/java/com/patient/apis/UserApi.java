package com.patient.apis;

import com.patient.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static Response signUp(User user) {

        return given()
                .baseUri("http://localhost:3030")
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/patients/login")
                .then()
                .log().all()
                .extract().response();

    }



    public static Response logIn(User user) {

        return given()
                .baseUri("http://localhost:3030")
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/patients/login")
                .then()
                .log().all()
                .extract().response();

    }
}
