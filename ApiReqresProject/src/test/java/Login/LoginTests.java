package Login;

import BaseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static EndPoints.Urls.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class LoginTests extends BaseTest {



    @Story("Login")
    @Description("Valid Login")
    @Test
    public void ValidLoginTest() {
        HashMap<String, Object> LoginData = new HashMap<>();
        LoginData.put("email", "eve.holt@reqres.in");
        LoginData.put("password", "cityslicka");

        given()
                .spec(Request)
                .body(LoginData)
                .contentType(ContentType.JSON)
                .header(header)
                .when()
                .post(ValidLogin)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("token", notNullValue());

    }

    @Story("Login")
    @Description("InValid Login")
    @Test
    public void InValidLoginTest() {
        HashMap<String, Object> LoginData = new HashMap<>();
        LoginData.put("email", "peter@klaven");
        given()
                .spec(Request)
                .body(LoginData)
                .contentType(ContentType.JSON)
                .header(header)
                .when()
                .post(InValidLogin)
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .assertThat().contentType(ContentType.JSON)
                .body("error", notNullValue());

    }
    }
