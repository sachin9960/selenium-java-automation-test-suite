package com.test.admin.uiAutomation.homePage;

import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.admin.uiAutomation.testBase.TestBase;
import com.test.admin.uiAutomation.uiActions.AgentPage;
import com.test.admin.uiAutomation.uiActions.HomePage;

public class TC007_agentPage extends TestBase {

	public static final Logger log = Logger.getLogger(TC007_agentPage.class.getName());
	HomePage homepage;
	AgentPage agentpage;
	String pagetitle = "User : Index : Ytel";
	String Agent_Page_Title = "User : Index : Ytel";
	String Expected_Delivery_Message = "Error Code: ER-X5A-U-3";
	String with_Letters_error_code = "Error Code: ER-X5A-U-2";
	String Empty_Agent_ID_error_code = "Error Code: ER-X5A-U-1";
	String Empty_password_error_code = "Error Code: ER-X5A-U-5";
	String Password_invalid_error_code = "Error Code: ER-X5A-U-12";
	String Password_with_one_letter_error_code = "Error Code: ER-X5A-U-6";
	String Full_name_only_one_letter_error_code = "Error Code: ER-X5A-U-8";
	String successfull_clone_message = "Agent ID cloned successfully";
	String expectedmsg = "Record successfully modified.";

	@BeforeMethod
	@Parameters("browser")

	public void setUp(String browser) {
		init(browser);
		homepage = new HomePage(driver);
		agentpage = new AgentPage(driver);

	}

	@Test(enabled = false)
	public void agent_create_delete_modify() throws InterruptedException {
		test = extent.createTest("Clone Agent  Test Case 0", "Create an agent");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		String s = Integer.toString(n);
		homepage.logintoapp("userid", "password");
		agentpage.cloneAgent(s, "password", "automation", successfull_clone_message);
		agentpage.CloseCloneFrame();
	
		//agentpage.deleteAgent("274");
			
		//modify agent
		String str = "pass" + rnd.nextInt(900);
		String[] ranSel = { "0405", "1001", "1234", "2020", "2234", "5001", "9960", "001", "6060", "9798" };
		int random = rnd.nextInt((11 - 1) + 1) + 0;
		String vmnum = ranSel[random];
		agentpage.ModifyAgent(str, str, vmnum, expectedmsg);
		String url = "https://goodsell.ytel.com/";
		agentpage.logintoAgentSide(s, "password", url);

	}

	@Test(enabled = true)
	public void Clone_Agent_With_3_Digits() {
		test = extent.createTest("Clone Agent  Test Case 1", " Test with Agent ID containing Minimum 3 Digits ");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("987", "password", "qweeert", Expected_Delivery_Message);
		agentpage.CloseCloneFrame();
	}

	@Test(enabled = false)
	public void Clone_Agent_With_8_Digits() {
		test = extent.createTest("Clone Agent Test Case 2", " Test with Agent ID containing more then 7 Digits ");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("999999999", "password", "qweeert", Expected_Delivery_Message);

	}

	@Test(enabled = false)
	public void Clone_Agent_With_Letters() {
		test = extent.createTest("Clone Agent Test Case 3", " Test with Agent ID containing only letters ");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("abcdef", "password", "qweeert", with_Letters_error_code);
	}

	@Test(enabled = false)
	public void Clone_Agent_With_Empty_AgentID() {
		test = extent.createTest("Clone Agent Test Case 4", " Test with Empty Agent ID");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("", "password", "qweeert", Empty_Agent_ID_error_code);

	}

	@Test(enabled = false)
	public void Clone_Agent_Invalid_Password() {
		test = extent.createTest("Clone Agent Test Case 5", " Test with Invalid Password");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("7894345", "@#$%&", "qweeert", Password_invalid_error_code);

	}

	@Test(enabled = false)
	public void Clone_Agent_oneLetter_Password() {
		test = extent.createTest("Clone Agent Test Case 6", " Test with only one letter Password");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("7894345", "a", "qweeert", Password_with_one_letter_error_code);

	}

