package com.vedic.astro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.vedic.astro.exception.SystemException;

/**
 * Utility class for managing date conversion operations.
 * 
 * @author Sumeer Saxena
 */
public class DateUtil {

	/**
	 * Private constructor so that nobody can instantiate class.
	 */
	private DateUtil() {
	}

	/**
	 * Converts the date from String to the Date format.
	 * 
	 * @param date
	 *            Date in String to convert
	 * @param format
	 *            Date format
	 * @return java.util.Date equivalent.
	 */
	public static Date toDate(String date, String format) {

		Date formattedDate = null;

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			if (date != null) {
				formattedDate = formatter.parse(date);
			}
		} catch (ParseException ex) {
			throw new SystemException(ex.getMessage(), ex);
		}

		return formattedDate;
	}

	/**
	 * Converts the java.util.Date to String format.
	 * 
	 * @param date
	 *            Date in Date format to convert
	 * @param outputFormat
	 *            Date format needed.
	 * @return String equivalent.
	 */
	public static String fromDate(Date date, String outputFormat) {

		SimpleDateFormat formatter = new SimpleDateFormat(outputFormat);
		String formattedDate = formatter.format(date);

		return formattedDate;
	}
	

	/**
	 * Add months to the current date
	 * 
	 * @param date1
	 * 
	 * @return number of days in between two dates.
	 */
	public static Date addMonths(Date date, int months) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.MONTH, months); 
		
		return calendar.getTime();
		
	}

	public static int getYears(String dob){
		
		Date dobDate = toDate(dob, "MM/dd/yyyy");
		
		Calendar dobCal = Calendar.getInstance();
		dobCal.setTime(dobDate);
		
		Calendar nowCal = Calendar.getInstance();
		nowCal.setTime(new Date());
		
		return (nowCal.get(Calendar.YEAR) - dobCal.get(Calendar.YEAR));
		
	}
	
  public static int yearsBetween(String from, String to){
		
		Date fromDate = toDate(from, "MM/dd/yyyy");
		Date toDate = toDate(to, "MM/dd/yyyy");
		
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(fromDate);
		
		Calendar toCal = Calendar.getInstance();
		toCal.setTime(toDate);
		
		return (toCal.get(Calendar.YEAR) - fromCal.get(Calendar.YEAR));
  }
  
  public static int yearsBetween(Date fromDate, Date toDate){
		
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(fromDate);
		
		Calendar toCal = Calendar.getInstance();
		toCal.setTime(toDate);
		
		return (toCal.get(Calendar.YEAR) - fromCal.get(Calendar.YEAR));
}

	
	public static Date getDateByDays(Date date, int days){

		Calendar c = Calendar.getInstance();
		Date result = null;

		try {
			c.setTime(date);
			c.add(Calendar.DAY_OF_YEAR, days);
			result = c.getTime();
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}

		return result;
	}
	
	public static Date getDateByMins(Date date, int mins){

		Calendar c = Calendar.getInstance();
		Date result = null;

		try {
			c.setTime(date);
			c.add(Calendar.MINUTE, mins);
			result = c.getTime();
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}

		return result;
	}
	
	public static int daysBetween(Date startDate, Date endDate) {

		long diff = startDate.getTime() - endDate.getTime();
		float diffDays = (float) diff / (24 * 60 * 60 * 1000);

		return Math.abs(Math.round(diffDays));
	}
	
	public static int minsBetween(Date startDate, Date endDate) {

		long diff = startDate.getTime() - endDate.getTime();
		float diffMins = (float) diff / ( 60 * 1000);

		return Math.abs(Math.round(diffMins));
	}
	
	public static Date convertDate(String date, String hhmm){
		
		String dateString = date + " " + hhmm + ":00";
		return toDate(dateString,"MM/dd/yyyy HH:mm:ss");
	}
	
	public static Date calcMidDay(String date, String sunrise, String sunset){
		
		Date sunriseDate = convertDate(date, sunrise);
		Date sunsetDate = convertDate(date, sunset);
		
		int mins = minsBetween(sunriseDate, sunsetDate);
		
		Date result = getDateByMins(sunriseDate, mins/2);
		
		return result;
	}
	
	public static Date calcMidNight(String date, String sunrise, String sunset){
		
		Date midDay = calcMidDay(date, sunrise, sunset);
		Date result = getDateByMins(midDay, 720);
		
		return result;
	}
	
	public static void main(String[] args) {
		//System.out.println(getYears("10/24/1968"));
		
		//System.out.println(getDateByDays(new Date(), 3650));
		
		//System.out.println(calcMidDay("11/23/2015","06:05", "18:28"));
		//System.out.println(calcMidNight("11/23/2015","06:05", "18:28"));
	
	/*	Date dob = toDate("09/12/1981", "MM/dd/yyyy");
		Date start = toDate("01/01/1952", "MM/dd/yyyy");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dob.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	     Date firstDayOfMonth = calendar.getTime();  

	     DateFormat sdf = new SimpleDateFormat("EEEEEEEE");   
	     System.out.println("First Day of Month: " + sdf.format(firstDayOfMonth));
	     
	     System.out.println("days elapsed =" + (daysBetween(start, dob)+175));
	   */
		
		Date dob = toDate("08/16/2004 09:16 AM", "MM/dd/yyyy hh:mm a");
		System.out.println("dob = " + dob);
		String date = fromDate(dob, "kk:mm:ss");
		System.out.println("date = " + date);
	}
}
