package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.response.Response;

import org.apache.log4j.Logger;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import org.apache.log4j.PropertyConfigurator;
import pojoDatas.CatFactDataPojo;

public class Get01_fact extends CatFactBaseURL {
      /*
    Given User send get reguest with fact endpoint
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"

     */

    @Test
    public void get01() {
        CatFactDataPojo dataPojo = new CatFactDataPojo();
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get01_fact.class);

        specification.pathParams("firstPath", "fact");
        logger.info("Go to URL: https://catfact.ninja/fact");


        Response response = given().spec(specification).when().get("{firstPath}");
        response.prettyPrint();
        logger.info("User Sends Request with GET Method");

        response.then().assertThat().statusCode(dataPojo.getStatusCode())
                .contentType(dataPojo.getContentType());
        logger.info("Status Code : 200 and  Content Type is application/json");
    }

}
