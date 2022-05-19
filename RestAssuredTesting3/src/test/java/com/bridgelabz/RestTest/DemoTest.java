package com.bridgelabz.RestTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoTest {
    @Test
    public void getTest() {
        Response response= RestAssured.
        given().
                when().
//                get("http://localhost:3000/posts");
//                get("http://localhost:3000/posts/2");
                  get("http://localhost:3000/posts/1/comments");
                  System.out.println(response.prettyPrint());
    }
}
