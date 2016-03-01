package com.baidu.model;

public class YHDTINFO extends Page {
	private String YHDT_ID;
	private String XX_ID;
	private String XX_TITLE;
	private String XX_TYPE;
	private String USER_NAME;
	private String YHDT_TYPE;
	private String YHDT_TIME;
	private String YHDT_FLAG;
	public String getYHDT_ID() {
		return YHDT_ID;
	}
	public void setYHDT_ID(String yHDT_ID) {
		YHDT_ID = yHDT_ID;
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
	public String getXX_TYPE() {
		return XX_TYPE;
	}
	public void setXX_TYPE(String xX_TYPE) {
		XX_TYPE = xX_TYPE;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getYHDT_TYPE() {
		return YHDT_TYPE;
	}
	public void setYHDT_TYPE(String yHDT_TYPE) {
		YHDT_TYPE = yHDT_TYPE;
	}
	public String getYHDT_TIME() {
		return YHDT_TIME;
	}
	public void setYHDT_TIME(String yHDT_TIME) {
		YHDT_TIME = yHDT_TIME;
	}
	public String getYHDT_FLAG() {
		return YHDT_FLAG;
	}
	public void setYHDT_FLAG(String yHDT_FLAG) {
		YHDT_FLAG = yHDT_FLAG;
	}
	@Override
	public String toString() {
		return "YHDTINFO [YHDT_ID=" + YHDT_ID + ", XX_ID=" + XX_ID
				+ ", XX_TITLE=" + XX_TITLE + ", XX_TYPE=" + XX_TYPE
				+ ", USER_NAME=" + USER_NAME + ", YHDT_TYPE=" + YHDT_TYPE
				+ ", YHDT_TIME=" + YHDT_TIME + ", YHDT_FLAG=" + YHDT_FLAG + "]";
	}
	public YHDTINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time, String yHDT_ID, String xX_ID,
			String xX_TITLE, String xX_TYPE, String uSER_NAME,
			String yHDT_TYPE, String yHDT_TIME, String yHDT_FLAG) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		YHDT_ID = yHDT_ID;
		XX_ID = xX_ID;
		XX_TITLE = xX_TITLE;
		XX_TYPE = xX_TYPE;
		USER_NAME = uSER_NAME;
		YHDT_TYPE = yHDT_TYPE;
		YHDT_TIME = yHDT_TIME;
		YHDT_FLAG = yHDT_FLAG;
	}
	public YHDTINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public YHDTINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		// TODO Auto-generated constructor stub
	}
	
}
