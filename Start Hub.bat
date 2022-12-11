set HERE=%CD%/Library
REM set HERE=%CD% %~dp0..\Library
set SELENIUM_VERSION=3.0.1
REM set HOST=192.168.0.197
REM set PORT=3216

start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -hubConfig hubConfig.json

REM start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -PropertiesFile\hubConfig PropertiesFile\hubConfig.json

REM start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -host %HOST% -port %PORT%


REM set HERE=%CD% %~dp0..\Library
REM set JAVA_HOME=%JAVA_HOME%
REM set PATH=%JAVA_HOME%\jre\bin;%JAVA_HOME%\bin;%PATH%
REM set SELENIUM_VERSION=3.0.1
REM set HOST=localhost
REM set PORT=3631

REM start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -host %HOST% -port %PORT% -log GridLogs\hub.log