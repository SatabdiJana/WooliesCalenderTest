package com.woolies.Pages;

import java.time.DayOfWeek;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.woolies.Utility.DateUtil;

public class CalendarPage {

	private static Logger log = Logger.getLogger(CalendarPage.class);  
	
	private WebDriver webDriver;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'Start date:')]")
	private WebElement startDate;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'End date:')]")
	private WebElement endDate;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'Got it')]")
	private WebElement gotItElement;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'next page')]")
	private WebElement nextPageElement;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'Show Calendar List')]")
	private WebElement calenderListElement;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'Create new event')]")
	private WebElement createNewEventElement;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'Event button')]")
	private WebElement selectNewEventElement;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'Next month')]")
	private WebElement selectNextMonth;

	@FindBy(how = How.ID, using = "android:id/button1")
	private WebElement buttonOKOnMonth;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'Start time:')]")
	private WebElement startTime;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'End time:')]")
	private WebElement endTime;

	@FindBy(how = How.ID, using = "android:id/am_label")
	private WebElement meridiemAM;

	@FindBy(how = How.ID, using = "android:id/pm_label")
	private WebElement meridiemPM;

	@FindBy(how = How.ID, using = "com.google.android.calendar:id/text")
	private WebElement doesNotRepeat;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'change end date')]")
	private WebElement changeEndDate;

	@FindBy(how = How.ID, using = "com.google.android.calendar:id/editor_scroll_view")
	private WebElement scrollUIelement;

	@FindBy(how = How.XPATH, using = "//*[contains(@content-desc, 'People list')]")
	private WebElement invitePeopleElement;

	public CalendarPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public WebElement getGotItElement() {
		return gotItElement;
	}

	public WebElement getNextPageElement() {
		return nextPageElement;
	}

	public WebElement getCalenderListElement() {
		return calenderListElement;
	}

	public WebElement getCreateNewEventElement() {
		return createNewEventElement;
	}

	public WebElement getSelectNewEventElement() {
		return selectNewEventElement;
	}

	public WebElement getNextMonthElement() {
		return selectNextMonth;
	}

	public WebElement getMeetStartDateElement(DayOfWeek dayOfWeek) {
		return webDriver.findElement(
				By.xpath("//android.view.View[@content-desc=\"" 
		+ DateUtil.pickFromattedMeetDate(dayOfWeek).trim()
		+ "\"]"));
	}

	public WebElement getButtonOKOnMonthElement() {
		return buttonOKOnMonth;
	}

	public WebElement getStartDateElement() {
		log.debug(startDate.getText());
		return startDate;
	}

	public WebElement getEndDateElement() {
		return endDate;
	}

	public WebElement getStartTimeElement() {
		return startTime;
	}

	public WebElement getEndTimeElement() {
		return endTime;
	}

	public WebElement getThreeMonthsDateOffsetFromNowElement() {
		return webDriver.findElement(By.xpath(
				"//android.view.View[@content-desc=\"" + DateUtil.pickDateWithThreeMonthsFromNow().trim() + "\"]"));
	}

	public WebElement getHoursOrMinuteElement(String hoursOrMinute) {
		return webDriver
				.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\""
						+ hoursOrMinute.trim() + "\"]"));
	}

	public WebElement getMeridiemAMElement() {
		return meridiemAM;
	}

	public WebElement getMeridiemPMElement() {
		return meridiemPM;
	}

	public WebElement getMoreOptionsElement() {
		return webDriver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout" + "/android.widget.LinearLayout/android.widget.FrameLayout"
						+ "/android.widget.FrameLayout/android.widget.LinearLayout"
						+ "/android.widget.FrameLayout/android.widget.ScrollView"
						+ "/android.view.ViewGroup/android.widget.LinearLayout"
						+ "/android.view.ViewGroup[1]/android.widget.TextView[4]"));
	}

	public WebElement getDoesNotRepeatElement() {
		return webDriver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout" + "/android.widget.LinearLayout/android.widget.FrameLayout"
						+ "/android.widget.FrameLayout/android.widget.LinearLayout"
						+ "/android.widget.FrameLayout/android.widget.ScrollView"
						+ "/android.view.ViewGroup/android.widget.LinearLayout"
						+ "/android.view.ViewGroup[3]/android.widget.Spinner"
						+ "/android.widget.LinearLayout/android.widget.TextView"));
	}

	public WebElement getCustomMoreOptionsElement() {
		return webDriver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout" + "/android.widget.FrameLayout/android.widget.FrameLayout"
						+ "/android.widget.LinearLayout/android.widget.FrameLayout"
						+ "/android.widget.ListView/android.widget.LinearLayout[6]" + "/android.widget.TextView"));
	}

	public WebElement getSelectFridayToRepeatWeeklyElement() {
		return webDriver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout" + "/android.widget.FrameLayout/android.widget.FrameLayout"
						+ "/android.widget.LinearLayout/android.widget.LinearLayout"
						+ "/android.widget.ScrollView/android.widget.LinearLayout"
						+ "/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]"
						+ "/android.widget.ToggleButton[2]"));
	}

	public WebElement getSelectForeverElement() {
		return webDriver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout" + "/android.widget.FrameLayout/android.widget.FrameLayout"
						+ "/android.widget.LinearLayout/android.widget.LinearLayout"
						+ "/android.widget.ScrollView/android.widget.LinearLayout"
						+ "/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]"
						+ "/android.widget.Spinner/android.widget.TextView"));
	}

	public WebElement getUntilADateElement() {
		return webDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout"
				+ "/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
	}

	public WebElement getChangeEndDateElement() {
		return changeEndDate;
	}

	public WebElement getThreeMonthsDateSelectDone() {
		return webDriver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout" + "/android.widget.FrameLayout/android.widget.FrameLayout"
						+ "/android.widget.LinearLayout/android.widget.LinearLayout"
						+ "/android.widget.LinearLayout/android.widget.Button"));
	}

	public WebElement getScrollUIElement() {
		return scrollUIelement;

	}

	public WebElement getTitleElement() {
		log.debug("Get Title Element");
		WebElement webElement = null;
		List<WebElement> webElements = webDriver.findElements(By.className("android.widget.EditText"));
		for (int index = 0; index < webElements.size(); index++) {
			webElement = webElements.get(index);
			if (webElement.getText().contains("Enter title, times, people, places")) {
				break;
			}
		}
		return webElement;
	}

	public WebElement getInvitedPeopleElement() {
		return invitePeopleElement;
	}

	public WebElement setInvitedPeopleElement() {
		return webDriver.findElement(
				By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
						+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
						+ "/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout"
						+ "/android.view.ViewGroup[4]/android.widget.EditText"));
	}

	public WebElement getSaveElement() {
		return webDriver.findElement(By.className("android.widget.Button"));
	}
}
