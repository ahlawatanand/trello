package com.trello.test.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.containsString;

public class ReusableSpecification {


    private static RequestSpecBuilder requestSpecBuilder;

    public static RequestSpecification getGenericRequestSpec() {
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setRelaxedHTTPSValidation();
        requestSpecBuilder.addHeader("userId", "test");
        return requestSpecBuilder.build();
    }

    public static ResponseSpecification getGenericResponseSpec() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectHeader("Content-Type", containsString("application/json"));
        return responseSpecBuilder.build();
    }

    public static RequestSpecification getGenericPOSTRequestSpec() {
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setConfig(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
        requestSpecBuilder.addHeader("userId", "test");
        requestSpecBuilder.setRelaxedHTTPSValidation();
        requestSpecBuilder.setContentType("application/json");
        return requestSpecBuilder.build();

    }

}
