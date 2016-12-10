package com.bogdan;

import com.jayway.restassured.internal.mapper.ObjectMapperType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.Optional.of;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 * Created by zoomout on 12/10/16.
 */
public class RestTest {

    @Test
    public void restBodyWithOptionalNotSetJacksonTest() {
        BodyWithOptional body = new BodyWithOptional();
        body.setName("Tim");

        given().
            contentType(JSON).
            body(body, ObjectMapperType.JACKSON_2).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body("json.name", equalTo("Tim")).
            body("json.age", nullValue());
    }


    @Test
    public void restBodyWithOptionalJacksonTest() {
        BodyWithOptional body = new BodyWithOptional();
        body.setName("Tim");
        body.setAge(of(20));

        given().
            contentType(JSON).
            body(body, ObjectMapperType.JACKSON_2).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body("json.name", equalTo("Tim")).
            body("json.age", equalTo(20));
    }

    @Test
    public void restJsonSchemaValidationOptionalTest() {
        Body body = new Body();
        body.setName("Fin");

        given().
            contentType(JSON).
            body(body, ObjectMapperType.JACKSON_2).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body(matchesJsonSchemaInClasspath("json_schema_optional.json"));
    }

    @Test
    public void restJsonSchemaValidationTest() {
        Body body = new Body();
        body.setName("Fin");
        body.setAge(20);

        given().
            contentType(JSON).
            body(body, ObjectMapperType.JACKSON_2).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body(matchesJsonSchemaInClasspath("json_schema.json"));
    }

    @Test
    public void restJacksonDatabindTest() {
        Body body = new Body();
        body.setName("Mark");
        body.setAge(18);

        given().
            contentType(JSON).
            body(body, ObjectMapperType.JACKSON_2).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body("json.name", equalTo("Mark")).
            body("json.age", equalTo(18));
    }

    @Test
    public void restBodyWithOptionalNotSetGsonTest() {
        BodyWithOptional body = new BodyWithOptional();
        body.setName("Tim");

        given().
            contentType(JSON).
            body(body, ObjectMapperType.GSON).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body("json.name", equalTo("Tim")).
            body("json.age", nullValue());
    }

    @Test
    public void restBodyWithOptionalGsonTest() {
        BodyWithOptional body = new BodyWithOptional();
        body.setName("Tim");
        body.setAge(of(20));

        given().
            contentType(JSON).
            body(body, ObjectMapperType.GSON).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body("json.name", equalTo("Tim")).
            body("json.age.value", equalTo(20));
    }

    @Test
    public void restGsonDatabindTest() {
        Body body = new Body();
        body.setName("Mark");

        given().
            contentType(JSON).
            body(body, ObjectMapperType.GSON).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body("json.name", equalTo("Mark"));
    }

    @Test
    public void restMapBodyTest() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("firstName", "John");
        jsonAsMap.put("lastName", "Doe");

        given().
            contentType(JSON).
            body(jsonAsMap).
            when().
            post("http://httpbin.org/post").
            then().log().all().
            statusCode(200).
            body("json.firstName", equalTo("John")).
            body("json.lastName", equalTo("Doe"));
    }
}
