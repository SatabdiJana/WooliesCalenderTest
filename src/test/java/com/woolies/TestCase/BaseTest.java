package com.woolies.TestCase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.woolies.Pages.CalendarPage;
import com.woolies.Utility.ReadConfig;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

	public WebDriver driver;
	public CalendarPage calendarPage;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	private ReadConfig readConfig = new ReadConfig();
	private String platformName = readConfig.getPlatformName();
	private String deviceName = readConfig.getDeviceName();
	private String appPackageName = readConfig.getAppPackageName();
	private String appActivityName = readConfig.appActivityName();
	private String driverURL = readConfig.driverUrl();
	protected String workshopTitle = readConfig.WorkshopTitle();
 
	@DataProvider(name = "test-data")
	public static Object[] invitePeopleList() {

		ArrayList<String> peopleList = new ArrayList<String>();
		peopleList.add("Satabdi");
		return peopleList.toArray();

	}

	@BeforeClass
	public void setup() throws InterruptedException {

		try {

			// Set up desired capabilities and pass the Android app-activity and app-package
			// to Appium

			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability("appPackage", appPackageName);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivityName);

			driver = new RemoteWebDriver(new URL(driverURL), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		calendarPage = new CalendarPage(driver);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	protected void setTime(String hours, String minutes, boolean anteMeridiem) {
		calendarPage.getHoursOrMinuteElement(hours).click();
		calendarPage.getHoursOrMinuteElement(minutes).click();

		if (anteMeridiem) {
			calendarPage.getMeridiemAMElement().click();
		} else {
			calendarPage.getMeridiemPMElement().click();
		}

		calendarPage.getButtonOKOnMonthElement().click();
	}	
}
