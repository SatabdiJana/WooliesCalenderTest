package com.woolies.TestCase;

import java.time.DayOfWeek;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.woolies.Pages.CalendarPage;
import com.woolies.Utility.DateUtil;
import com.woolies.Utility.Screenshots;

class WorkshopMeetTest extends GeneralMeetTest {

	private static Logger LOG = Logger.getLogger(WorkshopMeetTest.class);

	@Test(priority = 1)
	public void Test_Calender_Launch() {
		testLaunchCalendar(LOG);
	}

	@Test(priority = 2)
	public void Test_WorkShop_Title() {
		testMeetTitle(readConfig.workshopTitle(), LOG);
	}

	@Test(priority = 3)
	public void Test_Set_FridayMeet() {
		String[] startTime = readConfig.workShopStartTime().split("\\.");
		String[] endTime = readConfig.workShopEndTime().split("\\.");
		testCalendarConfig(DayOfWeek.FRIDAY, startTime[0] ,
				startTime[1], startTime[2], endTime[0],
				endTime[1], endTime[2], LOG);
	}

	@Test(dataProvider = "test-data", priority = 4)
	public void Test_Invite_People(String peopleList) {
		invitePeopleForMeet(peopleList, LOG);
	}

	@Test(priority = 5)
	public void Test_Repeat_Meeting_Occurrence() {
		setRepeatMeetingOccurrence(LOG);
	}
}
