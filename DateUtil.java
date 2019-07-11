package tk.huclele.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间处理工具类.
 *
 * @author : 薛乐乐
 * @since : 2019/7/11 10:55
 */
public class DateUtil {


  private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

  private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

  private static final String DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

  private static final String[] DF_PATTERN_14 = new String[]{"yyyy年MM月dd日",
      "yyyy年MM月dd日 HH时mm分ss秒"};

  private static final String S = "S";
  private static final String MS = "MS";
  private static final String Y = "Y";
  private static final String H = "H";
  private static final String M = "M";
  private static final String D = "D";

  /**
   * 日期转化为字符串.
   *
   * @param date 时间
   * @param dateStyle 日期格式化风格
   * @return yyyy-MM-dd HH:mm:ss 格式化的时间字符串
   */
  public static String dateToString(Date date, String dateStyle) {
    if (date == null) {
      return "";
    }
    return formatDate(date, dateStyle);
  }

  /**
   * 对日期进行格式化.
   *
   * @param date 日期
   * @param sf 日期格式
   * @return 字符串
   */
  private static String formatDate(Date date, String sf) {
    if (date == null) {
      return "";
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sf);
    return simpleDateFormat.format(date);
  }

  /**
   * 字符串转换为日期.
   *
   * @param str 时间字符串
   * @return date 时间日期
   */
  public static Date string2Date(String str) throws Exception {
    if (null == str || "".equals(str)) {
      return null;
    } else {
      SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
      return format.parse(str);
    }
  }

  /**
   * 字符串转换为时间戳.
   *
   * @param str 时间字符串
   * @return date 时间
   */
  public static Date string2Timestamp(String str) throws Exception {
    if (null == str || "".equals(str)) {
      return null;
    } else {
      SimpleDateFormat format = new SimpleDateFormat(DEFAULT_TIMESTAMP_FORMAT);
      return format.parse(str);
    }
  }

  /**
   * 日期转换为字符串.
   *
   * @param date 时间日期
   * @return 字符串
   */
  public static String date2String(Date date) {
    if (null == date) {
      return null;
    } else {
      SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
      return format.format(date);
    }
  }

  /**
   * 时间戳转换为字符串.
   *
   * @param date 时间戳
   * @return 字符串
   */
  public static String timestamp2String(Date date) {
    if (null == date) {
      return null;
    } else {
      SimpleDateFormat format = new SimpleDateFormat(DEFAULT_TIMESTAMP_FORMAT);
      return format.format(date);
    }
  }

  /**
   * 时间转换为字符串.
   *
   * @param date 时间
   * @return 字符串
   */
  public static String time2String(Date date) {
    if (null == date) {
      return null;
    } else {
      SimpleDateFormat format = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
      return format.format(date);
    }
  }

  /**
   * 比较日期时间是否相等.
   *
   * @param front 前一个时间
   * @param later 后一个时间节点
   * @return 比较结果
   */
  public static boolean isEqual(Date front, Date later) {
    if (null == front || null == later) {
      return false;
    } else if (front.before(later)) {
      return false;
    } else {
      return !front.after(later);
    }
  }

  /**
   * 得到当前的时间.
   *
   * @return 当前时间
   */
  public static Date getDate() {
    Calendar calendar = Calendar.getInstance();
    return calendar.getTime();
  }

  /**
   * 提到指定的millis得到时间.
   *
   * @param millis 秒
   * @return 时间日期
   */
  public static Date getDate(long millis) {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.setTimeInMillis(millis);
    return calendar.getTime();
  }

  /**
   * 获取时间秒.
   *
   * @return 秒
   */
  public static long getMillis() {
    return Calendar.getInstance().getTimeInMillis();
  }

