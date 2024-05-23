package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Get01 extends CatFactBaseURL {
      /*
    Given User send get reguest with fact endpoint
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"

     */

    @Test
    public  void get01(){

//Set the Url
//    'https://catfact.ninja/fact
        specification.pathParams("firstPath","fact");

//    User Sends Request with GET Method
       Response response= given().spec(specification).when().get("{firstPath}");
       response.prettyPrint();
        //    Assert that Status Code is "200"
        //    Assert that Content Type is "application/json"
        response.then().assertThat().statusCode(200).contentType("application/json");
    }

}
