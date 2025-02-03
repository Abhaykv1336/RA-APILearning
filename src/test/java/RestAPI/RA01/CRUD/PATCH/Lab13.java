//package RestAPI.RA01.CRUD.PATCH;
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
//
//    public class Lab13 {
//
//        RequestSpecification requestSpecification = RestAssured.given();
//        Response response;
//        ValidatableResponse vr;
//        String token = "4c90d70c695f491";
//        String bookingid = "6351";
//
//        String BASE_URL = "https://restful-booker.herokuapp.com";
//        String BASE_PATH = "/booking";
//
//        @Test
//        public void patchRequestNonBDD(){
//            String BASE_PATH_UPDATED = BASE_PATH +"/"+bookingid;
//            System.out.println(BASE_PATH_UPDATED);
//
//            String payload = "{\n" +
//                    "    \"firstname\" : \"Ashish\",\n" +
//                    "    \"lastname\" : \"Brown\"\n" +
//                    "}";
//
//            requestSpecification.baseUri(BASE_URL);
//            requestSpecification.basePath(BASE_PATH_UPDATED);
//            requestSpecification.contentType(ContentType.JSON);
//            requestSpecification.cookie("token", token);
//            requestSpecification.body(payload).log().all();
//
//            response = requestSpecification.when().log().all().patch();
//
//            vr = response.then().log().all();
//            vr.statusCode(200);
//            vr.body("firstname", Matchers.equalTo("Ashish"));
//            vr.body("lastname", Matchers.equalTo("Brown"));
//
//        }
//    }
//
