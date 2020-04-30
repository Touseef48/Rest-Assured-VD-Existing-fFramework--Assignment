/*
# Define payloads
 */

package Config;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class payload {


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





    public static String listOfSurvey() {
        return "{\n" +
                "  \"countryId\":" + configProperties.initialCountryId + ",\n" +
                "  \"customerId\":" + configProperties.initialCustomerId + ",\n" +
                "  \"descending\": true,\n" +
                "  \"fieldLocationId\":" + configProperties.initialFieldLocationId + ",\n" +
                "  \"pageNumber\": 1,\n" +
                "  \"pageSize\": 100,\n" +
                "  \"siteId\":" + configProperties.initialSiteId + ",\n" +
                "  \"sortProperties\": [\n" +
                "    \"id\"\n" +
                "  ]\n" +
                "}";
    }

    public static String createMilestone() {
        return "{\n" +
                "\t\"endDate\": \"" + getTomorrowDate() + "\",\n" +
                "\t\"startDate\": \"" + getCurrentDate() + "\" ,\n" +
                "\t\"customerId\":" + configProperties.initialCustomerId  + ",\n" +
                "\t\"countryId\":" + configProperties.initialCountryId  + ",\n" +
                "\t\"siteId\":" + configProperties.initialSiteId  + ",\n" +
                "\t\"fieldLocationId\": "+envGlobals.latestFieldId+",\n" +
                "\t\"ccspRequest\": {\n" +
                "\t\"customerId\": "+configProperties.initialCustomerId+",\n" +
                "\t\"countryId\": "+configProperties.initialCountryId+",\n" +
                "\t\"projectType\": \"PROJECT\",\n" +
                "\t\"siteId\": "+configProperties.initialSiteId+",\n" +
                "\t\"fieldLocationId\": "+envGlobals.latestFieldId+" \n" +
                "\t}\n" +
                "}";
    }




    public static String createCustomer() {
        return "{\"name\":\"Umair customer" +generateRandomNumber() + "\"" +

                "}\n";
    }

    public static String createCustomer_withsameName() {
        return "{\"name\": \"" + envGlobals.customerName + "\"\n" +

                "}\n";
    }

    public static String updateCustomer() {
        return "{\"name\":\"Umair customer112" +generateRandomNumber() + "\"" +

                "}\n";
    }




}