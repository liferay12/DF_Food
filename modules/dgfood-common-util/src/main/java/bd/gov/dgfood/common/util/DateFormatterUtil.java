package bd.gov.dgfood.common.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Pattern;

import bd.gov.dgfood.common.util.constants.DateConstants;

/**
 * The purpose of this class is to mention date related activities
 *
 * Accessibility : Throughout application
 *
 * @author Ashish Singh
 * 
 */

public class DateFormatterUtil {

	/**
	 * 
	 * To parse the string into Java Date object
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parseDate(String date) {
		Date parsedDate = null;
		if (Validator.isNotNull(getMatchedDateFormate(date))) {
			try {
				parsedDate = new SimpleDateFormat(getMatchedDateFormate(date)).parse(date);
			} catch (Exception e) {
				_log.error("Error while parsing the date " + date + ": " + e.getMessage());
				e.printStackTrace();
			}
		}
		return parsedDate;
	}

	/**
	 * Get the matched date formate
	 * 
	 * @param date
	 * @return String
	 */
	public static String getMatchedDateFormate(String date) {
		String dateFormat = StringPool.BLANK;

		Map<String, String> datePatternMapList = new HashMap<>();
		datePatternMapList.put(DateConstants.YYYY_MM_DD, "^\\d{4}-\\d{2}-\\d{2}$");
		// datePatternMapList.put("dd.MM.yyyy", "^\\d{2}\\.\\d{2}\\.\\d{4}$");
		datePatternMapList.put(DateConstants.DD_MM_YYYY, "^\\d{2}-\\d{2}-\\d{4}$");
		// datePatternMapList.put("dd/MM/yyyy", "^\\d{2}/\\d{2}/\\d{4}$");

		for (Entry<String, String> patternEntry : datePatternMapList.entrySet()) {
			Pattern datePattern = Pattern.compile(patternEntry.getValue());
			if (datePattern.matcher(date).matches()) {
				return patternEntry.getKey();
			}
		}

		return dateFormat;
	}

	/**
	 * To parse the string into Java Date object
	 * 
	 * @param date
	 * @param format
	 * @return Date
	 */
	public static Date parseDate(String date, String format) {
		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			_log.error("Error while parsing the date " + date + ": " + e.getMessage());
			e.printStackTrace();
		}
		return parsedDate;
	}

	/**
	 * Formate The date to teh given format
	 * 
	 * @param date
	 * @param pattern
	 * @return String
	 */
	public static String parseDate(Date date, String pattern) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.format(date);
		} catch (Exception e) {
			e.getMessage();
			return StringPool.BLANK;
		}
	}

	/**
	 * To get Date as input and provide date after 1 year as validity.
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date generateOneYearValidity(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.YEAR, 1);
			return cal.getTime();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

    public static String DateFormat(long currentTime) {
		Date date = new Date(currentTime);
		DateFormat formatter = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
		String dateFormatted = formatter.format(date);
		return dateFormatted;

	}
	private static Log _log = LogFactoryUtil.getLog(DateFormatterUtil.class);

}
