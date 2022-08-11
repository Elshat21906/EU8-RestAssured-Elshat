package com.cybertek.day04_JsonPath;

import com.cybertek.utilitis.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\": 2}")
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());


        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        //print hasMore
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first CountryId
        String countryId = response.path("items[0].country_id");
        System.out.println("countryId = " + countryId);

        //print second country name
        String secondCountryName = response.path("items[1].country_name");
        System.out.println("countryName = " + secondCountryName);

        //print "http://44.202.63.224:1000/ords/hr/countries/CA"
        String thirdHref = response.path("items[2].links[0].href");
        System.out.println("thirdHref = " + thirdHref);


        //get me all country names


        //assert that all regions ids are equal to 2
    }
}
