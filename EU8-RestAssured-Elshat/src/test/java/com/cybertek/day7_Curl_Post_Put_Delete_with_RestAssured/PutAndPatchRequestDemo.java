package com.cybertek.day7_Curl_Post_Put_Delete_with_RestAssured;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PutAndPatchRequestDemo {

    @DisplayName("PUT request to one spartan for update with Map")
    @Test
    public void PUTRequest(){

        //just like post request we have different options to send body, we will go with map


        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send
    }


    @DisplayName("PATCH request to one spartan for partial update with Map")
    @Test
    public void PATCHRequest(){

        //just like post request we have different options to send body, we will go with map


        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send

    }

    @DisplayName("DELETE one spartan")
    @Test
    public void deleteSpartan(){


        //send a get request after you delete make sure you are getting 404
    }

}
