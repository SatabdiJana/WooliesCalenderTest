package com.woolies.TestCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.woolies.Pages.CalendarPage;
import com.woolies.Utility.DateUtil;
import com.woolies.Utility.Screenshots;

class StandUpMeetTest extends GeneralMeetTest {

	private static Logger log = Logger.getLogger(StandUpMeetTest.class);

	@Test(priority = 1)
	public void Test_Calender_Launch() throws Exception {
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

	@Test(priority = 2)
	public void Test_WorkShop_Title() throws Exception {
		try {
			calendarPage.getCreateNewEventElement().click();
			calendarPage.getSelectNewEventElement().click();
			calendarPage.getTitleElement().sendKeys(workshopTitle);
			Assert.assertTrue(calendarPage.getTitleElement().isDisplayed());
		} catch (Exception e) {
			log.error("Enter worskshop Title Failed");
			Screenshots.takeSnapShot(driver);
		}
	}

	@Test(priority = 3)
	public void Test_Set_FridayMeet() throws Exception {
		try {
			calendarPage.getStartDateElement().click();
			if (!DateUtil.isThereAFridayWithInThisMonth()) {
				log.debug("Move Next Month");
				calendarPage.getNextMonthElement().click();
			}
			log.debug("Set Friday");
			calendarPage.getFridayDateElement().click();
			calendarPage.getButtonOKOnMonthElement().click();
			log.debug("Set 9:30 AM");
			calendarPage.getStartTimeElement().click();
			setTime("9", "30", true);
			log.debug("Set 1:30 PM");
			calendarPage.getEndTimeElement().click();
			setTime("1", "30", false);
			Assert.assertNotNull(calendarPage.getInvitedPeopleElement());
		} catch (Exception e) {
			log.error("Enter worskshop Title Failed");
			Screenshots.takeSnapShot(driver);
		}
	}

	@Test(dataProvider = "test-data", priority = 4)
	public void Test_Invite_People(String peopleList) throws Exception {
		try {
			log.debug("Invite People");
			calendarPage.getInvitedPeopleElement().click();
			calendarPage.setInvitedPeopleElement().sendKeys(peopleList);
			Assert.assertEquals(calendarPage.setInvitedPeopleElement().getText(), peopleList);
		} catch (Exception e) {
			log.error("Enter worskshop Title Failed");
			Screenshots.takeSnapShot(driver);
		}
	}

	@Test(priority = 5)
	public void Test_Repeat_Meeting_Occurrence() throws Exception {
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
}
