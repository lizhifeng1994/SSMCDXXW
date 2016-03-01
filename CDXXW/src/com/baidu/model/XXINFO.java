package com.baidu.model;

public class XXINFO extends Page{
	private String XX_ID;
	private String XX_TITLE;
	private String USER_NAME; 
	private String XX_TIME;
	private String XX_TYPE;
	private String XXMX_TYPE;
	private String XX_SC;
	private String XX_LL;
	private String XX_FLAG;
	private String XX_STATE;
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
	public String getXX_TYPE() {
		return XX_TYPE;
	}
	public void setXX_TYPE(String xX_TYPE) {
		XX_TYPE = xX_TYPE;
	}
	public String getXXMX_TYPE() {
		return XXMX_TYPE;
	}
	public void setXXMX_TYPE(String xXMX_TYPE) {
		XXMX_TYPE = xXMX_TYPE;
	}
	public String getXX_SC() {
		return XX_SC;
	}
	public void setXX_SC(String xX_SC) {
		XX_SC = xX_SC;
	}
	public String getXX_LL() {
		return XX_LL;
	}
	public void setXX_LL(String xX_LL) {
		XX_LL = xX_LL;
	}
	public String getXX_FLAG() {
		return XX_FLAG;
	}
	public void setXX_FLAG(String xX_FLAG) {
		XX_FLAG = xX_FLAG;
	}
	public String getXX_STATE() {
		return XX_STATE;
	}
	public void setXX_STATE(String xX_STATE) {
		XX_STATE = xX_STATE;
	}
	@Override
	public String toString() {
		return "XXINFO [XX_ID=" + XX_ID + ", XX_TITLE=" + XX_TITLE
				+ ", USER_NAME=" + USER_NAME + ", XX_TIME=" + XX_TIME
				+ ", XX_TYPE=" + XX_TYPE + ", XXMX_TYPE=" + XXMX_TYPE
				+ ", XX_SC=" + XX_SC + ", XX_LL=" + XX_LL + ", XX_FLAG="
				+ XX_FLAG + ", XX_STATE=" + XX_STATE + "]";
	}
	public XXINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time, String xX_ID, String xX_TITLE,
			String uSER_NAME, String xX_TIME, String xX_TYPE, String xXMX_TYPE,
			String xX_SC, String xX_LL, String xX_FLAG, String xX_STATE) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		XX_ID = xX_ID;
		XX_TITLE = xX_TITLE;
		USER_NAME = uSER_NAME;
		XX_TIME = xX_TIME;
		XX_TYPE = xX_TYPE;
		XXMX_TYPE = xXMX_TYPE;
		XX_SC = xX_SC;
		XX_LL = xX_LL;
		XX_FLAG = xX_FLAG;
		XX_STATE = xX_STATE;
	}
	public XXINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XXINFO(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super(pageNow, pageSize, pageCount, rowCount, start_time, end_time);
		// TODO Auto-generated constructor stub
	}
	
}
