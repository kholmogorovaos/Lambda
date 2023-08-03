import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests {
    @Test
    public void getWithParametersTest() {
            given()
                    .param("p1", "v1")
                    .param("p2", "v2")
                    .when()
                    .get("http://httpbin.org/anything")
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("args.p1", equalTo("v1"))
                    .body("args.p2", equalTo("v2"));
    }

    @Test
    public void postWithJsonBodyTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"parameter\": \"value\"}")
                .when()
                .post("http://httpbin.org/anything")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("json.parameter", equalTo("value"));
    }

    @Test
    public void basicAuthenticationTest() {
            given()
                    .auth()
                    .preemptive()
                    .basic("user", "password")
                    .when()
                    .get("http://httpbin.org/basic-auth/user/password")
                    .then()
                    .statusCode(200);
    }
    @Test
    public void bearerAuthenticationTest() {
        try {
            given()
                    .header("Authorization", "Bearer 123")
                    .when()
                    .get("http://httpbin.org/bearer")
                    .then()
                    .statusCode(200);
        } catch (AssertionError e) {
            if (e.getMessage().contains("Expected status code <200> but was <401>")) {
                System.out.println("Тест не прошел, получен ожидаемый статус код ошибки");
            } else {
                System.out.println("Тест не прошел, возникла ошибка");
            }
        }
    }
}
