package com.example.bean;

public class ReqCardInfBean {
	private String ARVL_ID;
	private String ARVL_CTIME;
	private String ARVL_REQUESTNUM;
	private String ARVL_CORID;
	private String ARVL_STATE;
	private String ARVL_MID;
	private String ARVL_ATIME;

	public ReqCardInfBean(String ARVL_ID, String ARVL_CTIME, String ARVL_REQUESTNUM, String ARVL_CORID, String ARVL_STATE, String ARVL_MID, String ARVL_ATIME) {
		this.ARVL_ID = ARVL_ID;
		this.ARVL_CTIME = ARVL_CTIME;
		this.ARVL_REQUESTNUM = ARVL_REQUESTNUM;
		this.ARVL_CORID = ARVL_CORID;
		this.ARVL_STATE = ARVL_STATE;
		this.ARVL_MID = ARVL_MID;
		this.ARVL_ATIME = ARVL_ATIME;
	}

	public ReqCardInfBean() {
	}

	public String getARVL_ID() {
		return ARVL_ID;
	}

	public void setARVL_ID(String ARVL_ID) {
		this.ARVL_ID = ARVL_ID;
	}

	public String getARVL_CTIME() {
		return ARVL_CTIME;
	}

	public void setARVL_CTIME(String ARVL_CTIME) {
		this.ARVL_CTIME = ARVL_CTIME;
	}

	public String getARVL_REQUESTNUM() {
		return ARVL_REQUESTNUM;
	}

	public void setARVL_REQUESTNUM(String ARVL_REQUESTNUM) {
		this.ARVL_REQUESTNUM = ARVL_REQUESTNUM;
	}

	public String getARVL_CORID() {
		return ARVL_CORID;
	}

	public void setARVL_CORID(String ARVL_CORID) {
		this.ARVL_CORID = ARVL_CORID;
	}

	public String getARVL_STATE() {
		return ARVL_STATE;
	}

	public void setARVL_STATE(String ARVL_STATE) {
		this.ARVL_STATE = ARVL_STATE;
	}

	public String getARVL_MID() {
		return ARVL_MID;
	}

	public void setARVL_MID(String ARVL_MID) {
		this.ARVL_MID = ARVL_MID;
	}

	public String getARVL_ATIME() {
		return ARVL_ATIME;
	}

	public void setARVL_ATIME(String ARVL_ATIME) {
		this.ARVL_ATIME = ARVL_ATIME;
	}
}
