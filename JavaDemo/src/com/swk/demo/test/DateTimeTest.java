/**
 * @createTime: 2018年3月5日
 */
package com.swk.demo.test;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @classDesc: 类描述: 日期时间类测试
 * @author vico
 * @createTime 2018年3月5日 下午3:15:20
 * @version v1.0.0
 */
public class DateTimeTest {

	    /**
	     * @methodDesc: 方法描述: 取得年月日、小时分钟秒
	     * @author vico
	     * @createTime 2018年3月5日 下午3:18:30
	     * @version v1.0.0
	     *
	     */
	    public static void dateTimeTest() {
	        Calendar cal = Calendar.getInstance();
	        System.out.println(cal.get(Calendar.YEAR));
	        System.out.println(cal.get(Calendar.MONTH));    // 0 - 11
	        System.out.println(cal.get(Calendar.DATE));
	        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
	        System.out.println(cal.get(Calendar.MINUTE));
	        System.out.println(cal.get(Calendar.SECOND));
	 
	        // Java 8
	        LocalDateTime dt = LocalDateTime.now();
	        System.out.println(dt.getYear());
	        System.out.println(dt.getMonthValue());     // 1 - 12
	        System.out.println(dt.getDayOfMonth());
	        System.out.println(dt.getHour());
	        System.out.println(dt.getMinute());
	        System.out.println(dt.getSecond());
	    }
	    
	    
	    /**
	     * @methodDesc: 方法描述: 获取毫秒数
	     * @author vico
	     * @createTime 2018年3月5日 下午3:17:54
	     * @version v1.0.0
	     *
	     */
	    public static void getMills() {
	    	Calendar.getInstance().getTimeInMillis();
	    	System.currentTimeMillis();
	    	Clock.systemDefaultZone().millis();
		}

	    /**
		 * @methodDesc: 方法描述:获取每月的最后一天
		 * @author vico
		 * @createTime 2018年3月5日 下午3:19:24
		 * @version v1.0.0
		 *
		 */
		private static void getLastDayOfMonth() {
			// TODO Auto-generated method stub
			Calendar time = Calendar.getInstance();
			time.getActualMaximum(Calendar.DAY_OF_MONTH);
		} 
		
		
		/**
		 * @methodDesc: 方法描述: 格式化日期
		 * @author vico
		 * @createTime 2018年3月5日 下午3:22:13
		 * @version v1.0.0
		 *
		 */
		public static void formatDate()
		{
		        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
		        Date date1 = new Date();
		        System.out.println(oldFormatter.format(date1));
		 
		        // Java 8
		        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		        LocalDate date2 = LocalDate.now();
		        System.out.println(date2.format(newFormatter));
		}
}
