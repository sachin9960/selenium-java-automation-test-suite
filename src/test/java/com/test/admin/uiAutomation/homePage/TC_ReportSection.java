package com.test.admin.uiAutomation.homePage;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.admin.uiAutomation.testBase.TestBase;
import com.test.admin.uiAutomation.uiActions.AgentPage;
import com.test.admin.uiAutomation.uiActions.HomePage;
import com.test.admin.uiAutomation.uiActions.ReportPage;

public class TC_ReportSection extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC007_agentPage.class.getName());
	
	HomePage homepage;
	ReportPage reportpage;
	
	@BeforeMethod
	@Parameters("browser")

	public void setUp(String browser) {
		init(browser);
		homepage = new HomePage(driver);
		reportpage = new ReportPage(driver);
	

	}
	
	
	@Test(enabled = true)
	public void Clone_Agent_With_Empty_AgentID() {
		test = extent.createTest("Report Test", " Inbound Report Test");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell@ytel.com", "!goodsell_Playhouse?");
		reportpage = new ReportPage(driver);
		reportpage.selectgroup();
		reportpage.inboundReport();
		reportpage.selectDate();
		reportpage.selectInboundgroup();

	}
	
	
	

}
