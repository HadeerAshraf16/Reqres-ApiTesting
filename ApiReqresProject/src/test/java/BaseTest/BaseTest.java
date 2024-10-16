package BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import static EndPoints.Urls.baseUrl;

public class BaseTest {
    public Header header = new Header("Accept", "application/json");
        public static RequestSpecification Request;
        @BeforeClass
        public void Spec(){
            Request = new RequestSpecBuilder()
                    .setBaseUri(baseUrl)
                    .build();
        }
    }
