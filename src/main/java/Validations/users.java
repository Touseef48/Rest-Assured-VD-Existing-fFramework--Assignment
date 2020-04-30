package Validations;

import Config.envGlobals;
import Config.reusableFunctions;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;

public class users {


    public static void verifyEmailUserdata(String Requestpayload) {

        Assert.assertNotNull(reusableFunctions.getResponsePath("data.id"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "fullName"), reusableFunctions.getResponsePath("data.fullName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "email"), reusableFunctions.getResponsePath("data.email"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "mobileNumber"), reusableFunctions.getResponsePath("data.mobileNumber"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "email"), reusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "accountType"), reusableFunctions.getResponsePath("data.accountType"));


    }


    public static void verifyExistingEmail() {

        Assert.assertEquals(reusableFunctions.getResponsePath("message"), "A user already exists with user name " + envGlobals.emailPrincipleName);


    }

    public static void verifyExistingPhone() {

        Assert.assertEquals(reusableFunctions.getResponsePath("message"), "A user already exists with user name " + envGlobals.PhoneprincipleName);


    }

    public static void verifyMobileUser(String Requestpayload) {

        Assert.assertNotNull(reusableFunctions.getResponsePath("data.id"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "fullName"), reusableFunctions.getResponsePath("data.fullName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "email"), reusableFunctions.getResponsePath("data.email"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "mobileNumber"), reusableFunctions.getResponsePath("data.mobileNumber"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "mobileNumber"), reusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "accountType"), reusableFunctions.getResponsePath("data.accountType"));


    }

    public static void VerifyGetUsersBYinvaliddetails() {

        Assert.assertEquals(reusableFunctions.getResponsePath("statusCode"), "0");

    }

//    public static void getUserList() {
//
//        for (int i = 0; i < envGlobals.pagesize; i++) {
//
//            Assert.assertNotNull(reusableFunctions.getResponsePath("content[" + i + "].id"));
//        }
//
//    }

}