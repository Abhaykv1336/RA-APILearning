package RestAPI.RA01.CRUD.GET.BDDStyle;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab07 {

    @Test
    public void getRequestBDDStyle(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/225412")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);
    }
}
