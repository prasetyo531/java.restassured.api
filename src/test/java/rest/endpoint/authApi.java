package rest.endpoint;

import io.restassured.response.Response;
import utils.configManager;

import static io.restassured.RestAssured.given;

public class authApi extends baseApi {

    public Response getToken(String username, String password) {
        try {
            String requestBody = "{"
                    + "\"username\": \"" + username + "\","
                    + "\"password\": \"" + password + "\""
                    + "}";

            return given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .when()
                    .post("/auth");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}