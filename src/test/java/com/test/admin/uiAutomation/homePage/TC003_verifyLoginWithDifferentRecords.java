//package com.test.admin.uiAutomation.homePage;
//
//import static org.testng.Assert.assertTrue;
//
//import java.io.IOException;
//
//import org.apache.log4j.Logger;
//import org.testng.SkipException;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.test.admin.uiAutomation.testBase.TestBase;
//import com.test.admin.uiAutomation.uiActions.HomePage;
//
//public class TC003_verifyLoginWithDifferentRecords extends TestBase {
//
//	public static final Logger log = Logger.getLogger(TC003_verifyLoginWithDifferentRecords.class.getName());
//
//	HomePage homepage;
//
//	String pageTitle = "DashboarR : Ytel";
//
//	// data provider : take value from excel sheet located in
//	// com.test.admin.uiAutomation.data package
//	@DataProvider(name = "loginData")
//	public String[][] getTestDatafromExcelFile() {
//		String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
//		return testRecords;
//	}
//
//	@BeforeMethod
//	@Parameters("browser")
//	public void setUp(String browser) {
//		init(browser);
//		homepage = new HomePage(driver);
//	}
//
//	@Test(dataProvider = "loginData")
//	public void testLogin(String emailAddress, String loginPassword, String runMode) throws InterruptedException, IOException {
//
//		test = extent.createTest("test login",
//				"using records: " + "--email address:-- " + emailAddress + " and--password:--" + loginPassword);
//		if (runMode.equalsIgnoreCase("n")) {
//
//			throw new SkipException("you have have marked this option as No in excel file");
//		}
//		log.info("==============STARTING TC003_verifyLoginWithDifferentRecords TEST CASE ======");
//
//		homepage = new HomePage(driver);
//		homepage.loginToApplication(emailAddress, loginPassword);
//		Thread.sleep(1000);
//		homepage.loginErrorDisplayed();
//
//		homepage.verifyTitle(); // this will verify title of your page
//		assertTrue(homepage.verifyTitle().contains(pageTitle));
//		homepage.selectDatabase();
//		test.fail("details").addScreenCaptureFromPath("screenshot.png");
//		
//		log.info("page title verified " + pageTitle);
//
//		log.info("============== FINISHED TC003_verifyLoginWithDifferentRecords TEST CASE ======");
//
//	}
//
//	@AfterMethod
//	public void endTest() {
//		driver.close();
//
//	}
//}
