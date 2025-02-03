package RestAPI.RA01.CRUD.GET.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab08 {

    @Test
    public void getRequestNonBDDStyle(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/225412");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }
}
