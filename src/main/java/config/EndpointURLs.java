package config;

public class EndpointURLs {

    public static final String oAuth = "/oauth/token";

///////////////////Users///////////////////
    public static final String createUser = "/api/user";
    public static final String updateUser = "/api/user";
    public static final String getUser  = "/api/user/";
    public static final String getRoles  = "/api/roles";
    public static final String getUsersList = "/api/users?q=&startIndex=0&length=10000";

    public static final String createUser2 = "/api/users";

    public static final String User2List = "/api/users?page=1";
    public static final String loginuser ="/api/login";
    public static final String registeruser ="/api/register";
    public static final String create ="/api/users";
    public static final String update ="/user/"+EnvGlobals.userId;
    public static final String delete ="/user/"+EnvGlobals.userId;
    public static final String getuserslist ="/api/users?page=2";

    public static final String createe ="/user/create";
    public static final String getSpecificUser="/user/"+EnvGlobals.userId;

    public static final String getsingleuser="/user/614875219dcb5ec687101cbf";
}
