package com.applaudGS.automation.modules.general;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertIssue {

    SoftAssert softAssert = new SoftAssert();
    String className = "SoftAssertion1";

    @Test
    public void test1_UsingSoftAssertion() {
        softAssert.assertTrue(true == true, "");
        softAssert.assertEquals("SoftAssert", "SoftAssertion");
        softAssert.assertNotEquals(className, "SoftAssertion");
        System.out.println("I am in test1_UsingSoftAssertion Method");
        softAssert.assertAll();
    }

    @Test
    public void test2_UsingSoftAssertion() {
        softAssert.assertTrue(true == true, "");
        softAssert.assertEquals("SoftAssertion", "SoftAssertion");
        softAssert.assertNotEquals(className, "SoftAssertion");
        System.out.println("I am in test2_UsingSoftAssertion Method");
        softAssert.assertAll();
        
    }
}