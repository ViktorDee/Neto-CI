package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnRUB() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body("[2].currency", equalTo("RUB"))
                .body("[0].currency", equalTo("RUB"))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;

    }

    @Test
    void shouldReturnUSD() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body("[1].currency", equalTo("USD"))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;


    }
}
