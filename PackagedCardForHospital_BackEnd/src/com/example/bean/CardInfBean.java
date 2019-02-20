package com.example.bean;

public class CardInfBean {
	private String ID;
	private String CARD_NUM;
	private String CARD_STATUS;
	private String CARD_REQUESTOR;
	private String CARD_USER;

	public CardInfBean(String ID, String CARD_NUM, String CARD_STATUS, String CARD_REQUESTOR, String CARD_USER) {
		this.ID = ID;
		this.CARD_NUM = CARD_NUM;
		this.CARD_STATUS = CARD_STATUS;
		this.CARD_REQUESTOR = CARD_REQUESTOR;
		this.CARD_USER = CARD_USER;
	}

	public CardInfBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCARD_NUM() {
		return CARD_NUM;
	}

	public void setCARD_NUM(String CARD_NUM) {
		this.CARD_NUM = CARD_NUM;
	}

	public String getCARD_STATUS() {
		return CARD_STATUS;
	}

	public void setCARD_STATUS(String CARD_STATUS) {
		this.CARD_STATUS = CARD_STATUS;
	}

	public String getCARD_REQUESTOR() {
		return CARD_REQUESTOR;
	}

	public void setCARD_REQUESTOR(String CARD_REQUESTOR) {
		this.CARD_REQUESTOR = CARD_REQUESTOR;
	}

	public String getCARD_USER() {
		return CARD_USER;
	}

	public void setCARD_USER(String CARD_USER) {
		this.CARD_USER = CARD_USER;
	}
}
