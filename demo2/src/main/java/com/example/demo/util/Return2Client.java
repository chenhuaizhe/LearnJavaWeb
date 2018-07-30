package com.example.demo.util;

public class Return2Client extends Message{
	
	public Return2Client(int retCode) {
		super(retCode);
	}

	private Object content;
	

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	
}
