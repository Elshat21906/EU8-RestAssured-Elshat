package com.cybertek.day7_Curl_Post_Put_Delete_with_RestAssured;

import com.cybertek.pojo.Spartan;
import com.cybertek.utilitis.SpartansTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanPostRequestDemo extends SpartansTestBase {



       /*
    Given accept type and Content type is JSON
    And request json body is:
    {
      "gender":"Male",
      "name":"Severus",
      "phone":8877445596
   }
    When user sends POST request to '/api/spartans'
    Then status code 201
    And content type should be application/json
    And json payload/response/body should contain:
    "A Spartan is Born!" message
    and same data what is posted
 */

    @Test
    public void postMethod1(){

        String requestJsonBody = "{\"gender\":\"Male\",\n" +
                "\"name\":\"Mikela\",\n" +
                "\"phone\":28375938747}";

        Response response = given().accept(ContentType.JSON).and()  //what we are asking from api which is JSON response
                .contentType(ContentType.JSON)//what we are sending to api, which is JSON also
                .body(requestJsonBody)
                .when()
                .post("/api/spartans");

        //verify status code
        assertThat(response.statusCode(),is(201));
        assertThat(response.contentType(),is("application/json"));

        String expectedResponseMessage = "A Spartan is Born!";
        assertThat(response.path("success"),is(expectedResponseMessage));
        assertThat(response.path("data.name"),is("Mikela"));
        assertThat(response.path("data.gender"),is("Male"));
        assertThat(response.path("data.phone"),is(28375938747L));



    }


    @DisplayName("POST with Map to JSON")
    @Test
    public void postMethod2() {

        //create a map to keep request json body information
        Map<String,Object> requestJsonMap = new LinkedHashMap<>();

        requestJsonMap.put("name","Mikela");
        requestJsonMap.put("gender","Male");
        requestJsonMap.put("phone",28375938747L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON).log().all()
                .body(requestJsonMap)
                .when()
                .post("/api/spartans");

        //verify status code
        assertThat(response.statusCode(),is(201));
        assertThat(response.contentType(),is("application/json"));

        String expectedResponseMessage = "A Spartan is Born!";
        assertThat(response.path("success"),is(expectedResponseMessage));
        assertThat(response.path("data.name"),is("Mikela"));
        assertThat(response.path("data.gender"),is("Male"));
        assertThat(response.path("data.phone"),is(28375938747L));

        response.prettyPrint();
    }




    @DisplayName("POST with Map to Spartan Class")
    @Test
    public void postMethod3(){

        // creat one object from pojo,send it as a JSON
        Spartan spartan = new Spartan();

        spartan.setName("MikelaSpartan");
        spartan.setGender("Male");
        spartan.setPhone(28375938747L);

        System.out.println("spartan = " + spartan);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(spartan).log().all()
                .when()
                .post("/api/spartans");

        //verify status code
        assertThat(response.statusCode(),is(201));
        assertThat(response.contentType(),is("application/json"));

        String expectedResponseMessage = "A Spartan is Born!";
        assertThat(response.path("success"),is(expectedResponseMessage));
        assertThat(response.path("data.name"),is("MikelaSpartan"));
        assertThat(response.path("data.gender"),is("Male"));
        assertThat(response.path("data.phone"),is(28375938747L));
        
    }



    @DisplayName("POST with Map to Spartan Class")
    @Test
    public void postMethod4(){


        //this example we implement serialization with creatin spartan object sending as a request body
        //also implemented deserialization getting the id,sending get request and saving that body as a response

        //create one object from your pojo, send it as a JSON
    }



}


//Create one SpartanUtil class
//create a static method that returns Map<String,Object>
//use faker library(add as a dependency) to assign each time different information
//for name,gender,phone number
//then use your method for creating spartan as a map,dynamically.



