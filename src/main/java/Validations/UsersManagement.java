package Validations;

import Config.EnvGlobals;
import com.jayway.jsonpath.JsonPath;
import com.venturedive.base.utility.ReusableFunctions;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

public class UsersManagement {


    public static void verifyEmailUserdata(String Requestpayload) {

        Assert.assertNotNull(ReusableFunctions.getResponsePath("data.id"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "fullName"), ReusableFunctions.getResponsePath("data.fullName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "email"), ReusableFunctions.getResponsePath("data.email"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "mobileNumber"), ReusableFunctions.getResponsePath("data.mobileNumber"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "email"), ReusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "accountType"), ReusableFunctions.getResponsePath("data.accountType"));


    }


    public static void verifyExistingEmail() {

        Assert.assertEquals(ReusableFunctions.getResponsePath("message"), "A user already exists with user name " + EnvGlobals.emailPrincipleName);


    }

    public static void verifyExistingPhone() {

        Assert.assertEquals(ReusableFunctions.getResponsePath("message"), "A user already exists with user name " + EnvGlobals.PhoneprincipleName);


    }

    public static void verifyMobileUser(String Requestpayload) {

        Assert.assertNotNull(ReusableFunctions.getResponsePath("data.id"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "fullName"), ReusableFunctions.getResponsePath("data.fullName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "email"), ReusableFunctions.getResponsePath("data.email"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "mobileNumber"), ReusableFunctions.getResponsePath("data.mobileNumber"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "mobileNumber"), ReusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "accountType"), ReusableFunctions.getResponsePath("data.accountType"));


    }

    public static void VerifyGetUsersBYinvaliddetails() {

        Assert.assertEquals(ReusableFunctions.getResponsePath("statusCode"), "0");

    }



    public static void getUserList() {

        for (int i = 0; i < EnvGlobals.pagesize; i++) {

            Assert.assertNotNull(ReusableFunctions.getResponsePath("data[" + i + "].id"));
            Assert.assertNotNull(ReusableFunctions.getResponsePath("data[" + i + "].principalName"));
            Assert.assertNotNull(ReusableFunctions.getResponsePath("data[" + i + "].accountType"));
        }
    }



        public static void VerifyPhoneuserinList() {

            int i = EnvGlobals.pagesize - 1 ;

                Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.fullName"), ReusableFunctions.getResponsePath("data[" + i + "].fullName"));
                Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.email"), ReusableFunctions.getResponsePath("data[" + i + "].email"));
                Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.mobileNumber"), ReusableFunctions.getResponsePath("data[" + i + "].mobileNumber"));
                Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.principalName"), ReusableFunctions.getResponsePath("data[" + i + "].principalName"));
                Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.accountType"), ReusableFunctions.getResponsePath("data[" + i + "].accountType"));
            }




    public static void veriyEmailUserinList() {

        int i = EnvGlobals.pagesize - 2 ;

        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse,"data.fullName" ), ReusableFunctions.getResponsePath("data[" + i + "].fullName"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.email"), ReusableFunctions.getResponsePath("data[" + i + "].email"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.mobileNumber"), ReusableFunctions.getResponsePath("data[" + i + "].mobileNumber"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.principalName"), ReusableFunctions.getResponsePath("data[" + i + "].principalName"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.accountType"), ReusableFunctions.getResponsePath("data[" + i + "].accountType"));
        }


    public static void verifygetPhoneUser() {

        Assert.assertNotNull(ReusableFunctions.getResponsePath("data.id"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.fullName"), ReusableFunctions.getResponsePath("data.fullName"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.email"), ReusableFunctions.getResponsePath("data.email"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.mobileNumber"), ReusableFunctions.getResponsePath("data.mobileNumber"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.principalName"), ReusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updatephoneuserResponse, "data.accountType"), ReusableFunctions.getResponsePath("data.accountType"));

    //    reusableFunctions.thenObjectmatch("content.projectType", "PROJECT");

    }


    public static void verifygetEmailUser() {

        Assert.assertNotNull(ReusableFunctions.getResponsePath("data.id"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.fullName"), ReusableFunctions.getResponsePath("data.fullName"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.email"), ReusableFunctions.getResponsePath("data.email"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.mobileNumber"), ReusableFunctions.getResponsePath("data.mobileNumber"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.principalName"), ReusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(EnvGlobals.updateEmailuserResponse, "data.accountType"), ReusableFunctions.getResponsePath("data.accountType"));
    }

    public static void verifyUSerRoles() {

        Assert.assertEquals(ReusableFunctions.getResponsePath("data[0]"), "ADMIN");
        Assert.assertEquals(ReusableFunctions.getResponsePath("data[1]"), "CUSTOMER");


    }

}