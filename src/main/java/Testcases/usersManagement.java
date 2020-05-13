package Testcases;

import Config.configProperties;
import Config.endpointURLs;
import Config.envGlobals;
import Config.reusableFunctions;
import general.baseTest;
import org.testng.annotations.Test;

public class usersManagement extends baseTest {


    @Test
    public void createEmailUser() {
        String Requestpayload = payloads.usersManagement.create_adminUser("Umair Nasir" + payloads.usersManagement.generateRandomNumber(), "umairtesting2+" + payloads.usersManagement.generateRandomNumber() + "@gmail.com", "03213895980", "EMAIL");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);
        envGlobals.EmailuserId = reusableFunctions.getResponsePath("data.id");
        envGlobals.emailPrincipleName = reusableFunctions.getResponsePath("data.principalName");

        Validations.usersManagement.verifyEmailUserdata(Requestpayload);


    }




    @Test
    public void createUser_with_ExistingEmail() {
        String Requestpayload = payloads.usersManagement.create_adminUser("Umair Nasir" + payloads.usersManagement.generateRandomNumber(), envGlobals.emailPrincipleName, "+44234234334", "EMAIL");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);


        Validations.usersManagement.verifyExistingEmail();


    }

    @Test
    public void createUser_withPhoneNo() {
        String Requestpayload = payloads.usersManagement.create_adminUser("Umair Nasir" + payloads.usersManagement.generateRandomNumber(), "umairtesting2+" + payloads.usersManagement.generateRandomNumber() + "@gmail.com", "032121" + payloads.usersManagement.generateRandomNumber(), "MOBILE_NUMBER");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);
        envGlobals.PhoneuserId = reusableFunctions.getResponsePath("data.id");
        envGlobals.PhoneprincipleName = reusableFunctions.getResponsePath("data.principalName");

        Validations.usersManagement.verifyMobileUser(Requestpayload);


    }

    @Test
    public void createUser_with_ExistingPhoneNo() {
        String Requestpayload = payloads.usersManagement.create_adminUser("Umair Nasir" + payloads.usersManagement.generateRandomNumber(), "umairtesting2+" + payloads.usersManagement.generateRandomNumber() + "@gmail.com", envGlobals.PhoneprincipleName, "MOBILE_NUMBER");

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);


        Validations.usersManagement.verifyExistingPhone();
    }
    @Test
    public void UpdateEmail_user() {
        String Requestpayload = payloads.usersManagement.update_adminUser(envGlobals.EmailuserId,"Umair Nasir" + payloads.usersManagement.generateRandomNumber(), "umairtesting2+" + payloads.usersManagement.generateRandomNumber() + "@gmail.com",    envGlobals.emailPrincipleName
        );

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("put", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.updateUser);
        reusableFunctions.thenFunction(200);
        envGlobals.emailPrincipleName = reusableFunctions.getResponsePath("data.principalName");

        envGlobals.updateEmailuserResponse = reusableFunctions.getResponse();
        Validations.usersManagement.verifyEmailUserdata(Requestpayload);

    }

    @Test
    public void UpdatePhone_user() {
        String Requestpayload = payloads.usersManagement.update_adminUser(envGlobals.PhoneuserId,"Umair Nasir" + payloads.usersManagement.generateRandomNumber(), "umairtesting2+" + payloads.usersManagement.generateRandomNumber() + "@gmail.com",    envGlobals.PhoneprincipleName
        );

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken), Requestpayload);
        reusableFunctions.whenFunction("put", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.updateUser);
        reusableFunctions.thenFunction(200);
        envGlobals.PhoneprincipleName = reusableFunctions.getResponsePath("data.principalName");

        envGlobals.updatephoneuserResponse = reusableFunctions.getResponse();
        Validations.usersManagement.verifyEmailUserdata(Requestpayload);

    }

    @Test
    public void getUSer_by_Email_Id() {
        reusableFunctions.givenHeaders(reusableFunctions.headers("Authorization", envGlobals
                .authorizationToken));
        reusableFunctions.whenFunction("get", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.getUser + envGlobals.emailPrincipleName);
        reusableFunctions.thenFunction(200);

        Validations.usersManagement.verifygetEmailUser();
    }

    @Test
    public void getUSer_by_Invalid_Email_Id() {
        reusableFunctions.givenHeaders(reusableFunctions.headers("Authorization", envGlobals
                .authorizationToken));
        reusableFunctions.whenFunction("get", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.getUser + "umairtesting2+20922@gmail.com");
        reusableFunctions.thenFunction(200);

        Validations.usersManagement.VerifyGetUsersBYinvaliddetails();

    }

    @Test
    public void getUSer_by_Phone_Id() {
        reusableFunctions.givenHeaders(reusableFunctions.headers("Authorization", envGlobals
                .authorizationToken));
        reusableFunctions.whenFunction("get", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort  + endpointURLs.getUser + envGlobals.PhoneprincipleName);
        reusableFunctions.thenFunction(200);

        Validations.usersManagement.verifygetPhoneUser();

    }

    @Test
    public void getUSer_by_InvalidPhone_Id() {
        reusableFunctions.givenHeaders(reusableFunctions.headers("Authorization", envGlobals
                .authorizationToken));
        reusableFunctions.whenFunction("get", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort  + endpointURLs.getUser + "234343432342");
        reusableFunctions.thenFunction(200);

        Validations.usersManagement.VerifyGetUsersBYinvaliddetails();
    }

    @Test
    public void getUsersList() {
        reusableFunctions.givenHeaders(reusableFunctions.headers("Authorization", envGlobals
                .authorizationToken));
        reusableFunctions.whenFunction("get", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort  + endpointURLs.getUsersList);
        reusableFunctions.thenFunction(200);
        envGlobals.pagesize = reusableFunctions.getPathLength("data.size()");

        System.out.print(envGlobals.pagesize);


        Validations.usersManagement.getUserList();
        Validations.usersManagement.VerifyPhoneuserinList();
        Validations.usersManagement.veriyEmailUserinList();


    }


    @Test
    public void getRoles() {
        reusableFunctions.givenHeaders(reusableFunctions.headers("Authorization", envGlobals
                .authorizationToken));
        reusableFunctions.whenFunction("get", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort  + endpointURLs.getRoles);
        reusableFunctions.thenFunction(200);

        Validations.usersManagement.verifyUSerRoles();
    }
}