package com.baidu.model;

public class JBXXINFO  extends Page{
	private String JB_ID;
	private String XX_ID;
	private String XX_TITLE;
	private String USER_NAME;
	private String JB_CONTENT;
	private String JB_TYPE;
	private String JB_TIME;
	private String JB_STATE;
	private String JB_FLAG;
	public String getJB_ID() {
		return JB_ID;
	}
	public void setJB_ID(String jB_ID) {
		JB_ID = jB_ID;
	}
	public String getXX_ID() {
		return XX_ID;
	}
	public void setXX_ID(String xX_ID) {
		XX_ID = xX_ID;
	}
	public String getXX_TITLE() {
		return XX_TITLE;
	}
	public void setXX_TITLE(String xX_TITLE) {
		XX_TITLE = xX_TITLE;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getJB_CONTENT() {
		return JB_CONTENT;
	}
	public void setJB_CONTENT(String jB_CONTENT) {
		JB_CONTENT = jB_CONTENT;
	}
	public String getJB_TYPE() {
		return JB_TYPE;
	}
	public void setJB_TYPE(String jB_TYPE) {
		JB_TYPE = jB_TYPE;
	}
	public String getJB_TIME() {
		return JB_TIME;
	}
	public void setJB_TIME(String jB_TIME) {
		JB_TIME = jB_TIME;
	}
	public String getJB_STATE() {
		return JB_STATE;
	}
	public void setJB_STATE(String jB_STATE) {
		JB_STATE = jB_STATE;
	}
	public String getJB_FLAG() {
		return JB_FLAG;
	}
	public void setJB_FLAG(String jB_FLAG) {
		JB_FLAG = jB_FLAG;
	}
	@Override
	public String toString() {
		return "JBXXINFO [JB_ID=" + JB_ID + ", XX_ID=" + XX_ID + ", XX_TITLE="
				+ XX_TITLE + ", USER_NAME=" + USER_NAME + ", JB_CONTENT="
				+ JB_CONTENT + ", JB_TYPE=" + JB_TYPE + ", JB_TIME=" + JB_TIME
				+ ", JB_STATE=" + JB_STATE + ", JB_FLAG=" + JB_FLAG + "]";
	}
	public JBXXINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time, String jB_ID, String xX_ID,
			String xX_TITLE, String uSER_NAME, String jB_CONTENT,
			String jB_TYPE, String jB_TIME, String jB_STATE, String jB_FLAG) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		JB_ID = jB_ID;
		XX_ID = xX_ID;
		XX_TITLE = xX_TITLE;
		USER_NAME = uSER_NAME;
		JB_CONTENT = jB_CONTENT;
		JB_TYPE = jB_TYPE;
		JB_TIME = jB_TIME;
		JB_STATE = jB_STATE;
		JB_FLAG = jB_FLAG;
	}
	public JBXXINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JBXXINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		// TODO Auto-generated constructor stub
	}
	
}
