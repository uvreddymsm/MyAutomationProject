package com.applaudGS.automation.modules.general;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

    String className = "HardAssertion1";

    @Test
    public void test_UsingHardAssertion() {
        Assert.assertTrue(5<6);
        Assert.assertEquals("HardAssertion", "HardAssertion");
        Assert.assertEquals(className, "HardAssertion");
        Assert.assertNotEquals("HardAssertion1", "HardAssertion");
        System.out.println("Successfully passed!");
    }
}