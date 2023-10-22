package com.patient.apis;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateApi {

    public static Response getMe(String token) {

        return given()
                .baseUri("http://localhost:3030")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().get("/api/patients/me")
                .then()
                .log().all()
                .extract().response();

    }

    public static Response changePassword(String token) {

        return given()
                .baseUri("http://localhost:3030")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().patch("/api/patients/changePassword")
                .then()
                .log().all()
                .extract().response();

    }
}
