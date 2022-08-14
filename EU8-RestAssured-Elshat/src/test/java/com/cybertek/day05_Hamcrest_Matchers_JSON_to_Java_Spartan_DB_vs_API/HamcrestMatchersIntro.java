package com.cybertek.day05_Hamcrest_Matchers_JSON_to_Java_Spartan_DB_vs_API;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @DisplayName("Assertion with number")
    @Test
    public void simpleTest1(){

        // actual 5+5
        assertThat(5+5,is(10));
        assertThat(5+5,equalTo(10));
        // matcher has 2 overloaded version
        // first that accept another matchers
        // below example is method accepting another matcher equals to make it readable
        assertThat(5+5,is(equalTo(10)));

        assertThat(5+5,not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5,is(not(equalTo((9)))));

        //number comparison
        //greaterThan()
        //greaterThanOrEqualTo()
        //lessThan()
        //lessThanOrEqualTo()

        assertThat(5+5,is(greaterThan(9)));
    }

    @DisplayName("Assertino with String")
    @Test
    public void stringHamcrest(){

        String text = "B22 is leaning Hamcrest";

        // checking for equality is name as numbers
        assertThat(text,is("B22 is learning Hamcrest" ));
        assertThat(text,equalTo("B22 is learning Hamcrest"));
        assertThat(text,is(equalTo("B22 is learning Hamcrest")));

        //check if this text starts with B22
        assertThat(text,startsWith("B22"));
        //now do it in case insensitive manner
        assertThat(text,startsWithIgnoringCase("b22"));

        //endswith
        assertThat(text,endsWith("rest"));

        //check if text contains String learning
        assertThat(text,containsString("learning"));
        //with ignoring case
        assertThat(text,containsStringIgnoringCase("LEARNING"));

        String str ="  ";

        //check if above str is blank
        assertThat(str,blankString());
        //check if trimmed str is empty string
        assertThat(str.trim(),emptyString());
    }

    @DisplayName("Hamcrest for collection")
    @Test
    public void testCollection(){

        List<Integer> listOfNumber = Arrays.asList(1,4,5,6,32,54,66,77,45,23);

        //check size of the list
        assertThat(listOfNumber,hasSize(10));

        //check if this list hasItem 77
        assertThat(listOfNumber,hasItem(77));

        //check if this list hasItems 77,54,23
        assertThat(listOfNumber,hasItems(77,54,23));

        //check if all numbers greater than 0
        assertThat(listOfNumber,everyItem(greaterThan(0)));



    }
}
