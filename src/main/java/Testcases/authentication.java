package Testcases;

import Config.configProperties;
import Config.envGlobals;
import Config.reusableFunctions;
import general.baseTest;
import org.testng.annotations.Test;

public class authentication extends baseTest {

    @Test
    public static void Authorization() {
        reusableFunctions.givenHeaderFormData(reusableFunctions.headers("Authorization", envGlobals
                .basicAccessToken), reusableFunctions.form_data("grant_type", configProperties.grantType,"scope","Admin" ,"username", configProperties.username,
                "password", configProperties.password));
        reusableFunctions.whenFunction("post",  configProperties.authUrl + Config.endpointURLs.oAuth);
        reusableFunctions.thenFunction(200);
        envGlobals.authorizationToken = "bearer " + envGlobals.response.body().path("access_token").toString();


    }
}