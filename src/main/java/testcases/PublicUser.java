package testcases;

import config.ConfigProperties;
import config.EndpointURLs;
import config.EnvGlobals;
import general.BaseTest;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.venturedive.base.utility.ReusableFunctions;

@Test( groups = {"retesting"})
public class PublicUser extends BaseTest {

    public static String namee="Moiz";
    public static String jobb="QA";
    public static String response;


        @Test
        //  @Test (description = "134207",groups = {"Testrun 1 smoke"}, invocationCount = 3, threadPoolSize =3)

        public void createUserClassVariable() {

        //USING CLASS DEFINED VARIABLES WITH PAYLOAD AS OBJECT
           payloads.PublicUser userCreation = new payloads.PublicUser(namee,jobb);

            JSONObject requestPayload = new JSONObject(userCreation);
            System.out.println(userCreation);
            ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), requestPayload.toString());
            ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl + EndpointURLs.createUser2);
            ReusableFunctions.thenFunction(201);
            response=ReusableFunctions.getResponse();
            System.out.println("JSON Response Payload\n\t"+response);
            EnvGlobals.userId = ReusableFunctions.getResponsePath("id");
            EnvGlobals.userName = ReusableFunctions.getResponsePath("name");
            EnvGlobals.userJob = ReusableFunctions.getResponsePath("job");

        //    System.out.println("Crete USer Class Variable Test is running on thread - " +Thread.currentThread().getId());


        }


    @Test (description = "134207", groups = {"smoke","sanity"})
    public void createUserEnvVariable() {

        payloads.PublicUser publicUser;

        // USING ENVIROMENT VARIABLES WITH PAYLOAD AS OBJECT
         payloads.PublicUser userCreation = new payloads.PublicUser(EnvGlobals.name,EnvGlobals.job);
        System.out.println(userCreation);
        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), userCreation);
        ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl + EndpointURLs.createUser2);
        ReusableFunctions.thenFunction(201);
        EnvGlobals.userId = ReusableFunctions.getResponsePath("id");
        EnvGlobals.userName = ReusableFunctions.getResponsePath("name");
        EnvGlobals.userJob = ReusableFunctions.getResponsePath("job");

      //  System.out.println("Crete USer Env Variable Test is running on thread - " +Thread.currentThread().getId());
    }



        @Test(groups = {"regression"})
        public void updateUserUsingTestcaseVariable () {

            // USING TESTCASE VARIABLES WITH PAYLOAD AS OBJECT

            createUserEnvVariable();
            payloads.PublicUser userCreation = new payloads.PublicUser(EnvGlobals.userName+"updated",EnvGlobals.userJob);
            System.out.println(userCreation);
            ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), userCreation);
            ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl + EndpointURLs.createUser2);
            ReusableFunctions.thenFunction(201);


          //  System.out.println("Update User usnig Testcase Variable Test is running on thread - " +Thread.currentThread().getId());



        }


        @Test
        public void getUsersList() {

            createUserEnvVariable();
            ReusableFunctions.givenHeaders(ReusableFunctions.headers());
            ReusableFunctions.whenFunction("get", ConfigProperties.baseUrl + EndpointURLs.User2List);
            ReusableFunctions.thenFunction(200);
            EnvGlobals.pagesize = ReusableFunctions.getResponseLengthByKey("data.size()");
            System.out.print(EnvGlobals.pagesize);
            validations.PublicUser.getUser2List();

            ReusableFunctions.verifySchema("jsonSchemata/UsersList.json");
        //    System.out.println("Get user list Test is running on thread - " +Thread.currentThread().getId());
        }

    @Test
    public void getUsersList_Negative_WhenRequiredValueMissing() {

        createUserEnvVariable();
        ReusableFunctions.givenHeaders(ReusableFunctions.headers());
        ReusableFunctions.whenFunction("get", ConfigProperties.baseUrl + EndpointURLs.User2List);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.pagesize = ReusableFunctions.getResponseLengthByKey("data.size()");
        System.out.print(EnvGlobals.pagesize);
        validations.PublicUser.getUser2List();

        ReusableFunctions.verifySchema("jsonSchemata/UsersListMissingRequiredProperty.json");
        //    System.out.println("Get user list Test is running on thread - " +Thread.currentThread().getId());
    }
    @Test
    public void getUsersList_Negative_WhenDataTypeDiffers() {

        createUserEnvVariable();
        ReusableFunctions.givenHeaders(ReusableFunctions.headers());
        ReusableFunctions.whenFunction("get", ConfigProperties.baseUrl + EndpointURLs.User2List);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.pagesize = ReusableFunctions.getResponseLengthByKey("data.size()");
        System.out.print(EnvGlobals.pagesize);
        validations.PublicUser.getUser2List();

        ReusableFunctions.verifySchema("jsonSchemata/UsersListDataTypeDiffers.json");
        //    System.out.println("Get user list Test is running on thread - " +Thread.currentThread().getId());
    }
    }
