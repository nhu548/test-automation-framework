package com.nhu.bankdemo.clients;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class AccountClient {

    public static Response createAccount(Object body){

        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/accounts");

    }

}