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


    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test
    public void test2(){


           given()
                   .accept(ContentType.JSON)
                   .and()
                   .pathParam("id", 21887)
        .when()
                   .get("http://api.cybertektraining.com/teacher/{id}")
        .then()
                   .statusCode(200)
                   .contentType("application/json;charset=UTF-8")
                   .and()
                   .header("Content-Type", "application/json;charset=UTF-8")
                   .and()
                   .header("Date", notNullValue())
                   .and().assertThat()
                   .body("teachers[0].firstName", is("Steve"))
                   .body("teachers[0].lastName", is("Peter"))
                   .body("teachers[0].gender", equalTo("Male"));



    }

    @DisplayName("GET request to teacher/all and chaining")
    @Test
    public void teachersTest(){

        //verify Steve,Leonel,Leoneli inside the all teachers
        given()
                .accept(ContentType.JSON)
                .when()
                .get("http://api.cybertektraining.com/teacher/all")
                .then()
                .statusCode(200)
                .and()
                .body("teachers.firstName",hasItems("Steve","Leonel","Leoneli"));
    }


}
