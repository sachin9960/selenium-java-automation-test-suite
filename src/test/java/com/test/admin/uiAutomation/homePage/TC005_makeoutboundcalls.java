//package com.test.admin.uiAutomation.homePage;
//
//import org.apache.log4j.Logger;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.test.admin.uiAutomation.testBase.TestBase;
//import com.test.admin.uiAutomation.uiActions.HomePage;
//
//public class TC005_makeoutboundcalls extends TestBase{
//	
//	public static final Logger log = Logger.getLogger(TC004_CheckCallStatus.class.getName());
//	HomePage homepage;
//	@BeforeMethod
//	@Parameters("browser")
//	public void setUp(String browser) {
//		init(browser);
//		homepage = new HomePage(driver);
//	}
//
//	@Test
//	public void testStatus() throws Exception {
//		test = extent.createTest("make outbound calls", "this will make outbound calls");
//		homepage = new HomePage(driver);
//		
//		homepage.loginToApplication("balaji@ytel.co.in", "aQ!23456");
//		homepage.selectDatabase();
//		//homepage.HideAgentChat();
//		try {	
//		homepage.agentLoggedInText();
//		homepage.agentInCalls();
//		homepage.AvailableAgents();
//		homepage.AgentsOnPause();
//		homepage.DeadAgents();
//		homepage.AgentsInDispo();		
//		} catch (Exception e) {			
//			log.info("no agent logged in");
//			}			
//	}
//	@AfterMethod
//	public void endTest() {
//		driver.close();
//	}
//}
