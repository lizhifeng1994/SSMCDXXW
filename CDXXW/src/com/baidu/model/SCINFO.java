package com.baidu.model;

public class SCINFO extends Page {
	private String SC_ID;
	private String XX_ID;
	private String USER_NAME;
	private String XX_TITLE;
	private String SC_TYPE;
	private String SC_TIME;
	private String SC_FLAG;
	public String getSC_ID() {
		return SC_ID;
	}
	public void setSC_ID(String sC_ID) {
		SC_ID = sC_ID;
	}
	public String getXX_ID() {
		return XX_ID;
	}
	public void setXX_ID(String xX_ID) {
		XX_ID = xX_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getXX_TITLE() {
		return XX_TITLE;
	}
	public void setXX_TITLE(String xX_TITLE) {
		XX_TITLE = xX_TITLE;
	}
	public String getSC_TYPE() {
		return SC_TYPE;
	}
	public void setSC_TYPE(String sC_TYPE) {
		SC_TYPE = sC_TYPE;
	}
	public String getSC_TIME() {
		return SC_TIME;
	}
	public void setSC_TIME(String sC_TIME) {
		SC_TIME = sC_TIME;
	}
	public String getSC_FLAG() {
		return SC_FLAG;
	}
	public void setSC_FLAG(String sC_FLAG) {
		SC_FLAG = sC_FLAG;
	}
	@Override
	public String toString() {
		return "SCINFO [SC_ID=" + SC_ID + ", XX_ID=" + XX_ID + ", USER_NAME="
				+ USER_NAME + ", XX_TITLE=" + XX_TITLE + ", SC_TYPE=" + SC_TYPE
				+ ", SC_TIME=" + SC_TIME + ", SC_FLAG=" + SC_FLAG + "]";
	}
	public SCINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time, String sC_ID, String xX_ID,
			String uSER_NAME, String xX_TITLE, String sC_TYPE, String sC_TIME,
			String sC_FLAG) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		SC_ID = sC_ID;
		XX_ID = xX_ID;
		USER_NAME = uSER_NAME;
		XX_TITLE = xX_TITLE;
		SC_TYPE = sC_TYPE;
		SC_TIME = sC_TIME;
		SC_FLAG = sC_FLAG;
	}
	public SCINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SCINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		// TODO Auto-generated constructor stub
	}
	
}
