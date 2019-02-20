package com.test.admin.uiAutomation.uiActions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.admin.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase {

	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	// page object model with page factory

	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement signIn;

	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement loginEmailAddress;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement loginPassword;

	@FindBy(xpath = "//*[@id=\"termsckbox\"]")
	WebElement checkBox;

	@FindBy(id = "login")
	WebElement submitButton;

	@FindBy(xpath = "//div[@class='login-form']/div/form/div[@id=\"showerror\"]")
	WebElement loginError;

	// Home page
	@FindBy(xpath = "/html/head/title")
	WebElement pageTitle;

	// pop up timezone window
	@FindBy(xpath = "//*[@id=\"x5AdminApp\"]/div[2]/div[3]/div/button[2]")
	WebElement popUp;

	// minimize Chat Window 
	@FindBy(xpath="//*[@id='x5AdminApp']/div[5]/div[1]/div[1]/a[4]/span[1]")
	WebElement minimizeAgentchat;
	
	@FindBy(xpath="//*[@id=\"x5AdminApp\"]/div[5]/div[1]/div/a[1]/span")
	WebElement collapseAgentchat;
	
	
	@FindBy(xpath = "//*[@id=\"x5AdminApp\"]/div[2]/div[3]/div/button[2]")
	WebElement ignoreButton;

	@FindBy(xpath = "//*[@id=\"realtime_content\"]/div[3]/div[1]/div/h3")
	WebElement agentLoggedIn;

	@FindBy(xpath = "//*[@id=\"realtime_content\"]/div[3]/div[1]/div/div/font")
	WebElement AgentLoggedInCount;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[2]/div[1]/h3")
	WebElement AgentsInCall;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[2]/div[1]/div[1]")
	WebElement AgentsInCallCount;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[3]/div[1]/h3")
	WebElement AvailableAgents;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[3]/div/div[1]")
	WebElement AvailableAgentsCount;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[4]/div/h3")
	WebElement AgentOnPause;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[4]/div/div[1]")
	WebElement AgentOnPauseCount;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[5]/div[1]/h3")
	WebElement DeadAgents;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[5]/div[1]/div[1]")
	WebElement DeadAgentsCounts;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[6]/div[1]/h3")
	WebElement AgentsInDispo;

	@FindBy(xpath = "//html//span[@id='realtime_content']/div[@class='row']/div[6]/div[1]/div")
	WebElement AgentsInDispoCount;
	
	@FindBy(xpath = "//*[@id=\"x5AdminApp\"]/div[1]/div[2]/div[2]/div/div[1]/ul[2]/li/a/i")
	WebElement SelectDatabase;
	
	@FindBy(xpath = "//*[@id=\"x5AdminApp\"]/div[1]/div[2]/div[2]/div/div[1]/ul[2]/li/ul/li/ul/li[2]/a")
	WebElement goodsellTestserver;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void setemailAddress(String emailAddress)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(loginEmailAddress));
		loginEmailAddress.sendKeys(emailAddress);
		
	}
	
	public void setPassword(String password)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(loginPassword));
		loginPassword.sendKeys(password);
	}
	
	public void clickOnCheckBox()
	{
		checkBox.click();
	}
	
	public void clickonSubmitButton()
	{
		submitButton.click();
	}
	
	public void hideChatWindow()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(minimizeAgentchat));
		minimizeAgentchat.click();
	}
	
	public void selectDataBase()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(SelectDatabase));
		SelectDatabase.click();		
		String database=goodsellTestserver.getText();
		assertTrue(database.contains("goodsell test server (goodsell.ytel.com )"));
		goodsellTestserver.click();
	}
		
	public void logintoapp(String emailAddress, String password) 
	{
		setemailAddress(emailAddress);
		setPassword(password);
		clickOnCheckBox();
		clickonSubmitButton();
		hideChatWindow();
		selectDataBase();		
		
	}

	// if login fails this will throw login error

	public WebElement loginErrorDisplayed() throws IOException {

		if (loginError.isDisplayed()) {

			log.info("login failed due to following reason: email id or password is invalid");
			

		} else {
			log.info("logged in successfully");

		}
		return loginError;

	}

	// this will verify title

	public String verifyTitle() {

		return driver.getTitle();
	}

	// this will disable timezone pop up on
	
//	
//	public void disabletimeZone() {
//		if (popUp.isDisplayed()) {
//			ignoreButton.click();
//			log.info("clicked on ignore now button ");
//		} else {
//			System.out.println("pop up windows not visible");
//		}
//	}

	
	

//	public void agentLoggedInText() {
//
//		log.info(agentLoggedIn.getText() + ":" + AgentLoggedInCount.getText());
//
//	}
//
//	public void agentInCalls() {
//
//		log.info(AgentsInCall.getText() + ":" + AgentsInCallCount.getText());
//	}
//
//	public void AvailableAgents() {
//
//		log.info(AvailableAgents.getText() + ":" + AvailableAgentsCount.getText());
//	}
//
//	public void AgentsOnPause() {
//
//		log.info(AgentOnPause.getText() + ":" + AgentOnPauseCount.getText());
//	}
//
//	public void DeadAgents() {
//		log.info(DeadAgents.getText() + ":" + DeadAgentsCounts.getText());
//	}
//
//	public void AgentsInDispo() {
//		log.info(AgentsInDispo.getText() + ":" + AgentsInDispoCount.getText());
//	}

}
