package testcases;

import com.venturedive.base.utility.ReusableFunctions;
import config.EndpointURLs;
import config.EnvGlobals;
import general.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class Crud extends BaseTest {


    public static String basurl="https://dummyapi.io/data/v1";



    @BeforeMethod
    public void userCreate() {

        String Requestpayload = payloads.CrudPayload.user_Creation("moiz"+payloads.UsersManagement.generateRandomNumber()+"@yopmail.com");

        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("app-id","6148559986d0393b74c90e3b"), Requestpayload);
        ReusableFunctions.whenFunction("post", basurl + EndpointURLs.createe);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.userId = ReusableFunctions.getResponsePath("id");
        System.out.println("User Id is " +EnvGlobals.userId);

    }


    @Test(groups = {"Testrun 1 smoke","sanity"})

    public void userGet() {

        ReusableFunctions.givenHeaders(ReusableFunctions.headers("app-id","6148559986d0393b74c90e3b"));
        ReusableFunctions.whenFunction("get", basurl + EndpointURLs.getSpecificUser);
        ReusableFunctions.thenFunction(200);

    }

    @Test (groups = {"Testrun 2 smoke"})

    public void userNameupdate() {


        String Requestpayload = payloads.CrudPayload.update_user();
        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("app-id","6148559986d0393b74c90e3b"), Requestpayload);
        ReusableFunctions.whenFunction("put", basurl + EndpointURLs.update);
        ReusableFunctions.thenFunction(200);

    }

    @Test(groups = {"regression"})

    public void userRemove() {

        ReusableFunctions.givenHeaders(ReusableFunctions.headers("app-id","6148559986d0393b74c90e3b"));
        ReusableFunctions.whenFunction("delete", basurl + EndpointURLs.delete);
        ReusableFunctions.thenFunction(200);

    }

}
