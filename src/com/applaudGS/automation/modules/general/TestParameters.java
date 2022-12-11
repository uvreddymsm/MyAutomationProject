package com.applaudGS.automation.modules.general;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	
	@Parameters({ "browser" })
	@Test
	public void testCaseOne(String browser) {
		System.out.println("browser passed as :- " + browser);
	}

	@Parameters({ "username", "password" })
	@Test
	public void testCaseTwo(String username, String password) {
		System.out.println("Parameter for User Name passed as :- " + username);
		System.out.println("Parameter for Password passed as :- " + password);
	}
	
	
	@Parameters({ "PhoneNo", "Address" })
	@Test
	public void testCaseThree(String PhoneNo, String Address) {
		System.out.println("Parameter for PhoneNo  :- " + PhoneNo);
		System.out.println("Parameter for Address :- " + Address);
	}
}
