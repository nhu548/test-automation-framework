package com.nhu.bankdemo.tests;

import com.nhu.bankdemo.base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccountAPITest extends BaseTest {

    @Test
    public void TC01_createAccount(){

        given()
                .log().all()
                .contentType("application/json")
                .body("{\"ownerName\":\"Tam\",\"balance\":1000}")
                .when()
                .post("/api/accounts")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void TC02_getAccount(){

        given()
                .log().all()
                .when()
                .get("/api/accounts/1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void TC03_getAllAccounts(){

        given()
                .when()
                .get("/api/accounts")
                .then()
                .statusCode(200);
    }

}