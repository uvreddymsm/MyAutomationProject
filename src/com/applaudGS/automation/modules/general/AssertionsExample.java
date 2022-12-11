package com.applaudGS.automation.modules.general;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsExample {
	
	String cityname="Hyderabad1";
	@Test
	public void testCaseOne1(){
		
		Assert.assertEquals(cityname,"Hyderabad");
	}
	
	@Test
	public void testCaseOne(){
		
		Assert.assertEquals("Hyderabad","Hyderabad");
	}

}
