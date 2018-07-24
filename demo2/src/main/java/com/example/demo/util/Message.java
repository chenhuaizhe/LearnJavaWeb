package com.example.demo.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 
 * @author hzy
 *
 */
public class Message {
	private int retCode;
	private String msg;
	
	public Message(int retCode) {
		super();
		this.retCode = retCode;
	}

	public int getRetCode() {
		return retCode;
	}
	
	

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	
	
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 返回json字符串
	 * @return
	 */
    public String toJson() {
//        Gson gson = new Gson();
    	Gson gson = new GsonBuilder()
		   .setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.toJson(this);
    }
	
}
