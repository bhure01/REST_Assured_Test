package com.bridgelabz.RestTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDDRestTest {
    @Test
    public void testGetProfile() {
        given().
                header("Content-Type", "application/json").
                when().
                get("http://localhost:3000/profile").
                then().
                statusCode(200);
    }
    @Test
    public void testGetAllPosts() {
        given().
                header("Content-Type", "application/json").
                when().
                get("http://localhost:3000/posts").
                then().
                statusCode(200);
    }
    @Test
    public void testGetPostsWithID() {
        given().
                header("Content-Type", "application/json").
                when().
                get("http://localhost:3000/posts/1").
                then().
                statusCode(200);
    }
    @Test
    public void testPostPosts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 3);
        jsonObject.put("title", "json");
        jsonObject.put("author", "guru");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                post("http://localhost:3000/posts").
                then().
                statusCode(201);
    }
    @Test()
    public void testPutPosts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "server");
        jsonObject.put("author", "Jommy");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                put("http://localhost:3000/posts/3").
                then().
                statusCode(200);
    }
    @Test()
    public void testDeletePosts() {
        given().
                header("Content-Type", "application/json").
                when().
                delete("http://localhost:3000/posts/2").
                then().
                statusCode(200);
    }

    @Test
    public void testGetAllComments() {
        given().
                header("Content-Type", "application/json").
                when().
                get("http://localhost:3000/comments").
                then().
                statusCode(200);
    }
    @Test
    public void testGetCommentsWithID() {
        given().
                header("Content-Type", "application/json").
                when().
                get("http://localhost:3000/comments/2").
                then().
                statusCode(200);
    }

    @Test
    public void testPostComments() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 4);
        jsonObject.put("body", "awesome");
        jsonObject.put("postId", 4);

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                post("http://localhost:3000/comments").
                then().
                statusCode(201);
    }
    @Test()
    public void testPutComments() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", "dashing");
        jsonObject.put("postId", "5");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                put("http://localhost:3000/comments/4").
                then().
                statusCode(200);
    }
    @Test()
    public void testDeleteCommentsWithID() {
        given().
                header("Content-Type", "application/json").
                when().
                delete("http://localhost:3000/comments/2").
                then().
                statusCode(200);
    }
    @Test()
    public void testDeleteAllComments() {
        given().
                header("Content-Type", "application/json").
                when().
                delete("http://localhost:3000/comments").
                then();
//              statusCode(200);
    }
}
