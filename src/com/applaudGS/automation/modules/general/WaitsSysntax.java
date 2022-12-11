package com.applaudGS.automation.modules.general;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitsSysntax {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Impicit Syntax
		System.out.println("First Statement");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Second Statement");
		System.out.println("Third Statement");
		
		// Explicit Wait
		System.out.println("First Statement");
		WebDriverWait wait=new WebDriverWait(driver, 15);
	//	wait.until(ExpectedCondition.textToBePresentElementLocated(By.xpath("body/dsdsd/"),"Time left: 7 seconds"));
		System.out.println("Second Statement");
		System.out.println("Third Statement");
		
		// fluentwait
		
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

       

	}

}
