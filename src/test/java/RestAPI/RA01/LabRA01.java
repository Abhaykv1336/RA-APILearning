package RestAPI.RA01;

import io.restassured.RestAssured;

public class LabRA01 {
    public static void main(String[] args) {
        //Rest Assured Hello World Program
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get().then().statusCode(201);
}}
