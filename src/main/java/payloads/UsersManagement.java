package payloads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class UsersManagement {


    private static int randomNum1 = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
    private static int randomNum2 = ThreadLocalRandom.current().nextInt(1, 10000 + 1);

    public static String Number;

    public static int randomNum;

    public static int generateRandomNumber() {
        randomNum = ThreadLocalRandom.current().nextInt(1, 100000 + 1);
        return randomNum;
    }


    private static String getCurrentDate() {
        return Instant.now().toString();
    }

    private static String getTomorrowDate() {
        return Instant.now().plus(Duration.ofDays(1)).toString();
    }

    private static String getyesterdayDate() {
        return Instant.now().plus(Duration.ofDays(-1)).toString();
    }


    public static String updateCustomer() {
        return "{\"name\":\"Umair customer112" + generateRandomNumber() + "\"" +

                "}\n";
    }


    public static String create_adminUser(String fullName, String email, String phone, String AccType) {
        return "{\n" +
                "\t\"fullName\":\"" + fullName + "\",\n" +
                "\t\"email\":\"" + email + "\",\n" +
                "\t\"mobileNumber\":\"" + phone + "\",\n" +
                "\t\"password\": \"Admin123!\",\n" +
                "\t\"accountType\":\"" + AccType + "\",\n" +
                "\t\"roles\": [\"ADMIN\"]\n" +
                "}\n";
    }

    public static String update_adminUser(String id, String fullName, String email, String principleName) {
        return "{\n" +
                "    \"id\":" + id + ",\n" +
                "\t\"fullName\":\"" + fullName + "\",\n" +
                "\t\"email\":\"" + "email123" + "\",\n" +
                "    \"mobileNumber\": \"+443898393838\",\n" +
                "    \"principalName\": \"" + principleName + "\",\n" +
                "    \"accountType\": \"EMAIL\",\n" +
                "    \"roles\": [\n" +
                "        \"ADMIN\"\n" +
                "    ]\n" +
                "}";
    }

}
