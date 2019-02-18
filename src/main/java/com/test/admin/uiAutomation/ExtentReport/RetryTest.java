package com.test.admin.uiAutomation.ExtentReport;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
int i = 0;
@Test
public void test1() {
System.out.println("retrying");
i++;
System.out.println("counter i is: "+i);
if (i < 3) {
System.out.println("Failure happened");
Assert.assertTrue(false);
}
else{
System.out.println("passed");
Assert.assertTrue(true);
}
}
}