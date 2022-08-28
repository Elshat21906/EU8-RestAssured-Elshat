package com.cybertek.Day06_Pojo_Post_Put_Patch_Delete;

import com.cybertek.pojo.Link;
import com.cybertek.pojo.Region;
import com.cybertek.utilitis.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ORDSPojoGetRequestTest extends HRTestBase{

    @Test
    public void regionTest(){

        JsonPath jsonPath = get("/regions").then().statusCode(200).extract().jsonPath();
        Region region1 = jsonPath.getObject("items[0]", Region.class);

        System.out.println(region1);
        System.out.println("region1.getRegion_id() = " + region1.getRegion_id());
        System.out.println("region1.getRegion_name() = " + region1.getRegion_name());

        System.out.println("region1.getLinks().get(0).getHref() = " + region1.getLinks().get(0).getHref());

    }

    @DisplayName("GET request to /employees and only get couple of values as a Pojo class")
    @Test
    public void employeeGet(){



    }

    /* send a get request to regions
        verify that region ids are 1,2,3,4
        verify that regions names Europe ,Americas , Asia, Middle East and Africa
        verify that count is 4
        try to use pojo as much as possible
        ignore non used fields
     */

    @DisplayName("GET request to region only some fields test")
    @Test
    public void regionPojoTest(){

        //send a get request and save everthing inside the regions object
        //since we prepare pojo also for the all properties we dont need to use any path so as() method is enough

        //verify count is 4

        //create empty list to store values

        //get list of regions out of regions object

        //loop through each of the region, save their ids and names to empty list that we prepare

        //prepare expected result

        //compare two result

    }

}
