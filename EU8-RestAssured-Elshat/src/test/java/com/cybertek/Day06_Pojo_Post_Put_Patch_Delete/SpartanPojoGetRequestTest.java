package com.cybertek.Day06_Pojo_Post_Put_Patch_Delete;

import com.cybertek.pojo.Search;
import com.cybertek.pojo.Spartan;
import com.cybertek.utilitis.SpartansTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
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
                .log().body()
                .extract().response();

        //De serialize --> JSON to POJO (java custom class)
        //2 different way to do this
        //1.using as() method
        //we convert json response to spartan object with the help of jackson
        //as() method uses jackson to de serialize(converting JSON to Java class)
        Spartan spartan15 = response.as(Spartan.class);
        System.out.println("spartan15 = " + spartan15);

        System.out.println("spartan15.getId() = " + spartan15.getId());
        System.out.println("spartan15.getName() = " + spartan15.getName());
        System.out.println("spartan15.getGender() = " + spartan15.getGender());
        System.out.println("spartan15.getPhone() = " + spartan15.getPhone());

        System.out.println("------------------------------------------------------------------");


        //second way of deserialize json to java
        //2.using JsonPath to deserialize to custom class

        JsonPath jsonPath = response.jsonPath();

        Spartan s15 = jsonPath.getObject("", Spartan.class);

        System.out.println("s15 = " + s15);
        System.out.println("s15.getId() = " + s15.getId());
        System.out.println("s15.getName() = " + s15.getName());
        System.out.println("s15.getGender() = " + s15.getGender());
        System.out.println("s15.getPhone() = " + s15.getPhone());


    }


    @DisplayName("Get one spartan from search endpoint result and use POJO")
    @Test
    public void spartanSearchWithPojo(){

        ///spartans/search?nameContains=a&gender=Male
        // send get request to above endpoint and save first object with type Spartan POJO
        JsonPath jsonPath = given().accept(ContentType.JSON)
                .and().queryParams("nameContains", "a"
                        , "gender", "Male")
                .when().get("/api/spartans/search")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        //get the first spartan from content list and put inside spartan object
        Spartan s1 = jsonPath.getObject("content[0]", Spartan.class);

        System.out.println("s1 = " + s1);
        System.out.println("s1.getId() = " + s1.getId());
        System.out.println("s1.getName() = " + s1.getName());
        System.out.println("s1.getGender() = " + s1.getGender());
        System.out.println("s1.getPhone() = " + s1.getPhone());

    }



    @Test
    public void test3(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParams("nameContains", "a",
                        "gender", "Male")
                .when().get("/api/spartans/search")
                .then()
                .statusCode(200)
                .extract().response();

        Search searchResult = response.as(Search.class);

        System.out.println(searchResult.getContent().get(0).getName());

    }


    @DisplayName("GET  /spartans/search and save as List<Spartan>")
    @Test
    public void test4(){
    }
}

//test1
//De serialize --> JSON to POJO (java custom class)
//2 different way to do this
//1.using as() method
//we convert json response to spartan object with the help of jackson
//as() method uses jackson to de serialize(converting JSON to Java class)

//second way of deserialize json to java
//2.using JsonPath to deserialize to custom

//test2
///spartans/search?nameContains=a&gender=Male
// send get request to above endpoint and save first object with type Spartan POJO



