package com.example.bean;

public class DoctorInfBean {
	private String ID;
	private String NAME;
	private String SEX;
	private String AGE;
	private String DEPARTMENT;

	public DoctorInfBean(String ID, String NAME, String SEX, String AGE, String DEPARTMENT) {
		this.ID = ID;
		this.NAME = NAME;
		this.SEX = SEX;
		this.AGE = AGE;
		this.DEPARTMENT = DEPARTMENT;
	}

	public DoctorInfBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String SEX) {
		this.SEX = SEX;
	}

	public String getAGE() {
		return AGE;
	}

	public void setAGE(String AGE) {
		this.AGE = AGE;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String DEPARTMENT) {
		this.DEPARTMENT = DEPARTMENT;
	}
}
