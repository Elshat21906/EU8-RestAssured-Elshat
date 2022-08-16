package com.cybertek.day05_Hamcrest_Matchers_JSON_to_Java_Spartan_DB_vs_API;

import com.cybertek.utilitis.HRTestBase;
import io.restassured.http.ContentType;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;


public class ORDSHamcrestTest extends HRTestBase {


    @DisplayName("GET request to Employees IT_PROG endpoint and chaining")
    @Test

    public void employeesTest(){

        //send a get request to employees end point with query parameter job_id IT_PROG
        //verify each job_id is IT_PROG
        //verify first names are .... (find proper method to check list against list)
        //verify emails without checking order (provide emails in different order,just make sure it has same emails)
        //expected names


        List<String> names = Arrays.asList("Alexander","Bruce","David","Valli","Diana");
        given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
                .when()
                .get("/employees")
        .then()
                .statusCode(200)
                .contentType("application/json")
                .body("items.job_id",everyItem(equalTo("IT_PROG")))
                .body("items.first_name",containsInRelativeOrder("Alexander","Bruce","David","Valli","Diana"))
                .body("items.email",containsInAnyOrder("AHUNOLD","DLORENTZ","VPATABAL","DAUSTIN","BERNST"))
                .body("items.first_name",equalTo(names));

    }
}
