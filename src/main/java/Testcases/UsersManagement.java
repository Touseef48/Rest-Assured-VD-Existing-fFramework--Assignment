package Testcases;

import Config.ConfigProperties;
import Config.EndpointURLs;
import Config.EnvGlobals;
import com.venturedive.base.utility.ReusableFunctions;
import general.BaseTest;
import org.testng.annotations.Test;

public class UsersManagement extends BaseTest {


    @Test
    public void createEmailUser() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com", "03213895980", "EMAIL");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.EmailuserId = ReusableFunctions.getResponsePath("data.id");
        EnvGlobals.emailPrincipleName = ReusableFunctions.getResponsePath("data.principalName");

        Validations.UsersManagement.verifyEmailUserdata(Requestpayload);


    }




    @Test
    public void createUser_with_ExistingEmail() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), EnvGlobals.emailPrincipleName, "+44234234334", "EMAIL");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);


        Validations.UsersManagement.verifyExistingEmail();


    }

    @Test
    public void createUser_withPhoneNo() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com", "032121" + payloads.UsersManagement.generateRandomNumber(), "MOBILE_NUMBER");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.PhoneuserId = ReusableFunctions.getResponsePath("data.id");
        EnvGlobals.PhoneprincipleName = ReusableFunctions.getResponsePath("data.principalName");

        Validations.UsersManagement.verifyMobileUser(Requestpayload);


    }

    @Test
    public void createUser_with_ExistingPhoneNo() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com", EnvGlobals.PhoneprincipleName, "MOBILE_NUMBER");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);


        Validations.UsersManagement.verifyExistingPhone();
    }
    @Test
    public void UpdateEmail_user() {
        String Requestpayload = payloads.UsersManagement.update_adminUser(EnvGlobals.EmailuserId,"Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com",    EnvGlobals.emailPrincipleName
        );

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("put", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.updateUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.emailPrincipleName = ReusableFunctions.getResponsePath("data.principalName");

        EnvGlobals.updateEmailuserResponse = ReusableFunctions.getResponse();
        Validations.UsersManagement.verifyEmailUserdata(Requestpayload);

    }

    @Test
    public void UpdatePhone_user() {
        String Requestpayload = payloads.UsersManagement.update_adminUser(EnvGlobals.PhoneuserId,"Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com",    EnvGlobals.PhoneprincipleName
        );

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("put", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.updateUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.PhoneprincipleName = ReusableFunctions.getResponsePath("data.principalName");

        EnvGlobals.updatephoneuserResponse = ReusableFunctions.getResponse();
        Validations.UsersManagement.verifyEmailUserdata(Requestpayload);

    }

    @Test
    public void getUSer_by_Email_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.getUser + EnvGlobals.emailPrincipleName);
        ReusableFunctions.thenFunction(200);

        Validations.UsersManagement.verifygetEmailUser();
    }

    @Test
    public void getUSer_by_Invalid_Email_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.getUser + "umairtesting2+20922@gmail.com");
        ReusableFunctions.thenFunction(200);

        Validations.UsersManagement.VerifyGetUsersBYinvaliddetails();

    }

    @Test
    public void getUSer_by_Phone_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getUser + EnvGlobals.PhoneprincipleName);
        ReusableFunctions.thenFunction(200);

        Validations.UsersManagement.verifygetPhoneUser();

    }

    @Test
    public void getUSer_by_InvalidPhone_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getUser + "234343432342");
        ReusableFunctions.thenFunction(200);

        Validations.UsersManagement.VerifyGetUsersBYinvaliddetails();
    }

    @Test
    public void getUsersList() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getUsersList);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.pagesize = ReusableFunctions.getResponseLengthByKey("data.size()");

        System.out.print(EnvGlobals.pagesize);


        Validations.UsersManagement.getUserList();
        Validations.UsersManagement.VerifyPhoneuserinList();
        Validations.UsersManagement.veriyEmailUserinList();


    }


    @Test
    public void getRoles() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getRoles);
        ReusableFunctions.thenFunction(200);

        Validations.UsersManagement.verifyUSerRoles();
    }
}