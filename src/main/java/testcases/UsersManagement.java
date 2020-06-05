package testcases;

import config.ConfigProperties;
import config.EndpointURLs;
import config.EnvGlobals;
import com.venturedive.base.utility.ReusableFunctions;
import general.BaseTest;
import org.testng.annotations.Test;

public class UsersManagement extends BaseTest {


    @Test(description = "134207")
    public void createEmailUser() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com", "03213895980", "EMAIL");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.EmailuserId = ReusableFunctions.getResponsePath("data.id");
        EnvGlobals.emailPrincipleName = ReusableFunctions.getResponsePath("data.principalName");

        validations.UsersManagement.verifyEmailUserdata(Requestpayload);


    }




    @Test(description = "134208")
    public void createUser_with_ExistingEmail() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), EnvGlobals.emailPrincipleName, "+44234234334", "EMAIL");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);


        validations.UsersManagement.verifyExistingEmail();


    }

    @Test(description = "134209")
    public void createUser_withPhoneNo() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com", "032121" + payloads.UsersManagement.generateRandomNumber(), "MOBILE_NUMBER");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.PhoneuserId = ReusableFunctions.getResponsePath("data.id");
        EnvGlobals.PhoneprincipleName = ReusableFunctions.getResponsePath("data.principalName");

        validations.UsersManagement.verifyMobileUser(Requestpayload);


    }

    @Test(description = "134210")
    public void createUser_with_ExistingPhoneNo() {
        String Requestpayload = payloads.UsersManagement.create_adminUser("Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com", EnvGlobals.PhoneprincipleName, "MOBILE_NUMBER");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.createUser);
        ReusableFunctions.thenFunction(200);


        validations.UsersManagement.verifyExistingPhone();
    }
    @Test(description = "134211")
    public void UpdateEmail_user() {
        String Requestpayload = payloads.UsersManagement.update_adminUser(EnvGlobals.EmailuserId,"Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com",    EnvGlobals.emailPrincipleName
        );

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("put", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.updateUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.emailPrincipleName = ReusableFunctions.getResponsePath("data.principalName");

        EnvGlobals.updateEmailuserResponse = ReusableFunctions.getResponse();
        validations.UsersManagement.verifyEmailUserdata(Requestpayload);

    }

    @Test(description = "134212")
    public void UpdatePhone_user() {
        String Requestpayload = payloads.UsersManagement.update_adminUser(EnvGlobals.PhoneuserId,"Umair Nasir" + payloads.UsersManagement.generateRandomNumber(), "umairtesting2+" + payloads.UsersManagement.generateRandomNumber() + "@gmail.com",    EnvGlobals.PhoneprincipleName
        );

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", EnvGlobals.authorizationToken), Requestpayload);
        ReusableFunctions.whenFunction("put", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.updateUser);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.PhoneprincipleName = ReusableFunctions.getResponsePath("data.principalName");

        EnvGlobals.updatephoneuserResponse = ReusableFunctions.getResponse();
        validations.UsersManagement.verifyEmailUserdata(Requestpayload);

    }

    @Test(description = "134213")
    public void getUSer_by_Email_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.getUser + EnvGlobals.emailPrincipleName);
        ReusableFunctions.thenFunction(200);

        validations.UsersManagement.verifygetEmailUser();
    }

    @Test(description = "134215")
    public void getUSer_by_Invalid_Email_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort + EndpointURLs.getUser + "umairtesting2+20922@gmail.com");
        ReusableFunctions.thenFunction(200);

        validations.UsersManagement.VerifyGetUsersBYinvaliddetails();

    }

    @Test(description = "134214")
    public void getUSer_by_Phone_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getUser + EnvGlobals.PhoneprincipleName);
        ReusableFunctions.thenFunction(200);

        validations.UsersManagement.verifygetPhoneUser();

    }

    @Test(description = "134216")
    public void getUSer_by_InvalidPhone_Id() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getUser + "234343432342");
        ReusableFunctions.thenFunction(200);

        validations.UsersManagement.VerifyGetUsersBYinvaliddetails();
    }

    @Test(description = "134217")
    public void getUsersList() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getUsersList);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.pagesize = ReusableFunctions.getResponseLengthByKey("data.size()");

        System.out.print(EnvGlobals.pagesize);


        validations.UsersManagement.getUserList();
        validations.UsersManagement.VerifyPhoneuserinList();
        validations.UsersManagement.veriyEmailUserinList();


    }


    @Test(description = "134224")
    public void getRoles() {
        ReusableFunctions.givenHeaders(ReusableFunctions.headers("Authorization", EnvGlobals
                .authorizationToken));
        ReusableFunctions.whenFunction("get", ConfigProperties.resourcesBaseUrl + ConfigProperties.resourcesserverPort  + EndpointURLs.getRoles);
        ReusableFunctions.thenFunction(200);

        validations.UsersManagement.verifyUSerRoles();
    }
}