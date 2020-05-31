/*
# Get properties values and set into variables
*/
package Config;
/*
# Get properties values and set into variables
*/

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

import java.util.ArrayList;

@Classpath({"ApplicationConfig.properties"})

public class ApplicationConfigReader {

    @Property("authUrl")
    private String authUrl;

    @Property("publicUserLogin")
    private String publicUserLogin;

    @Property("resourcesBaseUrl")
    private String resourcesBaseUrl;

    @Property("resourcesserverPort")
    private String resourcesserverPort;

    @Property("baseUrl")
    private String baseUrl;

    @Property("coreBaseUrl")
    private String coreBaseUrl;

    @Property("fpsBaseUrl")
    private String fpsBaseUrl;

    @Property("username")
    private String UserName;

    @Property(("userPhoneNo"))
    private String userPhoneNo;

    @Property("password")
    private String Password;

    @Property("Environment")
    private String Environment;

    @Property("Project")
    private String Project;

    @Property("port")
    private String Port;

    @Property("isEnableReporting")
    private String isEnableReporting;

    @Property("dbUrl")
    private String dbUrl;

    @Property("dbUserName")
    private String dbUserName;

    @Property("grantType")
    private String grantType;

    @Property("clientId")
    private String clientId;

    @Property("dbPassword")
    private String dbPassword;

    @Property("apiVersion")
    private String apiVersion;

    @Property("lookupNames")
    private ArrayList lookupNames;

    @Property("filePath")
    private String sheetPath;

    @Property("initialCountryId")
    private String initialCountryId;

    @Property("initialCustomerId")
    private String initialCustomerId;

    @Property("initialSiteId")
    private String initialSiteId;

    @Property("initialFieldLocationId")
    private String initialFieldLocationId;

    //For reporting into database



    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public ArrayList getLookupNames() {
        return lookupNames;
    }

    public String getGrantType() {
        return grantType;
    }



    public String getClientId() {
        return clientId;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getresourcesBaseUrl() {
        return this.resourcesBaseUrl;
    }

    public String getresourcesserverPort() {
        return this.resourcesserverPort;
    }





    public String getUserName() {
        return this.UserName;
    }
    public String getuserPhoneNo() { return this.userPhoneNo;  }
    public String getPassword() {
        return this.Password;
    }

    public String getEnvironment() {
        return this.Environment;
    }

    public String getProject() {
        return this.Project;
    }

    public String getPort() {
        return this.Port;
    }

    public String getIsEnableReporting() {
        return this.isEnableReporting;
    }

    public String getCoreBaseUrl() {
        return coreBaseUrl;
    }

    public String getFpsBaseUrl() {
        return fpsBaseUrl;
    }

    public String getFilePath() {
        return System.getProperty("user.dir") + "/files";
    }

    public String getInitialCountryId() {
        return initialCountryId;
    }

    public String getInitialCustomerId() {
        return initialCustomerId;
    }

    public String getInitialSiteId() {
        return initialSiteId;
    }

    public String getInitialFieldLocationId() {
        return initialFieldLocationId;
    }

    public String getAuthUrl() { return authUrl; }

    public String getpublicUserLogin() { return publicUserLogin; }





}