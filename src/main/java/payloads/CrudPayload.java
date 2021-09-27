package payloads;

public class CrudPayload {



    public static String user_Creation(String email) {

        return "{\n" +
                "    \"firstName\": \"Muhammad\",\n" +
                "    \"lastName\": \"Ajmal\",\n" +
                "    \"email\": \""+email+"\"\n" +
                "}";
    }


    public static String update_user() {

        return "{\n" +
                "    \"lastName\": \"Moiz Naqi\"\n" +
                "}";
    }
}
