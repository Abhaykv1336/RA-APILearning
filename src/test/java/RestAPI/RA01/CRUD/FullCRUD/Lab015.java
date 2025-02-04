package RestAPI.RA01.CRUD.FullCRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab015 {

    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void getAToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        //Extract token from this
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
    }

        @BeforeTest
        public void getABookingId(){
        String payload = "{\n" +
                "    \"firstname\" : \"Abhay\",\n" +
                "    \"lastname\" : \"Kumar\",\n" +
                "    \"totalprice\" : 108,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-26\",\n" +
                "        \"checkout\" : \"2025-01-27\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(payload);

            response = requestSpecification.when().post();

            ValidatableResponse validatableResponse = response.then();
            String responseString = response.asString();
            System.out.println(responseString);

            validatableResponse.statusCode(200);

            //Extract token from this
            bookingId = response.then().log().all().extract().path("bookingid");
            String firstName = response.then().log().all().extract().path("booking.firstname");
            System.out.println(firstName);
            System.out.println(bookingId);
            Assert.assertNotNull(bookingId);


        }

        @Test
    public void testPutRequestPositive(){
        //token and bookingId
            System.out.println("Test put request");

            String payload = "{\n" +
                    "    \"firstname\" : \"Ashish\",\n" +
                    "    \"lastname\" : \"Brown\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";
            requestSpecification.basePath("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("/booking/"+bookingId);
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.cookie("token", token);

            //PUT request
            requestSpecification.body(payload).log().all();

            response = requestSpecification.when().put();

            validatableResponse= response.then().log().all();
            validatableResponse.statusCode(200);

            String firstNameResponse = response.then().log().all().extract().path("firstname");
            Assert.assertEquals(firstNameResponse, "Ashish");

            String fullResponsezjsONString = response.asString();
            System.out.println(fullResponsezjsONString);

            //Verify all the keys and value pairs in the response
            //firstname, lastname, deposite, total, checkin...

            //3 ways you can verify the response:

            // 1. RA Matcher
            validatableResponse.body("firstname", Matchers.equalTo("Ashish")) ;
            validatableResponse.body("lastname", Matchers.equalTo("Brown")) ;

            // 2. TestNG Asserts-assert.Equals
            firstNameResponse = response.then().log().all().extract().path("firstname");
            Assert.assertEquals(firstNameResponse, "Ashish");

            // 2.1: TestNG Assertion with JSON Path lib
            JsonPath jsonPath = new JsonPath(fullResponsezjsONString);
            String firstNameJSONPathExtracted = jsonPath.getString("firstname");
            String lastNameJSONPathExtracted = jsonPath.getString("lastname");
            Integer totalPriceJSONPathExtracted = jsonPath.getInt("totalprice");
            String checkinDate = jsonPath.getString("bookingdates.checkin");

            Assert.assertEquals(firstNameResponse, "Ashish");
            Assert.assertEquals(lastNameJSONPathExtracted, "Brown");
            Assert.assertEquals(totalPriceJSONPathExtracted, 111);
            Assert.assertEquals(checkinDate, "2018-01-01");


            // 3. AssertJ Matching

    }
}
