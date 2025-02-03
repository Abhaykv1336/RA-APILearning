package RestAPI.RA01.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab09 {
    RequestSpecification r = RestAssured.given();
    @Test
    public void getRequestPositiveTC(){
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/2002").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }
    @Test
    public void getRequestNegativeTC(){
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/-2").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);
    }

}
