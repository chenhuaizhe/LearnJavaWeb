package com.example.demo.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class DateUtils {
	
	public SimpleDateFormat df_ymd = new SimpleDateFormat("yyyyMMdd");


	public boolean VerifyStartTime(String st){
		Pattern p = Pattern.compile("^\\d{8}$");
		Matcher m = p.matcher(st);
		
		if (!m.matches()) {
			return false;
		}
		return true;
	}
	
	/**
	 * 通过开始时间计算向后第N天
	 * @param sDate  开始日期
	 * @param ds     天数
	 * @return
	 */
	public Date getEndTimeByStartDate(java.util.Date sDate,int ds){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(sDate);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.add(Calendar.DATE, ds);
		java.util.Date eDate = calendar.getTime();
		Date sqlDate = new java.sql.Date(eDate.getTime());
		return sqlDate;
	}

	
	/**
	 * util 转 sql date
	 * @param date
	 * @return
	 */
	public java.sql.Date getSqlDate(java.util.Date date){
		Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	
	//numberDate like yyyyMMdd
	public java.util.Date numberToDate(int numberDate){
		try {
			java.util.Date dt = df_ymd.parse(String.valueOf(numberDate));
			return dt;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*返回统一时区，不受本地时间影响*/
	public SimpleDateFormat getSimpleDateFormat() {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dt.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		return  dt;
	}


	public int getYear() {
		Calendar c = Calendar.getInstance(); 
		return c.get(Calendar.YEAR);
	}
}
