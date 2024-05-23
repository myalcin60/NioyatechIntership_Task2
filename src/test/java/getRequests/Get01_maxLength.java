package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.CatFactDataPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get01_maxLength extends CatFactBaseURL {
    /*
    Given User send get reguest with fact endpoint and query param max_length=30
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"
    And User assert that length is less than or equal to 30

     */


    @Test
    public  void get01(){
        CatFactDataPojo catFactPojo = new CatFactDataPojo();

//Set the Url
//    ''https://catfact.ninja/fact?max_length=30
        specification.pathParams("firstPath","fact").
                queryParams("max_length",catFactPojo.getLength());

//    User Sends Request with GET Method

       Response response= given().spec(specification).when().get("{firstPath}");
       response.prettyPrint();

        //    Assert that Status Code is "200"
        //    Assert that Content Type is "application/json"
        response.then().assertThat().statusCode(200)
                .contentType("application/json");

        // Assert that lenght <= 30
        HashMap<String, Object> actualData =response.as(HashMap.class);
        int length = (int) actualData.get("length");
        assertTrue ( length <= catFactPojo.getLength() );



    }

}
