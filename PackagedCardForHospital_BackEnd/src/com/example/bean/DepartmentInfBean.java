package com.example.bean;

public class DepartmentInfBean {
	private String ID;
	private String NAME;
	private String STATE;
	private String CTIME;
	private String REMARK;

	public DepartmentInfBean(String ID, String NAME, String STATE, String CTIME, String REMARK) {
		this.ID = ID;
		this.NAME = NAME;
		this.STATE = STATE;
		this.CTIME = CTIME;
		this.REMARK = REMARK;
	}

	public DepartmentInfBean() {
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

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String STATE) {
		this.STATE = STATE;
	}

	public String getCTIME() {
		return CTIME;
	}

	public void setCTIME(String CTIME) {
		this.CTIME = CTIME;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
}
