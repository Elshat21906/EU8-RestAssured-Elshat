package com.cybertek.day02_Postman_Manual_Testing_Headers_RestAssured_Intro;

import org.junit.jupiter.api.BeforeAll;

public class HrGetRequest {

    //BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        //baseURI = "http://44.202.119.26:1000/ords/hr";
    }
}

/*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains   Americas
     */



