import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;


public class StatusTests {

    @Test
    void checkTotalWithResponseLogs() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .body("total", is(20));
    }

    @Test
    void checkTotalWithLogs() {
        given()
                .log().all();
        get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .body("total", is(20));
    }
}
