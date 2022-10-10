package testcases;

import com.venturedive.base.utility.ReusableFunctions;
import config.ConfigProperties;
import config.EndpointURLs;
import config.EnvGlobals;
import general.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Assignment extends BaseTest {
    @Test
    public void getAllUsers() {

        ReusableFunctions.givenHeaders(ReusableFunctions.headers());
        ReusableFunctions.whenFunction("get", ConfigProperties.baseUrl + EndpointURLs.get_All_Users);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.pagesize = ReusableFunctions.getResponseLengthByKey("data.size()");
        System.out.print(EnvGlobals.pagesize);
        validations.PublicUser.getUser2List();
        EnvGlobals.U_ID = ReusableFunctions.getResponsePath("data[2].id");

        ReusableFunctions.verifySchema("jsonSchemata/UsersList.json");
    }

    @Test
    public void deleteUser() {

        ReusableFunctions.givenHeaders(ReusableFunctions.headers("app-id","6148559986d0393b74c90e3b"));
        ReusableFunctions.whenFunction("delete", ConfigProperties.baseUrl + EndpointURLs.delete_specific_user);
        ReusableFunctions.thenFunction(204);

    }
}
