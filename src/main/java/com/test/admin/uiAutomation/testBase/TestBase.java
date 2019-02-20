package com.test.admin.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.admin.uiAutomation.ExtentReport.ExtentReportBase;
import com.test.admin.uiAutomation.excelReader.Excel_Reader;

public class TestBase extends ExtentReportBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	
	String url = "http://x5admin-preprod.ytel.com";

	Excel_Reader excel;

	public void init(String browser) {
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	private void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
			log.info("creating object of " + browser);
			driver = new FirefoxDriver();
			driver.manage().window().setPosition(new Point(2000, 10));

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			log.info("creating object of " + browser);
			driver = new ChromeDriver();
			driver.manage().window().setPosition(new Point(2000, 10));

		}
	}

	private void getUrl(String url) {
		log.info("navigating to site url : " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		log.info("browser is waiting for the page to load ");
	}

	public String[][] getData(String excelName, String sheetName) {

		String path = System.getProperty("user.dir") + "/src/main/java/com/test/admin/uiAutomation/data/" + excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

}
