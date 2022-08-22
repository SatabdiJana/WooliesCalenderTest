package com.woolies.TestCase;

import java.time.DayOfWeek;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.woolies.Pages.CalendarPage;
import com.woolies.Utility.DateUtil;
import com.woolies.Utility.Screenshots;

class StandUpMeetTest extends GeneralMeetTest {

	private static Logger LOG = Logger.getLogger(StandUpMeetTest.class);

	@Test(priority = 1)
	public void Test_Calender_Launch() {
		testLaunchCalendar(LOG);
	}

	@Test(priority = 2)
	public void Test_StandUp_Title() {
		testMeetTitle(readConfig.standUpMeetTitle(), LOG);
	}

	@Test(priority = 3)
	public void Test_Set_StandUp_Meet() {
		String[] startTime = readConfig.standUpStartTime().split("\\.");
		String[] endTime = readConfig.standUpEndTime().split("\\.");
		testCalendarConfig(DayOfWeek.MONDAY, startTime[0] ,
				startTime[1], startTime[2], endTime[0],
				endTime[1], endTime[2], LOG);
	}

	@Test(dataProvider = "test-data", priority = 4)
	public void Test_Invite_People_StandUp(String peopleList) {
		invitePeopleForMeet(peopleList, LOG);
	}

	@Test(priority = 5)
	public void Test_Repeat_Meeting_Occurrence_StandUp() {
		setRepeatMeetingOccurrence(LOG);
	}

}
