package com.bridgelabz.RestTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BDDTest {
    @Test
    public void getTest() {
       given().
       when().
       get("https://reqres.in/api/users?page=2").
       then().
       statusCode(200).
       and().
       body("page", equalTo(2)).
//     body("page", equalTo(1)).
       and().
       body("data.id", hasSize(6)).
//     body("data.id", hasSize(5)).
       and().
       body("data.id[0]", equalTo(7)).
       and().
       body("data.id[1]", equalTo(8)).
       and().
//     body("data.id[2]", equalTo(10)).
       body("data.first_name[2]", equalTo("Tobias")).
       and().
       body("data.first_name[0]", equalToIgnoringCase("michael")).
       and().
       body("data.email[0]", equalTo("michael.lawson@reqres.in")).
       and().
       body("data.last_name[4]", equalTo("Edwards")).
       body("data.first_name[0]", startsWith("Mi")).
       body("data.last_name[2]", startsWith("F")).
       body("data.email[5]", startsWith("r")).
       body("data.first_name[4]", endsWith("e")).
       body("data.last_name[2]", endsWith("ke")).
       body("data.id", hasItem(9)).
//     body("data.id", hasItem(13));
       body("data.id", hasItems(7,8,9,10,11,12)).
       body("data[0]", hasKey("id")).
       body("data[1]", hasKey("email")).
       body("support", hasKey("url")).
       body("data[5]", hasValue("Rachel")).
       body("data[0]", hasEntry("id",7)).
       body("data[1]", hasEntry("last_name","Ferguson"));

    }
}
