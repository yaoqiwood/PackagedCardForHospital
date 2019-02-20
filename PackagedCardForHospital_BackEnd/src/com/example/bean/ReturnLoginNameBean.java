package com.example.bean;

public class ReturnLoginNameBean {
	private String ID;
	private String USERID;
	private String USERNAME;
	private String MESSAGE;

	public ReturnLoginNameBean(String ID, String USERID, String USERNAME, String MESSAGE) {
		this.ID = ID;
		this.USERID = USERID;
		this.USERNAME = USERNAME;
		this.MESSAGE = MESSAGE;
	}

	public ReturnLoginNameBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String USERID) {
		this.USERID = USERID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;
	}

	public String getMESSAGE() {
		return MESSAGE;
	}

	public void setMESSAGE(String MESSAGE) {
		this.MESSAGE = MESSAGE;
	}
}
