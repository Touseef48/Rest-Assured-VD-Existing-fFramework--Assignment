**1- Purpose**

The purpose of this automation script is to automate all of the APIs so that we just need to execute the script for sanity,smoke and Regression testing or every time we get the new build changes from API level.
 
 **2- Scope**
 
 The script provides following features:
 

i- It has different reusable functions which can be accessed from any where of the script.

_Restassured framework follows BDD approach(Given,When,Then)_

There are different reusable functions of  **given** , **when** and **then** which are used on the basis of execution of an API.

`- given()`

Function with no parameter ,this function doesnot take any extra information with the Given statement

`- givenHeaders(Map<String, String> headers)`

Function with one parameter , this function takes header info with the Given statement.

`- givenHeaderPayload(Map<String, String> headers, String payload)`

Function with two parameters, this function takes header info and request payload of an API with the Given statement.

`- givenFormData(Map<String, String> formData)`

Function with one parameter , this function takes multipart form data key and value with the Given statement.

`- givenHeaderFormData(Map<String, String> headers, Map<String,String> formData)`

Function with two parameters , this function takes header info and multipart form data key and value with the Given statement

`- whenFunction(String requestType, String endPoint)`

Function with two parameters , this function takes info of the request type (Get,Post,Put,Delete etc) and the Url of an API with When statement. 

`- thenFunction(int statusCode)`

Function with one parameter , this function takes expected status code of an API with Then statement.

_**It has some other reusable functions which can be used on the basis of requirements.**_

`- printResponse()`

Print JSON response of an API on console.

`- getResponseString()`

Get response of API in string

`- getResponsePath(String key)`

Get path of the response.

`- getResponseLengthByKey(String Key)`

Get length of the response with respect to object of an array

e.g ReusableFunctions.getResponseLengthByKey("data.size()") --> It gives size of the data object.

`- thenObjectmatch (String path, String matchers)`

Checks at least one item which matches the parameter matcher.It can have more items (matching or not), in any order.The matcher is tried on each element until one of them matches, the rest of them is ignored.


`- compareFile(apiResponse,expectedJson,ignoreFields)`

Compare actual response with expected Json and ignore all of the dynamic values which are defined with ignoreFields parameters


ii-  It provides json comparison of static parameters of actual response from expected json file and ignore all of the dynaimc values which will be updating on every execution.
Its function takes three parameters
- Response Payload of an API
- Expected Json file
- list of the field which needs to be ignored
e.g reusableFunctions.compareFile(apiResponse,expectedJson,ignoreFields);

iii- It provides feature of reading path from request paylod and compare it with the path from response payload by usig "json.read" Syntax.
Its function takes two parameters
- Json object of Request payload 
- Json Path
e.g JsonPath.read(RequestPayload,"[0].firstName")

iv- It provides Database connection with Sonar DB. It saves the records of test execution in Sonar Database each time the script is executed on Jenkins. It also fetches the test coverage count either from the testrail based on the specified platform or from the key CoverageCount in case if the cases are not updated on TestRail.  

v- It provides the execution of JMeter script through mvn command and get the html report on every execution of the .jmx script

**3- TestNG File**

Path of testNG file is added into pom.xml file. Jenkins reads testNG file for the execution of automation script from pom.xml file.The testNG file which added into the pom.xml will be executing on jenkins.

e.g

   ` <suiteXmlFiles>`
 
    ` <suiteXmlFile>src/main/resources/testSuite/allServicesTestSuite.xml</suiteXmlFile>`  
   
   `</suiteXmlFiles>`
   
   There are two different testng files added into the testSuite package.
   - allServiceTestSuite.xml
   - publicUserTestsuite.xml
   
   allServiceTestSuite.xml - Contains APIs of usermanagment module which include testcase of userAuthentication , create , update and get users.
   
   publicUserTestsuite.xml - Contains public APIs which include testcases of create,update and get user.
  

**4- How to execute jmeter test file**

_**Following are the steps to execute jmeter through maven command.**_

i-  Add .jmx test file under scr/test/jmeter folder.

ii-  Add jmeter.properties file under scr/test/jmeter folder.

iii- Add jmeter Test file name under jmeter maven plugin in pom.xml file
 Here is the required plugin of jmeter

`<plugin>
                <groupId>com.lazerycode.jmeter</groupId>
                <artifactId>jmeter-maven-plugin</artifactId>
                <version>2.8.5</version>
                <executions>
                    <!-- Run JMeter tests -->
                    <execution>
                        <id>jmeter-tests</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>jmeter</goal>
                        </goals>
                    </execution>
                    <!-- Fail build on errors in test -->
                    <execution>
                        <id>jmeter-check-results</id>
                        <goals>
                            <goal>results</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <testFilesIncluded>
                        <jMeterTestFile>DnowFetchToken.jmx</jMeterTestFile>
                    </testFilesIncluded>
                </configuration>
       </plugin>
`