	@Test(enabled = false)
	public void Clone_Agent_empty_Password() {
		test = extent.createTest("Clone Agent Test Case 7", " Test with empty Password");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("7894345", "", "qweeert", Empty_password_error_code);
	}

	@Test(enabled = false)
	public void Clone_Agent_Full_name() {
		test = extent.createTest("Clone Agent Test Case 8", " Test with Full Name only one letter");
		test.assignCategory("Regression Test");
		homepage = new HomePage(driver);
		homepage.logintoapp("goodsell", "!goodsell_Playhouse?");
		agentpage.cloneAgent("7894345", "password", "v", Full_name_only_one_letter_error_code);
	}

	// @Test(enabled=true)
	// public void Header_test() throws Exception {
	// test = extent.createTest("Clone Agent Test Case 7", " Test with Full Name
	// only one letter");
	// test.assignCategory("Regression Test");
	// homepage = new HomePage(driver);
	// test.log(Status.INFO, "Logging to X5 Contact Center");
	// homepage.loginToApplication("goodsell", "!goodsell_Playhouse?");
	// test.log(Status.INFO, "Hiding Chat Window ");
	// homepage.hidechatwindow().click();
	// test.log(Status.INFO, "Selecting Database");
	// homepage.selectDatabase();
	// test.log(Status.INFO, "Clicked on Agent Clone Button");
	// agentpage.selectAgentOption();
	// String s = agentpage.verifyPageTitle();
	// test.log(Status.INFO, "Title of the page is : " + s);
	// if (agentpage.AgentlistingHeader().getText().equals("Agents Listing")
	// && agentpage.AgentIDText().getText().equals("Agent ID") &&
	// agentpage.Name().getText().equals("Nam")
	// && agentpage.Group().getText().equals("Group") &&
	// agentpage.Active().getText().equals("Active")
	// && agentpage.AgentStats().getText().equals("Agent Stats")
	// && agentpage.Outbound().getText().equals("Outbound") &&
	// agentpage.Inbound().getText().equals("Inbound")
	// && agentpage.Campaign().getText().equals("Campaign")
	// && agentpage.Callback().getText().equals("CallBack") &&
	// agentpage.Modify().getText().equals("Modify")) {
	// test.log(Status.INFO, "header 1 is : " +
	// agentpage.AgentlistingHeader().getText());
	// test.log(Status.INFO, "header 2 is : " + agentpage.Name().getText());
	// test.log(Status.INFO, "header 3 is : " + agentpage.Group().getText());
	// test.log(Status.INFO, "header 4 is : " + agentpage.Active().getText());
	// test.log(Status.INFO, "header 5 is : " + agentpage.AgentStats().getText());
	// test.log(Status.INFO, "header 6 is : " + agentpage.Outbound().getText());
	// test.log(Status.INFO, "header 7 is : " + agentpage.Inbound().getText());
	// test.log(Status.INFO, "header 8 is : " + agentpage.Campaign().getText());
	// test.log(Status.INFO, "header 9 is : " + agentpage.Callback().getText());
	// test.log(Status.INFO, "header 10 is : " + agentpage.Modify().getText());
	// assertfalse(false);
	// } else {
	// test.log(Status.INFO, "header 1 is : " +
	// agentpage.AgentlistingHeader().getText());
	// test.log(Status.INFO, "header 2 is : " + agentpage.Name().getText());
	// test.log(Status.INFO, "header 3 is : " + agentpage.Group().getText());
	// test.log(Status.INFO, "header 4 is : " + agentpage.Active().getText());
	// test.log(Status.INFO, "header 5 is : " + agentpage.AgentStats().getText());
	// test.log(Status.INFO, "header 6 is : " + agentpage.Outbound().getText());
	// test.log(Status.INFO, "header 7 is : " + agentpage.Inbound().getText());
	// test.log(Status.INFO, "header 8 is : " + agentpage.Campaign().getText());
	// test.log(Status.INFO, "header 9 is : " + agentpage.Callback().getText());
	// test.log(Status.INFO, "header 10 is : " + agentpage.Modify().getText());
	// assertFalse(false);
	// }
	// }

	@AfterMethod
	public void endTest() {

	}

}
