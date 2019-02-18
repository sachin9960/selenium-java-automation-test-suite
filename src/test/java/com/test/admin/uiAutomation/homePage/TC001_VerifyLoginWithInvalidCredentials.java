//package com.test.admin.uiAutomation.homePage;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//
//import org.apache.log4j.Logger;
//import com.test.admin.uiAutomation.testBase.TestBase;
//import com.test.admin.uiAutomation.uiActions.HomePage;
//
//public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
//
//	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
//
//	HomePage homepage;
//
//	@BeforeMethod
//	@Parameters("browser")
//	public void setUp(String browser) {
//		init(browser);
//	}
//
//	@Test
//
//	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
//		test = extent.createTest("login test x5 ", "valid login test.");
//		log.info("================ Starting VerifyLoginWithInvalidCredentials Test ================");
//		homepage = new HomePage(driver);
//		homepage.loginToApplication("balaji@ytel.co.in", "aQ!23456");
//		// Assert.assertEquals(homepage.getInvalidLoginText(),"Username or Password you
//		// entered is incorrect. (Error Code: ER-X5A-L-3)");
//		log.info("================ Finished VerifyLoginWithInvalidCredentials Test ================");
//	}
//
//	@AfterClass
//	public void endTest() {
//		driver.quit();
//	}
//}
