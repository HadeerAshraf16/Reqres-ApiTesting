package Users;

import BaseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import static EndPoints.Urls.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

public class UserTests extends BaseTest {
    @Description("CreateUser")
    @Story("User")
@Test
    public void CreateUser(){

    HashMap<String,String> UserData = new HashMap<>();
    UserData.put("name","Ahmed");
    UserData.put("age","25");
    UserData.put("job","Tester");
    given()
            .spec(Request)
            .body(UserData)
            .contentType(ContentType.JSON)
            .when()
            .post(createUser)
            .then()
            .log().all()
            .assertThat().statusCode(201)
            .assertThat().contentType(ContentType.JSON)
            .body("name" , notNullValue())
            .body("job" , notNullValue())
            .body("id" , notNullValue())
            .body("age" , notNullValue())
            .body("createdAt" , notNullValue());

}
    @Description("Update User")
    @Story("User")
    @Test
    public void PutUpdateUser(){

        HashMap<String,String> UserData = new HashMap<>();
        UserData.put("name","morpheus");
        UserData.put("job","zion resident");
        given()
                .spec(Request)
                .body(UserData)
                .contentType(ContentType.JSON)
                .when()
                .put(PutRequest)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("name" , notNullValue())
                .body("job" , notNullValue())
                .body("updatedAt" , notNullValue());
    }
    @Description("Update User Patch")
    @Story("User")
    @Test
    public void PatchRequestUser(){

        HashMap<String,String> PatchData = new HashMap<>();
       PatchData.put("name","morpheus");
        PatchData.put("job","zion resident");
        given()
                .spec(Request)
                .body(PatchData)
                .contentType(ContentType.JSON)
                .when()
                .patch(PatchRequest)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("name" , notNullValue())
                .body("job" , notNullValue())
                .body("updatedAt" , notNullValue());


    }
    @Description(" Delete User")
    @Story("User")
    @Test
    public void DeleteUser(){

        given()
                .spec(Request)
                .contentType(ContentType.JSON)
                .when()
                .delete(DeleteRequest)
                .then()
                .log().all()
                .assertThat().statusCode(204);

    }
    @Description("SingleUser")
    @Story("User")
@Test
public void GetSingleUser(){

    given()
            .spec(Request)
            .contentType(ContentType.JSON)
            .header(header)
            .when()
            .get(GetSingleUser)
            .then()
            .log().all()
            .assertThat().statusCode(200)
            .body("data" , notNullValue())
            .body("data.id" , notNullValue())
            .body("data.email" , notNullValue())
            .body("data.first_name" , notNullValue())
            .body("data.last_name" , notNullValue())
            .body("data.avatar" , notNullValue())
            .body("support" , notNullValue())
            .body("support.url" , notNullValue())
            .body("support.text" , notNullValue());

}

    @Description("ListUsers")
    @Story("User")
@Test
public void GetListUsers(){

    given()
            .spec(Request)
            .contentType(ContentType.JSON)
            .header(header)
            .when()
            .get(GetListUsers)
            .then()
            .log().all()
            .assertThat().statusCode(200)
            .body("page" , notNullValue())
            .body("per_page" , notNullValue())
            .body("total" , notNullValue())
            .body("total_pages" , notNullValue())
            .body("data" , notNullValue())
            .body("data" , hasSize(6))
            .body("support" , notNullValue());

}
    @Story("User")
    @Description("NotFoundSingleUser")
@Test
    public void GetNotFoundSingleUser(){

        given()
                .spec(Request)
                .contentType(ContentType.JSON)
                .header(header)
                .when()
                .get(NotFoundSingleUser)
                .then()
                .log().all()
                .assertThat().statusCode(404);


    }

    @Description("Delay  Response")
    @Story("User")
    @Test
    public void DelayResponse(){

        given()
                .spec(Request)
                .contentType(ContentType.JSON)
                .header(header)
                .when()
                .get(DelayResponse)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("page" , notNullValue())
                .body("per_page" , notNullValue())
                .body("total" , notNullValue())
                .body("total_pages" , notNullValue())
                .body("data" , notNullValue())
                .body("data" , hasSize(6))
                .body("support" , notNullValue());

    }

}
