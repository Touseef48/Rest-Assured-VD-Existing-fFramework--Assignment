testWithJmeter:
	 mvn clean test -DEnvironment=QA -Dusername=Dusername=admin@venturedive.com -DisEnableReporting=true
	 -Dpassword=Admin123! -DgrantType=password -DVersion=/v8
	-DbaseUrl="https://reqres.in/api/login"
	-DdbUrl="jdbc:mysql://tvstest.cks5fgrg4v5o.us-east-2.rds.amazonaws.com?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&allowPublicKeyRetrieval=true
	-DdbUserName="dnow-testr" -DdbPassword="EZARJ0P5EIU" -DENV="$(ENV)" -DGIT_COMMIT="$(GIT_COMMIT)" -DGIT_BRANCH="$(GIT_BRANCH)"
	-DBUILD_NUMBER="$(BUILD_NUMBER)" -DCOMPONENT_ID="$(COMPONENT_ID)"
	-Dmaven.test.failure.ignore=false -Dsurefire.suiteXmlFiles=src/main/Resources/testSuite/allServicesTestSuite.xml
	 mvn -DjmeterScript=Usermanagement.jmx clean verify

testWithoutJmeter:
	 mvn clean test -DEnvironment=QA -Dusername=Dusername=admin@venturedive.com -DisEnableReporting=true
	 -Dpassword=Admin123! -DgrantType=password -DVersion=/v8
	-DbaseUrl="https://reqres.in/api/login"
	-DdbUrl="jdbc:mysql://tvstest.cks5fgrg4v5o.us-east-2.rds.amazonaws.com?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&allowPublicKeyRetrieval=true
	-DdbUserName="dnow-testr" -DdbPassword="EZARJ0P5EIU" -DENV="$(ENV)" -DGIT_COMMIT="$(GIT_COMMIT)" -DGIT_BRANCH="$(GIT_BRANCH)"
	-DBUILD_NUMBER="$(BUILD_NUMBER)" -DCOMPONENT_ID="$(COMPONENT_ID)"
	-Dmaven.test.failure.ignore=false -Dsurefire.suiteXmlFiles=src/main/Resources/testSuite/allServicesTestSuite.xml
