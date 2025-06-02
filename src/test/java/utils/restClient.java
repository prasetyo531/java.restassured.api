package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class restClient {

    public static Response get(String endpoint) {
        return given()
                .baseUri(configManager.get("base.url"))
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }
}
