package validations;

import com.venturedive.base.utility.ReusableFunctions;
import org.testng.Assert;

public class Authentication {


    public static void VerifyAuthorisation() {


        Assert.assertNotNull(ReusableFunctions.getResponsePath("access_token"));
        Assert.assertEquals(ReusableFunctions.getResponsePath("token_type"), "bearer");
        Assert.assertNotNull(ReusableFunctions.getResponsePath("refresh_token"));
        Assert.assertEquals(ReusableFunctions.getResponsePath("scope"), "Admin");
        Assert.assertNotNull(ReusableFunctions.getResponsePath("jti"));




        }


    public static void VerifyinvalidAuthorisation() {


        Assert.assertEquals(ReusableFunctions.getResponsePath("error"), "invalid_grant");
        Assert.assertEquals(ReusableFunctions.getResponsePath("error_description"), "Bad credentials");




    }

    public static void VerifyAuthorisationFor_App() {


        Assert.assertNotNull(ReusableFunctions.getResponsePath("access_token"));
        Assert.assertEquals(ReusableFunctions.getResponsePath("token_type"), "bearer");
        Assert.assertEquals(ReusableFunctions.getResponsePath("scope"), "any");
        Assert.assertEquals(ReusableFunctions.getResponsePath("user_name"), "mobile-app");
        Assert.assertEquals(ReusableFunctions.getResponsePath("authorities[0]"), "ROLE_mobile-app");
        Assert.assertNotNull(ReusableFunctions.getResponsePath("jti"));




    }

}
