package com.baidu.vo;

public class JZXXVO {
	private String XX_ID;
	private String XX_TITLE;
	private String USER_NAME;
	private String XX_TIME;
	private String IMAGE_NAME;
	private String XXMX_TYPE;
	private String XX_LL;
	private String XX_SC;
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
	public String getXX_TIME() {
		return XX_TIME;
	}
	public void setXX_TIME(String xX_TIME) {
		XX_TIME = xX_TIME;
	}
	public String getIMAGE_NAME() {
		return IMAGE_NAME;
	}
	public void setIMAGE_NAME(String iMAGE_NAME) {
		IMAGE_NAME = iMAGE_NAME;
	}
	public String getXXMX_TYPE() {
		return XXMX_TYPE;
	}
	public void setXXMX_TYPE(String xXMX_TYPE) {
		XXMX_TYPE = xXMX_TYPE;
	}
	public String getXX_LL() {
		return XX_LL;
	}
	public void setXX_LL(String xX_LL) {
		XX_LL = xX_LL;
	}
	public String getXX_SC() {
		return XX_SC;
	}
	public void setXX_SC(String xX_SC) {
		XX_SC = xX_SC;
	}
	@Override
	public String toString() {
		return "JZXXVO [XX_ID=" + XX_ID + ", XX_TITLE=" + XX_TITLE
				+ ", USER_NAME=" + USER_NAME + ", XX_TIME=" + XX_TIME
				+ ", IMAGE_NAME=" + IMAGE_NAME + ", XXMX_TYPE=" + XXMX_TYPE
				+ ", XX_LL=" + XX_LL + ", XX_SC=" + XX_SC + "]";
	}
	public JZXXVO(String xX_ID, String xX_TITLE, String uSER_NAME,
			String xX_TIME, String iMAGE_NAME, String xXMX_TYPE, String xX_LL,
			String xX_SC) {
		super();
		XX_ID = xX_ID;
		XX_TITLE = xX_TITLE;
		USER_NAME = uSER_NAME;
		XX_TIME = xX_TIME;
		IMAGE_NAME = iMAGE_NAME;
		XXMX_TYPE = xXMX_TYPE;
		XX_LL = xX_LL;
		XX_SC = xX_SC;
	}
	public JZXXVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
