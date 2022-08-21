package com.woolies.Utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.apache.log4j.Logger;

public class DateUtil {
	
	private static final Logger log = Logger.getLogger(DateUtil.class);  
	
	private static final DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd MMMM yyyy ");

	public static String pickFromattedMeetDate(DayOfWeek dayOfWeek) {
		LocalDate dateToday = LocalDate.now();

		log.debug("before " + dateToday);

		LocalDate meetDate = dateToday.with(TemporalAdjusters.next(dayOfWeek));
		String formattedMeetDate = meetDate.format(formattedDate);
		log.debug("after " + formattedMeetDate);

		return formattedMeetDate;
	}

	public static String pickDateWithThreeMonthsFromNow() {
		LocalDate dateToday = LocalDate.now();

		log.debug("before " + dateToday);

		LocalDate dateThreeMonthsFromToday = dateToday.plusMonths(3);
		String formattedDateThreeMonthsFromToday = dateThreeMonthsFromToday.format(formattedDate);
		log.debug("after " + formattedDateThreeMonthsFromToday);

		return formattedDateThreeMonthsFromToday;
	}

	public static boolean isGivenDayWithInThisMonth(DayOfWeek dayOfWeek) {
		// Get current date
		LocalDate dateToday = LocalDate.now();

		// Find the next Friday
		LocalDate nextGivenDayDate = dateToday.with(TemporalAdjusters.next(dayOfWeek));

		// Test if its within same month
		return dateToday.getMonthValue() == nextGivenDayDate.getMonthValue();
	}	
}
