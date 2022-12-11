package com.applaudGS.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class MyListener implements ITestListener{   
           
    
             
    public void onTestFailure(ITestResult result){ 
    	   String methodname=result.getName();
    	   DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
 		  Date d=new Date();
 		  String time=df.format(d);
     	  WebDriver driver=ReportManager.driver;   
           File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                         
           try {
                  FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Data\\"+ "\\Failed Screen Shots\\"+methodname+" "+time+".png"));
           }
           catch (IOException e) {
                e.printStackTrace();
           }
    	  // GlobalFunctions.CaptureScreenShot(result,methodname);
           System.out.println(result.getName()+"  : Test Failed \n");
    }
          
    public void onTestSuccess(ITestResult result){
          System.out.println(result.getName()+" : Test Passed \n");
    }
          
    public void onTestSkipped(ITestResult result){
          System.out.println(result.getName()+" : Test Skipped \n");
    }
           
    public void CaptureScreenShot(ITestResult result, String methodname){
    	
    	  DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
		  Date d=new Date();
		  String time=df.format(d);
    	  WebDriver driver=ReportManager.driver;   
          File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                        
          try {
                 FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Data\\"+ "\\Failed Screen Shots\\"+methodname+" "+time+".png"));
          }
          catch (IOException e) {
               e.printStackTrace();
          }
     }

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	} 
}

