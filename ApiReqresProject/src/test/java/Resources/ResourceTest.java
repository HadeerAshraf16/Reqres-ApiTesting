package Resources;

import BaseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static EndPoints.Urls.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

public class ResourceTest extends BaseTest {

    @Story("Resource")
    @Description("Single Resource")
    @Test
    public void SingleResourceTest(){


        given()
                .spec(Request)

                .contentType(ContentType.JSON)
                .when()
                .get(SingleResource)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("data" , notNullValue())
                .body("data.id" , notNullValue())
                .body("data.name" , notNullValue())
                .body("data.color" , notNullValue())
                .body("data.year" , notNullValue())
                .body("data.pantone_value" , notNullValue())
                .body("support" , notNullValue())
                .body("support.url" , notNullValue())
                .body("support.text" , notNullValue());

    }
    @Story("Resource")
    @Description("Not Found Single Resource")
    @Test
    public void NotFoundSingleResourceTest(){
        given()
                .spec(Request)
                .contentType(ContentType.JSON)
                .when()
                .get(NotFoundSingleResource)
                .then()
                .log().all()
                .assertThat().statusCode(404);

    }

    @Story("Resource")
    @Description("List Resource")
    @Test
    public void ListResourceTest(){

        given()
                .spec(Request)

                .contentType(ContentType.JSON)
                .when()
                .get(ListResource)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("page" , notNullValue())
                .body("per_page" , notNullValue())
                .body("total" , notNullValue())
                .body("total_pages" , notNullValue())
                .body("data" , notNullValue())
                .body("data" , hasSize(6))
                .body("support" , notNullValue());

    }

}
