package com.example.bean;

public class RoleInfBean {

	private String ID;
	private String NAME;
	private String CTIME;
	private String STATE;
	private String REMARK;

	public RoleInfBean(String ID, String NAME, String CTIME, String STATE, String REMARK) {
		this.ID = ID;
		this.NAME = NAME;
		this.CTIME = CTIME;
		this.STATE = STATE;
		this.REMARK = REMARK;
	}

	public RoleInfBean() {
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

	public String getCTIME() {
		return CTIME;
	}

	public void setCTIME(String CTIME) {
		this.CTIME = CTIME;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String STATE) {
		this.STATE = STATE;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
}
