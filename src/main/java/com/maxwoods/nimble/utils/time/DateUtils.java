package com.maxwoods.nimble.utils.time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @project: chually-commons
 * @author: wangjz 2018年8月21日上午10:11:08
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	/**
	 * 当前时间戳
	 *
	 * @return
	 * @author: wangjz 2018年8月21日下午5:30:56
	 */
	public static Timestamp now() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 返回当前时间
	 */
	public static Date current() {
		return new Date();
	}

	public static String format(Date date, String formatString) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		return sdf.format(date);
	}

	/**
	 * 将时间转换为数字串，精确到秒
	 */
	public static String numberString(Date date) {
		return DateUtils.format(date, "yyyyMMddHHmmss");
	}

	/**
	 * 将时间转换为数字串，精确到毫秒
	 */
	public static String numberStringWithMillisecond(Date date) {
		return DateUtils.format(date, "yyyyMMddHHmmssSSS");
	}

	/**
	 * 将当前时间转换为数字串，精确到秒
	 */
	public static String currentDateTimeNumberString() {
		return DateUtils.numberString(DateUtils.current());
	}

	/**
	 * 将当前时分秒转为数字串
	 *
	 * @return
	 */
	public static String currentTimeNumberString() {
		return DateUtils.format(DateUtils.current(), "HHmmss");
	}

	public static String monthDayNumberString(Date date) {
		return DateUtils.format(date, "MMdd");
	}

	public static String currentMonthDayNumberString() {
		return DateUtils.format(DateUtils.current(), "MMdd");
	}

	public static String currentMonthDayTimeNumberString() {
		return DateUtils.format(DateUtils.current(), "MMddHHmmss");
	}

	/**
	 * 将时间转换为年月日数字串
	 */
	public static String yearMonthDayNumberString(Date date) {
		return DateUtils.format(date, "yyyyMMdd");
	}

	/**
	 * 将当前时间转换为年月日数字串
	 */
	public static String currentYearMonthDayNumberString() {
		return DateUtils.format(DateUtils.current(), "yyyyMMdd");
	}

	/**
	 * 将当前时间转换为数字串，精确到毫秒
	 */
	public static String currentNumberStringWithMillisecond() {
		return DateUtils.numberStringWithMillisecond(DateUtils.current());
	}

	/**
	 * 时间减去指定天数后的时间
	 */
	public static Date subDays(Date date, int days) {
		return org.apache.commons.lang3.time.DateUtils.addDays(date, -days);
	}

	/**
	 * 解析数字串
	 */
	public static Date parseNumberString(String dateNumberString) {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			result = sdf.parse(dateNumberString);
		} catch (Exception ex) {}
		return result;
	}

	/**
	 * 按格式解析
	 */
	public static Date parseByFormat(String dateString, String format) {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			result = sdf.parse(dateString);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * 计算时间差，以秒为单位
	 */
	public static Long getTimeIntervalSeconds(Date timeStart, Date timeEnd) {
		Long milliSeconds = timeEnd.getTime() - timeStart.getTime();
		return milliSeconds / 1000;
	}

	/**
	 * 计算时间差，以分钟为单位
	 */
	public static Long getTimeIntervalMinutes(Date timeStart, Date timeEnd) {
		Long seconds = DateUtils.getTimeIntervalSeconds(timeStart, timeEnd);
		return seconds / 60;
	}

	/**
	 * 本地时间转UTC时间
	 */
	public static Date localTimeToUtc(Date localTime) {
		return null;
	}

	/**
	 * 得到月头和月底
	 *
	 * @param date
	 * @param beginOrEnd 类型 true-begin false-end
	 * @return
	 * @author: zhangheng 2018/7/31 9:42
	 */
	public static Date getDateBeginOrEndByMonth(Date date, boolean beginOrEnd) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (beginOrEnd) {
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
		} else {
			int lastMonthMaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), lastMonthMaxDay, 23, 59, 59);
		}
		return c.getTime();
	}

	/**
	 * 得到一天中的开始时间或结束时间
	 * 
	 * @param date
	 * @param isBegin
	 * @return
	 * @author wangjz 2018年10月24日下午4:41:34
	 */
	public static Timestamp getBeginOrEndOfDay(Date date, boolean isBegin) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (isBegin) {
			c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
			c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
			c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
			c.set(Calendar.MILLISECOND, c.getActualMinimum(Calendar.MILLISECOND));
		} else {
			c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
			c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
			c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
			c.set(Calendar.MILLISECOND, c.getActualMaximum(Calendar.MILLISECOND));
		}
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 判断当前时间是否在两个时段（时分秒）中间 isBetweenTime("10:24:00","15:00:00")
	 * 
	 * @param startStr
	 * @param endStr
	 * @return
	 */
	public static boolean isBetweenTime(String startStr, String endStr) {
		return isBetweenTime(new Date(), startStr, endStr);
	}

	/**
	 * 判断时间是否在两个时段（时分秒）中间 isBetweenTime("10:30:00","15:00:00")
	 * isBetweenTime("15:00:00","10:30:00")
	 * 
	 * @param startStr
	 * @param endStr
	 * @return
	 */
	public static boolean isBetweenTime(Date date, String startStr, String endStr) {
		Calendar s = Calendar.getInstance();// 开始时间
		String[] start = startStr.split(":");
		s.set(Calendar.HOUR_OF_DAY, new Integer(start[0]));
		s.set(Calendar.MINUTE, new Integer(start[1]));
		s.set(Calendar.SECOND, start.length < 3 ? 0 : new Integer(start[2]));
		s.set(Calendar.MILLISECOND, 0);

		Calendar e = Calendar.getInstance();// 结束时间
		String[] end = endStr.split(":");
		e.set(Calendar.HOUR_OF_DAY, new Integer(end[0]));
		e.set(Calendar.MINUTE, new Integer(end[1]));
		e.set(Calendar.SECOND, start.length < 3 ? 0 : new Integer(start[2]));
		e.set(Calendar.MILLISECOND, 0);

		if (e.after(s)) {
			// 10:30:00~15:00:00
			return isBetweenTime(date, s.getTime(), e.getTime());
		} else {
			// 15:00:00~10:30:00==>15:00:00~23:59:59 || 00:00:00~10:30:00
			Calendar e1 = Calendar.getInstance();// 当天23:59:59.999
			e1.set(Calendar.HOUR_OF_DAY, 23);
			e1.set(Calendar.MINUTE, 59);
			e1.set(Calendar.SECOND, 59);
			e1.set(Calendar.MILLISECOND, 999);

			Calendar s1 = Calendar.getInstance();// 当天00:00:00.000
			s1.set(Calendar.HOUR_OF_DAY, 0);
			s1.set(Calendar.MINUTE, 0);
			s1.set(Calendar.SECOND, 0);
			s1.set(Calendar.MILLISECOND, 0);
			return isBetweenTime(date, s.getTime(), e1.getTime()) || isBetweenTime(date, s1.getTime(), e.getTime());
		}
	}

	/**
	 * 判断当前时间是否在两个时段（时分秒）中间
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isBetweenTime(Date start, Date end) {
		return isBetweenTime(new Date(), start, end);
	}

	/**
	 * 判断当前时间是否在两个时段（时分秒）中间
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isBetweenTime(Date date, Date start, Date end) {
		return start.getTime() <= date.getTime() && date.getTime() <= end.getTime();
	}
}