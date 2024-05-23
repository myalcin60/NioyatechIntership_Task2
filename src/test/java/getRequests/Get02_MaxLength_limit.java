package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.CatFactDataPojo;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.AssertJUnit.assertTrue;

public class Get02_MaxLength_limit extends CatFactBaseURL {
     /*
    Given User send get reguest with factS endpoint
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"
    And User assert that data.length is less than or equal to 40
    And User assert that data size is equal to limit

     */

    @Test
    public void get02(){
        CatFactDataPojo dataPojo = new CatFactDataPojo();
        //Set the Url
        // https://catfact.ninja/facts?max_length=40&limit=2
        specification.pathParam("firstPath", "facts")
                .queryParams("max_length",dataPojo.getLength(),"limit",dataPojo.getLimite());


        //Send the Request

       Response response= given().spec(specification).when().get("{firstPath}");
       response.prettyPrint();

        //Get the response and do assertion
        //Assert that Status Code is "200" && Assert that Content Type is "application/json"
        // Assert that data.length is less than or equal to 40
        //Assert that data size is equal to limit
                response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON)
                        .body("data.size()",equalTo(dataPojo.getLimite()),
                                "data.length", everyItem(lessThan(dataPojo.getLength())));

    }
}