iv- Run "mvn -DjmeterScript={jmeter test file name} clean verify" to execute jmeter script.
e.g mvn -DjmeterScript=Usermanagement.jmx clean verify

**5- Pre-requisite**

 - Jdk version >= 8

here is the link: 
https://www.oracle.com/java/technologies/javase-downloads.html

- Tool for dev : IntelliJ
- All the required dependencies along with version will be downloaded automatically through pom.xml file

**6- Framework setup** 

Clone the repository by copying the URL from the restassured framework. 
Enter git clone and the repository URL at your command line:
                                                                      
e.g

git clone https://{your bitbucket url}/venturedive/rest-assured-framework.git

**7- Import JAR File**

- Save "Settings.xml" file in your machine.
- Add dependency in pom.xml. (Add name and version of JAR file)

        <dependenc>
            <groupId>com.venturedive</groupId>
            <artifactId>testrail-integration</artifactId>
            <version>7.3-SNAPSHOT</version>
        </dependency>
- Define all relevant credentials for JIRA, TestRail & CQM in either ApplicationConfig.properties or environment variables.
    - Environment Variables
        - Create a shell script in /etc/profile.d
        - Add following variables:
          
            - export dbUrl={dbUrl}
            - export dbUserName={dbUserName}
            - export dbPassword={dbPassword}
              
            - export TestRailurl=https://{project}.testrail.io//
            - export TestRailusername=test.automation@venturedive.com
            - export TestRailpassword=Admin123
            - export TestRailToken=Basic {TestRailToken}

            - export JiraURL=https://{project}.atlassian.net/
            - export JiraUsername=test.automation@venturedive.com
            - export JiraPassword={JiraPassword}

            - export sonarurl={sonarurl}
            - export sonaruser={sonaruser}
            - export sonarpwd={sonarpwd}
            - export sonarport={sonarport}
- Note:
  - If properties are defined at both locations i.e. ApplicationConfig.properties and Environment variables, framework will read the values from ApplicationConfig.properties. 
  - These properties are defined on OS level and any changes to these properties will be loaded on system boot up.

**8- Purpose of JAR File**

- To integrate a project with Jenkins, TestRail, JIRA and CQM Dashboard.

**9- Functions used from JAR File**
- Reusable Functions.
- 

**10- Contents of JAR File**

- Reusable Functions.
- Code for integration with TestRail and JIRA.

**11- Config Properties used from JAR File**
-  ENV  
-  GIT_COMMIT  
-  GIT_BRANCH  
-  BUILD_NUMBER  
-  COMPONENT_ID  
-  MY_REPOSITORY  
-  TESTSUITE  

**11.1-TestRail:**

-  TestRailusername  
-  TestRailpassword  
-  TestRailprojectid  
-  TestRailToken  
-  UpdateCase= True
   ```` 
   "True" if you want to update cases on Testrail.
   "False" if you don't want to update cases on Testrail.
   ````
-  TemplateId = 5  
   ````
   If TemplateId is ommitted, following values will be used by default:
        - TemplateId = 5, when the Platform is API
        - TemplateId = 13, when the Platform is Web
        - TemplateId = 14, when the Platform is Mobile
  
   Note: A custom id can be provide, if the project has a template OR type ID different than the default Ids.
    ````
-  CoverageFromTestRail = True
   ````
   "True" in case you want to fetch test case coverage from TestRail.
   "False" in case you don't want to fetch test case coverage from TestRail.
   ````

-  CoverageCount = 100
   ````
   Provide this count when you have CoverageFromTestRail set as false, and you want to send the coverage manually.
    ````

**11.2 JIRA:**

- LogJIRA = True
   ````
   "True" in case you want to log tickets to JIRA. 
   "False" in case you don't want to log tickets to JIRA.
   ````
- JiraURL= https://vend.atlassian.net/  
- JiraUsername   
- JiraPassword   
- JiraProjectKey  
- JiraReporter  

**11.3 Email Notification:**

- SendEmailAfterExecution= False
````
 "True" in case you want to send email notification. 
 "False" in case you don't want to send email notification.
 ````

- From=vdautomationtesting@gmail.com  
- FromPassword=VDautomationtesting  
- To = {<"recipient1">,<"recipient2">}  
- ProjectDescription=Project Automation  

**12- How to use JAR file for integration with JIRA, TestRail, Jenkins and CQM Dashboard**

- While writing test cases, Reusable functions will be used.
- In baseTest class, functions for integration with TestRail and Jira will be used.
