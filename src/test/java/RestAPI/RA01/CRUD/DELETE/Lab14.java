//package RestAPI.RA01.CRUD.DELETE;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;
//import org.hamcrest.Matchers;
//import org.testng.annotations.Test;
//
//
//public class Lab14 {
//
//    RequestSpecification requestSpecification = RestAssured.given();
//    Response response;
//    ValidatableResponse vr;
//    String token = "859eeba1e553ebe";
//    String bookingid = "1471";
//
//    String BASE_URL = "https://restful-booker.herokuapp.com";
//    String BASE_PATH = "/booking";
//
//    @Test
//    public void deleteRequestNonBDD(){
//        String BASE_PATH_UPDATED = BASE_PATH +"/"+bookingid;
//        System.out.println(BASE_PATH_UPDATED);
//
//
//        requestSpecification.baseUri(BASE_URL);
//        requestSpecification.basePath(BASE_PATH_UPDATED);
//        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.cookie("token", token);
//        requestSpecification.log().all();
//
//        response = requestSpecification.when().log().all().delete();
//
//        vr = response.then().log().all();
//        vr.statusCode(201);
//
//
//    }
//}
//
