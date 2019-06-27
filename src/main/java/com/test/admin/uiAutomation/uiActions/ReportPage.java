package com.test.admin.uiAutomation.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.admin.uiAutomation.testBase.TestBase;

public class ReportPage extends TestBase{
	
	public static final Logger log = Logger.getLogger(ReportPage.class.getName());
	
	
	@FindBy(xpath="//*[@id=\"main-menu\"]/li[7]/ul/li[3]/a")
	WebElement reportmenu;
	
	@FindBy(xpath="//*[@id=\"table-1\"]/tbody/tr/td/ul/li[1]/a")
	WebElement inboundreports;
	
	@FindBy(css="#query_date")
	WebElement date;
	
	@FindBy(xpath="//button[@class='btn-primary applyBtn btn btn-small']")
	WebElement apply;
	
	@FindBy(xpath="//select[@id='group']")
	WebElement groups;
	
	@FindBy(css="#submit")
	WebElement submit;
	
	public ReportPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	public void selectgroup()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(reportmenu));
		reportmenu.click();
		System.out.println(driver);
		log.info("clicked on call menu");
	}
	
	public void inboundReport()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(inboundreports));
		inboundreports.click();
		System.out.println(driver);
		log.info("driver is inside inbound reports");
	}

	public void selectDate() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(date));
		date.clear();
		date.click();
		date.sendKeys("2019-06-25,2019-06-25");
		apply.click();
		
	}

	public void selectInboundgroup() {
		Select group = new Select(groups);
		group.selectByValue("TTTTT");
		submit.click();
	}
	
	
}
