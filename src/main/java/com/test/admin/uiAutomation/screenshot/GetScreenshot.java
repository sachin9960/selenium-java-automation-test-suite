package com.test.admin.uiAutomation.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {
		public static String capture(WebDriver driver, String screenshotName) throws IOException {
		// TODO Auto-generated method stub
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String dest = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName+ dateName +".png";
		//String dest = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName+ dateName +".mp4";
		File Destination = new File(dest);
		FileUtils.copyFile(source, Destination);
		return dest;
	}

	
}