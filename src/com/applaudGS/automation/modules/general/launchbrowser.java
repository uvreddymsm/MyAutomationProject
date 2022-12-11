package com.applaudGS.automation.modules.general;

import org.testng.annotations.Test;

import com.applaudGS.automation.objectrepository.Locators;
import com.applaudGS.automation.utility.GlobalFunctions;
import com.applaudGS.automation.utility.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

public class launchbrowser extends ReportManager{

	@Test
	public void sampleyuva()throws Exception{
		test=extent.startTest( "For Testing Purpose Buddy");
		
		driver=GlobalFunctions.launchBrowser(driver);
		test.log(LogStatus.INFO,"Hey : Browser Opened Sucessfully");
	//	driver=GlobalFunctions.openUrl(driver, "url");
		driver.get("http://www.instancy.com");;
		
		test.log(LogStatus.INFO,"Hey : Applicaiton Login SucessFully");
		
	//	GlobalFunctions.click(driver, Locators.ContactUS);
		
		test.log(LogStatus.INFO,"Buddy : Clicked Contact US Page");
		
		test.log(LogStatus.ERROR,"Buddy : Sample Message For ERROR Log");
		test.log(LogStatus.FAIL,"Buddy : Sample Message For FAIL Log");
		test.log(LogStatus.PASS,"Buddy : Sample Message For PASS Log");
		test.log(LogStatus.SKIP,"Buddy : Sample Message For SKIP Log");
		test.log(LogStatus.WARNING,"Buddy : Sample Message For WARNING Log");
		
		
		
	}
}
	

