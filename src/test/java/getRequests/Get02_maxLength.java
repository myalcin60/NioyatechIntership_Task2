package getRequests;

import baseURL.CatFactBaseURL;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import pojoDatas.CatFactDataPojo;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;

public class Get02_maxLength extends CatFactBaseURL {
    /*
    Given User send get reguest with fact endpoint and query param max_length=30
    Then  User assert that statusCode is 200
    And  User assert that Content type is "application/json"
    And User assert that length is less than or equal to 30

     */


    @Test
    public  void get02(){
        CatFactDataPojo dataPojo = new CatFactDataPojo(200, "application/json",30 );

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(Get02_maxLength.class);


        specification.pathParams("firstPath","fact").
                queryParams("max_length",dataPojo.getLength());
        logger.info("Go to URL: https://catfact.ninja/fact?max_length=30");

       Response response= given().spec(specification).when().get("{firstPath}");
       response.prettyPrint();
        logger.info("User Sends Request with GET Method");


        response.then().assertThat().statusCode(dataPojo.getStatusCode())
                .contentType(dataPojo.getContentType());
        logger.info("Status Code : 200 and  Content Type is application/json");

        HashMap<String, Object> actualData =response.as(HashMap.class);
        int length = (int) actualData.get("length");
        assertTrue ( length <= dataPojo.getLength() );

        logger.info("Assert that lenght <= 30");
    }

}
