package payloads;

public class publicUser {


    public static String createUser() {
        return "{\n" +
                "    \"name\": \"rest assured user\",\n" +
                "    \"job\": \"leader\"\n" +
                "}\n";
    }


    public static String updateUser() {
        return "{\n" +
                "    \"name\": \"Umair nasir\",\n" +
                "    \"job\": \"QA Lead\"\n" +
                "}\n";
    }

    public static String public_userLogin() {
        return "{\n" +
                "        \"email\": \"eve.holt@reqres.in\",\n" +
                "            \"password\": \"cityslicka\"\n" +
                "}\n";
    }





}