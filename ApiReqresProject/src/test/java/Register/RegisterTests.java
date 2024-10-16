package Register;
import BaseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import static EndPoints.Urls.successRegister;
import static EndPoints.Urls.unsuccessfulRegister;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterTests extends BaseTest {
@Story("Register")
@Description("Valid Register")
@Test
public void SuccessfulRegisterTest(){
    HashMap<String,Object> RegisterData = new HashMap<>();
    RegisterData.put("email","eve.holt@reqres.in");
    RegisterData.put("password","pistol");
    given()
            .spec(Request)
            .body(RegisterData)
            .contentType(ContentType.JSON)
            .when()
            .post(successRegister)
            .then()
            .log().all()
            .assertThat().statusCode(200)
            .assertThat().contentType(ContentType.JSON)
            .body("token" , notNullValue())
            .body("id" , notNullValue());

}
    @Story("Register")
    @Description("InValid Register")
    @Test
    public void UnSuccessfulRegisterTest() {
        HashMap<String, Object> RegisterData = new HashMap<>();
        RegisterData.put("email", "sydney@fife");

        given()
                .spec(Request)
                .body(RegisterData)
                .contentType(ContentType.JSON)
                .when()
                .post(unsuccessfulRegister)
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .assertThat().contentType(ContentType.JSON)
                .body("error", notNullValue());
    }}

