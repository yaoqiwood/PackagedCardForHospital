package com.example.bean;

public class LeftPanelInfBean {
	private String ID;
	private String NAME;
	private String URL;
	private String UPLEVELID;
	private String STATE;
	private String CTIME;
	private String REMARK;

	public LeftPanelInfBean(String ID, String NAME, String URL, String UPLEVELID, String STATE, String CTIME, String REMARK) {
		this.ID = ID;
		this.NAME = NAME;
		this.URL = URL;
		this.UPLEVELID = UPLEVELID;
		this.STATE = STATE;
		this.CTIME = CTIME;
		this.REMARK = REMARK;
	}

	public LeftPanelInfBean() {
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

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public String getUPLEVELID() {
		return UPLEVELID;
	}

	public void setUPLEVELID(String UPLEVELID) {
		this.UPLEVELID = UPLEVELID;
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
