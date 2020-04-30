package Testcases;

import Config.configProperties;
import Config.endpointURLs;
import Config.envGlobals;
import Config.reusableFunctions;
import org.testng.annotations.Test;

public class users {


    @Test
    public void createEmailUser() {
        String Requestpayload = payloads.users.create_adminUser("Umair Nasir" + payloads.users.generateRandomNumber(), "umairtesting2+" + payloads.users.generateRandomNumber() + "@gmail.com", "03213895980", "EMAIL");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);
        envGlobals.EmailuserId = reusableFunctions.getResponsePath("data.id");
        envGlobals.emailPrincipleName = reusableFunctions.getResponsePath("data.principalName");

        Validations.users.verifyEmailUserdata(Requestpayload);


    }




    @Test
    public void createUser_with_ExistingEmail() {
        String Requestpayload = payloads.users.create_adminUser("Umair Nasir" + payloads.users.generateRandomNumber(), envGlobals.emailPrincipleName, "+44234234334", "EMAIL");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);


        Validations.users.verifyExistingEmail();


    }

    @Test
    public void createUser_withPhoneNo() {
        String Requestpayload = payloads.users.create_adminUser("Umair Nasir" + payloads.users.generateRandomNumber(), "umairtesting2+" + payloads.users.generateRandomNumber() + "@gmail.com", "032121" + payloads.users.generateRandomNumber(), "MOBILE_NUMBER");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);
        envGlobals.PhoneuserId = reusableFunctions.getResponsePath("data.id");
        envGlobals.PhoneprincipleName = reusableFunctions.getResponsePath("data.principalName");

        Validations.users.verifyMobileUser(Requestpayload);


    }

    @Test
    public void createUser_with_ExistingPhoneNo() {
        String Requestpayload = payloads.users.create_adminUser("Umair Nasir" + payloads.users.generateRandomNumber(), "umairtesting2+" + payloads.users.generateRandomNumber() + "@gmail.com", envGlobals.PhoneprincipleName, "MOBILE_NUMBER");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);


        Validations.users.verifyExistingPhone();
    }
    @Test
    public void UpdateEmail_user() {
        String Requestpayload = payloads.users.update_adminUser(envGlobals.EmailuserId,"Umair Nasir" + payloads.users.generateRandomNumber(), "umairtesting2+" + payloads.users.generateRandomNumber() + "@gmail.com");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("put", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.updateUser);
        reusableFunctions.thenFunction(200);
        Validations.users.verifyEmailUserdata(Requestpayload);

    }

    @Test
    public void UpdatePhone_user() {
        String Requestpayload = payloads.users.update_adminUser(envGlobals.PhoneuserId,"Umair Nasir" + payloads.users.generateRandomNumber(), "umairtesting2+" + payloads.users.generateRandomNumber() + "@gmail.com");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("put", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.updateUser);
        reusableFunctions.thenFunction(200);
        Validations.users.verifyEmailUserdata(Requestpayload);

    }
}