package com.woolies.Utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.apache.log4j.Logger;

public class DateUtil {
	
	private static final Logger log = Logger.getLogger(DateUtil.class);  
	
	private static final DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd MMMM yyyy ");

	public static String pickFromattedFridayDate() {
		LocalDate dateToday = LocalDate.now();

		log.debug("before " + dateToday);

		LocalDate fridayDate = dateToday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		String formattedFridayDate = fridayDate.format(formattedDate);
		log.debug("after " + formattedFridayDate);

		return formattedFridayDate;
	}

	public static String pickDateWithThreeMonthsFromNow() {
		LocalDate dateToday = LocalDate.now();

		log.debug("before " + dateToday);

		LocalDate dateThreeMonthsFromToday = dateToday.plusMonths(3);
		String formattedDateThreeMonthsFromToday = dateThreeMonthsFromToday.format(formattedDate);
		log.debug("after " + formattedDateThreeMonthsFromToday);

		return formattedDateThreeMonthsFromToday;
	}

	public static boolean isThereAFridayWithInThisMonth() {
		// Get current date
		LocalDate dateToday = LocalDate.now();

		// Find the next Friday
		LocalDate nextFridayDate = dateToday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

		// Test if its within same date
		return dateToday.getMonthValue() == nextFridayDate.getMonthValue();
	}
}
