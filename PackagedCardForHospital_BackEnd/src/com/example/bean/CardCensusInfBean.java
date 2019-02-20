package com.example.bean;

public class CardCensusInfBean {
	private String P_CARD_ID;
	private String ARVL_CTIME;
	private String ARVL_ATIME;
	private String U_NAME;
	private String P_NAME;
	private String C_AMOUNT;
	private String C_STATE;

	public CardCensusInfBean(String p_CARD_ID, String ARVL_CTIME, String ARVL_ATIME, String u_NAME, String p_NAME, String c_AMOUNT, String c_STATE) {
		P_CARD_ID = p_CARD_ID;
		this.ARVL_CTIME = ARVL_CTIME;
		this.ARVL_ATIME = ARVL_ATIME;
		U_NAME = u_NAME;
		P_NAME = p_NAME;
		C_AMOUNT = c_AMOUNT;
		C_STATE = c_STATE;
	}

	public CardCensusInfBean() {
	}

	public String getP_CARD_ID() {
		return P_CARD_ID;
	}

	public void setP_CARD_ID(String p_CARD_ID) {
		P_CARD_ID = p_CARD_ID;
	}

	public String getARVL_CTIME() {
		return ARVL_CTIME;
	}

	public void setARVL_CTIME(String ARVL_CTIME) {
		this.ARVL_CTIME = ARVL_CTIME;
	}

	public String getARVL_ATIME() {
		return ARVL_ATIME;
	}

	public void setARVL_ATIME(String ARVL_ATIME) {
		this.ARVL_ATIME = ARVL_ATIME;
	}

	public String getU_NAME() {
		return U_NAME;
	}

	public void setU_NAME(String u_NAME) {
		U_NAME = u_NAME;
	}

	public String getP_NAME() {
		return P_NAME;
	}

	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}

	public String getC_AMOUNT() {
		return C_AMOUNT;
	}

	public void setC_AMOUNT(String c_AMOUNT) {
		C_AMOUNT = c_AMOUNT;
	}

	public String getC_STATE() {
		return C_STATE;
	}

	public void setC_STATE(String c_STATE) {
		C_STATE = c_STATE;
	}
}

