package org.smartbar;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class CategoriesResourceTest {
    @Test
    void getsListsOfCategories() {
       final Response response = given()
           .when().get ("/categories")
           .then()
           .statusCode(200)
           .extract().response();

        final JsonPath jsonPath = response.jsonPath();
        Assertions.assertEquals("Soft Drinks", jsonPath.getString("[0].name"));
    }

}