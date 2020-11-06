/*
# set & get environment/globals variables
*/

package config;

import io.restassured.config.Config;

import java.util.ArrayList;

public class ConfigProperties {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String Environment = appConfig.getEnvironment();
    public static String Project = appConfig.getProject();
    public static String baseUrl = appConfig.getBaseUrl();
    public static String username = appConfig.getUserName();
    public static String userPhoneNo = appConfig.getuserPhoneNo();
    public static String resourcesBaseUrl = appConfig.getresourcesBaseUrl();
    public static String resourcesserverPort = appConfig.getresourcesserverPort();

    public static String password = appConfig.getPassword();
    public static String Port = appConfig.getPort();
    public static String IsEnableReporting = appConfig.getIsEnableReporting();
    public static String dbUrl = appConfig.getDbUrl();
    public static String dbUsername = appConfig.getDbUsername();
    public static String dbPassword = appConfig.getDbPassword();
    public static String grantType = appConfig.getGrantType();
    public static String clientId = appConfig.getClientId();
    public static ArrayList lookupNames = appConfig.getLookupNames();
    public static String coreBaseUrl = appConfig.getCoreBaseUrl();
    public static String fpsBaseUrl = appConfig.getFpsBaseUrl();
    public static String filePath = appConfig.getFilePath();
    public static String initialCountryId = appConfig.getInitialCountryId();
    public static String initialCustomerId = appConfig.getInitialCustomerId();
    public static String initialSiteId = appConfig.getInitialSiteId();
    public static String initialFieldLocationId = appConfig.getInitialFieldLocationId();
    public static String authUrl = appConfig.getAuthUrl();



    public static String publicUserLogin = appConfig.getpublicUserLogin();
}
