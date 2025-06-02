package rest.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class getUserDetail {

    @Test
    public void simple_test_case(){
        given().
                baseUri("http://localhost:3000/localpras").
                when().
                get("/user/1").
                then().
                statusCode(200).
                body("data.first_name", is(equalTo("Pras")));
    }
}