package com.example.bean;

public class WorkCensusInfBean {
	private String B_EXCUTORID;
	private String SOLD_CARD;
	private String CHANGE_CARD;
	private String EXID_CARD;

	public WorkCensusInfBean(String b_EXCUTORID, String SOLD_CARD, String CHANGE_CARD, String EXID_CARD) {
		B_EXCUTORID = b_EXCUTORID;
		this.SOLD_CARD = SOLD_CARD;
		this.CHANGE_CARD = CHANGE_CARD;
		this.EXID_CARD = EXID_CARD;
	}

	public WorkCensusInfBean() {
	}

	public String getB_EXCUTORID() {
		return B_EXCUTORID;
	}

	public void setB_EXCUTORID(String b_EXCUTORID) {
		B_EXCUTORID = b_EXCUTORID;
	}

	public String getSOLD_CARD() {
		return SOLD_CARD;
	}

	public void setSOLD_CARD(String SOLD_CARD) {
		this.SOLD_CARD = SOLD_CARD;
	}

	public String getCHANGE_CARD() {
		return CHANGE_CARD;
	}

	public void setCHANGE_CARD(String CHANGE_CARD) {
		this.CHANGE_CARD = CHANGE_CARD;
	}

	public String getEXID_CARD() {
		return EXID_CARD;
	}

	public void setEXID_CARD(String EXID_CARD) {
		this.EXID_CARD = EXID_CARD;
	}
}
