REM set HERE=%CD% %~dp0..\Library
set HERE=%CD%/Library
set JAVA_HOME=%JAVA_HOME%
set PATH=%JAVA_HOME%\jre\bin;%JAVA_HOME%\bin;%PATH%
set SELENIUM_VERSION=3.0.1
set HOST=localhost
REM set PORT=3210

REM start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -host %HOST% -port %PORT%

start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -hubConfig hubConfig.json


REM start java -jar lib/selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -hubConfig ConfigFiles/HubConfig.json