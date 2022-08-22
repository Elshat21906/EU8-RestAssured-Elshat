package com.cybertek.day05_Hamcrest_Matchers_JSON_to_Java_Spartan_DB_vs_API;

import com.cybertek.utilitis.SpartansTestBase;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanAPIvsDB extends SpartansTestBase {

    public void testDB1() {

        //get id,name,gender phone  from database
        //get same information from api
        //compare


        //1. get id,name,gender phone  from database

        //save data inside the map

        //2.get info from api


        //Deserialization here JSon to Java  with Jackson objectMapper

        //3.compare database vs api --> we assume expected result is db

    }

}
