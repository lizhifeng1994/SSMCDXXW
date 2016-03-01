package com.baidu.model;

public class HDLYINFO extends Page {
	private String HDLY_ID;
	private String XX_ID;
	private String XX_TITLE;
	private String LY_NAME;
	private String LY_CONTENT;
	private String LY_TIME;
	private String HF_NAME;
	private String HF_CONTENT;
	private String HF_TIME;
	private String HDLY_FLAG;
	public String getHDLY_ID() {
		return HDLY_ID;
	}
	public void setHDLY_ID(String hDLY_ID) {
		HDLY_ID = hDLY_ID;
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
	public String getLY_NAME() {
		return LY_NAME;
	}
	public void setLY_NAME(String lY_NAME) {
		LY_NAME = lY_NAME;
	}
	public String getLY_CONTENT() {
		return LY_CONTENT;
	}
	public void setLY_CONTENT(String lY_CONTENT) {
		LY_CONTENT = lY_CONTENT;
	}
	public String getLY_TIME() {
		return LY_TIME;
	}
	public void setLY_TIME(String lY_TIME) {
		LY_TIME = lY_TIME;
	}
	public String getHF_NAME() {
		return HF_NAME;
	}
	public void setHF_NAME(String hF_NAME) {
		HF_NAME = hF_NAME;
	}
	public String getHF_CONTENT() {
		return HF_CONTENT;
	}
	public void setHF_CONTENT(String hF_CONTENT) {
		HF_CONTENT = hF_CONTENT;
	}
	public String getHF_TIME() {
		return HF_TIME;
	}
	public void setHF_TIME(String hF_TIME) {
		HF_TIME = hF_TIME;
	}
	public String getHDLY_FLAG() {
		return HDLY_FLAG;
	}
	public void setHDLY_FLAG(String hDLY_FLAG) {
		HDLY_FLAG = hDLY_FLAG;
	}
	@Override
	public String toString() {
		return "HDLYINFO [HDLY_ID=" + HDLY_ID + ", XX_ID=" + XX_ID
				+ ", XX_TITLE=" + XX_TITLE + ", LY_NAME=" + LY_NAME
				+ ", LY_CONTENT=" + LY_CONTENT + ", LY_TIME=" + LY_TIME
				+ ", HF_NAME=" + HF_NAME + ", HF_CONTENT=" + HF_CONTENT
				+ ", HF_TIME=" + HF_TIME + ", HDLY_FLAG=" + HDLY_FLAG + "]";
	}
	public HDLYINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time, String hDLY_ID, String xX_ID,
			String xX_TITLE, String lY_NAME, String lY_CONTENT, String lY_TIME,
			String hF_NAME, String hF_CONTENT, String hF_TIME, String hDLY_FLAG) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		HDLY_ID = hDLY_ID;
		XX_ID = xX_ID;
		XX_TITLE = xX_TITLE;
		LY_NAME = lY_NAME;
		LY_CONTENT = lY_CONTENT;
		LY_TIME = lY_TIME;
		HF_NAME = hF_NAME;
		HF_CONTENT = hF_CONTENT;
		HF_TIME = hF_TIME;
		HDLY_FLAG = hDLY_FLAG;
	}
	public HDLYINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HDLYINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		// TODO Auto-generated constructor stub
	}
	

}
