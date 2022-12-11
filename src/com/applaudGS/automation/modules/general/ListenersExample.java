package com.applaudGS.automation.modules.general;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.applaudGS.automation.utility.MyListener.class)
public class ListenersExample {
	
	
	@Test		
	public void Login()				
	{		
	    System.out.print("I Am From Login Method");				
	}		

	//Forcefully failed this test as verify listener.		
	@Test		
	public void TestToFail()				
	{		
	    System.out.println("This method to test fail");					
	    Assert.assertTrue(false);			
	}		

}
