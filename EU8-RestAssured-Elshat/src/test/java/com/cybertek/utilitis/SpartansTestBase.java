package com.cybertek.utilitis;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartansTestBase {

    @BeforeAll
    public static void init(){

        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://44.202.119.26:8000";

    }
}
