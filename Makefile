test:
	 mvn clean test -Dpassword=Admin123! -DgrantType=password -DVersion=/v8 -DbaseUrl="https://reqres.in/api/login" -DdbUserName="dnow-testr" -DdbPassword="EZARJ0P5EIU" -DdbUrl="jdbc:mysql://tvstest.cks5fgrg4v5o.us-east-2.rds.amazonaws.com?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&allowPublicKeyRetrieval=true -DENV=${ENV} -DGIT_BRANCH=${BRANCH} -DBUILD_NUMBER=${BRANCH} -DGIT_COMMIT=${BRANCH} -DCOMPONENT_ID=${COMPONENT_ID} -DEnvironment=QA -Dusername=Dusername=admin@venturedive.com -DisEnableReporting=true





