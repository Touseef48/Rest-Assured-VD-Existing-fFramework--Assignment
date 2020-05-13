package Testcases;

import Config.ConfigProperties;
import Config.EndpointURLs;
import Config.EnvGlobals;
import Config.ReusableFunctions;
import general.BaseTest;
import org.testng.annotations.Test;

public class PublicUser extends BaseTest {



        @Test
        public void createlUser () {
            String Requestpayload = payloads.PublicUser.createUser();

            ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), Requestpayload);
            ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl + EndpointURLs.createUser2);
            ReusableFunctions.thenFunction(201);
            EnvGlobals.userId = ReusableFunctions.getResponsePath("id");

            Validations.PublicUser.VerifyUser2(Requestpayload);


        }

        @Test
        public void updateUser () {
            String Requestpayload = payloads.PublicUser.updateUser();

            ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), Requestpayload);
            ReusableFunctions.whenFunction("put", ConfigProperties.baseUrl + EndpointURLs.createUser2);
            ReusableFunctions.thenFunction(200);

            Validations.PublicUser.verifyUpdatedUser(Requestpayload);


        }

        @Test
        public void getUsers2List () {
            ReusableFunctions.givenHeaders(ReusableFunctions.headers());
            ReusableFunctions.whenFunction("get", ConfigProperties.baseUrl + EndpointURLs.User2List);
            ReusableFunctions.thenFunction(200);
            EnvGlobals.pagesize = ReusableFunctions.getPathLength("data.size()");
            System.out.print(EnvGlobals.pagesize);
            Validations.PublicUser.getUser2List();


        }


    }
