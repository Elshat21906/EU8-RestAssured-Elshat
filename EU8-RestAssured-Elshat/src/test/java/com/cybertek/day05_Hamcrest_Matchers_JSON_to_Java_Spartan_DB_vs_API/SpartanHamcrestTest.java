package com.cybertek.day05_Hamcrest_Matchers_JSON_to_Java_Spartan_DB_vs_API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.cybertek.utilitis.SpartansTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SpartanHamcrestTest extends SpartansTestBase {

    @DisplayName("Get spartan/search and chaining together")
    @Test
    public void test1() {

        //along with this statement, I want to save names inside the List<String>

        List<String> names = given().accept(ContentType.JSON)
                .and().queryParams("nameContains", "j",
                        "gender", "Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .body("totalElement", greaterThanOrEqualTo(3))
                .extract().response().jsonPath().getList("content.name");

        System.out.println(names);

    }


    @DisplayName("GET spartan/search and chaining together")
    @Test
    public void test2() {

        //save status code
        int statusCode = given().accept(ContentType.JSON)
                .and().queryParams("nameContains", "j",
                        "gender", "male")
                .when().get("/api/spartans/search")
                .then()
                .statusCode(200)
                .body("totalElement", greaterThanOrEqualTo(6))
                .extract().statusCode();

        System.out.println(statusCode);
    }
}
