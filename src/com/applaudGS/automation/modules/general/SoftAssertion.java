package com.applaudGS.automation.modules.general;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    SoftAssert softAssert = new SoftAssert();
    String className = "SoftAssertion";

    @Test
    public void test_UsingSoftAssertion() {
        softAssert.assertTrue(true == true, "");
        softAssert.assertEquals("SoftAssert", "SoftAssertion");
        softAssert.assertEquals(className, "SoftAssertion");
        System.out.println("Last statement gets executed!");
        softAssert.assertAll();
    }
}