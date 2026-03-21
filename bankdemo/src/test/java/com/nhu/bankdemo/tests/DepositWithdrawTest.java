package com.nhu.bankdemo.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DepositWithdrawTest {

    @Test(enabled = false)
    public void TC07_depositMoney(){

        RestAssured.baseURI = "http://localhost:8081";

        given()
                .contentType("application/json")
                .body("{\"accountId\":1,\"amount\":500}")
                .when()
                .post("/deposit")
                .then()
                .statusCode(200);
    }

}
