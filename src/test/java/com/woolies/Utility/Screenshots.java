package com.woolies.Utility;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

public class Screenshots {
	private static Logger LOG = Logger.getLogger(Screenshots.class);
	public static void takeSnapShot(WebDriver driver) {

		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date = new Date();

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(System.getProperty("user.dir") + "\\test-output\\screenshot\\" + "Error-" + dateFormat.format(date) + ".png");
        
		// Copy file at destination
		
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			LOG.error("Exception occurred while copying files");
		}
		

	}

}
