package rest.endpoint;

import io.restassured.RestAssured;
import utils.configManager;

public class baseApi {
    static {
        RestAssured.baseURI = configManager.get("base.url");
        System.out.println("baseURI set to: " + RestAssured.baseURI);
    }
}