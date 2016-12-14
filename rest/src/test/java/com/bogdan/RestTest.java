package com.bogdan;

import com.bogdan.domain.Body;
import com.bogdan.domain.BodyWithOptional;
import com.bogdan.domain.httpbinbody.HttpBinBody;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookie.Builder;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
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

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "http://httpbin.org";
    }

    @Test
    public void basicAuthTest() {
        Response response = given().
            auth().basic("u", "p").
            when().
            get("/basic-auth/u/p");

        response.then().
            statusCode(200);
    }

    @Test
    public void deserializationTest() throws IOException {
        Body requestBody = new Body();
        requestBody.setName("Fred");
        requestBody.setAge(25);

        Response response = given().
            contentType(JSON).
            body(requestBody).
            when().
            put("/put");

        response.then().log().all().statusCode(200);

        String responseBodyJson = response.getBody().prettyPrint();

        HttpBinBody responseBody =
            new ObjectMapper().readValue(responseBodyJson, new TypeReference<HttpBinBody<Body>>() {
            });

        Assert.assertEquals(responseBody.getRequestBody(), requestBody);
    }

    @Test
    public void cookiesSet() {

        Cookie cookie = new Builder("my", "cookie").build();
        Cookies cookies = new Cookies(cookie);
        given().
            cookies(cookies).
            when().log().all().
            get("/cookies/set").
            then().log().all().
            statusCode(200).
            body("cookies.my", equalTo("cookie"));
    }

    @Test
    public void urlRedirects() {
        given().
            param("hi").
            when().
            get("/get").
            then().log().all().
            statusCode(200).
            body("args.hi", equalTo(""));
    }


    @Test
    public void urlParameterWithNoValue() {
        given().
            param("hi").
            when().
            get("/get").
            then().log().all().
            statusCode(200).
            body("args.hi", equalTo(""));
    }

    @Test
    public void restBodyWithOptionalNotSetJacksonTest() {
        BodyWithOptional body = new BodyWithOptional();
        body.setName("Tim");

        given().
            contentType(JSON).
            body(body).
            when().
            post("/post").
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
            body(body).
            when().
            post("/post").
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
            body(body).
            when().
            post("/post").
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
            body(body).
            when().
            post("/post").
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
            body(body, ObjectMapperType.JACKSON_2). //just an example, JACKSON_2 is used by default
            when().
            post("/post").
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
            post("/post").
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
            post("/post").
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
            post("/post").
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
            post("/post").
            then().log().all().
            statusCode(200).
            body("json.firstName", equalTo("John")).
            body("json.lastName", equalTo("Doe"));
    }
}
