package com.example.bean;

public class UserLoginInfBean {
	private String UID;
	private String UNAME;
	private String U_STATE;

	public UserLoginInfBean(String UID, String UNAME, String u_STATE) {
		this.UID = UID;
		this.UNAME = UNAME;
		U_STATE = u_STATE;
	}

	public UserLoginInfBean() {
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String UID) {
		this.UID = UID;
	}

	public String getUNAME() {
		return UNAME;
	}

	public void setUNAME(String UNAME) {
		this.UNAME = UNAME;
	}

	public String getU_STATE() {
		return U_STATE;
	}

	public void setU_STATE(String u_STATE) {
		U_STATE = u_STATE;
	}
}
