package com.applaudGS.automation.modules.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.applaudGS.automation.utility.GlobalUserDefinedMessages;
import com.applaudGS.automation.utility.ReportManager;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendsLog extends ReportManager{
	
	
	
	@Test
	public void TC1() {
		test=extent.startTest( "Login Functionality For SpiceJet Application");
		
		
		test.log(LogStatus.INFO,"Hi Just Passed Info Step");
		
		test.log(LogStatus.WARNING, "Hi This Is Error Step");
		

		
		test.log(LogStatus.FAIL, "Hi This Is Fail Step");
		
	
	}
	
	@Test
	public void TC2() {
		test=extent.startTest( "form Registration For Account Creation");
		
		test.log(LogStatus.INFO,"Sucessfully Regestration ");
		
		test.log(LogStatus.ERROR, "Aadhar No Not verified");
		
		test.log(LogStatus.FAIL, "Entered Wrong Aadhar no");
		
		test.log(LogStatus.SKIP, "Hey Just For Skip");
		
	
	}
	
	@Test
	public void TC3() {
		test=extent.startTest( "Details Validation For Account Creation");
		
		test.log(LogStatus.INFO,"Aadhar Verified");
		
		test.log(LogStatus.ERROR, "Voter Card Invalid");
		
		test.log(LogStatus.FAIL, "In Valid Voter Card, so it is failuer");
		
	
	}
	@Test
	public void TC4() {
		test=extent.startTest( "Logout Functionality For SpiceJet");
		
		test.log(LogStatus.INFO,"Hey !! Sucessfully Regestered You Account In Spicejet");
		
		
		
	
	}

}
