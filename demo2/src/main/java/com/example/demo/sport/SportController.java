package com.example.demo.sport;

//导入一些需要使用到的系统类库
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.*;
import com.example.demo.model.WalkingDataPojo;
//导入要使用到的自己创建的工具类
import com.example.demo.util.*;
import com.example.demo.db.DataRepository;



@RestController
public class SportController {
	
	private DateUtils dateUtil = new DateUtils();
	
	@Autowired
	private DataRepository dbRepository;
	
	@RequestMapping(value = "/getstep", method = RequestMethod.GET)
	public String getStepData(long uid,String date) {
		try {
			//检测参数是否合法
			if (date != null && !VerifyStartTime(date)) {
				return ErrorResponseBuilder.InvalidParamsHadSend();
			}
			//将String类型的时间转换成Date类型
			SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
			java.util.Date sDate =(java.util.Date) sdf.parse(date);
			Date sqlsDate = dateUtil.getSqlDate(sDate);
			//根据 uid 和 date 查询数据，一般是去查询数据库；
			Date eDate = dateUtil.getEndTimeByStartDate(sqlsDate, 0);
			List<WalkingDataPojo> list = dbRepository.getWalkingDataOfWholeHistory(uid, sqlsDate, eDate);
			//构造json返回值
			Return2Client response = new Return2Client(ErrorResponseBuilder.SUCCESS);
			response.setContent(list);
			return response.toJson();
			
		} catch (ParseException e) {
			return ErrorResponseBuilder.InsertOrUpdateTryCatch();
		}
	}
	

	/************************************************* Private ***********************************************************/
	//检测时间是否合理的私有方法
	private boolean VerifyStartTime(String st){
		Pattern p = Pattern.compile("^\\d{8}$");
		Matcher m = p.matcher(st);
		
		if (!m.matches()) {
			return false;
		}
		return true;
	}
	
	/*
	//获取步数数据的私有方法，在这个方法里面，使用的是假数据
	private Map<String,String> getStepDataFromDB(long uid,Date date){
		Map<String,String> m1 = new HashMap<String,String>(); 
	    m1.put("step", "8888");
	    m1.put("calorie", "88");
	    return m1;
	}
	*/
	
	
}
