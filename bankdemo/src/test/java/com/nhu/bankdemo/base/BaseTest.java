package com.nhu.bankdemo.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class BaseTest {

    @BeforeSuite
    public void setupSuite(){

        RestAssured.baseURI = "http://localhost:8081";

        System.out.println("Automation Suite Started");
    }

    @BeforeMethod
    public void resetDatabase(){

        given()
                .post("/test/reset-database");
        System.out.println("Database reset");
    }
}