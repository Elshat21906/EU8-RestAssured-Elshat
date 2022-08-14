package com.cybertek.day05_Hamcrest_Matchers_JSON_to_Java_Spartan_DB_vs_API;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersApiTest {

     /*
       given accept type is Json
       And path param id is 15
       When user sends a get request to spartans/{id}
       Then status code is 200
       And content type is Json
       And json data has following
            "id": 15,
           "name": "Meta",
           "gender": "Female",
           "phone": 1938695106
        */

    @DisplayName("One spartan with Hamcreste and chaining ")
    @Test
    public void test1(){

        given()
                .accept(ContentType.JSON)
                .and().pathParam("id",15)
                .get("http://44.202.119.26:8000/api/spartans/{id}")
                .then()
                    .statusCode(200)
                    .contentType("application/json")
                    .and()
                    .body("id",is(15),
      "name",is("Meta"),
                            "gender",is("Female"),
                             "phone",is(1938695106));



    }

}
