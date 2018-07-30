package com.example.demo.model;

public class WalkingDataPojo {
	
	private long uid;
    private long record_date;
	private String date;
	private int step;
    private float calorie;
    private float distance;
    private String data_from;

	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getRecord_date() {
		return record_date;
	}
	public void setRecord_date(long record_date) {
		this.record_date = record_date;
	}

	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}

	public float getCalorie() {
		return calorie;
	}
	public void setCalorie(float calorie) {
		this.calorie = calorie;
	}

	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getData_from() {
		return data_from;
	}
	public void setData_from(String data_from) {
		this.data_from = data_from;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public WalkingDataPojo() {
		super();

	}

}
