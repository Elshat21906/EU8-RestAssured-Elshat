package com.cybertek.Day6_Pojo_Post_Put_Patch_Delete;

import com.cybertek.utilitis.HRTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ORDSPojoGetRequestTest extends HRTestBase {

    @Test
    public void regionTest(){


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
