package com.test.admin.uiAutomation.Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	int retryLimit = 1;
	/*
	* This method decides how many times a test needs to be rerun.
	* TestNg will call this method every time a test fails. So we
	* can put some code in here to decide when to rerun the test.
	*
	* Note: This method will return true if a tests needs to be retried
	* and false it not.
	*
	*/

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter < retryLimit)
		{
		counter++;
		return true;
		}
		return false;
	}
	
	
	
	
	

}
