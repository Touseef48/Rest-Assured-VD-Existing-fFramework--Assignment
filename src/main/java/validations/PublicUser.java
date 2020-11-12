package validations;

import config.EnvGlobals;
import com.jayway.jsonpath.JsonPath;
import com.venturedive.base.utility.ReusableFunctions;
import org.junit.Assert;

public class PublicUser {


    public static void VerifyUser2(String Requestpayload) {

        Assert.assertNotNull(ReusableFunctions.getResponsePath("id"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "name"), ReusableFunctions.getResponsePath("name"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "job"), ReusableFunctions.getResponsePath("job"));



    }

    public static void verifyUpdatedUser(String Requestpayload) {

        Assert.assertEquals(JsonPath.read(Requestpayload, "name"), ReusableFunctions.getResponsePath("name"));
        Assert.assertEquals(JsonPath.read(Requestpayload, "job"), ReusableFunctions.getResponsePath("job"));



    }

    public static void getUser2List() {

        for (int i = 0; i < EnvGlobals.pagesize; i++) {

            Assert.assertNotNull(ReusableFunctions.getResponsePath("data[" + i + "].id"));
            Assert.assertNotNull(ReusableFunctions.getResponsePath("data[" + i + "].email"));
            Assert.assertNotNull(ReusableFunctions.getResponsePath("data[" + i + "].first_name"));
        }
    }
}
