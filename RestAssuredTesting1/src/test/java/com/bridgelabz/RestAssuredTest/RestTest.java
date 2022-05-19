package com.bridgelabz.RestAssuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/*import org.json.simple.JSONObject;*/

public class RestTest {
    @Test
    public void TestGetUserProfile_ShouldReturn_StatusCode200() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer BQCLUysg85OL5X7dFL0o6Qyftnn-hPGmOS404e2WcgDfBoHt8wHZZNa1DoGqGmVjn3kRl4W7-S4_1iUDJj8L1vES7sGULLVY187mhB5fkmmZcs110Pwg2b9gdUogCX2r7mgKk6fLVADHobyi9DEnwKijktnq_PzDF-tCuelqp3dZDtKPoPRBPOWFUgwmVPnkk65zIEoem_Msi10JKUvpr-JGM-T89XNVWvlhmxA4uLWi-mG9crTujS7FQobsC5lGRgkRIhY-X9lvsvHDTtYfMd4wxD7Cd30T7Q");
        Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/me\n");
        response.prettyPrint();

        int statusCode = response.statusCode();
        response.body();
        response.headers();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void TestCreatePlaylist_ShouldReturn_StatusCode201 () {
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.body("{\n" +
                "  \"name\": \"New Playlist15\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}");
     /*  <--- or body can be modified like below  ---->
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "New Playlist15");
        jsonObject.put("description","new playlist");
        jsonObject.put("public","false");
        requestSpecification.body(jsonObject.toString());*/


        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer BQC32sNi31axuyUk0Grel7bIJCqyooukTzq-gopi5wtkw-II-xnjInJ_HbbiuKT_XUWPIIWYmVVDLejjob5eepKN731xiEx_ZnUNX9jD8YjhAIl4IbNKtvtw-9qn_sDh3Jw3140BpAcNxukU5909V57pCMsGdYauIIO_DrVpeKcHutZj9C4_CZ1VuHqHbrtoCIgW3s3_cpt5V0VJZLsV7mmKToJHzkJMOmREH0ItDJAqj06FBlSiB8PuEpuZMyoMu3H-Tugn00vu9TCndLlsc7dpL5G8EEPaXmb1RZQ");
        Response response = requestSpecification.request(Method.POST,"https://api.spotify.com/v1/users/31xxwnrflfgdq4ybo7vis37jemee/playlists");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 201);
    }
}
