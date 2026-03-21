package com.nhu.bankdemo.tests;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TransferAPITest {

    @Test(enabled = false)
    public void TC13_transferMoney(){

        RestAssured.baseURI = "http://localhost:8081";

        given()
                .contentType("application/json")
                .body("{\"fromAccount\":1,\"toAccount\":2,\"amount\":100}")
                .when()
                .post("/transfer")
                .then()
                .statusCode(200);
    }

}
