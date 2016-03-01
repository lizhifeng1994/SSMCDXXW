package com.baidu.model;

public class ZNTZINFO extends Page {
	private String ZNTZ_ID;
	private String USER_NAME;
	private String ZNTZ_TIME;
	private String ZNTZ_CONTENT;
	private String ZNTZ_STATE;
	private String ZNTZ_FLAG;
	public String getZNTZ_ID() {
		return ZNTZ_ID;
	}
	public void setZNTZ_ID(String zNTZ_ID) {
		ZNTZ_ID = zNTZ_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getZNTZ_TIME() {
		return ZNTZ_TIME;
	}
	public void setZNTZ_TIME(String zNTZ_TIME) {
		ZNTZ_TIME = zNTZ_TIME;
	}
	public String getZNTZ_CONTENT() {
		return ZNTZ_CONTENT;
	}
	public void setZNTZ_CONTENT(String zNTZ_CONTENT) {
		ZNTZ_CONTENT = zNTZ_CONTENT;
	}
	public String getZNTZ_STATE() {
		return ZNTZ_STATE;
	}
	public void setZNTZ_STATE(String zNTZ_STATE) {
		ZNTZ_STATE = zNTZ_STATE;
	}
	public String getZNTZ_FLAG() {
		return ZNTZ_FLAG;
	}
	public void setZNTZ_FLAG(String zNTZ_FLAG) {
		ZNTZ_FLAG = zNTZ_FLAG;
	}
	@Override
	public String toString() {
		return "ZNTZINFO [ZNTZ_ID=" + ZNTZ_ID + ", USER_NAME=" + USER_NAME
				+ ", ZNTZ_TIME=" + ZNTZ_TIME + ", ZNTZ_CONTENT=" + ZNTZ_CONTENT
				+ ", ZNTZ_STATE=" + ZNTZ_STATE + ", ZNTZ_FLAG=" + ZNTZ_FLAG
				+ "]";
	}
	public ZNTZINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time, String zNTZ_ID,
			String uSER_NAME, String zNTZ_TIME, String zNTZ_CONTENT,
			String zNTZ_STATE, String zNTZ_FLAG) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		ZNTZ_ID = zNTZ_ID;
		USER_NAME = uSER_NAME;
		ZNTZ_TIME = zNTZ_TIME;
		ZNTZ_CONTENT = zNTZ_CONTENT;
		ZNTZ_STATE = zNTZ_STATE;
		ZNTZ_FLAG = zNTZ_FLAG;
	}
	public ZNTZINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZNTZINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		// TODO Auto-generated constructor stub
	}
	
}
