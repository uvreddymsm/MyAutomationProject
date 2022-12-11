package com.applaudGS.automation.modules.general;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesOnMethods {

	//Here is an example of a hard dependency:
	
	@Test(priority=1)
	public void login() {
		Assert.assertTrue(5>6, "Condition Is False.");
		System.out.println("Hey Login Sucessfully");
	}
	 
	@Test(priority=2,dependsOnMethods = { "login" })
	public void formRegistration() {
		System.out.println("Hey Form Registration Did Sucessfully");
	}

}
