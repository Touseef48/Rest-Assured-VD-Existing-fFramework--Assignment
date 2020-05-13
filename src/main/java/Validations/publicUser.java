package Validations;

import Config.envGlobals;
import Config.reusableFunctions;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;

public class publicUser {


    public static void VerifyUser2(String Requestpayload) {

        Assert.assertNotNull(reusableFunctions.getResponsePath("id"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "name"), reusableFunctions.getResponsePath("name"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "job"), reusableFunctions.getResponsePath("job"));



    }

    public static void verifyUpdatedUser(String Requestpayload) {

        Assert.assertEquals(JsonPath.read(Requestpayload, "name"), reusableFunctions.getResponsePath("name"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "job"), reusableFunctions.getResponsePath("job"));



    }

    public static void getUser2List() {

        for (int i = 0; i < envGlobals.pagesize; i++) {

            Assert.assertNotNull(reusableFunctions.getResponsePath("data[" + i + "].id"));
            Assert.assertNotNull(reusableFunctions.getResponsePath("data[" + i + "].email"));
            Assert.assertNotNull(reusableFunctions.getResponsePath("data[" + i + "].first_name"));
        }
    }
}
