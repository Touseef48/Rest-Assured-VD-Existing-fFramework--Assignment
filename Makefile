test:
	mvn clean test -DfpsBaseUrl="https://test-tvs.dnow.com/tvs-fps" -DcoreBaseUrl="https://test-tvs.dnow.com/tvs-core" -DauthUrl="https://test-tvs.dnow.com/tvs-uaa/oauth/token" -DdbUrl="jdbc:mysql://tvstest.cks5fgrg4v5o.us-east-2.rds.amazonaws.com?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT" -DdbUserName="dnow-testr" -DdbPassword="EZARJ0P5EIU" -DENV="$(ENV)" -DGIT_COMMIT="$(GIT_COMMIT)" -DGIT_BRANCH="$(GIT_BRANCH)" -DBUILD_NUMBER="$(BUILD_NUMBER)" -DCOMPONENT_ID="$(COMPONENT_ID)" -Dmaven.test.failure.ignore=false

docker:
	mvn clean test -DfpsBaseUrl="http://${IP}:30082/tvs-fps" -DcoreBaseUrl="http://${IP}:30081/tvs-core" -DauthUrl="http://${IP}:30080/tvs-uaa/oauth/token" -DdbUrl="jdbc:mysql://3.228.20.116:30036/tvs" -DdbUserName="root" -DdbPassword="1234567890" -DENV="$(ENV)" -DGIT_COMMIT="$(GIT_COMMIT)" -DGIT_BRANCH="$(GIT_BRANCH)" -DBUILD_NUMBER="$(BUILD_NUMBER)" -DCOMPONENT_ID="$(COMPONENT_ID)" -Dmaven.test.failure.ignore=false 

local:
	mvn clean test -DfpsBaseUrl="http://localhost:8082/tvs-fps" -DcoreBaseUrl="http://localhost:8081/tvs-core" -DauthUrl="http://localhost:8085/tvs-uaa/oauth/token" -DdbUrl="jdbc:mysql://tvstest.cks5fgrg4v5o.us-east-2.rds.amazonaws.com" -DdbUserName="root" -DdbPassword="AX@HK*QYa%ZCXqR#" -DENV="$(ENV)" -DGIT_COMMIT="$(GIT_COMMIT)" -DGIT_BRANCH="$(GIT_BRANCH)" -DBUILD_NUMBER="$(BUILD_NUMBER)" -DCOMPONENT_ID="$(COMPONENT_ID)" -Dmaven.test.failure.ignore=false


istg:
	mvn clean test -DfpsBaseUrl="http://istg-tvsdnow.vendians.com/tvs-fps" -DcoreBaseUrl="http://istg-tvsdnow.vendians.com/tvs-core" -DauthUrl="http://istg-tvsdnow.vendians.com/tvs-uaa/oauth/token" -DdbUrl="jdbc:mysql://dnowtvs-dev.czhwifqqwqwc.us-east-1.rds.amazonaws.com/tvs?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT" -DdbUserName="dnow-devr" -DdbPassword="EZARJ0P5EIU" -DENV="$(ENV)" -DGIT_COMMIT="$(GIT_COMMIT)" -DGIT_BRANCH="$(GIT_BRANCH)" -DBUILD_NUMBER="$(BUILD_NUMBER)" -DCOMPONENT_ID="$(COMPONENT_ID)" -Dmaven.test.failure.ignore=false

dev:
	mvn clean test -DfpsBaseUrl="https://dev-tvs.dnow.com/tvs-fps" -DcoreBaseUrl="https://dev-tvs.dnow.com/tvs-core" -DauthUrl="https://dev-tvs.dnow.com/tvs-uaa/oauth/token" -DdbUrl="jdbc:mysql://dnowtvs-dev.czhwifqqwqwc.us-east-1.rds.amazonaws.com?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT" -DdbUserName="dnow-devr" -DdbPassword="EZARJ0P5EIU" -DENV="$(ENV)" -DGIT_COMMIT="$(GIT_COMMIT)" -DGIT_BRANCH="$(GIT_BRANCH)" -DBUILD_NUMBER="$(BUILD_NUMBER)" -DCOMPONENT_ID="$(COMPONENT_ID)" -Dmaven.test.failure.ignore=false
staging:
	exit 0

prod:
	exit 0

