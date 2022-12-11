package com.applaudGS.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.applaudGS.automation.objectrepository.Locators;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;


public class ApplicationFunctions extends ReportManager {
	static String AppDBName="AppLaud_QA";
	
	public static WebDriver driver;
	public static Map<String, String> data;
	
	
	public static WebDriver verifyingEnvironment(WebDriver driver,String enterenvironmentcode) throws Exception{
		String envname=GlobalFunctions.getText(driver, Locators.envname);
		
	    if(envname.contains(AppDBName)){
	    	test.log(LogStatus.INFO,"Application Connected To Right DB : "+envname);
	    	
	    } else {
	    	
	    	test.log(LogStatus.ERROR, "Application Connected To Wrong DB And It Is : "+envname );
	    	
	    }
		return driver;
	}
	
	public static WebDriver logout(WebDriver driver) throws Exception{
		GlobalFunctions.click(driver, Locators.loginImage9006);
        GlobalFunctions.click(driver, Locators.signout);
        boolean b = driver.getPageSource().contains("Applaud");
        if(b=true){
        	test.log(LogStatus.INFO,GlobalUserDefinedMessages.LogOutSucess);	
        }else{
        	test.log(LogStatus.ERROR,GlobalUserDefinedMessages.LogOutFailure);	
        } 
		return driver;
		
	}
	
	public static WebDriver  readToastMsg(WebDriver driver) throws Exception{
		Thread.sleep(1000);
		String toastmsg=driver.findElement(GlobalFunctions.getLocator(Locators.ToastMessage)).getText();
        if(toastmsg.equals("Table Created Successfully")){
        	test.log(LogStatus.INFO,GlobalUserDefinedMessages.TableCreatedSucessMessage);
        }else{
        	test.log(LogStatus.ERROR,GlobalUserDefinedMessages.TableCreatedFailureMessage);
		
        }
		return driver;
		
	}
	
	public static WebDriver CommonThings() throws Exception{
		test=extent.startTest( "DataManager Module Testing");
		test.log(LogStatus.INFO,"Browser Used For Testing : "+GlobalFunctions.launchProperties("browser"));
	    test.log(LogStatus.INFO,"URL Used For Testing : "+GlobalFunctions.launchProperties("url"));
		return driver;
		
	}
	
	public static WebDriver readValue(WebDriver driver,String message,String Value) throws Exception{
		data=DataReader.readData();
		String value= data.get(Value);
		test.log(LogStatus.INFO,""+message +" :: "+value);
	    return driver;
		
	}
	
}

