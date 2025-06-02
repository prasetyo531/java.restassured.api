package rest.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class getUserDetail {

    @Test
    public void get_user_detail(){
        given().
                baseUri("http://localhost:3000/localpras").
                when().
                get("/user/1").
                then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("getUserDetail.schema.json"));

    }
}