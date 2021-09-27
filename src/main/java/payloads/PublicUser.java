package payloads;



public class PublicUser {

    // PAYLOADS USED AS OBJECTS

    private  String name;
    private  String job;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public  PublicUser(String name, String job)
    {
        this.name = name;
        this.job = job;
    }











// PAYLOADS USED AS STRING

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

    public static String publicUserLogin() {
        return "{\n" +
                "        \"email\": \"eve.holt@reqres.in\",\n" +
                "            \"password\": \"cityslicka\"\n" +
                "}\n";
    }





}
