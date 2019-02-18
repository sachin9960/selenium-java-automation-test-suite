package com.test.admin.uiAutomation.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.admin.uiAutomation.screenshot.GetScreenshot;



public class ExtentReportBase {
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	

		
	@BeforeSuite
	public void setUpExtentReport() {
		// alternate location to save report :
		// System.getProperty("user.dir")+"/test-output/report.html

		htmlReporter = new ExtentHtmlReporter("/home/amit/eclipse-workspace/ContactCenter/test-output/ccreport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Linux");
		extent.setSystemInfo("Host Name", "xoyal");
		extent.setSystemInfo("Environment", "dev");
		extent.setSystemInfo("Java Version", "1.8");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		htmlReporter.config().setReportName("My Own Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		
	}
		

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			System.out.println(driver+"just checking");
		//String screenShotPath = GetScreenShot.capture(driver,"screenShotName");
			String screenshotPath = GetScreenshot.capture(driver,"screenshotForExtentReport");
			test.fail(result.getThrowable());
			test.log(Status.FAIL, "screenshot below : "+ test.addScreenCaptureFromPath(screenshotPath));

					
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			String screenshotPath1 = GetScreenshot.capture(driver,"screenshotForExtentReport");
			test.log(Status.PASS, "screenshot below : "+ test.addScreenCaptureFromPath(screenshotPath1));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		//driver.quit();
	}
	
	
	}
