package com.baidu.vo;

public class USERVO {
	private String USER_NAME;
	private String USER_PWD;
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PWD() {
		return USER_PWD;
	}
	public void setUSER_PWD(String uSER_PWD) {
		USER_PWD = uSER_PWD;
	}
	@Override
	public String toString() {
		return "USERVO [USER_NAME=" + USER_NAME + ", USER_PWD=" + USER_PWD
				+ "]";
	}
	public USERVO(String uSER_NAME, String uSER_PWD) {
		super();
		USER_NAME = uSER_NAME;
		USER_PWD = uSER_PWD;
	}
	public USERVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
