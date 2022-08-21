package com.woolies.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {

	private static Logger log = Logger.getLogger(ReadConfig.class);
	private Properties properties;

	public ReadConfig() {
		try {
			File src = new File("./Configurations\\config.properties");
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			log.error("Exception is" + e.getMessage());
		}
	}

	public String getPlatformName() {
		return properties.getProperty("PlatformName");
	}

	public String getDeviceName() {
		return properties.getProperty("DEVICENAME");
	}

	public String getAppPackageName() {
		return properties.getProperty("appPackage");
	}

	public String appActivityName() {
		return properties.getProperty("APPACTIVITY");
	}

	public String driverUrl() {
		return properties.getProperty("DriverUrl");
	}

	public String workshopTitle() {
		return properties.getProperty("WorkshopTitle");
	}

	public String workShopDay() {
		return properties.getProperty("WorkShopDay");
	}

	public String workShopStartTime() {
		return properties.getProperty("WorkShopStartTime");
	}

	public String workShopEndTime() {
		return properties.getProperty("WorkShopEndTime");
	}
	
	public String standUpMeetTitle() {
		return properties.getProperty("StandUpTitle");
	}
	
	public String standUpStartTime() {
		return properties.getProperty("StandUpStartTime");
	}

	public String standUpEndTime() {
		return properties.getProperty("StandUpEndTime");
	}
}
