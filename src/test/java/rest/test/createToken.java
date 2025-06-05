package rest.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import rest.endpoint.authApi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class createToken {

    @Test
    public void testTokenGeneration() {
        authApi AuthAPI = new authApi();
        Response response = AuthAPI.getToken("admin", "password123");

        System.out.println("Response body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().getString("token"));
    }

    @Test
    public void testDirectCall() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        RestAssured.useRelaxedHTTPSValidation(); // In case SSL fails

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
                .when()
                .post("https://restful-booker.herokuapp.com/auth");

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
    }
}