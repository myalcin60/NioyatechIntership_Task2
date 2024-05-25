package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import pojoDatas.CatFactDataPojo;

import static io.restassured.RestAssured.given;

public class Get03_facts extends CatFactBaseURL {
     /*
    Given User send get reguest with factS endpoint
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"
     */

    @Test
    public void get03() {

        CatFactDataPojo dataPojo = new CatFactDataPojo(200, "application/json" );
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get03_facts.class);
        specification.pathParam("firstPath", "facts");
        logger.info("Go to URL: https://catfact.ninja/facts");


        Response response = given().spec(specification).when().get("{firstPath}");
        response.prettyPrint();
        logger.info("User Sends Request with GET Method");

        response.then().assertThat().statusCode(dataPojo.getStatusCode())
                .contentType(dataPojo.getContentType());
        logger.info("Status Code : 200 and  Content Type is application/json");
    }
}
