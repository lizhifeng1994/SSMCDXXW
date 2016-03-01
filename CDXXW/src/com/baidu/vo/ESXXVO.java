package com.baidu.vo;



/*
 * XX_ID
 * XX_TITLE
 * USER_NAME
 * XX_TIME
 * XXMX_TYPE
 * IMAGE_NAME
 */
public class ESXXVO  {
	private String XX_ID;
	private String XX_TITLE;
	private String USER_NAME;
	private String XX_TIME;
	private String IMAGE_NAME;
	private String ES_PRICE;
	private String XX_STATE;
	private String XX_LL;
	private String XX_SC;
	private String XXMX_TYPE;
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
	public String getES_PRICE() {
		return ES_PRICE;
	}
	public void setES_PRICE(String eS_PRICE) {
		ES_PRICE = eS_PRICE;
	}
	public String getXX_STATE() {
		return XX_STATE;
	}
	public void setXX_STATE(String xX_STATE) {
		XX_STATE = xX_STATE;
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
	public String getXXMX_TYPE() {
		return XXMX_TYPE;
	}
	public void setXXMX_TYPE(String xXMX_TYPE) {
		XXMX_TYPE = xXMX_TYPE;
	}
	@Override
	public String toString() {
		return "ESXXVO [XX_ID=" + XX_ID + ", XX_TITLE=" + XX_TITLE
				+ ", USER_NAME=" + USER_NAME + ", XX_TIME=" + XX_TIME
				+ ", IMAGE_NAME=" + IMAGE_NAME + ", ES_PRICE=" + ES_PRICE
				+ ", XX_STATE=" + XX_STATE + ", XX_LL=" + XX_LL + ", XX_SC="
				+ XX_SC + ", XXMX_TYPE=" + XXMX_TYPE + "]";
	}
	public ESXXVO(String xX_ID, String xX_TITLE, String uSER_NAME,
			String xX_TIME, String iMAGE_NAME, String eS_PRICE,
			String xX_STATE, String xX_LL, String xX_SC, String xXMX_TYPE) {
		super();
		XX_ID = xX_ID;
		XX_TITLE = xX_TITLE;
		USER_NAME = uSER_NAME;
		XX_TIME = xX_TIME;
		IMAGE_NAME = iMAGE_NAME;
		ES_PRICE = eS_PRICE;
		XX_STATE = xX_STATE;
		XX_LL = xX_LL;
		XX_SC = xX_SC;
		XXMX_TYPE = xXMX_TYPE;
	}
	public ESXXVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
