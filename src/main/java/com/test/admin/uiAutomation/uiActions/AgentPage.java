package com.test.admin.uiAutomation.uiActions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.test.admin.uiAutomation.testBase.TestBase;

public class AgentPage extends TestBase {
	String Expected_Delivery_Message = "Error Code: ER-X5A-U-3";

	public static final Logger log = Logger.getLogger(AgentPage.class.getName());

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/a")
	WebElement selectagentoption;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/ul/li[1]/a/span")
	WebElement selectagent;

	@FindBy(xpath = "/html/head/title")
	WebElement pagetitle;

	@FindBy(xpath = "//*[@id=\"x5AdminApp\"]/div[1]/div[2]/div[3]/legend/div/a")
	WebElement cloneIcon;

	@FindBy(xpath = "//*[@id=\"user\"]")
	WebElement userid;

	@FindBy(xpath = "//*[@id=\"pass\"]")
	WebElement pass;

	@FindBy(xpath = "//*[@id=\"full_name\"]")
	WebElement fullname;

	@FindBy(xpath = "//*[@id=\"from_id\"]")
	WebElement sourceAgent;

	@FindBy(id = "from_id")
	WebElement formID;

	@FindBy(xpath = "//*[@id=\"modal-7\"]/div/div/div[4]/button[1]")
	WebElement closeCloneframe;

	@FindBy(xpath = "//*[@id=\"modal-7\"]/div/div/div[4]/button[2]")
	WebElement savecloning;

	@FindBy(xpath = "//*[@id=\"sucess\"]/div")
	WebElement cloneDeliveryMessage;

	@FindBy(xpath = "//*[@id=\"modal-7\"]/div/div/div[1]/button")
	WebElement closecloneframe;

	@FindBy(xpath = "//*[@id=\"x5AdminApp\"]/div[1]/div[2]/div[3]/legend")
	WebElement AgentListingHeader;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[1]")
	WebElement Agentidtext;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[2]")
	WebElement name;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[3]")
	WebElement group;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[4]/center")
	WebElement active;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[5]/center")
	WebElement agentstats;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[6]/center")
	WebElement outbound;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[7]/center")
	WebElement inbound;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[8]/center")
	WebElement campaign;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[9]/center")
	WebElement callback;

	@FindBy(xpath = "//*[@id=\"table-1\"]/thead/tr/th[10]/center")
	WebElement modify;

	@FindBy(xpath = "//*[@id=\"table-1_filter\"]/label/input")
	WebElement searchbar;

	@FindBy(id = "table-1")
	WebElement vicitable;

	// @FindBy(xpath="//*[@id='12']/td[10]/a[2]")
	// WebElement dellink;

	@FindBy(className = "sorting_1")
	WebElement tr;

	@FindBy(name = "table-1_length")
	WebElement selALL;

	@FindBy(xpath = "//div[@class='modal-footer']/div/div/button[1]")
	WebElement CANCEL;

	@FindBy(xpath = "//div[@class='modal-footer']/div/div/button[2]")
	WebElement OK;

	// all modify agent locators
	@FindBy(xpath = "//*[@id=\"139\"]/td[10]/a[1]")
	WebElement editAgent;

	@FindBy(id = "pass")
	WebElement MagentPass;

	@FindBy(id = "full_name")
	WebElement MfullName;

	@FindBy(id = "user_group")
	WebElement Musergroup;

	@FindBy(id = "voicemail_id")
	WebElement mVoicemail;

	@FindBy(id = "table-1_wrapper")
	WebElement saveformtable;

	@FindBy(xpath = "//*[@id=\"\"001\"\"]")
	WebElement general;

	@FindBy(id = "save-form")
	WebElement savefForm;

	@FindBy(id = "generic")
	WebElement successAlert;

	@FindBy(id = "agent-login")
	WebElement agent_id;

	@FindBy(id = "agent-password")
	WebElement agent_password;

	// modify agent locators ends here

	// to go to Dashboard
	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[1]/a")
	WebElement dashboard;

	// get campaign

	@FindBy(id = "btn-get-campaign")
	WebElement getCampaign;

	@FindBy(id = "select-campaign")
	WebElement selectCampaing;

	@FindBy(id = "btn-submit")
	WebElement submitBtn;

