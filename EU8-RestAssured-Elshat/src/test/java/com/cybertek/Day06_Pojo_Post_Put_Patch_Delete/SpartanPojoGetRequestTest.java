package com.cybertek.Day06_Pojo_Post_Put_Patch_Delete;

import com.cybertek.utilitis.SpartansTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanPojoGetRequestTest extends SpartansTestBase {

    @DisplayName("GET one spartan and convert it to Spartan Object")
    @Test
    public void oneSpartanPojo(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}")
                .then().statusCode(200)
                .extract().response();

        //De serialize --> JSON to POJO (java custom class)
        //2 different way to do this
        //1.using as() method
        //we convert json response to spartan object with the help of jackson
        //as() method uses jackson to de serialize(converting JSON to Java class)


        //second way of deserialize json to java
        //2.using JsonPath to deserialize to custom class
    }


    @DisplayName("Get one spartan from search endpoint result and use POJO")
    @Test
    public void spartanSearchWithPojo(){

        ///spartans/search?nameContains=a&gender=Male
        // send get request to above endpoint and save first object with type Spartan POJO

        //get the first spartan from content list and put inside spartan object

    }



    @Test
    public void test3(){


    }


    @DisplayName("GET  /spartans/search and save as List<Spartan>")
    @Test
    public void test4(){
    }
}
