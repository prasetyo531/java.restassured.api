package rest.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.restClient;

import static rest.constant.userApi.USER_ENDPOINT;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class getUserDetail {

    @Test
    public void testGetUsers() {
        Response res = restClient.get(USER_ENDPOINT + "1");
        Assert.assertEquals(res.statusCode(), 200);

        res.then().assertThat()
                .body(matchesJsonSchemaInClasspath("getUserDetail.schema.json"));
    }

}