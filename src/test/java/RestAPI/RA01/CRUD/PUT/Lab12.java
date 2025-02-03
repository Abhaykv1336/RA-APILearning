//package RestAPI.RA01.CRUD.PUT;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;
//import org.hamcrest.Matchers;
//import org.testng.annotations.Test;
//
//public class Lab12 {
//
//    RequestSpecification rs = RestAssured.given();
//    Response response;
//    ValidatableResponse vr;
//    String token = "4c90d70c695f491";
//    String bookingid = "6351";
//
//    String BASE_URL = "https://restful-booker.herokuapp.com";
//    String BASE_PATH = "/booking";
//
//    @Test
//    public void putRequestNonBDD(){
//        String BASE_PATH_UPDATED = BASE_PATH +"/"+bookingid;
//        System.out.println(BASE_PATH_UPDATED);
//
//        String payload = "{\n" +
//                "    \"firstname\" : \"Abhay\",\n" +
//                "    \"lastname\" : \"Kumar\",\n" +
//                "    \"totalprice\" : 108,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2025-01-26\",\n" +
//                "        \"checkout\" : \"2025-01-27\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
//
//        rs.baseUri(BASE_URL);
//        rs.basePath(BASE_PATH_UPDATED);
//        rs.contentType(ContentType.JSON);
//        rs.cookie("token", token);
//        rs.body(payload).log().all();
//
//        response = rs.when().log().all().put();
//
//        vr = response.then().log().all();
//        vr.statusCode(200);
//        vr.body("firstname", Matchers.equalTo("Abhay"));
//        vr.body("lastname", Matchers.equalTo("Kumar"));
//
//    }
//}
