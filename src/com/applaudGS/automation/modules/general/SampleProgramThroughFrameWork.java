package com.applaudGS.automation.modules.general;

import org.testng.annotations.Test;

import com.applaudGS.automation.objectrepository.Locators;
import com.applaudGS.automation.utility.GlobalFunctions;
import com.applaudGS.automation.utility.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

public class SampleProgramThroughFrameWork extends ReportManager{
	

	
	@Test
	public void TC1() throws Exception {
		
		
		// This is Yuvaraju R
		test=extent.startTest( "Sample Program Through Framework");
		driver=	GlobalFunctions.launchBrowser(driver);
		GlobalFunctions.openUrl(driver,"url");
		test.log(LogStatus.INFO, "Hey Buddy Application Opened Sucessfully");
		GlobalFunctions.selectValueByVisibleText_Normal(driver, Locators.DropdownForTitle, "Mrs");
		GlobalFunctions.enterText(driver, Locators.FirstName, "John Petter");
		GlobalFunctions.enterText(driver, Locators.LastName, "Sample");
		test.log(LogStatus.PASS, "Hey Both First Name and Last Name is entered Sucessfully");

		
		
		
		
//		GlobalFunctions.click(driver, Locators.oneWay);
//		GlobalFunctions.click(driver, Locators.Depature);
//		GlobalFunctions.click(driver, Locators.from);
//		GlobalFunctions.click(driver, Locators.to);
		
	}
	
	@Test
	public void TC2() throws Exception {
		
		test=extent.startTest( "Login For Spicejet");
		test.log(LogStatus.INFO, "Login Sucessfull");
		
		
		
	}
	
//	@Test
//	public void TC3() throws Exception {
//		
//		test=extent.startTest( "Member Creation For Spicejet");
//		test.log(LogStatus.INFO, "Info Log Sample Message");
//		test.log(LogStatus.ERROR, "Error Log Sample Message");
//		test.log(LogStatus.FATAL, "Fatal Log Sample Message");
//		test.log(LogStatus.SKIP, "Skip Log Sample Message");
//		
//		
//		
//	}
	

}
