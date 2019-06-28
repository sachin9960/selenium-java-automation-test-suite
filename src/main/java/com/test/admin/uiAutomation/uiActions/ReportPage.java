package com.test.admin.uiAutomation.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.admin.uiAutomation.testBase.TestBase;

public class ReportPage extends TestBase {

	public static final Logger log = Logger.getLogger(ReportPage.class.getName());

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[7]/ul/li[3]/a")
	WebElement reportmenu;

	@FindBy(xpath = "//*[@id=\"table-1\"]/tbody/tr/td/ul/li[1]/a")
	WebElement inboundreports;

	@FindBy(css = "#query_date")
	WebElement date;

	@FindBy(xpath = "//button[@class='btn-primary applyBtn btn btn-small']")
	WebElement apply;

	@FindBy(xpath = "//select[@id='group']")
	WebElement groups;

	@FindBy(css = "#submit")
	WebElement submit;

	@FindBy(xpath = "//table[@id='campaignwisetable']/thead//tr//td[4]")
	WebElement columnvalue;

	// this works for drop% - //table[@id='campaignwisetable']/thead//tr//td[4]

	public ReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectgroup() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(reportmenu));
		reportmenu.click();
		System.out.println(driver);
		log.info("clicked on call menu");
	}

	public void inboundReport() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(inboundreports));
		inboundreports.click();
		System.out.println(driver);
		log.info("driver is inside inbound reports");
	}

	public void selectDate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(date));
		date.clear();
		date.click();
		date.sendKeys("2019-06-01,2019-06-25");
		apply.click();
		submit.click();
		Thread.sleep(3000);
	}

	public void selectInboundgroup() {
		Select group = new Select(groups);
		group.selectByValue("TTTTT");

	}

	public void getTableValues() {
		String total = "'totalcallist table table-bordered datatable dataTable'";
		tableMultigroup(total); // table multi-group breakdown // total
		String drop = "'dropcalllist table table-bordered datatable dataTable'";
		tableMultigroup(drop); // table drop

		String customIndicators = "'customindicatorlist table table-bordered datatable dataTable'";
		tableMultigroup(customIndicators);

		String queueStats = "'queuestats table table-bordered dataTable dataTable'";
		tableMultigroup(queueStats);

		String callStatusStat = "'callstatustable'";
		tableMultigroupbyID(callStatusStat);
	}

	public void tableMultigroup(String cl) {
// if class is defined for the table then use this method to fetch values
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class=" + cl + "]/tbody//tr"));
		int rowcount = rows.size();

		List<WebElement> col = driver.findElements(By.xpath("//table[@class=" + cl + "]/tbody//tr[1]//td"));
		int colcount = col.size();

		System.out.println("-----------------------printing table started------------------------------");
		for (int count = 1; count <= rowcount; count++) {

			for (int r = 1; r <= colcount; r++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@class=" + cl + "]/tbody//tr[" + count + "]//td[" + r + "]"))
						.getText());
			}
			System.out.println("");
		}
		System.out.println("------------------------printing table completed-------------------------");
	}

	public void tableMultigroupbyID(String id) {
		// if ID is defined for the table then use this method to fetch values
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id=" + id + "]/tbody//tr"));
		int rowcount = rows.size();

		List<WebElement> col = driver.findElements(By.xpath("//table[@id=" + id + "]/tbody//tr[1]//td"));
		int colcount = col.size();

		System.out.println("-----------------------printing table started------------------------------");
		for (int count = 1; count <= rowcount; count++) {

			for (int r = 1; r <= colcount; r++) {
				System.out.print(
						driver.findElement(By.xpath("//table[@id=" + id + "]/tbody//tr[" + count + "]//td[" + r + "]"))
								.getText());
			}
			System.out.println("");
		}
		System.out.println("------------------------printing table completed-------------------------");
	}

}
