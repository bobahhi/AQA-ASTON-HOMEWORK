package CollectionPostmanEcho;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class TestPostmanEcho {
    private static final String BASE_URI = "https://postman-echo.com";
    private static final String TEST_BODY = "This is expected to be sent back as part of response body.";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.config = RestAssured.config().encoderConfig(
                EncoderConfig.encoderConfig().defaultContentCharset("UTF-8"));
    }

    //Get Request Woops
    @Test
    void testGetRequest1() {
        given()
                .baseUri(BASE_URI)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    //Get Request
    @Test
    void testGetRequest2() {
        given()
                .baseUri(BASE_URI)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    //Post Raw Text
    @Test
    void testPostRawText() {
        String body = TEST_BODY;
        given()
                .baseUri(BASE_URI)
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    //Post Form Data
    @Test
    void testPostFormData() {
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.TEXT)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(""))
                .body("files.size()", equalTo(0))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    //Put Request
    @Test
    void testPutRequest() {
        String body = TEST_BODY;
        given()
                .baseUri(BASE_URI)
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    //Patch Request
    @Test
    void testPatchRequest() {
        String body = TEST_BODY;
        given()
                .baseUri(BASE_URI)
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    //Delete Request
    @Test
    void testDeleteRequest() {
        String body = TEST_BODY;
        given()
                .baseUri(BASE_URI)
                .body(body)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/delete"));
    }


}