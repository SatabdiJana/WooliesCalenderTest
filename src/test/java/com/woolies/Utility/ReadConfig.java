package com.woolies.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {

	private static Logger log = Logger.getLogger(ReadConfig.class);
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			log.error("Exception is" + e.getMessage());
		}
	}

	public String getPlatformName() {
		return pro.getProperty("PlatformName");
	}

	public String getDeviceName() {
		return pro.getProperty("DEVICENAME");
	}

	public String getAppPackageName() {
		return pro.getProperty("appPackage");
	}

	public String appActivityName() {
		return pro.getProperty("APPACTIVITY");
	}

	public String driverUrl() {
		return pro.getProperty("DriverUrl");
	}

	public String WorkshopTitle() {
		return pro.getProperty("WorkshopTitle");
	}

	public String workShopDay() {
		return pro.getProperty("WorkShopDay");
	}

	public String workShopStartTime() {
		return pro.getProperty("WorkShopStartTime");
	}

	public String workShopEndTime() {
		return pro.getProperty("WorkShopEndTime");
	}
}
