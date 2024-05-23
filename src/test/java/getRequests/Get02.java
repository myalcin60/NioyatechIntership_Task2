package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02 extends CatFactBaseURL {
     /*
    Given User send get reguest with factS endpoint
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"
    And User assert that length is less than or equal to 30

     */

    @Test
    public void get02(){
        //Set the Url
        specification.pathParam("firstPath", "facts");

        //Set the expected data

        //Send the Request

       Response response= given().spec(specification).when().get("{firstPath}");
       response.prettyPrint();

        //Get the response and do assertion
        //Assert that Status Code is "200" && Assert that Content Type is "application/json"
                response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }
}
