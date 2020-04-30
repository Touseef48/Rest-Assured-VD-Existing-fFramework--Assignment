//package Validations;
//
//import Config.payload;
//import Config.reusableFunctions;
//import com.jayway.jsonpath.JsonPath;
//import org.junit.Assert;
//
//public class users {
//
//
//
//    public static void verifyexternalUserdata() {
//        Assert.assertEquals(JsonPath.read(payload.createUser(),"name"),reusableFunctions.getResponsePath("name"));
//        Assert.assertEquals(JsonPath.read(payload.createUser(),"email"),reusableFunctions.getResponsePath("email"));
//        Assert.assertEquals(JsonPath.read(payload.createUser(),"company"),reusableFunctions.getResponsePath("company"));
//        Assert.assertEquals(JsonPath.read(payload.createUser(),"contact"),reusableFunctions.getResponsePath("contact"));
//        Assert.assertEquals(JsonPath.read(payload.createUser(),"location"),reusableFunctions.getResponsePath("location"));
//
//    }
//
//    public static void verifyEngineerUserdata() {
//        Assert.assertEquals(JsonPath.read(payload.createUser_Engineer(),"name"),reusableFunctions.getResponsePath("name"));
//        Assert.assertEquals(JsonPath.read(payload.createUser_Engineer(),"email"),reusableFunctions.getResponsePath("email"));
//        Assert.assertEquals(JsonPath.read(payload.createUser_Engineer(),"company"),reusableFunctions.getResponsePath("company"));
//        Assert.assertEquals(JsonPath.read(payload.createUser_Engineer(),"contact"),reusableFunctions.getResponsePath("contact"));
//        Assert.assertEquals(JsonPath.read(payload.createUser_Engineer(),"location"),reusableFunctions.getResponsePath("location"));
//
//    }
//
//
//
//
//}