  /**
   * 得到指定日期的字符串(yyyy-MM-dd HH:mm:ss.SSS).
   *
   * @param date 时间类型
   * @param format 格式风格
   * @return 字符串
   */
  private static String getDateFormat(Date date, String format) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
      return simpleDateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  /**
   * 根据日期得到YYYY-MM-DD HH:MM:SS.SSS格式字符串.
   *
   * @param date 时间类型
   * @return 字符串
   */
  public static String getYMdHmsS(Date date) {
    return DateUtil.getDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS");
  }

  /**
   * 根据日期得到YYYY-MM-DD HH:MM:SS格式MM格式字符串字符串.
   *
   * @param date 时间类型
   * @return 字符串
   */
  public static String get4yMdHms(Date date) {
    return DateUtil.getDateFormat(date, "yyyy-MM-dd HH:mm:ss");
  }

  /**
   * 根据日期得到YYYY-MM-DD HH:.
   *
   * @param date 时间类型
   * @return 字符串
   */
  public static String get4yMdHm(Date date) {
    return DateUtil.getDateFormat(date, "yyyy-MM-dd HH:mm");
  }

  /**
   * 根据日期得到YYYY-MM-DD格式字符串.
   */
  public static String get4yMd(Date date) {
    return DateUtil.getDateFormat(date, "yyyy-MM-dd");
  }

  /**
   * 把指定字符(yyyy-MM-dd HH:mm:ss.SSS)串转成Date.
   */
  public static Date parseymdhmss(String sDate) {
    return DateUtil.parseDate(sDate, "yyyy-MM-dd HH:mm:ss.SSS");
  }

  /**
   * 把指定字符(yyyy-MM-dd HH:mm:ss)串转成Date.
   */
  public static Date parseyMdHms(String sDate) {
    return DateUtil.parseDate(sDate, "yyyy-MM-dd HH:mm:ss");
  }

  /**
   * 把指定字符(yyyy-MM-dd HH:mm)串转成Date.
   */
  public static Date parse4yMdHm(String sDate) {
    return DateUtil.parseDate(sDate, "yyyy-MM-dd HH:mm");
  }

  /**
   * 把指定字符(yyyy-MM-dd)串转成Date.
   */
  public static Date parse4yMd(String sDate) {
    return DateUtil.parseDate(sDate, "yyyy-MM-dd");
  }

  /**
   * 根据指定格式,把字符串转成日期.
   */
  private static Date parseDate(String sDate, String formate) {
    SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
    try {
      return simpleDateFormate.parse(sDate);
    } catch (ParseException e) {
      return null;
    }
  }

  /**
   * 两个长整型的时间相差(时间的毫秒数),可以得到指定的毫秒数,秒数,分钟数,天数.
   *
   * @param minuendTime [被减去的时间]
   * @param subtrahendTime [减去的时间]
   * @param tdatestr [part可选值["D","H","M","S","MS"] @return[minuendTime- subtrahendTime]
   */
  private static double getDifTwoTime(long minuendTime, long subtrahendTime, String tdatestr) {
    if (tdatestr == null || "".equals(tdatestr)) {
      tdatestr = "MS";
    }
    double temp = 1;
    //得到秒
    if (S.equalsIgnoreCase(tdatestr)) {
      temp = 1000;
    }
    //得到分
    if (M.equalsIgnoreCase(tdatestr)) {
      temp = 1000 * 60;
    }
    //得到小时
    if (H.equalsIgnoreCase(tdatestr)) {
      temp = 1000 * 60 * 60;
    }
    //得到天
    if (D.equalsIgnoreCase(tdatestr)) {
      temp = 1000 * 60 * 60 * 24;
    }
    return (minuendTime - subtrahendTime) / temp;
  }

