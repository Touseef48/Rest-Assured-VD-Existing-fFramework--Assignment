package Testcases;

import Config.configProperties;
import Config.endpointURLs;
import Config.envGlobals;
import Config.reusableFunctions;
import org.testng.annotations.Test;

public class users {



    @Test
    public void createUser() {
        String Requestpayload = payloads.users.create_adminUser("Umair Nasir" + payloads.users.generateRandomNumber(), "umairtesting2+"+ payloads.users.generateRandomNumber()+ "@gmail.com" );

        reusableFunctions.givenHeaderPayload(reusableFunctions.headers("Authorization", envGlobals.authorizationToken),  Requestpayload);
        reusableFunctions.whenFunction("post", configProperties.resourcesBaseUrl + configProperties.resourcesserverPort + endpointURLs.createUser);
        reusableFunctions.thenFunction(200);
        envGlobals.userId = reusableFunctions.getResponsePath("data.id");
        Validations.users.verifyAdminUserdata(Requestpayload);


    }


}
