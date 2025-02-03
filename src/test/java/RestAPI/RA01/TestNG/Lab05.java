package RestAPI.RA01.TestNG;

import groovyjarjarantlr4.runtime.Token;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.IDN;

public class Lab05 {

//    CRUD
//    Create Booking -->ID
//    Create Auth  --> Token
//    PUT -> ID, Token
//    Delete --> ID
//    GET -> ID -- Verify it should not exist

    String token;
    Integer bookingid;

    public String getToken() {
        token = "123";
        return token;
    }

        @BeforeTest
        public void getTokenAndBookingID(){
        token = getToken();
        bookingid= 123;
        }

    @Test
    public void testPUTReq(){
            System.out.println(token);
            System.out.println(bookingid);
    }
    @Test
    public void testDeleteReq(){
        System.out.println(token);
        System.out.println(bookingid);
    }
    @Test
    public void testGETReq(){
        System.out.println(token);
        System.out.println(bookingid);
    }


}
