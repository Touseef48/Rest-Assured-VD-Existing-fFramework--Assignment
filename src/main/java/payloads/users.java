package payloads;

import Config.envGlobals;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class users {




    private static int randomNum1 = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
    private static int randomNum2 = ThreadLocalRandom.current().nextInt(1, 10000 + 1);

    public static String dnowNumber;
    public static String dnowFlangeNumber;
    public static String dnowValveNo;
    public static String dnowValveFNo;
    public static String valveTagNo;
    public static String valveTagFNo;
    public static String dnowProject;
    public static String jobName;
    public static String uniqueNo;
    public static String uniqueFNo;
    public static String dnowJointId;
    public static int randomNum;

    public static int generateRandomNumber()
    {   randomNum = ThreadLocalRandom.current().nextInt(1, 100000 + 1);
        return randomNum;}

    public static String getUniqueNo() {
        return uniqueNo = "\"DnowV_" + generateRandomNumber() + "\"";}

    public static String getDnowNumber() {
        return dnowNumber = "\"DnowV_" + generateRandomNumber() + "\"";}

    public static String getUniqueFNo() {
        return uniqueFNo = "\"DnowF_" + generateRandomNumber() + "\"";}

    public static String getDnowFlange()
    {return dnowFlangeNumber = "\"DnowF_" + generateRandomNumber() +"\"";}

    public static String getDnowValveNo() {
        dnowValveNo = "\"DnowV-" + generateRandomNumber() +"\"";
        return  dnowValveNo;}

    public static String getDnowValveFNo()
    {return dnowValveFNo = "\"DnowF-" + generateRandomNumber() +"\"";}

    public static String getValveTagNo()
    {return valveTagNo = "\"TagV_" + generateRandomNumber() +"\"";}

    public static String getValveTagFNo()
    {return valveTagFNo = "\"TagF_" + generateRandomNumber() +"\"";}

    public static String getDnowProject()
    {return dnowProject = "\"DNOW-BR-" + generateRandomNumber() +"\"";}

    public static String getJobName()
    {return jobName = "\"JOB_" + generateRandomNumber() +"\"";}

    public static String getDnowJointId()
    {return dnowJointId = "\"FL-" + generateRandomNumber() +"\"";}

    //Instant instant = Instant.now();
    //private static String currentDate = Instant.now().toString();
    //private static String tomorrowDate = Instant.now().plus(Duration.ofDays(1)).toString();

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
        return "{\"name\":\"Umair customer112" +generateRandomNumber() + "\"" +

                "}\n";
    }


    public static String create_adminUser(String fullName, String email,String phone,String AccType) {
        return "{\n" +
                "\t\"fullName\":\"" + fullName + "\",\n" +
                "\t\"email\":\"" + email + "\",\n" +
                "\t\"mobileNumber\":\"" + phone + "\",\n" +
                "\t\"password\": \"Admin123!\",\n" +
                "\t\"accountType\":\"" + AccType + "\",\n" +
                "\t\"roles\": [\"ADMIN\"]\n" +
                "}\n";
    }

    public static String update_adminUser(String id ,String fullName, String email ) {
        return "{\n" +
                "    \"id\":" + id + ",\n" +
                "\t\"fullName\":\"" + fullName + "\",\n" +
                "\t\"email\":\"" + email + "\",\n" +
                "    \"mobileNumber\": \"+443898393838\",\n" +
                "    \"principalName\": \"" + envGlobals.emailPrincipleName + "\",\n" +
                "    \"accountType\": \"EMAIL\",\n" +
                "    \"roles\": [\n" +
                "        \"ADMIN\"\n" +
                "    ]\n" +
                "}";
    }


}
