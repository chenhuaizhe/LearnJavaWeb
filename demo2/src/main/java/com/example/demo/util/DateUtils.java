package com.example.demo.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


	public int getYear() {
		Calendar c = Calendar.getInstance(); 
		return c.get(Calendar.YEAR);
	}
}
