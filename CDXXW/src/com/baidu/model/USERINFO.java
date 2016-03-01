package com.baidu.model;

public class USERINFO extends Page{


	private String USER_ID;
	private String USER_NAME;
	private String USER_EMAIL;
	private String USER_PWD;
	private String USER_TYPE;
	private String USER_MARK;
	private String USER_TIME;
	private String USER_FLAG;
	private String USER_WORK;
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public String getUSER_PWD() {
		return USER_PWD;
	}
	public void setUSER_PWD(String uSER_PWD) {
		USER_PWD = uSER_PWD;
	}
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	public String getUSER_MARK() {
		return USER_MARK;
	}
	public void setUSER_MARK(String uSER_MARK) {
		USER_MARK = uSER_MARK;
	}
	public String getUSER_TIME() {
		return USER_TIME;
	}
	public void setUSER_TIME(String uSER_TIME) {
		USER_TIME = uSER_TIME;
	}
	public String getUSER_FLAG() {
		return USER_FLAG;
	}
	public void setUSER_FLAG(String uSER_FLAG) {
		USER_FLAG = uSER_FLAG;
	}
	public String getUSER_WORK() {
		return USER_WORK;
	}
	public void setUSER_WORK(String uSER_WORK) {
		USER_WORK = uSER_WORK;
	}
	@Override
	public String toString() {
		return "USERINFO [USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME
				+ ", USER_EMAIL=" + USER_EMAIL + ", USER_PWD=" + USER_PWD
				+ ", USER_TYPE=" + USER_TYPE + ", USER_MARK=" + USER_MARK
				+ ", USER_TIME=" + USER_TIME + ", USER_FLAG=" + USER_FLAG
				+ ", USER_WORK=" + USER_WORK + "]";
	}
	public USERINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time, String uSER_ID,
			String uSER_NAME, String uSER_EMAIL, String uSER_PWD,
			String uSER_TYPE, String uSER_MARK, String uSER_TIME,
			String uSER_FLAG, String uSER_WORK) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_EMAIL = uSER_EMAIL;
		USER_PWD = uSER_PWD;
		USER_TYPE = uSER_TYPE;
		USER_MARK = uSER_MARK;
		USER_TIME = uSER_TIME;
		USER_FLAG = uSER_FLAG;
		USER_WORK = uSER_WORK;
	}
	public USERINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public USERINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		// TODO Auto-generated constructor stub
	}
	
}
