package com.bridgelabz.RestTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import java.security.PublicKey;
import static org.hamcrest.Matchers.*;

public class RestTest {
    @Test
    public void getTest() {
        RestAssured.given().
                          when().
                          get("https://reqres.in/api/users?page=2").
                          then().
                          body("page", equalTo(2)).
                          body("total", equalTo(12)).
                          body("data.email[0]", equalTo("michael.lawson@reqres.in")).
                          body("data.id", hasSize(6));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.id[1]", equalTo(8));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.first_name[3]", equalToIgnoringCase("byron"));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.last_name[5]", equalTo("Howell"));

/*      RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("page", equalTo(1));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("total", equalTo(13));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.id", hasSize(7));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.id[0]", equalTo(8));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.first_name[2]", equalToIgnoringCase("george"));
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.last_name[3]", equalTo("Howell"));*/
    }
    @Test
    public void testGetAllPosts() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
//      response.prettyPrint();
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testGetPosts() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/posts/1");
        System.out.println(response.getStatusCode());
//      response.prettyPrint();
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testPostPosts() {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "12");
        jsonObject.put("title", "BL QA Learning");
        jsonObject.put("author", "datta");
        request.body(jsonObject.toJSONString());

        Response response = request.post("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

        /*RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("first_name", "datta");
        jsonObject.put("last_name", "bhure");
        jsonObject.put("sub_id", 1);
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/users");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());*/
    }
    @Test
    public void testPutPosts() {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "12");
        jsonObject.put("title", "BL QA Learning");
        jsonObject.put("author", "ganesh");
        request.body(jsonObject.toJSONString());

        Response response = request.put("http://localhost:3000/posts/12");

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,201);
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testDeletePosts() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/12");
        System.out.println("Response Code: "+response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,201);
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testGetAllComments() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());
//      response.prettyPrint();
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testGetComments() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/comments/2");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testPostComments() {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 3);
        jsonObject.put("body", "wonderful");
        jsonObject.put("postId", 3);
        request.body(jsonObject.toJSONString());

        Response response = request.post("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testPutComments() {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 3);
        jsonObject.put("body", "amazing");
        jsonObject.put("postId", 3);
        request.body(jsonObject.toJSONString());

        Response response = request.put("http://localhost:3000/comments/3");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testDeleteComments() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/comments/2");
        System.out.println("Response Code: "+response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void testGetProfile() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
//      response.prettyPrint();
        System.out.println(response.prettyPrint());
    }
    @Test
    public void getCommentsDetails_WithPostID_ForProfile() {
        Response response= RestAssured.
                given().
                when().
                get("http://localhost:3000/posts?_embed=comments");
//              get("http://localhost:3000/posts/1/comments");
        System.out.println(response.prettyPrint());
    }
    @Test
    public void getCommentsDetails_WithPostID_ForProfile1() {
        Response response= RestAssured.
                given().
                when().
                get("http://localhost:3000/posts/1?_embed=comments");
        System.out.println(response.prettyPrint());
    }
    @Test
    public void getPostsDetails_WithCommentID_ForProfile() {
        Response response= RestAssured.
                given().
                when().
                get("http://localhost:3000/comments/1/posts");
        System.out.println(response.prettyPrint());
    }
}


