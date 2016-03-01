package com.baidu.vo;

import java.io.Serializable;

import com.baidu.model.Page;

public class HDXXVO  implements Serializable {
	private String XX_ID;
	private String XX_TITLE;
	private String USER_NAME;
	private String XXMX_TYPE;
	private String IMAGE_NAME;
	private String HD_CONTENT;
	private String XX_SC;
	private String XX_LL;
	private String XX_TIME;
	private String XX_STATE;
//	活动留言的数量
	private String XX_HDLY;
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
	public String getXXMX_TYPE() {
		return XXMX_TYPE;
	}
	public void setXXMX_TYPE(String xXMX_TYPE) {
		XXMX_TYPE = xXMX_TYPE;
	}
	public String getIMAGE_NAME() {
		return IMAGE_NAME;
	}
	public void setIMAGE_NAME(String iMAGE_NAME) {
		IMAGE_NAME = iMAGE_NAME;
	}
	public String getHD_CONTENT() {
		return HD_CONTENT;
	}
	public void setHD_CONTENT(String hD_CONTENT) {
		HD_CONTENT = hD_CONTENT;
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
	public String getXX_TIME() {
		return XX_TIME;
	}
	public void setXX_TIME(String xX_TIME) {
		XX_TIME = xX_TIME;
	}
	public String getXX_STATE() {
		return XX_STATE;
	}
	public void setXX_STATE(String xX_STATE) {
		XX_STATE = xX_STATE;
	}
	public String getXX_HDLY() {
		return XX_HDLY;
	}
	public void setXX_HDLY(String xX_HDLY) {
		XX_HDLY = xX_HDLY;
	}
	@Override
	public String toString() {
		return "HDXXVO [XX_ID=" + XX_ID + ", XX_TITLE=" + XX_TITLE
				+ ", USER_NAME=" + USER_NAME + ", XXMX_TYPE=" + XXMX_TYPE
				+ ", IMAGE_NAME=" + IMAGE_NAME + ", HD_CONTENT=" + HD_CONTENT
				+ ", XX_SC=" + XX_SC + ", XX_LL=" + XX_LL + ", XX_TIME="
				+ XX_TIME + ", XX_STATE=" + XX_STATE + ", XX_HDLY=" + XX_HDLY
				+ "]";
	}
	public HDXXVO(String xX_ID, String xX_TITLE, String uSER_NAME,
			String xXMX_TYPE, String iMAGE_NAME, String hD_CONTENT,
			String xX_SC, String xX_LL, String xX_TIME, String xX_STATE,
			String xX_HDLY) {
		super();
		XX_ID = xX_ID;
		XX_TITLE = xX_TITLE;
		USER_NAME = uSER_NAME;
		XXMX_TYPE = xXMX_TYPE;
		IMAGE_NAME = iMAGE_NAME;
		HD_CONTENT = hD_CONTENT;
		XX_SC = xX_SC;
		XX_LL = xX_LL;
		XX_TIME = xX_TIME;
		XX_STATE = xX_STATE;
		XX_HDLY = xX_HDLY;
	}
	public HDXXVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
