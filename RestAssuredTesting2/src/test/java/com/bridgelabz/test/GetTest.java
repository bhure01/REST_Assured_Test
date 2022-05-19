package com.bridgelabz.test;

import io.restassured.RestAssured;
import  io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTest {
    @Test
    public void getTest() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Status code: " + response.getStatusCode());
            // to get the response body in beautiful pretty format
        System.out.println("Response body: " + response.prettyPrint());

        System.out.println("-------------------------------");
            // to get the response body in normal string format
        System.out.println("Response Body as a string: " + response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
