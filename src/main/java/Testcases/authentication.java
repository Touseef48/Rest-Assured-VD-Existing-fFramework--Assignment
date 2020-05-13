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
                .basicAccessToken), reusableFunctions.form_data("grant_type", configProperties.grantType, "scope", "Admin", "username", configProperties.username,
                "password", configProperties.password));
        reusableFunctions.whenFunction("post", configProperties.authUrl + Config.endpointURLs.oAuth);
        reusableFunctions.thenFunction(200);
        envGlobals.authorizationToken = "bearer " + envGlobals.response.body().path("access_token").toString();

        Validations.authentication.VerifyAuthorisation();


    }
    @Test
    public static void publicAuth() {

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers(), payloads.publicUser.publicUserLogin());
        reusableFunctions.whenFunction("post", configProperties.publicUserLogin);
        reusableFunctions.thenFunction(200);


    }

    @Test
    public static void Authorization_with_PhoneNo() {

        reusableFunctions.givenHeaderFormData(reusableFunctions.headers("Authorization", envGlobals
                .basicAccessToken), reusableFunctions.form_data("grant_type", configProperties.grantType, "scope", "Admin", "username", configProperties.userPhoneNo,
                "password", configProperties.password));
        reusableFunctions.whenFunction("post", configProperties.authUrl + Config.endpointURLs.oAuth);
        reusableFunctions.thenFunction(200);
        Validations.authentication.VerifyAuthorisation();


    }


    @Test
    public static void Authorization_with_invalidEmail() {

        reusableFunctions.givenHeaderFormData(reusableFunctions.headers("Authorization", envGlobals
                .basicAccessToken), reusableFunctions.form_data("grant_type", configProperties.grantType, "scope", "Admin", "username", "umairtesting@gmail.com",
                "password", configProperties.password));
        reusableFunctions.whenFunction("post", configProperties.authUrl + Config.endpointURLs.oAuth);
        reusableFunctions.thenFunction(400);
        Validations.authentication.VerifyinvalidAuthorisation();
    }

    @Test
    public static void Authorization_with_invalidPhoneNo() {

        reusableFunctions.givenHeaderFormData(reusableFunctions.headers("Authorization", envGlobals
                .basicAccessToken), reusableFunctions.form_data("grant_type", configProperties.grantType, "scope", "Admin", "username", "+923213895980",
                "password", configProperties.password));
        reusableFunctions.whenFunction("post", configProperties.authUrl + Config.endpointURLs.oAuth);
        reusableFunctions.thenFunction(400);
        Validations.authentication.VerifyinvalidAuthorisation();


    }

    @Test
    public static void Authorization_with_gratType_ClientCreds() {
        reusableFunctions.givenHeaderFormData(reusableFunctions.headers("Authorization", envGlobals.appbasicToken),
                reusableFunctions.form_data("grant_type", "client_credentials", "scope", "any", "username", configProperties.username,
                "password", configProperties.password));
        reusableFunctions.whenFunction("post", configProperties.authUrl + Config.endpointURLs.oAuth);
        reusableFunctions.thenFunction(200);

        Validations.authentication.VerifyAuthorisationFor_App();
    }

}