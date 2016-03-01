package com.baidu.vo;

public class SCXXVO {
	private String SC_ID;
	private String XX_ID;
	private String SC_TIME;
	private String IMAGE_NAME;
	private String XX_TITLE;
	private String XX_TYPE;
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
	public String getSC_TIME() {
		return SC_TIME;
	}
	public void setSC_TIME(String sC_TIME) {
		SC_TIME = sC_TIME;
	}
	public String getIMAGE_NAME() {
		return IMAGE_NAME;
	}
	public void setIMAGE_NAME(String iMAGE_NAME) {
		IMAGE_NAME = iMAGE_NAME;
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
	public SCXXVO(String sC_ID, String xX_ID, String sC_TIME,
			String iMAGE_NAME, String xX_TITLE, String xX_TYPE) {
		super();
		SC_ID = sC_ID;
		XX_ID = xX_ID;
		SC_TIME = sC_TIME;
		IMAGE_NAME = iMAGE_NAME;
		XX_TITLE = xX_TITLE;
		XX_TYPE = xX_TYPE;
	}
	@Override
	public String toString() {
		return "SCXXVO [SC_ID=" + SC_ID + ", XX_ID=" + XX_ID + ", SC_TIME="
				+ SC_TIME + ", IMAGE_NAME=" + IMAGE_NAME + ", XX_TITLE="
				+ XX_TITLE + ", XX_TYPE=" + XX_TYPE + "]";
	}
	public SCXXVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
