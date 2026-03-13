package com.nhu.bankdemo.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SecurityAPITest {

    @Test
    public void TC18_unauthorizedAccess(){

        RestAssured.baseURI = "http://localhost:8081";

        given()
                .when()
                .get("/accounts")
                .then()
                .statusCode(401);
    }

}