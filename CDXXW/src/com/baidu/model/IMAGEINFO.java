package com.baidu.model;

public class IMAGEINFO {
	private int IMAGE_ID;
	private String XX_ID;
	private String IMAGE_NAME;
	private String IMAGE_TYPE;
	public int getIMAGE_ID() {
		return IMAGE_ID;
	}
	public void setIMAGE_ID(int iMAGE_ID) {
		IMAGE_ID = iMAGE_ID;
	}
	public String getXX_ID() {
		return XX_ID;
	}
	public void setXX_ID(String xX_ID) {
		XX_ID = xX_ID;
	}
	public String getIMAGE_NAME() {
		return IMAGE_NAME;
	}
	public void setIMAGE_NAME(String iMAGE_NAME) {
		IMAGE_NAME = iMAGE_NAME;
	}
	public String getIMAGE_TYPE() {
		return IMAGE_TYPE;
	}
	public void setIMAGE_TYPE(String iMAGE_TYPE) {
		IMAGE_TYPE = iMAGE_TYPE;
	}
	@Override
	public String toString() {
		return "IMAGEINFO [IMAGE_ID=" + IMAGE_ID + ", XX_ID=" + XX_ID
				+ ", IMAGE_NAME=" + IMAGE_NAME + ", IMAGE_TYPE=" + IMAGE_TYPE
				+ "]";
	}
	public IMAGEINFO(int iMAGE_ID, String xX_ID, String iMAGE_NAME,
			String iMAGE_TYPE) {
		super();
		IMAGE_ID = iMAGE_ID;
		XX_ID = xX_ID;
		IMAGE_NAME = iMAGE_NAME;
		IMAGE_TYPE = iMAGE_TYPE;
	}
	public IMAGEINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
