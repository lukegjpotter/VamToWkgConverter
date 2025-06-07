package com.lukegjpotter.tools.vam_to_wkg_converter.controller;

import com.lukegjpotter.tools.vam_to_wkg_converter.dto.VamRequestRecord;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class VamToWkgConverterControllerTest {

    @BeforeAll
    static void beforeAll() {
        baseURI = "http://localhost:8080/";
    }

    @Test
    @Order(1)
    public void healthCheck() {
        when()
                .get("/health")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(equalTo("OK"));
    }

    @Test
    @Order(2)
    void test_TestMethod() {
        when()
                .get("/test")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "wattsPerKilo", is(6.8F),
                        "rawWatts", is(440),
                        "errorMessage", emptyString());
    }

    @Test
    void convert_goldenPath() {
        given()
                .contentType(ContentType.JSON)
                .body(new VamRequestRecord(1606, 8.1, 68.0))
                .when()
                .post("/convert")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "wattsPerKilo", is(5.72F),
                        "rawWatts", is(388),
                        "errorMessage", emptyString());
    }

    @Test
    void convert_riderWeight_zero() {
        given()
                .contentType(ContentType.JSON)
                .body(new VamRequestRecord(1800, 9.5, 0.0))
                .when()
                .post("/convert")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "wattsPerKilo", is(6.1F),
                        "rawWatts", nullValue(),
                        "errorMessage", emptyString());
    }

    @Test
    void convert_riderWeight_null() {
        given()
                .contentType(ContentType.JSON)
                .body(new VamRequestRecord(1800, 9.5, null))
                .when()
                .post("/convert")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "wattsPerKilo", is(6.1F),
                        "rawWatts", nullValue(),
                        "errorMessage", emptyString());
    }

    @Test
    void convert_negativeNumbers() {
        given()
                .contentType(ContentType.JSON)
                .body(new VamRequestRecord(-1800, -9.5, -68.0))
                .when()
                .post("/convert")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(
                        "wattsPerKilo", nullValue(),
                        "rawWatts", nullValue(),
                        "errorMessage", is("verticalAscentMeters and gradient must be positive numbers. riderWeight is optional, but must be positive if provided."));
    }
    //todo Cases: no vam or gradient, string inputs and 3XX error codes, max inputs.
}