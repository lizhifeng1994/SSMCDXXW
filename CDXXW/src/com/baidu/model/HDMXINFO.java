package com.baidu.model;

public class HDMXINFO {
	private String XX_ID;
	private String HD_TYPE;
	private String HD_START_TIME;
	private String HD_END_TIME;
	private String HD_PLACE;
	private String HD_CONTENT;
	private String HD_PHONE;
	private String HD_QQ;
	private String HD_WEB;
	public String getXX_ID() {
		return XX_ID;
	}
	public void setXX_ID(String xX_ID) {
		XX_ID = xX_ID;
	}
	public String getHD_TYPE() {
		return HD_TYPE;
	}
	public void setHD_TYPE(String hD_TYPE) {
		HD_TYPE = hD_TYPE;
	}
	public String getHD_START_TIME() {
		return HD_START_TIME;
	}
	public void setHD_START_TIME(String hD_START_TIME) {
		HD_START_TIME = hD_START_TIME;
	}
	public String getHD_END_TIME() {
		return HD_END_TIME;
	}
	public void setHD_END_TIME(String hD_END_TIME) {
		HD_END_TIME = hD_END_TIME;
	}
	public String getHD_PLACE() {
		return HD_PLACE;
	}
	public void setHD_PLACE(String hD_PLACE) {
		HD_PLACE = hD_PLACE;
	}
	public String getHD_CONTENT() {
		return HD_CONTENT;
	}
	public void setHD_CONTENT(String hD_CONTENT) {
		HD_CONTENT = hD_CONTENT;
	}
	public String getHD_PHONE() {
		return HD_PHONE;
	}
	public void setHD_PHONE(String hD_PHONE) {
		HD_PHONE = hD_PHONE;
	}
	public String getHD_QQ() {
		return HD_QQ;
	}
	public void setHD_QQ(String hD_QQ) {
		HD_QQ = hD_QQ;
	}
	public String getHD_WEB() {
		return HD_WEB;
	}
	public void setHD_WEB(String hD_WEB) {
		HD_WEB = hD_WEB;
	}
	@Override
	public String toString() {
		return "HDMXINFO [XX_ID=" + XX_ID + ", HD_TYPE=" + HD_TYPE
				+ ", HD_START_TIME=" + HD_START_TIME + ", HD_END_TIME="
				+ HD_END_TIME + ", HD_PLACE=" + HD_PLACE + ", HD_CONTENT="
				+ HD_CONTENT + ", HD_PHONE=" + HD_PHONE + ", HD_QQ=" + HD_QQ
				+ ", HD_WEB=" + HD_WEB + "]";
	}
	public HDMXINFO(String xX_ID, String hD_TYPE, String hD_START_TIME,
			String hD_END_TIME, String hD_PLACE, String hD_CONTENT,
			String hD_PHONE, String hD_QQ, String hD_WEB) {
		super();
		XX_ID = xX_ID;
		HD_TYPE = hD_TYPE;
		HD_START_TIME = hD_START_TIME;
		HD_END_TIME = hD_END_TIME;
		HD_PLACE = hD_PLACE;
		HD_CONTENT = hD_CONTENT;
		HD_PHONE = hD_PHONE;
		HD_QQ = hD_QQ;
		HD_WEB = hD_WEB;
	}
	public HDMXINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
