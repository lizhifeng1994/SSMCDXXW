package com.baidu.model;

public class ESMXINFO {
	private String XX_ID;
	private String ES_PRICE;
	private String ES_CS;
	private String ES_CONTENT;
	private String ES_PHONE;
	private String ES_QQ;
	public String getXX_ID() {
		return XX_ID;
	}
	public void setXX_ID(String xX_ID) {
		XX_ID = xX_ID;
	}
	public String getES_PRICE() {
		return ES_PRICE;
	}
	public void setES_PRICE(String eS_PRICE) {
		ES_PRICE = eS_PRICE;
	}
	public String getES_CS() {
		return ES_CS;
	}
	public void setES_CS(String eS_CS) {
		ES_CS = eS_CS;
	}
	public String getES_CONTENT() {
		return ES_CONTENT;
	}
	public void setES_CONTENT(String eS_CONTENT) {
		ES_CONTENT = eS_CONTENT;
	}
	public String getES_PHONE() {
		return ES_PHONE;
	}
	public void setES_PHONE(String eS_PHONE) {
		ES_PHONE = eS_PHONE;
	}
	public String getES_QQ() {
		return ES_QQ;
	}
	public void setES_QQ(String eS_QQ) {
		ES_QQ = eS_QQ;
	}
	@Override
	public String toString() {
		return "ESMXINFO [XX_ID=" + XX_ID + ", ES_PRICE=" + ES_PRICE
				+ ", ES_CS=" + ES_CS + ", ES_CONTENT=" + ES_CONTENT
				+ ", ES_PHONE=" + ES_PHONE + ", ES_QQ=" + ES_QQ + "]";
	}
	public ESMXINFO(String xX_ID, String eS_PRICE, String eS_CS,
			String eS_CONTENT, String eS_PHONE, String eS_QQ) {
		super();
		XX_ID = xX_ID;
		ES_PRICE = eS_PRICE;
		ES_CS = eS_CS;
		ES_CONTENT = eS_CONTENT;
		ES_PHONE = eS_PHONE;
		ES_QQ = eS_QQ;
	}
	public ESMXINFO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
