package com.bridgelabz.RestTest;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class RestAssuredTestTwitterAPI {
    @Test
//     ("API Key", "API Key Secret", "Access token", "Access secret") - Fundamental credentials required to access Twitter APIs which acts as username & password
    public void tweetTwitterPost() {
        Response response = RestAssured.given()
                            .auth().oauth("S3eDYwiSJ57HQPWliHxhnndgY",
                              "4Nd9zhlvUiVJO9ibxbRg041s6lhDFujCEP7WwIeBZ8BwA2OTnP",
                              "1527487364817616896-tYi7SPwKbbGyMMYFS1AKjMSTVkUjsk",
                              "YNjoCEWnq08coZnq4p4dafpGEzOm0efeHdkp5q8jRPfhu")
                            .post("https://api.twitter.com/1.1/statuses/update.json?status = Good Morning Guys");
        System.out.println("Response Body: " + response.prettyPrint());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("Tweet ID : " + jsonPath.get("id_str"));
    }
    @Test
    public void retweetTwitterPost() {
        Response response = RestAssured.given()
                            .auth().oauth("S3eDYwiSJ57HQPWliHxhnndgY",
                              "4Nd9zhlvUiVJO9ibxbRg041s6lhDFujCEP7WwIeBZ8BwA2OTnP",
                              "1527487364817616896-tYi7SPwKbbGyMMYFS1AKjMSTVkUjsk",
                              "YNjoCEWnq08coZnq4p4dafpGEzOm0efeHdkp5q8jRPfhu")
                            .post("https://api.twitter.com/1.1/statuses/retweet/1528376011506974721.json");
        System.out.println("Response Body: " + response.prettyPrint());
    }
    @Test
    public void deleteTwitterPost() {
        Response response = RestAssured.given()
                            .auth().oauth("S3eDYwiSJ57HQPWliHxhnndgY",
                              "4Nd9zhlvUiVJO9ibxbRg041s6lhDFujCEP7WwIeBZ8BwA2OTnP",
                              "1527487364817616896-tYi7SPwKbbGyMMYFS1AKjMSTVkUjsk",
                              "YNjoCEWnq08coZnq4p4dafpGEzOm0efeHdkp5q8jRPfhu")
                            .delete("https://api.twitter.com/2/tweets/1528376011506974721");
        System.out.println("Response Body: " + response.prettyPrint());
    }
}
