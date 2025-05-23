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

    public VamToWkgConverterControllerTest() {
    }

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
                .body(new VamRequestRecord(1606, 8.1, 68))
                .when()
                .post("/convert")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "wattsPerKilo", is(5.72F),
                        "rawWatts", is(388),
                        "errorMessage", emptyString());
    }

    //todo Cases: no rider weight, no vam or gradient, string inputs and 3XX error codes, max inputs.
}