package Testcases;

import Config.configProperties;
import Config.endpointURLs;
import Config.envGlobals;
import Config.reusableFunctions;
import general.baseTest;
import org.testng.annotations.Test;

public class user2 extends baseTest {




    @Test
    public void createlUser() {
        String Requestpayload = payloads.User2.createUser();

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers(), Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.baseUrl + endpointURLs.createUser2);
        reusableFunctions.thenFunction(201);
        envGlobals.userId = reusableFunctions.getResponsePath("id");

        Validations.user2.VerifyUser2(Requestpayload);


    }

    @Test
    public void updateUser() {
        String Requestpayload = payloads.User2.updateUser();

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers(), Requestpayload);
        reusableFunctions.whenFunction("put", configProperties.baseUrl + endpointURLs.createUser2);
        reusableFunctions.thenFunction(200);

        Validations.user2.verifyUpdatedUser(Requestpayload);


    }

    @Test
    public void getUsers2List() {
        reusableFunctions.givenHeaders(reusableFunctions.headers());
        reusableFunctions.whenFunction("get", configProperties.baseUrl + endpointURLs.User2List);
        reusableFunctions.thenFunction(200);
        envGlobals.pagesize = reusableFunctions.getPathLength("data.size()");
        System.out.print(envGlobals.pagesize);
        Validations.user2.getUser2List();



    }



}