	public AgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectAgentOption() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(selectagentoption));
		test.log(Status.INFO, "clicked on Agent menu");
		selectagentoption.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectagent));
		selectagent.click();
		test.log(Status.INFO, "clicked on agent ");

	}

	public void clickonCloneAgentIcon() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(cloneIcon));
		cloneIcon.click();
	}

	public String verifyPageTitle() {
		System.out.println(driver);
		return driver.getTitle();

	}

	public void cloneAgent(String userID, String userPass, String fullName, String expected_msg) {
		selectAgentOption();
		clickonCloneAgentIcon();
		cloneUserID(userID);
		clonePassword(userPass);
		cloneFullname(fullName);
		selectSourceAgent();
		clickonsavebutton();
		getDeliveryMessage();
		String actualmsg = getDeliveryMessage();
		verifycloning(actualmsg, expected_msg);
	}

	public void deleteAgent(String agentID) {

		selectAgentOption();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(selALL));
		Select s = new Select(selALL);
		s.selectByVisibleText("All");

		WebElement webtable = vicitable;
		By mysel = By.className("sorting_1");
		List<WebElement> showtablerow = webtable.findElements(mysel);

		// second method of showing list
		for (WebElement tr : showtablerow) {

			System.out.println("id: " + tr.getText());

		}
		Dimension size = tr.getSize();
		System.out.println(size);

		// second method finishes here

		WebElement dellink = driver.findElement(By.xpath("//*[@id='" + agentID + "']/td[10]/a[2]"));

		js.executeScript("arguments[0].scrollIntoView()", dellink);
		System.out.println(dellink);
		dellink.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.textToBePresentInElement(OK, "OK"));
		OK.getText();
		System.out.println("shown : " + OK.getText());
		CANCEL.click();

	}

	// this is for modify agent
	public void ModifyAgent(String pass2, String Name2, String vmnum, String expected_msg) {

		clickOnModifyAgentButton();
		mPass(pass2);
		mFullname(Name2);
		clickonVoicemailbu(vmnum);
		clickonSaveform();
		String successm = getAlrtmsg().toString();
		verifycloning(successm, expected_msg);

		verifychangesforAgent(pass2, Name2, vmnum, expected_msg);

	}

	private void verifychangesforAgent(String pass2, String name2, String vmnum, String expected_msg) {
		gotoDashboard();
		selectAgentOption();
		clickOnModifyAgentButton();
		String agentPasstxt = MagentPass.getAttribute("value").toString();
		String agentFullnametxt = MfullName.getAttribute("value").toString();
		String voiceMailtxt = mVoicemail.getAttribute("value").toString();

		System.out.println(agentPasstxt);
		System.out.println(agentFullnametxt);
		System.out.println(voiceMailtxt);

		verifycloning(pass2, agentPasstxt);
		verifycloning(name2, agentFullnametxt);
		verifycloning(vmnum, voiceMailtxt);

	}

	public void gotoDashboard() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		dashboard.click();
	}

	public String getAlrtmsg() {
		return successAlert.getText();
	}

	public void clickonSaveform() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(savefForm));
		savefForm.click();
	}

	public void clickonVoicemailbu(String vmnum) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(mVoicemail));
		mVoicemail.clear();
		mVoicemail.sendKeys(vmnum);
	}

	public void mFullname(String Name) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(MfullName));
		MfullName.clear();
		MfullName.sendKeys(Name);
	}

	public void mPass(String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(MagentPass));
		MagentPass.clear();
		MagentPass.sendKeys(pass);
	}

	public void clickOnModifyAgentButton() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(editAgent));
		editAgent.click();
	}

	// modify agent ends here

	public void searchbar(String agentID) {
		searchbar.click();
		searchbar.sendKeys(agentID);
	}

	public void verifycloning(String actualmsg, String expected_msg) {

		Assert.assertTrue(actualmsg.contains(expected_msg), "\n Error message was not correct." + " \n Expected was : "
				+ expected_msg + " \n but found : " + actualmsg + "\n");

	}

	public String getDeliveryMessage() {
		return cloneDeliveryMessage.getText();
	}

	public void selectSourceAgent() {
		sourceAgent.click();
		Select sourceagent = new Select(formID);
		sourceagent.selectByVisibleText("0405 - Kiran Gaikwad");;
	}

	public void CloseCloneFrame() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(closecloneframe));
		closecloneframe.click();
	}

	public void cloneUserID(String userID) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(userid));
		userid.sendKeys(userID);
	}

	public void clonePassword(String userPass) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(pass));
		pass.sendKeys(userPass);
	}

	public void cloneFullname(String fullName) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(fullname));
		fullname.sendKeys(fullName);
		;
	}

	public void clickonsavebutton() {
		savecloning.click();
	}

	public WebElement CloseCloneframe() {
		return closecloneframe;
	}

	// below are headers - ignore

	public WebElement AgentlistingHeader() {
		return AgentListingHeader;
	}

	public WebElement AgentIDText() {
		return Agentidtext;
	}

	public WebElement Name() {
		return name;
	}

	public WebElement Group() {
		return group;
	}

	public WebElement Active() {
		return active;
	}

	public WebElement AgentStats() {
		return agentstats;
	}

	public WebElement Outbound() {
		return outbound;
	}

	public WebElement Inbound() {
		return inbound;
	}

	public WebElement Campaign() {
		return campaign;
	}

	public WebElement Callback() {
		return callback;
	}

	public WebElement Modify() {
		return modify;
	}// headers ends here

	public void logintoAgentSide(String s, String pass, String url) throws InterruptedException {
		// js code to open new tab
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("function createDoc(){var w = window.open(); }; createDoc();"); // code end
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs2.size());
		driver.switchTo().window(tabs2.get(1));
		driver.get(url);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.switchTo().frame("ytel-frame");
		driver.findElement(By.id("login-agent")).click();

		enterAgentID(s);
		enterPassword(pass);
		clickon_get_campaign();
		clickon_select_campaign();
		Select list = new Select(selectCampaing);
		list.selectByValue("moh_camp");
		clickon_submitbtn();
	}

	public void clickon_submitbtn() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
	}

	public void clickon_select_campaign() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(selectCampaing));
		// selectCampaing.click();
		Select list = new Select(selectCampaing);
		list.selectByValue("moh_camp");
	}

	public void clickon_get_campaign() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(getCampaign));
		getCampaign.click();
	}

	public void enterPassword(String agent_passord) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(agent_password));
		agent_password.sendKeys(agent_passord);
	}

	public void enterAgentID(String user_id) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(agent_id));
		agent_id.sendKeys(user_id);
	}

}
