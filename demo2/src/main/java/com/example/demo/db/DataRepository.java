package com.example.demo.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WalkingDataPojo;

//导入要使用到的自己创建的工具类
import com.example.demo.util.DateUtils;


@Repository
public class DataRepository {
	//@Autowired 这个注解就是spring可以自动帮你把bean里面引用的对象的setter/getter方法省略，它会自动帮你set/get。
	@Autowired
	protected JdbcTemplate jdbc;
	
	
	@Autowired
	private DateUtils dateUtil = new DateUtils();
	
	SimpleDateFormat dt = dateUtil.getSimpleDateFormat();
	
	
	/**
	 * 查询walking历史
	 * 
	 * @param uid
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public List<WalkingDataPojo> getWalkingDataOfWholeHistory(long uid, Date sDate, Date eDate) {
		String sDateStr = dt.format(sDate);
		String eDateStr = dt.format(eDate);
		String sql = "select * from Walking where uid = ? and str_to_date(record_date,'%Y-%m-%d') "
				+ " between str_to_date(?,'%Y-%m-%d %H:%i:%s') and str_to_date(?,'%Y-%m-%d %H:%i:%s');";

		return jdbc.query(sql, walkingDataMapper, uid, sDateStr, eDateStr);
	}
	
	private static final RowMapper<WalkingDataPojo> walkingDataMapper = new RowMapper<WalkingDataPojo>() {
		public WalkingDataPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
			WalkingDataPojo walkingData = new WalkingDataPojo();
			walkingData.setUid(rs.getLong("uid"));
			walkingData.setRecord_date(rs.getDate("record_date").getTime() / 1000);
			walkingData.setStep(rs.getInt("step") );
			walkingData.setCalorie(rs.getFloat("calorie"));
			walkingData.setDistance(rs.getFloat("distance"));
			walkingData.setData_from(rs.getString("data_from"));
			return walkingData;
		}
	};

}
