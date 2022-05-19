package com.bridgelabz.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethodTest {
    public void getTest() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " +response.prettyPrint());
    }

    public static void main(String[] args) {
        GetMethodTest getMethodTest = new GetMethodTest();
        getMethodTest.getTest();
    }
}
