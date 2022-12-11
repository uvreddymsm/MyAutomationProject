package com.applaudGS.automation.modules.general;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesOnGroups {

	@Test(groups = { "Admin" })
	public void loginWithClientIDd() {
		Assert.assertTrue(5<6, "Condition Is False.");
		//System.out.println("Login With Client ID");
	}
	
	/*@Test(groups = { "Admin" })
	public void loginWithAdminCreditionals() {
		Assert.assertTrue(5>6, "Condition Is False.");
	//	System.out.println("Login With Client ID");
	}*/
	 
	/*@Test(groups = { "Employee" })
	public void loginWithUserNamePwd() {
		Assert.assertTrue(5>6, "Condition Is False.");
		System.out.println("Login With UserName & Password");
	}
	 */
	@Test(dependsOnGroups = { "Admin" })
	public void formRegistrationForClient() {
		System.out.println("Form Reg Done Sucessfully For Client");
	}

}
