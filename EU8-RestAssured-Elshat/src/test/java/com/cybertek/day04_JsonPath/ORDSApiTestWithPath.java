package com.cybertek.day04_JsonPath;

import com.cybertek.utilitis.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ORDSApiTestWithPath extends HRTestBase {


    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://44.202.119.26:1000/ords/hr";

    }

    @DisplayName("Get request to countries with Path method")
    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .queryParam("q", "{\"region_id\": 2}")
                .when()
                .get("/countries");

        assertEquals(200, response.statusCode());


        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        //print hasMore
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first CountryId
        String firstCountryId = response.path("items[0].country_id");
        System.out.println("firstCountryId = " + firstCountryId);

        //print second country name
        String secondCountryName = response.path("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        //print "http://44.202.63.224:1000/ords/hr/countries/CA"
        String thirdHref = response.path("items[2].links[0].href");
        System.out.println("thirdHref = " + thirdHref);

        //get me all country names
        List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);

        //assert that all regions ids are equal to 2
        List<Integer> allRegionsId = response.path("items.region_id");

        for (Integer regionsID : allRegionsId) {
            System.out.println("regionsID = " + regionsID);
            assertEquals(2, regionsID);
        }


    }

    @DisplayName("GET request to /employees with Query Param")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
                .when().get("/employees");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.header("Content-Type"));
        assertTrue(response.body().asString().contains("IT_PROG"));


        //make sure we have only IT_PROG as a job_id
        List<String> allJobIDs = response.path("items.job_id");
        for (String JobID : allJobIDs) {

            System.out.println("JobID = " + JobID);
            assertEquals("IT_PROG",JobID);

        }



    }
}
