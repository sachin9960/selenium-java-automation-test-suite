//package com.test.admin.uiAutomation.homePage;
//import static org.junit.Assert.assertFalse;
//
//import org.apache.log4j.Logger;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.test.admin.uiAutomation.testBase.TestBase;
//import com.test.admin.uiAutomation.uiActions.HomePage;
//import com.test.admin.uiAutomation.uiActions.ReportPage;
//
//
//public class TC006_verifyReport extends TestBase {
//	public static final Logger log = Logger.getLogger(TC004_CheckCallStatus.class.getName());
//	HomePage homepage;
//	ReportPage reportpage;
//	@BeforeMethod
//	@Parameters("browser")
//	
//	public void setUp(String browser) {
//		init(browser);
//		homepage = new HomePage(driver);
//		reportpage = new ReportPage(driver);
//	}
//
//	@Test
//	public void testStatus() throws Exception {
//		test = extent.createTest("verify reports", "inbound reports");
//		homepage = new HomePage(driver);
//		
//		homepage.loginToApplication("goodsell", "!goodsell_Playhouse?");
//		homepage.selectDatabase();
//		reportpage.selectgroup();
//		reportpage.inboundReport();
//		String s = "sachin";
//		assertFalse(s.contains("sach"));
//	}
//
//}
