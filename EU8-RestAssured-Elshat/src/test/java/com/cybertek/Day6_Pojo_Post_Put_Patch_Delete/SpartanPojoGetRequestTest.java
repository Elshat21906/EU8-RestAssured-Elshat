package com.cybertek.Day6_Pojo_Post_Put_Patch_Delete;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanPojoGetRequestTest {

    @DisplayName("GET one spartan and convert it to Spartan Object")
    @Test
    public void oneSpartanPojo(){


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