  /**
   * 获取指定日期的前后面天数的日期.
   *
   * @param specifiedDay 指定的日期字符串
   * @param duration 天数
   */
  public static String getSpecifiedDayBeforeAndAfter(String specifiedDay, int duration) {
    Calendar c = Calendar.getInstance();
    Date date;
    try {
      date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
      c.setTime(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    int day = c.get(Calendar.DATE);
    c.set(Calendar.DATE, day + duration);
    return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
  }

  /**
   * 设置日期格式.
   */
  private static DateFormat getDateFormat(String format) {
    return new SimpleDateFormat(format);
  }

  /**
   * 获取指定日期格式.
   *
   * @param date 日期
   * @param pattern 格式[yyyyMMdd,yyyyMMddHHmmss,yyyyMMddHHmmssSSS]
   */
  public static String getFormatDatePattern(Date date, String pattern) {
    return getDateFormat(pattern).format(date);
  }

  /**
   * 格式化日期，其格式为[yyyy年MM月dd日].
   */
  public static String getFormatDate14(Date date) {
    return getDateFormat(DF_PATTERN_14[0]).format(date);
  }

  /**
   * 格式化日期，其格式为[yyyy年MM月dd月 HH时mm分ss秒].
   */
  public static String getFormatDate14H(Date date) {
    return getDateFormat(DF_PATTERN_14[1]).format(date);
  }

  /**
   * 获取当前日期是星期几<br>.
   *
   * @return 当前日期是星期几
   */
  public static String getWeekOfDate(Date dt) {
    String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    Calendar cal = Calendar.getInstance();
    cal.setTime(dt);
    int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    if (w < 0) {
      w = 0;
    }
    return weekDays[w];
  }

  /**
   * 两个时间相差距离多少天多少小时多少分多少秒.
   *
   * @param str1 时间参数 1 格式：1990-01-01 12:00:00
   * @param str2 时间参数 2 格式：2009-01-01 12:00:00
   * @return long[] 返回值为：{天, 时, 分, 秒}
   */
  public static long[] getDistanceTimes(String str1, String str2) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date one;
    Date two;
    long day = 0;
    long hour = 0;
    long min = 0;
    long sec = 0;
    try {
      one = df.parse(str1);
      two = df.parse(str2);
      long time1 = one.getTime();
      long time2 = two.getTime();
      long diff;
      if (time1 < time2) {
        diff = time2 - time1;
      } else {
        diff = time1 - time2;
      }
      day = diff / (24 * 60 * 60 * 1000);
      hour = (diff / (60 * 60 * 1000) - day * 24);
      min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
      sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

      if (hour > 0) {
        min = min + hour * 60;
      }
      if (day > 0) {
        min = min + day * 24 * 60;
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return new long[]{day, hour, min, sec};
  }

  /**
   * 两个时间相差距离多少天多少小时多少分多少秒.
   *
   * @param str1 时间参数 1 格式：1990-01-01 12:00:00
   * @param str2 时间参数 2 格式：2009-01-01 12:00:00
   * @return String 返回值为：xx天xx小时xx分xx秒
   */
  public static String getDistanceTime(String str1, String str2) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date one;
    Date two;
    long day = 0;
    long hour = 0;
    long min = 0;
    long sec = 0;
    try {
      one = df.parse(str1);
      two = df.parse(str2);
      long time1 = one.getTime();
      long time2 = two.getTime();
      long diff;
      if (time1 < time2) {
        diff = time2 - time1;
      } else {
        diff = time1 - time2;
      }
      day = diff / (24 * 60 * 60 * 1000);
      hour = (diff / (60 * 60 * 1000) - day * 24);
      min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
      sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return day + "天" + hour + "小时" + min + "分" + sec + "秒";
  }

  public static boolean between(Date sourDate, Date date1, Date date2) {
    boolean flag = false;
    if (sourDate.after(date1) && sourDate.before(date2)) {
      flag = true;
    }
    return flag;
  }

  /**
   * 把date时间往前/后递增/递减minute分钟.
   *
   * @param date 被修改时间
   * @param minute 分钟
   * @return date
   */
  public static Date calendarDate(Date date, int minute) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    calendar.add(Calendar.MINUTE, minute);
    return calendar.getTime();
  }

}
