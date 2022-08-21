package com.woolies.TestCase;

import java.time.DayOfWeek;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.woolies.Utility.DateUtil;
import com.woolies.Utility.Screenshots;

public class GeneralMeetTest extends BaseTest {
	
	protected void testLaunchCalendar(Logger log) {
		try {
			WebElement nextPageEle = calendarPage.getNextPageElement();
			for (int index = 0; index < 3; ++index) {
				nextPageEle.click();
			}
			calendarPage.getGotItElement().click();
			log.debug(calendarPage.getCalenderListElement().getText());
			Assert.assertNotNull(calendarPage.getCalenderListElement());
		} catch (Exception e) {
			log.error("Calender Launch Failed");
			Screenshots.takeSnapShot(driver);
		}		
	}
	
	protected void testMeetTitle(String meetTitle, Logger log) {
		try {
			calendarPage.getCreateNewEventElement().click();
			calendarPage.getSelectNewEventElement().click();
			calendarPage.getTitleElement().sendKeys(meetTitle);
			Assert.assertTrue(calendarPage.getTitleElement().isDisplayed());
		} catch (Exception e) {
			log.error("Enter worskshop Title Failed");
			Screenshots.takeSnapShot(driver);
		}		
	}
	
	protected void testCalendarConfig(DayOfWeek dayOfWeek, String startHour,
			String startMinutes, String startMeridiem, String endHour,
			String endMinutes, String endMeridiem, Logger log) {
		try {
			calendarPage.getStartDateElement().click();
			if (!DateUtil.isGivenDayWithInThisMonth(dayOfWeek)) {
				log.debug("Move Next Month");
				calendarPage.getNextMonthElement().click();
			}
			log.debug("Set " + dayOfWeek.name());
			calendarPage.getMeetStartDateElement(dayOfWeek).click();
			calendarPage.getButtonOKOnMonthElement().click();
			log.debug("Set " + startHour + ":" + startMinutes + startMeridiem );
			calendarPage.getStartTimeElement().click();
			setTime(startHour, startMinutes, startMeridiem.toLowerCase().equals("am"));
			log.debug("Set " + endHour + ":" + endMinutes + endMeridiem );
			calendarPage.getEndTimeElement().click();
			setTime(endHour, endMinutes, endMeridiem.toLowerCase().equals("am"));
			Assert.assertNotNull(calendarPage.getInvitedPeopleElement());
		} catch (Exception e) {
			log.error(dayOfWeek.name() + " meet test failed");
			Screenshots.takeSnapShot(driver);
		}		
	}
	
	protected void invitePeopleForMeet(String peopleList, Logger log) {
		try {
			log.debug("Invite People");
			calendarPage.getInvitedPeopleElement().click();
			calendarPage.setInvitedPeopleElement().sendKeys(peopleList);
			Assert.assertEquals(calendarPage.setInvitedPeopleElement().getText(), peopleList);
		} catch (Exception e) {
			log.error("Invite People test Failed");
			Screenshots.takeSnapShot(driver);
		}
	}
	
	public void setRepeatMeetingOccurrence(Logger log) {
		try {
			log.debug("More Option for Meeting");
			calendarPage.getMoreOptionsElement().click();
			log.debug("Repeat the Meeting");
			calendarPage.getDoesNotRepeatElement().click();
			log.debug("Custom the Meeting");
			calendarPage.getCustomMoreOptionsElement().click();
			log.debug("To set the Enddate of the Meeting");
			calendarPage.getSelectForeverElement().click();
			log.debug("Enddate of the Meeting");
			calendarPage.getUntilADateElement().click();
			log.debug("SelectEnd and Chage Date");
			calendarPage.getChangeEndDateElement().click();
			for (int index = 0; index < 2; ++index) {
				calendarPage.getNextMonthElement().click();
			}
			log.debug("Select three month date from now");
			calendarPage.getThreeMonthsDateOffsetFromNowElement().click();
			calendarPage.getButtonOKOnMonthElement().click();
			log.debug("Metting setup Done");
			calendarPage.getThreeMonthsDateSelectDone().click();
			log.debug("Metting Saved");
			calendarPage.getSaveElement().click();
			Assert.assertNotNull(calendarPage.getCalenderListElement());
		} catch (Exception e) {
			log.error("Meeting Occurrence Failed");
			Screenshots.takeSnapShot(driver);
		}
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
