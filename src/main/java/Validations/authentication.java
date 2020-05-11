package Validations;

import Config.envGlobals;
import Config.reusableFunctions;
import org.testng.Assert;

public class authentication {


    public static void VerifyAuthorisation() {


        Assert.assertNotNull(reusableFunctions.getResponsePath("access_token"));
        Assert.assertEquals(reusableFunctions.getResponsePath("token_type"), "bearer");
        Assert.assertNotNull(reusableFunctions.getResponsePath("refresh_token"));
        Assert.assertEquals(reusableFunctions.getResponsePath("scope"), "Admin");
        Assert.assertNotNull(reusableFunctions.getResponsePath("jti"));




        }


    public static void VerifyinvalidAuthorisation() {


        Assert.assertEquals(reusableFunctions.getResponsePath("error"), "invalid_grant");
        Assert.assertEquals(reusableFunctions.getResponsePath("error_description"), "Bad credentials");




    }

    public static void VerifyAuthorisationFor_App() {


        Assert.assertNotNull(reusableFunctions.getResponsePath("access_token"));
        Assert.assertEquals(reusableFunctions.getResponsePath("token_type"), "bearer");
        Assert.assertEquals(reusableFunctions.getResponsePath("scope"), "any");
        Assert.assertEquals(reusableFunctions.getResponsePath("user_name"), "mobile-app");
        Assert.assertEquals(reusableFunctions.getResponsePath("authorities[0]"), "ROLE_mobile-app");
        Assert.assertNotNull(reusableFunctions.getResponsePath("jti"));




    }

}
