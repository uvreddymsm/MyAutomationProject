package com.applaudGS.automation.modules.general;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataThroughPropertiesFile {
	
public static void main(String args[]) {
	Properties properties = new Properties();
	   try{
		   
		
		  //   FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
		   FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\ConfigFiles\\Config.properties");

		   properties.load(fileInput);
		   
	String str=	   properties.getProperty("browser");
	String str1=	   properties.getProperty("url");
	System.out.println(properties.getProperty("emaild"));
	System.out.println(str);
	System.out.println(str1);
	
		   
		
	      }catch(Exception e){
		      e.printStackTrace();
	     }
}
	
	
	@Test(enabled=false)
	public void TC1() {
		System.out.println("I Am Hyderabad");
	}
	
	@Test(enabled=true)
	public void TC2() {
		System.out.println("I Am Banglore");
	}
	
	@Test(enabled=false)
	public void TC3() {
		System.out.println("I Am Chittoor");
	}

}
