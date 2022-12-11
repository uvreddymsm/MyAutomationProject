REM set HERE=%CD% %~dp0..\Library
set HERE=%CD%/Library
set JAVA_HOME=%JAVA_HOME%
set PATH=%JAVA_HOME%\jre\bin;%JAVA_HOME%\bin;%PATH%
set SELENIUM_VERSION=3.0.1
set PLATFORM=WINDOWS

set CHROME_VERSION=39
set CHROME_WEBDRIVER_VERSION=2.13
set CHROME_WEBDRIVER_LOC=%CD% %~dp0..\Library\chromedriver.exe
REM set CHROME_WEBDRIVER_LOC=%HERE%/CHROMEDRIVERS/%CHROME_WEBDRIVER_VERSION%/chromedriver.exe
set CHROME_BINARY_LOC=C:\Program Files (x86)\Google\Chrome\Application\chrome.exe

REM set FIREFOX_VERSION=35
REM set FIREFOX_BINARY_LOC=C:\Program Files (x86)\Mozilla Firefox\firefox.exe

REM set IE_VERSION=10
REM set IE_WEBDRIVER_VERSION=2.44
REM set IE_WEBDRIVER_LOC=%HERE%/IEDRIVERS/%IE_WEBDRIVER_VERSION%/IEDriverServer.exe

set HUB_HOST=192.168.0.30
set HUB_PORT=5050
set HUB_URL=http://%HUB_HOST%:%HUB_PORT%/grid/register
set NODE_HOST=202.65.148.130
set NODE_PORT=5558


REM -browser "browserName=firefox,version=%FIREFOX_VERSION%,firefox_binary=%FIREFOX_BINARY_LOC%,maxInstances=5,platform=%PLATFORM%" -browser "browserName=chrome,version=%CHROME_VERSION%,chrome_binary=%CHROME_BINARY_LOC%,maxInstances=5,platform=%PLATFORM%"

java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role node -hub %HUB_URL% -host %NODE_HOST% -port %NODE_PORT% -browser "browserName=chrome,maxInstance=5" -browser "browserName=iexplore,maxInstance=5"

REM java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role node -hub %HUB_URL% -host %NODE_HOST% -port %NODE_PORT% -Dwebdriver.chrome.driver=%CHROME_WEBDRIVER_LOC% -browser "browserName=chrome,version=%CHROME_VERSION%,chrome_binary=%CHROME_BINARY_LOC%,maxInstances=3,platform=%PLATFORM%" -nodeConfig nodeConfig.json

REM start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role node -hub %HUB_URL% -host %NODE_HOST% -port %NODE_PORT% -Dwebdriver.chrome.driver=%CHROME_WEBDRIVER_LOC% -Dwebdriver.ie.driver=%IE_WEBDRIVER_LOC% -browser "browserName=firefox,version=%FIREFOX_VERSION%,firefox_binary=%FIREFOX_BINARY_LOC%,maxInstances=5,platform=%PLATFORM%" -browser "browserName=chrome,version=%CHROME_VERSION%,chrome_binary=%CHROME_BINARY_LOC%,maxInstances=5,platform=%PLATFORM%" -browser "browserName=internet explorer,version=%IE_VERSION%,maxInstances=5,platform=%PLATFORM%" -log SELENIUMLOGS\selnode-%NODE_PORT%.log



REM start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role node -hub %HUB_URL% -host %NODE_HOST% -port %NODE_PORT% -Dwebdriver.chrome.driver=%CHROME_WEBDRIVER_LOC% -browser "browserName=chrome,version=%CHROME_VERSION%,chrome_binary=%CHROME_BINARY_LOC%,maxInstances=5,platform=%PLATFORM%" -nodeConfig nodeConfig.json