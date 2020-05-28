package Testcases;

import Config.ConfigProperties;
import Config.EndpointURLs;
import Config.EnvGlobals;
import Config.ReusableFunctions;
import general.BaseTest;
import org.testng.annotations.Test;
import payloads.PublicUser;

public class Authentication extends BaseTest {



    @Test
    public static void adminAuthorization() {
        ReusableFunctions.givenHeaderFormData(ReusableFunctions.headers("Authorization", EnvGlobals
                .basicAccessToken), ReusableFunctions.form_data("grant_type", ConfigProperties.grantType, "scope", "Admin", "username", ConfigProperties.username,
                "password", ConfigProperties.password));
        ReusableFunctions.whenFunction("post", ConfigProperties.authUrl + EndpointURLs.oAuth);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.authorizationToken = "bearer " + EnvGlobals.response.body().path("access_token").toString();

        Validations.Authentication.VerifyAuthorisation();
    }


    @Test
    public static void publicAuth() {

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), PublicUser.publicUserLogin());
        ReusableFunctions.whenFunction("post", ConfigProperties.publicUserLogin);
        ReusableFunctions.thenFunction(200);


    }

    @Test
    public static void authorization_With_PhoneNo() {

        ReusableFunctions.givenHeaderFormData(ReusableFunctions.headers("Authorization", EnvGlobals
                .basicAccessToken), ReusableFunctions.form_data("grant_type", ConfigProperties.grantType, "scope", "Admin", "username", ConfigProperties.userPhoneNo,
                "password", ConfigProperties.password));
        ReusableFunctions.whenFunction("post", ConfigProperties.authUrl + EndpointURLs.oAuth);
        ReusableFunctions.thenFunction(200);
        Validations.Authentication.VerifyAuthorisation();


    }


    @Test
    public static void authorization_With_InvalidEmail() {

        ReusableFunctions.givenHeaderFormData(ReusableFunctions.headers("Authorization", EnvGlobals
                .basicAccessToken), ReusableFunctions.form_data("grant_type", ConfigProperties.grantType, "scope", "Admin", "username", "umairtesting@gmail.com",
                "password", ConfigProperties.password));
        ReusableFunctions.whenFunction("post", ConfigProperties.authUrl + EndpointURLs.oAuth);
        ReusableFunctions.thenFunction(400);
        Validations.Authentication.VerifyinvalidAuthorisation();
    }

    @Test
    public static void authorization_With_InvalidPhoneNo() {

        ReusableFunctions.givenHeaderFormData(ReusableFunctions.headers("Authorization", EnvGlobals
                .basicAccessToken), ReusableFunctions.form_data("grant_type", ConfigProperties.grantType, "scope", "Admin", "username", "+923213895980",
                "password", ConfigProperties.password));
        ReusableFunctions.whenFunction("post", ConfigProperties.authUrl + EndpointURLs.oAuth);
        ReusableFunctions.thenFunction(400);
        Validations.Authentication.VerifyinvalidAuthorisation();


    }

    @Test
    public static void authorization_With_GrantType_ClientCreds() {
        ReusableFunctions.givenHeaderFormData(ReusableFunctions.headers("Authorization", EnvGlobals.appbasicToken),
                ReusableFunctions.form_data("grant_type", "client_credentials", "scope", "any", "username", ConfigProperties.username,
                "password", ConfigProperties.password));
        ReusableFunctions.whenFunction("post", ConfigProperties.authUrl + EndpointURLs.oAuth);
        ReusableFunctions.thenFunction(200);

        Validations.Authentication.VerifyAuthorisationFor_App();
    }

}