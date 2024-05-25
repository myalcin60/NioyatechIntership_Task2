package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import pojoDatas.CatFactDataPojo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.lessThan;


public class Get04_maxLength_limit extends CatFactBaseURL {
     /*
    Given User send get reguest with factS endpoint
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"
    And User assert that data.length is less than or equal to 40
    And User assert that data size is equal to limit

     */

    @Test
    public void get04() {
        CatFactDataPojo dataPojo = new CatFactDataPojo(200, "application/json",40,4 );

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get04_maxLength_limit.class);

        specification.pathParam("firstPath", "facts")
                .queryParams("max_length", dataPojo.getLength(), "limit", dataPojo.getLimite());
        logger.info("Go to URL: https://catfact.ninja/facts?max_length=40&limit=2");

        Response response = given().spec(specification).when().get("{firstPath}");
        response.prettyPrint();
        logger.info("User Sends Request with GET Method");

        response.then().assertThat()
                .statusCode(dataPojo.getStatusCode())
                .contentType(dataPojo.getContentType())
                .body("data.size()", equalTo(dataPojo.getLimite()),
                        "data.length", everyItem(lessThan(dataPojo.getLength())));
        logger.info("Status Code : 200 and  \n" +
                "Content Type is application/json \n" +
                "data.length is less than or equal to 40 \n" +
                "data size is equal to limit");
    }
}
