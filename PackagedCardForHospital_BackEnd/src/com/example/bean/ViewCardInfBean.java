package com.example.bean;

public class ViewCardInfBean {
	private String CardNum;
	private String CardAmount;
	private String CardStatus;
	private String CardUser;
	private String CardRequester;
	private String CardReqTime;
	private String CardVender;
	private String CardVendTime;

	public ViewCardInfBean(String cardNum, String cardAmount, String cardStatus, String cardUser, String cardRequester, String cardReqTime, String cardVender, String cardVendTime) {
		CardNum = cardNum;
		CardAmount = cardAmount;
		CardStatus = cardStatus;
		CardUser = cardUser;
		CardRequester = cardRequester;
		CardReqTime = cardReqTime;
		CardVender = cardVender;
		CardVendTime = cardVendTime;
	}

	public ViewCardInfBean() {
	}

	public String getCardNum() {
		return CardNum;
	}

	public void setCardNum(String cardNum) {
		CardNum = cardNum;
	}

	public String getCardAmount() {
		return CardAmount;
	}

	public void setCardAmount(String cardAmount) {
		CardAmount = cardAmount;
	}

	public String getCardStatus() {
		return CardStatus;
	}

	public void setCardStatus(String cardStatus) {
		CardStatus = cardStatus;
	}

	public String getCardUser() {
		return CardUser;
	}

	public void setCardUser(String cardUser) {
		CardUser = cardUser;
	}

	public String getCardRequester() {
		return CardRequester;
	}

	public void setCardRequester(String cardRequester) {
		CardRequester = cardRequester;
	}

	public String getCardReqTime() {
		return CardReqTime;
	}

	public void setCardReqTime(String cardReqTime) {
		CardReqTime = cardReqTime;
	}

	public String getCardVender() {
		return CardVender;
	}

	public void setCardVender(String cardVender) {
		CardVender = cardVender;
	}

	public String getCardVendTime() {
		return CardVendTime;
	}

	public void setCardVendTime(String cardVendTime) {
		CardVendTime = cardVendTime;
	}
}
