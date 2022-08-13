package com.cybertek.day04_JsonPath;

import com.cybertek.utilitis.HRTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath  extends HRTestBase {

    @DisplayName("GET request to Countries")
    @Test
    public void test1(){

        Response response = get("/countries");

        //get the second country name with JsonPath
        //to use jsonpath we assign response to JsonPath


        //get all country ids
        //items.country_id

        //get all country names where their region id is equal to 2

    }

}
