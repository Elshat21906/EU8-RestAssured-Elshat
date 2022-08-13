package com.cybertek.day04_JsonPath;

import com.cybertek.utilitis.HRTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath  extends HRTestBase {

    @DisplayName("GET request to Countries")
    @Test
    public void test1(){

        Response response = get("/countries");

        //get the second country name with JsonPath
        //to use jsonpath we assign response to JsonPath
        JsonPath jsonPath = response.jsonPath();
        //response.prettyPrint();

        String secondCountryName = response.jsonPath().getString("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        //get all country ids
        //items.country_id
        List<String> allCountryIDs = response.jsonPath().getList("items.country_id");
        System.out.println("allCountryIDs = " + allCountryIDs);

        //get all country names where their region id is equal to 2
        List<String> allCountryNamesWithRegionId2 = response.jsonPath().getList("items.findAll{it.region_id==2}.country_name");
        System.out.println("allCountryNamesWithRegionId2 = " + allCountryNamesWithRegionId2);

    }

    @DisplayName("GET request to /employees with query param")
    @Test
    public void test2(){

        //we added limit query param to get 107 employees
        Response response = given().queryParam("limit",107)
                .when().get("/employees");

        JsonPath jsonPath = response.jsonPath();

        //get me all email of employees who is working as IT_PROG
        List<String> allEmailsOfEmplyees = response.jsonPath().getList("items.findAll{it.job_id==\"IT_PROG\"}.email");
        System.out.println("allEmailsOfEmplyees = " + allEmailsOfEmplyees);

        //get me first name of employees who is making more than 10000
        List<String> empName = response.jsonPath().getList("items.findAll{it.salary > 10000}.first_name");
        System.out.println("empName = " + empName);

        //get the max salary first_name
        String firstNameMaxSalary = jsonPath.getString("items.max{it.salary}.first_name");
        System.out.println("firstNameMaxSalary = " + firstNameMaxSalary);

        String firstNameMaxSalaryWithPathMethod = response.path("items.max{it.salary}.first_name");
        System.out.println("firstNameMaxSalaryWithPathMethod = " + firstNameMaxSalaryWithPathMethod);


    }

}
