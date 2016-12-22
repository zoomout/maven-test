package com.bogdan;

import com.bogdan.domain.*;
import com.bogdan.domain.httpbinbody.HttpBinBody;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookie.Builder;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.testng.Assert.assertEquals;

/**
 * Created by zoomout on 12/10/16.
 */
public class RestTest {
    ObjectMapper jacksonObjectMapper = new ObjectMapper();

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://httpbin.org";
    }

    @Test
    public void fluentSettersAndAssertJWithNotSetField() throws IOException {

        ExternalDTO requestBody = generateExternalDTO();

        ExternalDTO responseBody = sendRequestAndExtractExternalDTOFromResponse(requestBody);

        responseBody.setInternalDTO(null);

        assertThat(responseBody).isEqualToComparingFieldByFieldRecursively(requestBody.setInternalDTO(null));

    }

    @Test
    public void fluentSettersAndAssertJ() throws IOException {

        ExternalDTO requestBody = generateExternalDTO();

        ExternalDTO responseBody = sendRequestAndExtractExternalDTOFromResponse(requestBody);

        responseBody.setName("Another Name");
        responseBody.setInternalDTO(null);
        assertThat(responseBody).isEqualToIgnoringGivenFields(requestBody, "name");

    }

    private ExternalDTO sendRequestAndExtractExternalDTOFromResponse(ExternalDTO externalDTO)
      throws IOException {

        String requestBodyJson = jacksonObjectMapper.writeValueAsString(externalDTO);

        Response response = given().
          contentType(JSON).
          body(requestBodyJson).
          when().
          put("/put");

        response.then().log().all().statusCode(200);

        String responseBodyJson = response.getBody().prettyPrint();

        HttpBinBody<ExternalDTO> responseBody = jacksonObjectMapper
          .readValue(responseBodyJson, new TypeReference<HttpBinBody<ExternalDTO>>() {});

        return responseBody.getRequestBody();
    }

    private ExternalDTO generateExternalDTO() {
        ArrayList<InternalDTO> internalDTOsList = new ArrayList<>();
        internalDTOsList.add(new InternalDTO().
          setIntName("intNameInList1"));
        internalDTOsList.add(new InternalDTO().
          setIntName("intNameInList2"));

        HashMap<String, InternalDTO> internalDTOsMap = new HashMap<>();

        internalDTOsMap.put("mapsKey1", new InternalDTO().
          setIntName("intNameInMap1"));
        internalDTOsMap.put("mapsKey2", new InternalDTO().
          setIntName("intNameInMap2"));

        return new ExternalDTO().
          setName("NAME").
          setInternalDTO(new InternalDTO().
            setIntName("someField")).
          setAge(15).
          setInternalDTOsList(internalDTOsList).
          setInternalDTOsMap(internalDTOsMap);
    }


    @Test
    public void jacksonOnly() throws IOException {
        Nested nested = new Nested("ID", new Body("NAME", 23));

        ObjectMapper jacksonObjectMapper = new ObjectMapper();

        String requestBodyJson = jacksonObjectMapper.writeValueAsString(nested);

        Response response = given().
          contentType(JSON).
          body(requestBodyJson).
          when().
          put("/put");

        response.then().log().all().statusCode(200);

        String responseBodyJson = response.getBody().prettyPrint();

        HttpBinBody<Nested> responseBody = jacksonObjectMapper
          .readValue(responseBodyJson, new TypeReference<HttpBinBody<Nested>>() {});

        Nested nestedInResponse = responseBody.getRequestBody();

        String requestBodyInResponseBodyJson =
          jacksonObjectMapper.writeValueAsString(nestedInResponse);

        assertSameJson(requestBodyJson, requestBodyInResponseBodyJson, false);
    }

    public static void assertSameJson(String expected, String actual, boolean strictMode){
        try {
            JSONAssert.assertEquals(expected, actual, strictMode);
        } catch (JSONException e) {
            throw new AssertionError(e);
        }
    }

    @Test
    public void jackson_gson_jsonb() throws IOException {
        ObjectMapper jacksonObjectMapper = new ObjectMapper();
        Nested nested = new Nested("ID", new Body("NAME", 23));

        Jsonb jsonb = JsonbBuilder.create();

        String requestBodyJson = jsonb.toJson(nested);

        Response response = given().
          contentType(JSON).
          body(requestBodyJson).
          when().
          put("/put");

        response.then().log().all().statusCode(200);

        String responseBodyJson = response.getBody().prettyPrint();

        HttpBinBody<Nested> responseBody = jacksonObjectMapper
          .readValue(responseBodyJson, new TypeReference<HttpBinBody<Nested>>() {});

        Nested requestBodyInResponse = responseBody.getRequestBody();

        String requestBodyInResponseBodyJson = jsonb.toJson(requestBodyInResponse);

        JsonParser gsonParser = new JsonParser();
        JsonElement requestJsonElement = gsonParser.parse(requestBodyJson);
        JsonElement responseJsonElement = gsonParser.parse(requestBodyInResponseBodyJson);
        assertEquals(responseJsonElement, requestJsonElement);

    }

    @Test
    public void deserializationJsonAssertTest() throws IOException, JSONException {
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

        HttpBinBody<Body> responseBody =
          new ObjectMapper().readValue(responseBodyJson, new TypeReference<HttpBinBody<Body>>() {});
        Body requestBodyInResponse = responseBody.getRequestBody();


        ObjectMapper mapper = new ObjectMapper();

        String requestBodyInString = mapper.writeValueAsString(requestBody);
        String requestBodyInResponseInString = mapper.writeValueAsString(requestBodyInResponse);

        JSONAssert.assertEquals(requestBodyInString, requestBodyInResponseInString, false);

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
          new ObjectMapper().readValue(responseBodyJson, new TypeReference<HttpBinBody<Body>>() {});

        assertEquals(responseBody.getRequestBody(), requestBody);
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
