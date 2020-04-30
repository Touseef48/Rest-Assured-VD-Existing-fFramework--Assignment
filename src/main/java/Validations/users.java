package Validations;

import Config.reusableFunctions;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;

public class users {



    public static void verifyAdminUserdata(String Requestpayload) {

        Assert.assertNotNull(reusableFunctions.getResponsePath("data.id"));
        Assert.assertEquals(JsonPath.read(Requestpayload,"fullName"),reusableFunctions.getResponsePath("data.fullName"));
        Assert.assertEquals(JsonPath.read(Requestpayload,"email"),reusableFunctions.getResponsePath("data.email"));
        Assert.assertEquals(JsonPath.read(Requestpayload,"mobileNumber"),reusableFunctions.getResponsePath("data.mobileNumber"));
        Assert.assertEquals(JsonPath.read(Requestpayload,"email"),reusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(Requestpayload,"email"),reusableFunctions.getResponsePath("data.principalName"));
        Assert.assertEquals(JsonPath.read(Requestpayload,"accountType"),reusableFunctions.getResponsePath("data.accountType"));


    }






}
